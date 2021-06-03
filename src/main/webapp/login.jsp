<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
div {
  margin-bottom: 15px;
  padding: 4px 12px;
}
.info {
  background-color: #e7f3fe;
  border-left: 6px solid #2196F3;
}

</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Login Page</h3>
		<form action="LoginServlet" method="post">
		<table class="table table-borderless">
		<caption></caption>
		
			<tbody>
			<tr>
			<tr>
			<th scope="col"><label for="MobileNumber">Mobile Number</label> </th>
			<th scope="col"><input type="tel" name="userPh" id="userPh" placeholder="10-digit number"
			onchange="mobNo()" pattern="[0-9]{10}" min=0 required></th>  
			</tr>
			
		    <tr>
		    <th scope="col"> <label for="password">Password</label></th>
		    <th scope="col"><input type="password" name="pwd" id="pwd" placeholder=*** 
		    onchange="password()" pattern="[a-z0-9]{8}" min="8" required></th>
		    </tr>
			</tbody>
		</table>
		<button type="submit"class="btn btn-success">Login</button>
		<a href="SignUp.jsp" class="btn btn-secondary" role="button">Sign-Up</a>
		<button type="reset"class="btn btn-danger">Reset</button>	
		<a href="forgotPwd.jsp" class="btn btn-danger">Forgot Password</a>
		</form>
		<script type="text/javascript">
			function mobNo(){
			var mobNo= document.querySelector("#userPh").value;
				if(mobNo.length != 10){
					alert("Give 10 digit valid mobile number");
				}
			}
			function password(){
				var pass=document.querySelector("#pwd").value;
				if(pass.length != 8){
					alert("Give 8-Characters(a-z,0-9) as password");
				}
			}
		</script>
	</main>
	<br/>
	<div class="info">
	  <p><strong>! </strong>Admin(Mobile Number:9900990090, Password:admin123)</p>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>