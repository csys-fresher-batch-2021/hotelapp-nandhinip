<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="ISO-8859-1">
<title>Your Bill</title>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="BillDisplay" method="get">
			<div style="table-align: center;">
				<h4>Your Bill Amount</h4>

				<table class="table table-borderless">
					<caption></caption>
					<thead>
						<tr>
							<th scope="col">Choices</th>
							<th scope="col">Price (INR)</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="choice" items="${BILL}">
							<tr>
								<td>${choice.key}</td>
								<td>${choice.value }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<button type="submit" class="btn btn-success">Book</button>
			<a href="javascript:history.go(-1);" class="btn btn-secondary">Change
				Choice</a>
		</form>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>