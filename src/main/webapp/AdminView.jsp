<!DOCTYPE html>
<%@page import="in.nandhini.model.BookingInfo"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Room Booking Details</title>
<style>
div {
  margin-bottom: 15px;
  padding: 4px 12px;
}
.info {
  background-color: #e7f3fe;
  border-left: 6px solid #2196F3;
}

</style>
</head>
<body onload="search()" >
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h5>Room Booking Details</h5>
		<label for=userName>Name</label>
		<input type=text name="name" id="name" placeholder="Lower Case Name" 
			onchange="search()" pattern="[a-z]{3,30}" required autofocus>
			<p id = "GFG_DOWN">  </p>
		<table id="table" class="table table-bordered">
			<caption></caption>	
		</table>
		<script>
		function search(){
			var userName=document.querySelector("#name").value
			let url = "BookingDetails";
			fetch(url).then(res=>res.json()).then(res=>{
				console.log(res);
				let data = [];
				data = res;
				if(userName!=null){
					data=searchUser(res,userName);
				}
				displayBookingDetails(data);
				});
			}
		
		
		function displayBookingDetails(data){
			var tableData = '<tr><th scope="col">Mobile Number</th><th scope="col">Name</th>'+
			'<th scope="col">Booked Date</th><th scope="col">Check-In Date</th><th scope="col">Suite Type</th>'+
			'<th scope="col">AC Choice</th><th scope="col">Pool Choice</th><th scope="col">Transport</th>'+
			'<th scope="col">Amount</th><th scope="col">Status</th><th scope="col">Modified Date</th></tr>'
				tableData+= '<tbody>'
			    for(i = 0;i < data.length; i++){
			    	tableData+= '<tr>';
			    	tableData+= '<td>' + data[i].mob_No + '</td>';
			    	tableData+= '<td>' + data[i].name + '</td>';
			    	tableData+= '<td>' + data[i].bookDate+ '</td>';
			    	tableData+= '<td>' + data[i].checkIn + '</td>';
			    	tableData+= '<td>' + data[i].suite + '</td>';
			    	tableData+= '<td>' + data[i].acChoice + '</td>';
			    	tableData+= '<td>' + data[i].poolChoice + '</td>';
			    	tableData+= '<td>' + data[i].transport + '</td>';
			    	tableData+= '<td>' + data[i].amount + '</td>';
			    	tableData+= '<td>' + data[i].status + '</td>';
			    	tableData+= '<td>' + data[i].modDate + '</td>';		        
			    	tableData+= '</tr>';
			    	tableData+='</tbody>';
				    document.getElementById("table").innerHTML = tableData;
			    }
				
		}
		
		
		function searchUser(res,userName){
				data = res.filter(res => res.name.includes(userName));
				return data;
		}
		
		</script>
		
		<div class="info">
	 	 <p><strong>! </strong> If there is no data regarding the name,table won't alter.
	 	  Refresh it, to get all details</p>
		</div>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>