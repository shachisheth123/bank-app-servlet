package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloworld", loadOnStartup = 1, urlPatterns = { "/hello", "/helloWorld", "/login" })
public class HelloWorldController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher;

	public HelloWorldController() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		System.out.println("Hello World !!!!!"); // prints on the server

		PrintWriter out = response.getWriter();
		out.print("Helloo World");// prints on browser

		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (username.equals("root") && password.equals("root@123")) {
			// out.println("<h2> Login Successful . Welcome" +" " +username + "</h2>");
			dispatcher = request.getRequestDispatcher("success.html");

		}

		else {
			dispatcher = request.getRequestDispatcher("Error.html");
		}
		// out.println("<h2> Invalid username or password </h2>");

		dispatcher.forward(request, response);
	}

}
