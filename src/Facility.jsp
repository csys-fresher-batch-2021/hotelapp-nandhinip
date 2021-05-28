<!DOCTYPE html>
<%@page import="java.util.Map"%>
<%@page import="in.nandhini.service.DisplayFacility"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Facilities</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Room Types</h3>
		<div class="card">
			<h5 class="card-header">AC/FAN (per Hour)</h5>
			<div class="card-body">
				<img class="rounded mx-auto d-block" width="400" height="250"
					src="AcChoice.jpg" alt="Card image cap">
					 <%
						Map<String, Double> acChoice = DisplayFacility.getAcOption();
						for (String acOption : acChoice.keySet()) {
							double price = acChoice.get(acOption);
					 %>
				    <h6><%=acOption%> : <%=price%> INR per hour</h6>
					<%}%>
					<p class="card-text">Your's choice is ours. We respect your choice</p>
			</div>
		</div>
		<br />

		<div class="card">
			<h5 class="card-header">Pool Access</h5>
			<div class="card-body">
				<img class="rounded mx-auto d-block" width="400" height="250"
					src="PoolChoice.jpg" alt="Card image cap">
					<%
						Map<String, Double> poolChoice = DisplayFacility.getPoolAccessOption();
						for (String poolOption : poolChoice.keySet()) {
							double price = poolChoice.get(poolOption);
						%>
						<h6><%=poolOption%> : <%=price%> INR per hour</h6>
						<%}%>
				<p class="card-text">Your's choice is ours. We respect your
					choice</p>
			</div>
		</div>
		<br />

		<div class="card">
			<h5 class="card-header">Transport</h5>
			<div class="card-body">
				<img class="rounded mx-auto d-block" width="400" height="250"
					src="TransportChoice.jpg" alt="Card image cap">
					<%
						Map<String, Double> transportChoice = DisplayFacility.getTransportOption();
						for (String transportOption : transportChoice.keySet()) {
							double price = transportChoice.get(transportOption);
					%>


					<h6><%=transportOption%> : <%=price%> INR per hour</h6>
					<%}%>
				<p class="card-text">Your's choice is ours. We respect your
					choice</p>
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