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
<title>Input Page</title>
</head>
<body>
	<div class="container register-form">
			<div class="note">
				<h3>Entry Form</h3>
			</div>

			<div class="form-content">
				<form method="post">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">User Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="name"
								placeholder="Enter Name">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Enter Value 1:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="value1"
								placeholder="Value 1">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Enter Value 2:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="value2"
								placeholder="Value 2">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Operation</label>
						<div class="col-sm-10">
							<div class="dropdown">
								<select name="oper" id="oper">
									<option value="add">Add</option>
									<option value="sub">Sub</option>

								</select>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
				<button type="submit" class="btn btn-warning float-right ml-2"
					onclick="location.href = '/list-todos';">Show Report</button>
			</div>
		</div>

	<%-- welcome ${name} ! --%>
</body>
</html>