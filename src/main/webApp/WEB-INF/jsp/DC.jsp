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


<script type="text/javascript">
	$(document).ready(function() {

		var activity_name = $('#activityName').val();
		if (activity_name) {
			loadCustomer();
		}

	});
	function loadCustomer() {
		var activity_name = $('#activityName').val();
		$.ajax({
			type : 'POST',
			url : '/loadCustomer',
			data : {
				'activity_name' : activity_name
			},
			cache : false,
			success : function(data) {
				var html = '';
				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i][0] + '">' + data[i][1]
							+ '</option>';
				}
				html += '</option>';
				$('#customerId').html(html);
			},
			error : function(e) {
				alert("error");
			}

		});
	}
</script>
<title>Data Center</title>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h3>Data Center</h3>
			<div></div>
		</div>
		<div style="text-align: right">
			<a href="/admin">Admin User?</a>
		</div>
		<div class="form-content">
			<form>
				<div class="form-group row"> 
					<label class="col-sm-2 col-form-label">Activity Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" id="activityName" readonly="readonly"
							 name="activityName" value="${activityName}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Customer</label>
					<div class="col-sm-10">
						<div class="dropdown">
							<select name="customerId" id="customerId">
								<option value="0" selected="selected">--SELECT--</option>
							</select>
						</div>
					</div>

				</div>
				<button type="submit" formaction="/customer" formmethod="GET"
					class="btn btn-success">Add Customer</button>

				<button type="submit" formaction="/addReport" formmethod="POST"
					class="btn btn-primary">Add Report</button>
				<button type="submit" formaction="/generateReport" formmethod="POST"
					class="btn btn-warning float-center ml-2">Show Report</button>
				<button type="button" class="btn btn-danger"
				onclick="location.href = '/';">Back</button>
			</form>

		</div>
	</div>
</body>
</html>
