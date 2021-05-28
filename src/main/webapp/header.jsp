<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<%String loggedInUsername = (String)session.getAttribute("LOGGED_IN_USER");%>
		<a class="navbar-brand" href="#">Bliss Hotel</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			
			 <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<%if (loggedInUsername==null) {%>
				<li class="nav-item active">
				<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="BookRoomBeforeLogin">Book Room</a>
				</li>
				<%
				}else if(loggedInUsername.equals("admin")){
				%>
				<li class="nav-item">
				<a class="nav-link" href="EditRoom.jsp">Booking Details</a></li>
				<%}else{%>
				 <li class="nav-item active">
				<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="BookRoomBeforeLogin">Book Room</a>
				</li>
				<%} %>	
			</ul>

			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<%
				
				if ( loggedInUsername==null) {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="SignUp.jsp">Register</a>
				</li>
				<%
				} else if(loggedInUsername.equals("admin")) {
				%>
				<li class="nav-item"><a class="nav-link" href="#">Welcome <%=loggedInUsername%></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
				</li>
				<%
				}else{
				%>
				<li class="glyphicon glyphicon-shopping-cart">
				<a class="nav-link" href="cart.jsp">Your Cart</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Welcome <%=loggedInUsername%></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
				</li>
				<%} %>
			</ul>
		</div>
	</nav>
</header>
