<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<meta charset="utf-8" />
<title>room Booking</title>
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
						for(var i=0; i<op;i++){
							console.log(op[i]);
							(data[0]>1)?op[i].disabled=true:op[i].disabled=false;
							(data[1]>1)?op[i].disabled=true:op[i].disabled=false;
							(data[2]>1)?op[i].disabled=true:op[i].disabled=false;
						}
						
						});
					}
				availability();
			</script>
		</form>
		</main>

</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>