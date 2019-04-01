package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.capgemini.bankapp.exception.BankAccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;

@WebServlet(urlPatterns = { "*.do" }, loadOnStartup = 1)
public class BankAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BankAccountService bankService;

	static final Logger logger = Logger.getLogger(BankAppController.class);

	public BankAppController() {

		bankService = new BankAccountServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String path = request.getServletPath();
		List<BankAccount> bankAccounts = null;

		// checks the request from the index.html page and adds the list of banks
		// accounts to the request object in the form of <key,value> pair.
		if (path.equals("/getAllBankAccounts.do")) {

			bankAccounts = bankService.findAllBankDetails();
			RequestDispatcher dispatcher = request.getRequestDispatcher("Display.jsp");
			request.setAttribute("accounts", bankAccounts);

			dispatcher.forward(request, response);

		}
		/*
		 * if (path.equals("/getAccountDetailsById.do")) {
		 * 
		 * 
		 * try { bankAccounts = bankService.findAccountById(); } catch
		 * (BankAccountNotFoundException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher("Display.jsp");
		 * request.setAttribute("accounts", bankAccounts);
		 * 
		 * dispatcher.forward(request, response); }
		 */

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String path = request.getServletPath();
		System.out.println(path);

		if (path.equals("/addNewBankAccount.do")) {
			String accountholderName = request.getParameter("accountholderName");
			String accountType = request.getParameter("type");
			double balance = Double.parseDouble(request.getParameter("balance"));

			BankAccount account = new BankAccount(accountholderName, accountType, balance);

			if (bankService.addNewBankAccount(account)) {

				out.println("<h2> BankAccount is created successfully");
				out.println("<h2> <a href='index.html'> |HOME|</h2>");
				out.close();
			}

		}

		if (path.equals("/withdraw.do")) {
			long account_id = Long.parseLong(request.getParameter("account_number"));

			double balance = Double.parseDouble(request.getParameter("amount"));

			try {
				double accountBalance = bankService.withdraw(account_id, balance);
				out.println("<h2> Amount is withdrawn" + accountBalance);
				out.println("<h2> <a href='index.html'> |HOME|</h2>");
				out.close();
			} catch (LowBalanceException | BankAccountNotFoundException e) {
				logger.error("Exception :", e);
				if (e instanceof LowBalanceException) {
					out.println("<h2> You do not have suffucient fund");
					out.println("<h2> <a href='index.html'> |HOME|</h2>");
				} else {
					out.println("<h2> Bank account dont exists");
					out.println("<h2> <a href='index.html'> |HOME|</h2>");
				}

			}

		}

		if (path.equals("/delete.do")) {
			long account_id = Long.parseLong(request.getParameter("accnum"));

			try {
				if (bankService.deleteBankAccount(account_id)) {
					out.println("<h2> Deleted bank account");
					out.println("<h2> <a href='index.html'> |HOME|</h2>");
					out.close();
				}
			} catch (BankAccountNotFoundException e) {
				e.getMessage();
				out.println("<h2> Bank account dont exists");
				out.println("<h2> <a href='index.html'> |HOME|</h2>");
			}

		}
		if (path.equals("/deposit.do")) {
			long account_id = Long.parseLong(request.getParameter("account_id"));

			double amount = Double.parseDouble(request.getParameter("amount"));

			try {
				double accountBalance = bankService.deposit(account_id, amount);
				out.println("<h2> Amount is deposited" + accountBalance);
				out.println("<h2> <a href='index.html'> |HOME|</h2>");
				out.close();
			} catch (BankAccountNotFoundException e) {
				logger.error("Exception :", e);
				out.println("<h2> Bank account dont exists");
				out.println("<h2> <a href='index.html'> |HOME|</h2>");

			}

		}

		if (path.equals("/fundTransfer.do")) {
			long from_Account = Long.parseLong(request.getParameter("fromAccount"));
			long to_Account = Long.parseLong(request.getParameter("toAccount"));

			double amount = Double.parseDouble(request.getParameter("amount"));

			try {
				double accountBalance = bankService.fundTransfer(from_Account, to_Account, amount);
				out.println("<h2> Amount is transfered" + accountBalance);
				out.println("<h2> <a href='index.html'> |HOME|</h2>");
				out.close();
			} catch (LowBalanceException | BankAccountNotFoundException e) {
				logger.error("Exception :", e);
				if (e instanceof LowBalanceException) {
					out.println("<h2> You do not have suffucient fund");
					out.println("<h2> <a href='index.html'> |HOME|</h2>");
				} else {
					out.println("<h2> Bank account dont exists");
					out.println("<h2> <a href='index.html'> |HOME|</h2>");
				}
			}

		}

		if (path.equals("/getAccountDetailsById.do")) {
			long account_Id = Long.parseLong(request.getParameter("accountID"));
			try {
				BankAccount account = bankService.findAccountById(account_Id);

				RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayAccountDetailsById.jsp");
				request.setAttribute("accounts", account);
				dispatcher.forward(request, response);
			} catch (BankAccountNotFoundException e) {

				e.printStackTrace();
			}

		}

		if (path.equals("/getDisplayDetailsById.do")) {
			long account_Id = Long.parseLong(request.getParameter("accountID"));
			try {
				BankAccount account = bankService.findAccountById(account_Id);

				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateBankaccountDetails.jsp");
				request.setAttribute("accounts", account);
				dispatcher.forward(request, response);
			} catch (BankAccountNotFoundException e) {

				e.printStackTrace();
			}

		}

		if (path.equals("/getUpdateDetailsById.do")) {
			long account_Id = Long.parseLong(request.getParameter("cid"));
			String customer_name = request.getParameter("cname");
			String account_type = request.getParameter("ctype");
			boolean account = false;
			System.out.println(account_Id);
			System.out.println(account_type);
			System.out.println(customer_name);
			try {
				account = bankService.updateBankAccountDetails(account_Id, customer_name, account_type);
			} catch (BankAccountNotFoundException e) {
			
				e.printStackTrace();
			}

			if (account)
				response.sendRedirect("getAllBankAccounts.do");

		}

	}

}
