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
<style type="text/css">
.note {
	text-align: center;
	height: 50px;
	background: -webkit-linear-gradient(left, #0072ff, #8811c5);
	color: #fff;
	font-weight: bold;
	line-height: 80px;
}

.form-content {
	padding: 5%;
	border: 1px solid #ced4da;
	margin-bottom: 2%;
}

.form-control {
	border-radius: 1.5rem;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("input[type='radio']")
								.click(
										function() {
											loadCustomer();
										});
						var activity_name = $(
						"input[name='activityName']:checked")
						.val();
						if( activity_name ) {
							loadCustomer();
						}
						
					});
	function loadCustomer(){
		var activity_name = $(
		"input[name='activityName']:checked")
		.val();
$
		.ajax({
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
					html += '<option value="' + data[i][0] + '">'
							+ data[i][1]
							+ '</option>';
				}
				html += '</option>';
				$('#customerId')
						.html(html);
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
			<h3></h3>
		</div>

		<div class="form-content">
			<form>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Select Your Option</label>
					<div class="col-sm-10">
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="customRadioInline1" required
								name="activityName" class="custom-control-input" value="DC2DC">
							<label class="custom-control-label" for="customRadioInline1">
								DC To DC</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="customRadioInline2" name="activityName"
								class="custom-control-input" value="DC2C"> <label
								class="custom-control-label" for="customRadioInline2">DC
								to Cloud DC</label>
						</div>
					</div>

				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Customer</label>
					<div class="col-sm-10">
						<div class="dropdown">
							<select name="customerId" id="customerId" required>
								<option value="0" selected="selected">--SELECT--</option>
							</select>
							<button type="button" class="btn btn-primary"
								onclick="location.href = '/customer';">Add Customer</button>

						</div>
					</div>

				</div>
				<button type="submit" formaction="/addReport" formmethod="POST"
					class="btn btn-primary">Add Report</button>
				<button type="submit" formaction="/generateReport" formmethod="POST"
					class="btn btn-warning float-center ml-2">Show
					Report</button>
			</form>

		</div>
	</div>
</body>
</html>