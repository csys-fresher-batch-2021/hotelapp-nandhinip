<!DOCTYPE html>
<%@page import="in.nandhini.service.UserManager"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="ForgotPwd" method="post">
			<table class="table table-borderless">
				<caption></caption>
				<tbody>
					<tr>
						<th scope="col"><label>Enter the Mobile Number</label></th>
					</tr>
					<tr>
						<th scope="col"><input type="number" name="mobNo" id="mobNo"
							pattern="[0-9]{10}" required></th>
					</tr>

					
					<%
					Long mobNo=(Long)session.getAttribute("MOBILE_NO");
					String pwd = (String) session.getAttribute("PASSWORD");
					if (pwd != null && mobNo!=null) {
					%>
					<tr>
						<th scope="col">Your Password is: <%=pwd%></th>
					</tr>
					<%
					} else if(pwd==null && mobNo!=null) {
					%>
					<tr>
						<th scope="col">User doesn't exist, kindly register</th>
					</tr>
					<%
					}
					%>

					<tr>
						<th scope="col"><button type="submit" class="btn btn-success">Forgot Password</button>
					    <a href="DeleteForgotPwdDetails" class="btn btn-secondary">Previous</a></th>
					</tr>
				</tbody>
			</table>
		
		</form>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>