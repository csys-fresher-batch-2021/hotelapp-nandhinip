<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>room Booking</title>
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
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form id="orderForm" action="BookRoom" method="post">

			<table class="table table-borderless">
			<caption></caption>
			<tbody>
			<tr>
				<th scope="col"><label for="cid">Check-In Date</label> </th>
				<th scope="col">
				<input type="dateTime-local" name="cid" id="cid" width="312" required oninput="onCINSelected()">
				</th>
			</tr>
			
			<tr>
				<th scope="col"><label for="cod">Check-out Date</label> </th>
				<th scope="col"><input type="dateTime-local"id="cod" name="cod" width="312" required></th>
			</tr>

			<tr>
				<th scope="col"><label for="suiteType">Suite Type</label> </th>
				<th scope="col"><select class="form-control" id="suiteType" name="suiteType" required>
					<option value="" disabled="disabled" selected="selected">Select an option</option>
					<option value="Mountain View">Mountain View</option>
					<option value="Night Ocean View">Night Ocean View</option>
					<option value="Night City View">Night City View</option>
				</select></th>
			</tr>
			

			<tr>
				<th scope="col"><label for="AcOption">AC/FAN</label> </th>
				<th scope="col"><select class="form-control" name="AcOption" id="AcOption" required>
				<option value="" disabled="disabled" selected="selected">Select an option</option>
				<option value="AC">AC</option>
				<option value="FAN">Fan</option>
				</select></th>
			</tr>

			<tr>
				<th scope="col"><label for="poolOption">Need a Pool Access</label></th>
				 <th scope="col"><select class="form-control" name="poolOption" id="poolOption" required="required">
				 <option value="" disabled="disabled" selected="selected">Select an option</option>
				 <option value="Pool Access">Yes</option>
				 <option value="Without Pool Access">No</option>
				 </select></th>
			</tr>
			

			<tr>
				<th scope="col"><label for="transportOption">Need a Transport Access</label></th>
				 <th scope="col"><select class="form-control" name="transportOption" id="transportOption" required>
				 <option value="" disabled="disabled" selected="selected">Select an option</option>
				 <option value="With Transport">Yes</option>
				 <option value="Without Transport">No</option>
				 </select></th>
			</tr>
			
			<tr>
			<th scope="col"><button type="submit" class="btn btn-secondary">Estimate Price</button></th>
			</tr>

			</tbody>
			</table>
			
			<script>
				var today = new Date()
				var jsonToday = today.toJSON()
				document.getElementById("cid").setAttribute("min",jsonToday.substr(0, 16))

				function onCINSelected() {
					var cin = document.getElementById("cid").value;
					document.getElementById("cod").setAttribute("min", cin);
				}
				
				function availability(){
					var op=document.getElementById("suiteType").getElementsByTagName("option")
					let url = "RoomAvailability";
					fetch(url).then(res=>res.json()).then(res=>{
						console.log(res);
						let data = [];
						data = res;
						console.log(op)
							console.log(op[1]);
							(data[0]>1)?op[1].disabled=true:op[1].disabled=false;
							(data[1]>9)?op[2].disabled=true:op[2].disabled=false;
							(data[2]>9)?op[3].disabled=true:op[3].disabled=false;
						});
					}
				availability();
			</script>
		</form>
		<div  class="info">
		<strong>Option will be disabled, if there is no availability</strong>
		 <p><strong>! </strong> Mountain View Room: Availability - 2</p>
		 <p><strong>! </strong> Night Ocean View Room: Availability - 10</p>
		  <p><strong>! </strong> Night City View Room: Availability - 10</p>
		  </div>
		</main>

</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>