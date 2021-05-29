<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Online Payment</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Online Payment</h3>
		<form action=Payment>
		<table class="table table-borderless">
		<caption></caption>
			<tbody>
			<tr>
			<th scope="col"><p>Please select your card type</p></th>
			<th scope="col"><input type="radio" id="card" name="card" value="credit" required>
			<label for="credit">Credit</label>
			<input type="radio" id="dard" name="card" value="debit">
			<label for="debit">Debit</label>
			<input type="radio" id="card" name="card" value="paypal">
			<label for="paypal" >Paypal</label></th>
			</tr>
			
			<tr>
			<th scope="col"><label>Card Number</label></th>
			<th scope="col"><input type="number" id="cardNum" name="cardNum" placeholder="Card Number" pattern="[0-9]{16}" required></th>
			</tr>
			
			<tr>
			<th scope="col"><label>Valid Until</label></th>
			<th scope="col"><input type="month" id="mon" name="mon" placeholder="yyyy-mm" required></th>
			</tr>
			
			<tr>
			<th scope="col"><label>CVV</label></th>
			<th scope="col"><input type="password" id="cvv" name="cvv" placeholder="***" pattern="[0-9]{3}" required></th>
			</tr>
			
			</tbody>
		</table>
		<button  type="submit" class="btn btn-success" > Proceed </button>
		</form>
		<script>
		var today = new Date()
		var jsonToday = today.toJSON()
		document.getElementById("mon").setAttribute("min",jsonToday.substr(0, 7))
		</script>
	</main>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>