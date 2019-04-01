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
<title>Bank Application</title>
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

			<li class="nav-item"><a class="nav-link" href="Display.html">Display
					Account details</a></li>
			<li class="nav-item"><a class="nav-link" href="Delete.html">Delete
					Account</a></li>
			<li class="nav-item"><a class="nav-link"
				href="UpdateDetails.html">Update Bank Account Details</a></li>

		</ul>
	</nav>
	<form action="getUpdateDetailsById.do" method="post">
	
		<div class="title1">
			<h1 class="col-sm-6 col-form-label">Update Bank Account Details
			</h1>

		</div>
		<div class="form-group mpadding col-md-6">

			<label for="anumber">Account number</label> <input type="text"
				class="form-control" id="anumber" value="${accounts.accountId}" readonly="readonly" name="cid"
				placeholder="Enter your account number" >
		</div>
		</nav>

		<div class="form-group mpadding col-md-6">

			<label for="anumber">Enter customer name</label> <input type="text"
				class="form-control" id="anumber" name="cname"
				value="${accounts.accountHolderName}"
				placeholder="Enter name to be updated" >
		</div>
		<div class="form-group mpadding col-md-6">

			<label for="anumber">Enter Balance</label> <input type="text"
				class="form-control" id="anumber" value="${accounts.accountBalance}" readonly="readonly" name="cbal"
				placeholder="Enter amount to be updated" >
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Select Account Type</label> <select
				 value="${accounts.accountType}" name="ctype">
				<option value="saving">Saving</option>
				<option value="current">Current</option>

			</select>
		</div>
		<div class="form-group mpadding col-md-2">
			<input type="submit" class="btn btn-success "
				style="margin-bottom: 280px;">Submit</button>

		</div>

</form>
</body>
</html>