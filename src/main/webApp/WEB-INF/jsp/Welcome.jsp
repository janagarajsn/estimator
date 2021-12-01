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
<link rel="stylesheet" href="/css/sideBar.css">

<title>Data Center</title>
</head>
<body>
	<div class="note">
		<h3>Data Center</h3>
		<div></div>
	</div>
	<div class="sidebar">
		<a href="/admin">Admin User</a> <a href="#news">News</a> <a
			href="#contact">Contact</a> <a href="#about">About</a>
	</div>
	<div class="content">
		<div class="container register-form">

			<!-- 		<div style="text-align: right"> -->
			<!-- 			<a href="/admin">Admin User?</a> -->
			<!-- 		</div> -->
			<form action="/ShowCustomer" method="POST">
				<table>
					<tr>
						<td>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" id="customRadioInline1" required
									name="activityName" class="custom-control-input"
									value="DC to DC" onclick="this.form.submit()"> <label
									class="custom-control-label" for="customRadioInline1">
									<img src="\images\dc.png" alt="DC to DC" title="DC to DC" />
								</label>
							</div>
						</td>
					<tr>
						<td><div
								class="custom-control custom-radio custom-control-inline">
								<input type="radio" id="customRadioInline2" name="activityName"
									class="custom-control-input" value="DC to Cloud"
									onclick="this.form.submit()"> <label
									class="custom-control-label" for="customRadioInline2">
									<img src="\images\data-center-cl.png" alt="DC to Cloud"
									title="DC to Cloud" />
								</label>
							</div></td>
					</tr>
				</table>

			</form>
		</div>
	</div>
</body>
</html>