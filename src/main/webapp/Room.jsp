<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Room Types</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
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
				<h5 class="card-title" id="mv"></h5>
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
				<h5 class="card-title" id="ov"></h5>
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
				<h5 class="card-title" id="nv"></h5>
				<h6>Accommodation: 5 Members</h6>
				<p class="card-text">The Stunning view of busy city will create
					anxiety to get down and explore. The suite is waiting for you.</p>
			</div>
		</div>
		<br />

		<div>
			<a href="javascript:history.go(-1);" class="btn btn-secondary">Back</a>
		</div>
		<br />
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