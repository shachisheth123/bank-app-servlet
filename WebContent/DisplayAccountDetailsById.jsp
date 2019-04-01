<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="prop.css"></link>
<title>Display Account Details</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="index.html">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="OpenAccount.html">Open
					a Account</a></li>
			<li class="nav-item"><a class="nav-link" href="Withdraw.html">Withdraw</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="Deposit.html">Deposit</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="FundTrans.html">Fund
					Transfer</a></li>
			<li class="nav-item"><a class="nav-link"
				href="SearchAccountUsingID.html">Search Account Using Id</a></li>

			<li class="nav-item"><a class="nav-link" href="Checkbal.html">Check
					Balance</a></li>

			<li class="nav-item"><a class="nav-link"
				href="getAllBankAccounts.do">Display Account details</a></li>
			<li class="nav-item"><a class="nav-link" href="Delete.html">Delete
					Account</a></li>
			<li class="nav-item"><a class="nav-link"
				href=""UpdateDetails.html"">Update Bank Account Details</a>
			</li>

		</ul>
	</nav>
	<div class="title1">
		<h1 class="col-sm-6 col-form-label">Account Details</h1>

	</div>
	<div class="form-group">
		<table class=" table  mpadding col-md-8">
			<thead>
				<tr>
					<th scope="col">Account Number</th>
					<th scope="col">Customer Name</th>
					<th scope="col">Account Type</th>
					<th scope="col">Account Balance</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>${accounts.accountId}</td>
					<td>${accounts.accountHolderName}</td>
					<td>${accounts.accountType}</td>
					<td>${accounts.accountBalance}</td>
				</tr>

			</tbody>
		</table>
	</div>



</body>
</html>