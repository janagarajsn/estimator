<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
<script src="webjars/jquery/3.6.0/jquery.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Welcome Page</title>
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
		    $('#custId').val(${custId});
		});
		
function goBack() {
	  window.history.back();
}
</script>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h3>Report </h3>
		</div>

		<div class="table-responsive">
		<form action="/export">
		<input type="text" class="form-control" name="custId"
						id="custId" hidden="true">
						<button type="submit" class="btn btn-warning">Export</button>
						<button type="button" class="btn btn-warning float-right ml-2"
				onclick="goBack()">Back</button>
		
		</form>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th>Report Name</th>
						<th>Technology Name</th>
						<th>Task Name</th>
						<th>Effort</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${results}" var="item">
						<tr>
							<th>${item.report_name}</th>
							<td>${item.technology_name}</td>
							<td>${item.task_name}</td>
							<td>${item.effort}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
	</div>

</body>
</html>