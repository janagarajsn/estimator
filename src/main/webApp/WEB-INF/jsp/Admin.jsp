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
<title>Admin</title>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h3>Admin</h3>
		</div>
		
		<div class="form-content">
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/scope';">Add Scope</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/technology';">Add Technology</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/task';">Add Task</button>
				<button type="button" class="btn btn-warning center"
				onclick="location.href = '/';">Cancel</button>

		</div>
	</div>
</body>
</html>