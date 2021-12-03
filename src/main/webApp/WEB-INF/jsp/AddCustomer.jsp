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

<script type="text/javascript">
	$(document).ready(function() {
		var activityName = $('#activityName').val();
		if (activityName == "DC to DC") {
			$('#cloudDropdown').hide();

		}
	});
</script>
<title>Customer</title>

</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h4>Add Customer</h4>
		</div>

		<div class="form-content">
			<form method="POST" action="/addCustomer">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Activity Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" id="activityName"
							readonly="readonly" name="activityName" value="${activityName}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Customer Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="customerName"
							required="required" placeholder="Enter Name">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Address : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="address"
							placeholder="Address">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Vertical : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="vertical"
							placeholder="Vertical">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Number of Server : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="number" class="form-control" name="server"
							required="required" placeholder="Server">
					</div>
				</div>
				<div class="form-group row">
				<label class="col-sm-2 col-form-label">Locations : </label>
						<input type="checkbox" name="location1" value="US">US
						<input type="checkbox" name="location2" value="EMEA">EMEA
						<input type="checkbox" name="location3" value="APAC">APAC
						<input type="checkbox" name="location4" value="Others">Others
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Project Duration :
					</label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="number" class="form-control" name="duration"
							required="required" placeholder="Duration(Months)">
					</div>
				</div>
				<div class="form-group row" id="cloudDropdown">
					<label class="col-sm-2 col-form-label">Cloud Vendor :</label>
					<div class="col-sm-10">
						<div class="dropdown">
							<select name="cloudVendor" id="cloudVendor" required>
								<option value="0" selected="selected">--SELECT--</option>
								<option value="AWS">AWS</option>
								<option value="Azure">Microsoft Azure</option>
								<option value="GCP">Google Cloud</option>
								<option value="Private">Private Cloud</option>
							</select>
						</div>
					</div>

				</div>
				<button type="submit" class="btn btn-success">Submit</button>
				<button type="button" class="btn btn-warning center"
					onclick="location.href = '/ShowCustomer';">Back</button>
			</form>
		</div>
	</div>
</body>
</html>
