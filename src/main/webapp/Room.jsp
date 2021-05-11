<!DOCTYPE html>
<%@page import="java.util.Map"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Types</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Room Types</th>
					<th>Package Price(INR)</th>
					<th>Choose</th>
				</tr>
			</thead>

			<tbody>
			<%
			int i=0;
			Map<String,Double>room =DisplayRooms.getAvailableRooms();
			for (String rooms : room.keySet()) {
				double price = room.get(rooms);
				i++;
			%>
				<tr>
					<td><%=i%></td>
					<td><%=rooms%></td>
					<td><%=price%></td>
					<td><button type="button" class="btn btn-secondary">Proceed with this pack</button></td>
				</tr>
			</tbody>
	<%} %>
		</table>

	</main>
</body>
</html>