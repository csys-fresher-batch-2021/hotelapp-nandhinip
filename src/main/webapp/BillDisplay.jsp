<!DOCTYPE html>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<html lang="en">
<head>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script> --%>
<meta charset="ISO-8859-1">
<title>Your Bill</title>
</head>
<body>

	 
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="payment.jsp" method="post">
		
			<div style="table-align:center;">
			<h4>Your Bill Amount</h4>
			
				
			 	<table class="table table-borderless" >
				<caption></caption>
				<thead>
				<tr>
				<th scope="col">Choices</th>
				<th scope="col"> Price (INR)</th>
				</tr>
				</thead>
				<tbody>
			   <%
				 LinkedHashMap<String,Double> bill=(LinkedHashMap<String,Double>)request.getAttribute("BILL");
				 for (String choice : bill.keySet()) {
				 double price = bill.get(choice);
				%>
				<tr>
					<td><%=choice%></td>
					<td><%=price%></td>
				</tr>
				</tbody>
				<%
				}
				%>
				<%-- <% LinkedHashMap<String,Double> bill=(LinkedHashMap<String,Double>)request.getAttribute("BILL"); %>
	            <c:forEach var="choice" items="${bill.keySet()}">
	            <tr>
	                <td><c:out value="${choice}" /></td>
	                <td><c:out value="${bill.get(choice)}"/></td>
	            </tr>
	            </c:forEach> --%>
	            </tbody>
	   		    </table>
	   		    
			</div>
		<button type="submit" class="btn btn-success">Confirm</button>
		<a href="javascript:history.go(-1);" class="btn btn-secondary">back</a>
     
     	<!-- <script>
		function get(){
			let url = "BookRoom?";
			let data = null;
			axios.post(url, data).then(res=>{
				let bill = res.data;
				console.log(bill);
				let content = "";
				for(let key in bill){
					let value = choices[key];
					content +="<tr><td>" + key +"</td><td>Rs." + value +"</td></tr>";
				}
				document.querySelector("#bill_tbl").innerHTML= content;
			})
		}
		get();
		</script> -->

		</form>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>