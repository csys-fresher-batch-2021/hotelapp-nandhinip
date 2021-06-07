
<html>
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>Bliss Hotel</h1>
		<img class="img-fluid" src="Entrance.jpg" alt="Card image cap">
		<h3>About</h3>
		<p>Built in 1901 and substantially remodeled to meet BEST WESTERN standards , 
		the Bliss Hotel in Pert Land, captures the ambiance of the whaling days and 
		the plantation era, with architecture that evokes the tranquil lifestyle of
		 the century while offering all the comforts and convenience of a modern hotel.
		</p>

		<div class="row">
			<div class="col-sm-6">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="Room.jpg" alt="Card image cap">
					<div class="card-body">
						<h3 class="card-title">Rooms Available</h3>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Mountain View</li>
						<li class="list-group-item">Night Ocean View</li>
						<li class="list-group-item">Night City View</li>
					</ul>
					<div class="card-body">
						<a href="Room.jsp" class="card-link">Room Details</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="facilityIcon.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h3 class="card-title">Facilities Available</h3>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Transport</li>
						<li class="list-group-item">Pool Access</li>
						<li class="list-group-item">AC Option</li>
					</ul>
					<div class="card-body">
						<a href="Facility.jsp" class="card-link">Facility Details</a>
					</div>
				</div>
			</div>
		</div>
		<br />
	

	</main>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>
