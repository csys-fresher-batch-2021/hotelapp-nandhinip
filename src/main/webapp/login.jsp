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
		<form action="journeyDetails.html">
		<table class="table table-borderless">
			<tbody>
			<tr>
			<th scope="col"><label for="user">Mobile Number</label></th>
			<th scope="col"> <input type="tel" name="Mobile Number" id="user" placeholder="Mobile Number" pattern="[0-9]{10}" required autofocus></th>
			</tr>
			
		    <tr>
		    <th scope="col"> <label for="password">Password</label></th>
		    <th scope="col"><input type="password" name="password" id="pwd" placeholder="8-Character password" pattern="[a-z0-9]{8}" min="8" required></th>
		    </tr>
			</tbody>
		</table>
		<button type="submit" class="btn btn-success">Login</button>
		<a href="SignUp.jsp" class="btn btn-secondary" role="button">Sign-Up</a>
		<button type="button" onClick="window.location.reload()" class="btn btn-danger">Reset</button>
		<a href="signUp.jsp"></a>	
		</form>
	</main>
</body>
</html>