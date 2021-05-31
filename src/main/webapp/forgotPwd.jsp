<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form  onsubmit="getPwd()">
			<table class="table table-borderless">
				<caption></caption>
				<tbody>
					<tr>
						<th scope="col"><label>Enter the Mobile Number</label></th>
					</tr>
					<tr>
						<th scope="col"><input type="number" name="mobNo" id="mobNo"
							pattern="[0-9]{10}" min="0" required></th>
					</tr>
					<tr>
						<th scope="col"><button type="submit" class="btn btn-success">Forgot Password</button>
					    <button type="reset"  class="btn btn-danger">Reset</button>
					</tr>
				</tbody>
			</table>
		
		<script type="text/javascript">
			function getPwd(){
				event.preventDefault();
				console.log("Fetching");
				let num = document.querySelector("#mobNo").value;
				console.log(num);
				let url = "ForgotPwd?mobNo="+num;
				axios.get(url).then(res=> {
					let result = res.data;
					console.log(result);
					if(result != null){
						alert("Your Password: "+result);
					}
					else{
						alert("User doesn't exist, kindly register");
					}
				})
			}
		</script>
		
		</form>
	</main>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>