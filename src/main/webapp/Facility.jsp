<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Facilities</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="row">
			<div class="col text-center">
				<h3>Facility</h3>
			</div>
		</div>

		<div class="row row-cols-1 row-cols-md-3">
			<div class="col mb-4">
				<div class="card h-100">
					<h5 class="card-header">AC/FAN (per Hour)</h5>
					<div class="card-body">
						<a href="RoomBooking.jsp?facility=ac"><img
							class="rounded mx-auto d-block" width="400" height="250"
							src="AcChoice.jpg" alt="Card image cap"></a>
						<h6 id="fan"></h6>
						<h6 id="ac"></h6>
						<p class="card-text">Your's choice is ours. We respect your
							choice</p>
					</div>
				</div>
			</div>

			<div class="col mb-4">
				<div class="card h-100">
					<h5 class="card-header">Pool Access</h5>
					<div class="card-body">
						<a href="RoomBooking.jsp?facility=pool"><img
							class="rounded mx-auto d-block" width="400" height="250"
							src="PoolChoice.jpg" alt="Card image cap"></a>
						<h6 id="pool"></h6>
						<p class="card-text">Your's choice is ours. We respect your
							choice</p>
					</div>
				</div>
			</div>

			<div class="col mb-4">
				<div class="card h-100">
					<h5 class="card-header">Transport</h5>
					<div class="card-body">
						<a href="RoomBooking.jsp?facility=car"><img
							class="rounded mx-auto d-block" width="400" height="250"
							src="TransportChoice.jpg" alt="Card image cap"></a>
						<h6 id="transport"></h6>
						<p class="card-text">Your's choice is ours. We respect your
							choice</p>
					</div>
				</div>
			</div>
		</div>


		<div>
			<a href="javascript:history.go(-1);" class="btn btn-secondary">Back</a>
		</div>

		<script>
		function getAc(){
			let url="acServlet"
			axios.get(url).then(res=> {
				let result = res.data;
				document.getElementById("fan").innerHTML="FAN: "+result['FAN']+" INR";
				document.getElementById("ac").innerHTML="AC: "+result['AC']+" INR";
			})
		}
		
		function getPool(){
			let url="PoolServlet"
			axios.get(url).then(res=> {
				let result = res.data;
				console.log(result);
				document.getElementById("pool").innerHTML=result['Pool Access']+" INR";
			})
		}
		
		function getTransport(){
			let url="TransportServlet"
			axios.get(url).then(res=> {
				let result = res.data;
				console.log(result);
				document.getElementById("transport").innerHTML=result['With Transport']+" INR";
			})
		}
		getAc();
		getPool();
		getTransport();
		</script>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>