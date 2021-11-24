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
<title>Report</title>
<script type="text/javascript">
	$(document).ready(function() {
		loadTechnology();
	});
	function loadTechnology() {
		var activityName = $("#activityName").text();
		$.ajax({
			type : 'POST',
			url : '/loadTechnology',
			data : {
				'activity_name' : activityName
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
				$('#technology').html(html);
				loadTask();
			},
			error : function(e) {
				alert(e);
			}

		});
	}
	function loadTask() {
		var techId = $('#technology :selected').val();
		$.ajax({
			type : 'POST',
			url : '/loadTask',
			data : {
				'techId' : techId
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
				$('#taskName').html(html);
			},
			error : function(e) {
				alert("error");
			}

		});
	}
	function saveReport() {
		var techId = $('#technology :selected').val();
		var taskId = $('#taskName :selected').val();
		var custId = $('#custId').text();
		var effort = $('#effort').val();
		var reportName = $('#reportName').val();
		$.ajax({
			type : 'POST',
			url : '/saveReport',
			data : {
				'techId' : techId,
				'taskId' : taskId,
				'custId' : custId,
				'effort' : effort,
				'reportName' : reportName
			},
			cache : false,
			success : function(data) {
				if(data){
				$('#dynTable tbody').empty();
				for (var i = 0; i < data.length; i++) {
                    var rows = "<tr>"  
                    + "<td >" + data[i][0] + "</td>"    
                    + "<td >" + data[i][1] + "</td>"  
                    + "<td >" + data[i][2] + "</td>"  
                    + "</tr>";  
                    $('#dynTable tbody').append(rows);  
                }  
				}
				else{
					$('#dynTable').empty();
					$('#dynTable').html
				}
				
			},
			error : function(e) {
				alert("error");
			}

		});

	}
	function goBack() {
		  window.history.back();
	}
</script>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h4>Create Report</h4>
		</div>

		<div class="form-content">
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Activity Name</label>
				<div class="col-sm-10">
					<label id="activityName" class="col-sm-2 col-form-label ">${activityName}</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Customer Name</label>
				<div class="col-sm-10">
					<label class="col-sm-2 col-form-label">${customerName}</label> <label
						id="custId" hidden="true">${customerId}</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Report Name</label>
				<div class="form-group mx-sm-3 mb-2">
					<input type="text" class="form-control" name="reportName"
						id="reportName" placeholder="Report Name">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Technology</label>
				<div class="form-group mx-sm-3 mb-2">
					<select class="form-control" id="technology" onchange="loadTask()">
						<option value="0" selected="selected">--SELECT--</option>
					</select>
				</div>
				<button type="button" class="btn btn-primary"
					onclick="location.href = '/technology';">Add Technology</button>
			</div>
			<div class="form-group row">
				<label for="taskName" class="col-sm-2 col-form-label">Task
					Name</label>
				<div class="form-group mx-sm-3 mb-2">
					<select class="form-control" id="taskName">
						<option value="0" selected="selected">--SELECT--</option>
					</select>
				</div>
				<button type="button" class="btn btn-primary"
					onclick="location.href = '/task';">Add Task</button>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Effort(Phrs)</label>
				<div class="form-group mx-sm-3 mb-2">
					<input type="text" class="form-control" name="effort" id="effort"
						placeholder="Duration">
				</div>
			</div>
				<table class="table table-striped" id="dynTable">
				<thead class="thead-dark">
					<tr>
						<th>Technology Name</th>
						<th>Task Name</th>
						<th>Effort(Phrs)</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
				
			</table>
			<button type="button" class="btn btn-primary" onclick="saveReport()">Save</button>
			<button type="button" class="btn btn-warning float-right ml-2"
				onclick="goBack()">Back</button>

		</div>
	</div>

</body>
</html>