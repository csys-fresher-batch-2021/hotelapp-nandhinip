<!DOCTYPE html>
<%@page import="in.nandhini.model.CartInfo"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<style>
body {
  background-image: url("bg.jpg");
}
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
</style>
<title>Cart</title>
</head>
<body>
 
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Your Cart</h3>
		<%List<CartInfo>cart=(List<CartInfo>)session.getAttribute("CART");
		 if(cart==null || cart.isEmpty()){
		%>
			<br><br/>
      		<img src="empty.jpg" alt="Paris" class="center">
      		<br><br/>
		<%}else{
			for(CartInfo yc:cart )	{
		%>
			<div class="col d-flex justify-content-center">
			<div class="card" style="width: 18rem;">
			  <div class="card-header">Your Cart </div>
			  <ul class="list-group list-group-flush">
			    <li class="list-group-item"><%=yc.getCheckIn() %></li>
			    <li class="list-group-item"><%=yc.getSuite() %></li>
			    <li class="list-group-item"><%=yc.getAcChoice() %></li>
			    <li class="list-group-item"><%=yc.getPoolChoice() %></li>
			    <li class="list-group-item"><%=yc.getTransport() %></li>
			    <li class="list-group-item">INR.<%=yc.getAmount() %></li>
			    <li  class="list-group-item"><a href="CancelOrder?id=<%=yc.getId() %>">Remove From Cart</a></li>
			  </ul>
			  </div>
			</div>
			<br>
		<%}} %>
		
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>