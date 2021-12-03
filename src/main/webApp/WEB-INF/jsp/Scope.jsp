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
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/dataCenter.css">
<title>Task</title>
<script>
	$(document).ready(function() {
		var successText = $('#successMsg').text();
		if (successText) {
			$('#successMsgDiv').show();
		} else {
			$('#successMsgDiv').hide();
		}
	});
</script>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h3>Add Scope</h3>
		</div>
	<div id="successMsgDiv" style="text-align: center;font-weight: bold" >
			<label id="successMsg" style="color:green">${message}</label>
		</div>
		<div class="form-content">
			<form action="/addScope" method="post">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Activity Type: </label>
					<div class="btn-group btn-group-toggle" data-toggle="buttons">
						<label class="btn btn-outline-info active"> <input
							type="radio" name="activityType" id="transition"
							value="Transition" autocomplete="off" checked> Transition
						</label> <label class="btn btn-outline-info"> <input type="radio"
							name="activityType" id="transformation" value="Transformation"
							autocomplete="off"> Transformation
						</label><label class="btn btn-outline-info"> <input type="radio"
							name="activityType" id="both" value="Both" autocomplete="off">
							Both
						</label>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Scope Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="scopeName"
							required="required" placeholder="Scope Name">
					</div>
				</div>
				<button type="Submit" class="btn btn-primary">Add Scope</button>
				<button type="button" class="btn btn-warning center"
					onclick="location.href = '/admin';">Back</button>
			</form>
		</div>
	</div>

</body>
</html>
