<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
			<th scope="col"><label for=username>Name</label></th>
	<th scope="col"><input type=text name="username" id="username" placeholder="Your name" pattern="[a-z]{3,30}" required autofocus></th> 
			</tr>
			
		    <tr>
		    <th scope="col"> <label for="password">Password</label></th>
		    <th scope="col"><input type="password" name="password" id="pwd" placeholder="8-Character password" pattern="[a-z0-9]{8}" min="8" required></th>
		    </tr>
			</tbody>
		</table>
		<button type="submit"class="btn btn-success">Login</button>
		<a href="SignUp.jsp" class="btn btn-secondary" role="button">Sign-Up</a>
		<button type="reset"class="btn btn-danger">Reset</button>	
		<a href="forgotPwd.jsp" class="btn btn-danger">Forgot Password</a>
		</form>
	</main>
	<br/>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>