<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Sign Up</h3>
	<form action="SignUp" method="post">
	
	<table class="table table-borderless">
	<caption></caption>
	<tbody>
	<tr>
	<th scope="col"><label for=userName>Name*</label></th>
	<th scope="col"><input type=text name="name" id="name" placeholder="Lower Case Name" 
	onchange="nameError()" pattern="[a-z]{3,30}" required autofocus></th> 
	</tr>
	
	<tr>
	<th scope="col"><label for="MobileNumber">Mobile Number*</label> </th>
	<th scope="col"><input type="tel" name="userMobile" id="userMobile" placeholder="10-Digit Number"
	onchange="mobNo()" pattern="[0-9]{10}" min=0 required></th>  
	</tr>
	
	<tr>
	<th scope="col"><p>Gender</p></th>
	<th scope="col">
	<input type="radio" id="gender" name="gender" value="Female">
	<label for="Female">Female</label>
	<input type="radio" id="gender" name="gender" value="Male">
	<label for="Male">Male</label>
	<input type="radio" id="gender" name="gender" value="other">
	<label for="other" >Other</label></th>
	</tr>
	
	<tr>
	<th scope="col"><label for="password">Password*</label></th>
	<th scope="col"><input type="password" name="pwd" id="pwd" placeholder=***
	onchange="password()" pattern="[a-z0-9]{8}" required></th> 
	</tr>
	</tbody>
	</table>
	
	<button type="submit" class="btn btn-success">Sign Up</button>
	<button type="reset"  class="btn btn-danger">Reset</button>
	<a href="login.jsp" class="btn btn-secondary" role="button">Login</a>
	</form>
	<script type="text/javascript">
			function mobNo(){
			var mobNo= document.querySelector("#userMobile").value;
				if(mobNo.length != 10){
					alert("Give 10 digit valid mobile number");
				}
			}
			function password(){
				var pass=document.querySelector("#pwd").value;
				if(pass.length!= 8){
					alert("Give 8-Characters(a-z,0-9) as password");
				}
			}
			function nameError(){
				var name=document.querySelector("#name").value;
				if(name.length<3 || name.length>25){
					alert("Lower case User name between 3-25 Character")
				}
			}
		</script>
	</main>
	<br/>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>