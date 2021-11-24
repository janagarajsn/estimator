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
<title>Customer</title>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h3>Add Technology</h3>
		</div>

		<div class="form-content">
			<form method="POST" action="/addTechnology">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Select Your Option</label>
					<div class="col-sm-10">
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="customRadioInline1" name="activity_name"
								value="DC2DC" required class="custom-control-input"> <label
								class="custom-control-label" for="customRadioInline1">
								DC To DC</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" id="customRadioInline2" value="DC2C"
								name="activity_name" class="custom-control-input"> <label
								class="custom-control-label" for="customRadioInline2">DC
								to Cloud DC</label>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Technology Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="technology_name"
							placeholder="Technology Name">
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="button" class="btn btn-warning float-right ml-2"
					onclick="goBack();">Back</button>
			</form>
		</div>
	</div>

</body>
</html>