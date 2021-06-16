<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Contact Us</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1"
	crossorigin="anonymous">
<style>
body {
	background-image: url('contact.jpg');
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<section id="contact">
			<div class="container">
				<h3 class="text-center text-uppercase">contact us</h3>
				<p class="text-center w-75 m-auto"></p>
				<div class="row">
					<div class="col-sm-12 col-md-6 col-lg-3 my-5">
						<div class="card h-100">
							<div class="card border-0">
								<div class="card-body text-center">
									<i class="fa fa-phone fa-5x mb-3" aria-hidden="true"></i>
									<h4 class="text-uppercase mb-5">call us</h4>
									<a href="tel:+91 9999 8888 89">+91 9999 8888 89</a>
								</div>
							</div>
						</div>
					</div>

					<div class="col-sm-12 col-md-6 col-lg-3 my-5">
						<div class="card h-100">
							<div class="card border-0">
								<div class="card-body text-center">
									<i class="fa fa-map-marker fa-5x mb-3" aria-hidden="true"></i>
									<h4 class="text-uppercase mb-5">Location</h4>
									<address>888/Bliss Hotel,Peace Land,India</address>
								</div>
							</div>
						</div>
					</div>

					<div class="col-sm-12 col-md-6 col-lg-3 my-5">
						<div class="card h-100">
							<div class="card border-0">
								<div class="card-body text-center">
									<i class="fa fa-globe fa-5x mb-3" aria-hidden="true"></i>
									<h4 class="text-uppercase mb-5">e-mail</h4>
									<a href="mailto:customercare@bliss.com">customercare@bliss.com</a>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
