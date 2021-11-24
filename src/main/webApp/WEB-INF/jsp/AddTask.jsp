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
<title>Task</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("input[type='radio']").click(function() {
			addTechnology();
		});
	});
	function addTechnology() {
		var activityName = $("input[name='activity_name']:checked").val();
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
			},
			error : function(e) {
				alert(e);
			}

		});
	}
	function addTask() {
		var activityName = $("input[name='activity_name']:checked").val();
		var techName = $('#technology :selected').text();
		var techId = $('#technology :selected').val();
		var task_name = $("#task_name").val();
		console.log(task_name);
		$.ajax({
			type : 'POST',
			url : '/addTask',
			data : {
				'activity_name' : activityName,
				'tech_name' : techName,
				'techId' : techId,
				'task_name' : $("#task_name").val(),
				'task_desc' : $("#task_desc").val()
			},
			cache : false,
			success : function(data) {
				addTechnology();
				var html = '';
				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i][0] + '">' + data[i][1]
							+ '</option>';
				}
				html += '</option>';
				$('#technology').html(html);
				alert("Task added Successfully");
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
			<h3>Add Task</h3>
		</div>
		
		<div class="form-content">
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Select Your Option</label>
				<div class="col-sm-10">
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="customRadioInline1" name="activity_name"
							required value="DC2DC" class="custom-control-input"> <label
							class="custom-control-label" for="customRadioInline1"> DC
							To DC</label>
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
				<label class="col-sm-2 col-form-label">Technology</label>
				<div class="form-group mx-sm-3 mb-2">
					<select class="form-control" id="technology" required>
						<option>--SELECT--</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Task Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="task_name"
						id="task_name" placeholder="Task Name" required="required">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Task Description</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="task_desc" id="task_desc"
						placeholder="Task Name"></textarea>
				</div>
			</div>
			<button type="button" class="btn btn-primary" onclick="addTask()">Add
				Task</button>
			<button type="button" class="btn btn-warning float-right ml-2"
				onclick="goBack();">Back</button>
		</div>
	</div>

</body>
</html>