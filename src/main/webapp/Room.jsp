<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Room Types</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		
		<div class="row">
			<div class="col text-center">
				<h4>Room Types</h4>
			</div>
		</div>
		
		<div class="row row-cols-1 row-cols-md-3">
			<div class="col mb-4">
				<div class="card h-100">
					<h5 class="card-header">Mountain View</h5>
					<div class="card-body">
						<a href="RoomBooking.jsp"> <img
							class="rounded mx-auto d-block" width="350" height="250"
							src="MountainView.jpg" alt="Card image cap">
						</a>
						<h5 class="card-title" id="mv"></h5>
						<h6>Accommodation: 5 Members</h6>
						<p class="card-text">Amazing view of mountain will have your
							heart. If you are the nature lover, then It's the place for you.</p>
					</div>
				</div>
			</div>

			<div class="col mb-4">
				<div class="card h-100">
					<h5 class="card-header">Night Ocean View</h5>
					<div class="card-body">
						<a href="RoomBooking.jsp"><img class="rounded mx-auto d-block" width="350" height="250"
							src="OceanView.jpg" alt="Card image cap"></a>
						<h5 class="card-title" id="ov"></h5>
						<h6>Accommodation: 5 Members</h6>
						<p class="card-text">Sound of waves
							touching the shore will touch your heart eventually. Eager to
							sense that feel, it's for you.</p>
					</div>
				</div>
			</div>


			<div class="col mb-4">
				<div class="card h-100">
					<h5 class="card-header">Night City View</h5>
					<div class="card-body">
						<a href="RoomBooking.jsp"><img class="rounded mx-auto d-block" width="350" height="250"
							src="CityView.jpg" alt="Card image cap"></a>
						<h5 class="card-title" id="nv"></h5>
						<h6>Accommodation: 5 Members</h6>
						<p class="card-text">The Stunning view of busy city will
							create anxiety to get down and explore. The suite is waiting for
							you.</p>
					</div>
				</div>
			</div>
		</div>

		<div>
			<a href="javascript:history.go(-1);" class="btn btn-secondary">Back</a>
		</div>

		<script type="text/javascript">
		function getRoom(){
			console.log("Fetching");
			let url="DisplayRoom"
			axios.get(url).then(res=> {
				let result = res.data;
				document.getElementById("mv").innerHTML=result['Mountain View']+" INR";
				document.getElementById("ov").innerHTML=result['Night Ocean View']+" INR";
				document.getElementById("nv").innerHTML=result['Night City View']+" INR"
			})
		}
		getRoom();
		</script>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>