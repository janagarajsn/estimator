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
<title>Scope Technology</title>
<script type="text/javascript">
	$(document).ready(function() {
		loadScope();
		loadTechnology();
		var successText = $('#successMsg').text();
		if (successText) {
			$('#successMsgDiv').show();
		} else {
			$('#successMsgDiv').hide();
		}
	});
	function  hideDiv(){
		$('#successMsgDiv').html('');
	}
	function loadScope() {
		$.ajax({
			type : 'POST',
			url : '/loadScope',
			cache : false,
			success : function(data) {
				var html = '';
				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i][0] + '">' + data[i][1]
							+ '</option>';
				}
				html += '</option>';
				$('#scope').html(html);
			},
			error : function(xhr, statusText, err) {
				if (xhr.status == 400)
					alert("Error: Please Enter all the details");
				else
					alert("Error Occured");
			}
		});
	}
	function loadTechnology() {
		$('#successMsgDiv').hide();
		$.ajax({
			type : 'POST',
			url : '/loadTechnology',
			cache : false,
			success : function(data) {
				var html = '';
				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i][0] + '">' + data[i][1]
							+ '</option>';
				}
				html += '</option>';
				$('#technology').html(html);
			},
			error : function(xhr, statusText, err) {
				if (xhr.status == 400)
					alert("Error: Please Enter all the details");
				else
					alert("Error Occured");
			}
		});
	}
</script>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h3>Add Scope Technology</h3>
		</div>
		<div id="successMsgDiv" style="text-align: center; font-weight: bold">
			<label id="successMsg" style="color: green">${message}</label>
		</div>
		<div class="form-content">
			<form action="/addScopeTech" method="post">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Scope</label>
					<div class="form-group mx-sm-3 mb-2">
						<select class="form-control" id="scope" name="scope_id"
							onchange="loadTechnology()" required="required">
							<option>--SELECT--</option>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Technology</label>
					<div class="form-group mx-sm-3 mb-2">
						<select class="form-control" name="techid" id="technology" onchange="hideDiv();"
							required>
							<option>--SELECT--</option>
						</select>
					</div>
				</div>
				<button type="Submit" class="btn btn-primary">Submit</button>
				<button type="button" class="btn btn-warning center"
					onclick="location.href = '/'">Cancel</button>
			</form>
		</div>
	</div>

</body>
</html>