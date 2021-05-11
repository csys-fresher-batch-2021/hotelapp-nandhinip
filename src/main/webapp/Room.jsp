<!DOCTYPE html>
<%@page import="in.nandhini.service.DisplayRooms"%>
<%@page import="java.util.Map"%>
<html  lang="en">
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
					<th scope="col">S.No</th>
					<th scope="col">Room Types</th>
					<th scope="col">Package Price(INR)</th>
					<th scope="col">Choose</th>
				</tr>
			</thead>

			<tbody>
			<%
			int i=0;
			Map<String,Double>room = DisplayRooms.getRoomAvailable();
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