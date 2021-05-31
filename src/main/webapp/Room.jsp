<!DOCTYPE html>
<%@page import="in.nandhini.model.MessageConstants"%>
<%@page import="in.nandhini.service.DisplayRooms"%>
<%@page import="java.util.Map"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Room Types</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Room Types</h3>


		<div class="card">
			<h5 class="card-header">Mountain View</h5>
			<div class="card-body">
				<img class="rounded mx-auto d-block" width="400" height="250"
					src="MountainView.jpg" alt="Card image cap">
					<%
						double price= DisplayRooms.getRoomAvailable().get(MessageConstants.MOUNTAINVIEW);
					%>
				<h5 class="card-title"><%=price%> INR</h5>
				<h6>Accommodation: 5 Members</h6>
				<p class="card-text">Amazing view of mountain will have your
					heart. If you are the nature lover, then It's the place for you.</p>
			</div>
		</div>
		<br />

		<div class="card">
			<h5 class="card-header">Night Ocean View</h5>
			<div class="card-body">
				<img class="rounded mx-auto d-block" width="400" height="250"
					src="OceanView.jpg" alt="Card image cap">
					<%
						double ovPrice= DisplayRooms.getRoomAvailable().get(MessageConstants.OCEANVIEW);
					%>
				<h5 class="card-title"><%=ovPrice%> INR</h5>
				<h6>Accommodation: 5 Members</h6>
				<p class="card-text">Fascinating view and the sound of waves
					touching the shore will touch your heart eventually. If you are
					eager to sense that feel, then It's for you.</p>
			</div>
		</div>
		<br />

		<div class="card">
			<h5 class="card-header">Night City View</h5>
			<div class="card-body">
				<img class="rounded mx-auto d-block" width="400" height="250"
					src="CityView.jpg" alt="Card image cap">
					<%
						double cvPrice= DisplayRooms.getRoomAvailable().get(MessageConstants.OCEANVIEW);
					%>
				<h5 class="card-title"><%=cvPrice%> INR</h5>
				<h6>Accommodation: 5 Members</h6>
				<p class="card-text">The Stunning view of busy city will create
					anxiety to get down and explore. The suite is waiting for you.</p>
			</div>
		</div>
		<br />
		
		<div>
			<a href="index.jsp" class="btn btn-secondary" role="button">Previous</a>
		</div>
		<br />
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>