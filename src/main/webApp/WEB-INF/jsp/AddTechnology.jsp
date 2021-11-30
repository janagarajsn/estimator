<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
<script src="webjars/jquery/3.6.0/jquery.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.slim.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/dataCenter.css">
<script>
	$(document).ready(function() {
		var successText = $('#successMsg').text();
		if (successText) {
			$('#successMsgDiv').show();
			$('#successMsgDiv').html('');
		}
		else{
			$('#successMsgDiv').hide();
		}
	});
</script>
<title>Technology</title>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h3>Add Technology</h3>
		</div>
		<div id="successMsgDiv" style="text-align: center;font-weight: bold" >
			<label id="successMsg" style="color:green">${message}</label>
		</div>
		<div class="form-content">
			<form method="POST" action="/addTechnology">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Technology Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="technology_name"
							placeholder="Technology Name">
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="button" class="btn btn-warning center"
					onclick="location.href = '/admin';">Back</button>
			</form>
		</div>
	</div>

</body>
</html>
