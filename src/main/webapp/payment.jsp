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
		<form action=Payment method="get">
		<table class="table table-borderless">
		<caption></caption>
			<tbody>
			<tr>
			<th scope="col"><p>Please select your card type*</p></th>
			<th scope="col"><input type="radio" id="card" name="card" value="credit" required>
			<label for="credit">Credit</label>
			<input type="radio" id="dard" name="card" value="debit">
			<label for="debit">Debit</label>
			<input type="radio" id="card" name="card" value="paypal">
			<label for="paypal" >Paypal</label></th>
			</tr>
			
			<tr>
			<th scope="col"><label>Card Number*</label></th>
			<th scope="col"><input type="number" id="cardNum" name="cardNum" onchange="cardNo()" placeholder="Card Number" pattern="[0-9]{16}" required></th>
			</tr>
			
			<tr>
			<th scope="col"><label>Valid Until*</label></th>
			<th scope="col"><input type="month" id="mon" name="mon" placeholder="yyyy-mm" required></th>
			</tr>
			
			<tr>
			<th scope="col"><label>CVV*</label></th>
			<th scope="col"><input type="password" id="cvv" name="cvv" onchange="Cvv()" placeholder="***" pattern="[0-9]{3}" required></th>
			</tr>
			
			</tbody>
		</table>
		<button  type="submit" class="btn btn-success" > Proceed </button>
		
		</form>
		<script>
		var today = new Date()
		var jsonToday = today.toJSON()
		document.getElementById("mon").setAttribute("min",jsonToday.substr(0, 7))
		
		function cardNo(){
			let cardNo=document.querySelector('#cardNum').value;
			if(cardNo.length != 16){
				alert("Enter 16-digit card number")
			}
		}
		
		function Cvv(){
			let cvv=document.querySelector('#cvv').value;
			if(cvv.length != 3){
				alert("Enter 3-Digit CVV number")
			}
		}
		</script>
	</main>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>