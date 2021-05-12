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
	<form action="signUp" method="get">
	
	<table class="table table-borderless">
	<caption></caption>
	<tbody>
	<tr>
	<th scope="col"><label for=userName>Name</label></th>
	<th scope="col"><input type=text name="name" id="userName" placeholder="Your name" pattern="[A-Za-z]{3,30}" required autofocus></th> 
	</tr>
	
	<tr>
	<th scope="col"><label for="MobileNumber">Mobile Number</label> </th>
	<th scope="col"><input type="tel" name="MobileNumber" id="userMobile" placeholder="Mobile Number"pattern="[0-9]{10}" required></th>  
	</tr>
	
	<tr>
	<th scope="col"><label for="password">Password</label></th>
	<th scope="col"><input type="password" name="password"id="pwd" placeholder="8-Character password" pattern="[a-zA-Z0-9]{8}" required></th> 
	</tr>
	</tbody>
	</table>
	
	<button type="submit" class="btn btn-success">Sign Up</button>
	<button type="button" onClick="window.location.reload()" class="btn btn-danger">Reset</button>
	<a href="login.jsp" class="btn btn-secondary" role="button">Login</a>
	</form>
	</main>
</body>
</html>