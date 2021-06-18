<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Bliss Hotel</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">

			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<c:choose>
					<c:when test="${empty LOGGED_IN_USER}">
						<li class="nav-item active"><a class="nav-link"
							href="index.jsp">Home <span class="sr-only">(current)</span></a>
						<li class="nav-item"><a class="nav-link" href="Room.jsp">Rooms</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="Facility.jsp">Facility</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="RoomBooking.jsp">Book Room</a></li>
					</c:when>
					<c:when test="${ LOGGED_IN_USER eq'admin'}">
					</c:when>
					<c:when test="${not empty LOGGED_IN_USER}">
						<li class="nav-item active"><a class="nav-link"
							href="index.jsp">Home <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="Room.jsp">Rooms</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="Facility.jsp">Facility</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="RoomBooking.jsp">Book Room</a></li>
					</c:when>
				</c:choose>
			</ul>

			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<c:choose>
					<c:when test="${empty LOGGED_IN_USER}">
						<li class="nav-item"><a class="nav-link" href="contactUs.jsp">Contact
								Us</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="login.jsp">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="SignUp.jsp">Register</a>
						</li>
					</c:when>
					<c:when test="${LOGGED_IN_USER eq 'admin'}">
						<li class="nav-item"><a class="nav-link" href="#">Welcome
								${LOGGED_IN_USER}</a></li>
						<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
						</li>
					</c:when>
					<c:when test="${not empty LOGGED_IN_USER}">
						<li class="glyphicon glyphicon-shopping-cart"><a
							class="nav-link" href="cart">My Booking</a></li>
						<li class="nav-item"><a class="nav-link" href="contactUs.jsp">Contact
								Us</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Welcome
								${LOGGED_IN_USER}</a></li>
						<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
						</li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</nav>
</header>
