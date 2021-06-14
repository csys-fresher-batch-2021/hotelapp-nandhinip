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
		<h3>Room Types</h3>

		<div class="card">
			<h5 class="card-header">AC/FAN (per Hour)</h5>
			<div class="card-body">
				<img class="rounded mx-auto d-block" width="400" height="250"
					src="AcChoice.jpg" alt="Card image cap">
				<h6 id="fan"></h6>
				<h6 id="ac"></h6>
				<p class="card-text">Your's choice is ours. We respect your
					choice</p>
			</div>
		</div>
		<br />

		<div class="card">
			<h5 class="card-header">Pool Access</h5>
			<div class="card-body">
				<img class="rounded mx-auto d-block" width="400" height="250"
					src="PoolChoice.jpg" alt="Card image cap">
				<h6 id="pool"></h6>
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
				<h6 id="transport"></h6>
				<p class="card-text">Your's choice is ours. We respect your
					choice</p>
			</div>
		</div>
		<br />

		<div>
			<a href="javascript:history.go(-1);" class="btn btn-secondary">Back</a>
		</div>
		<br />
		<script>
		function getAc(){
			let url="acServlet"
			axios.get(url).then(res=> {
				let result = res.data;
				document.getElementById("fan").innerHTML=result['FAN']+" INR";
				document.getElementById("ac").innerHTML=result['AC']+" INR";
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