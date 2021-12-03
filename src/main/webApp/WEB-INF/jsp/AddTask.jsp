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
<title>Task</title>
<script type="text/javascript">
	$(document).ready(function() {
		loadTechnology();
	});
	function loadTechnology() {
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
			error: function(xhr, statusText, err){
				 if(xhr.status == 400  )
			        alert("Error: Please Enter all the details"); 
				 else
					 alert("Error Occured");
			    }
		});
	}
	function addTask() {
		var activityName = $("input[name='activity_name']:checked").val();
		var techName = $('#technology :selected').text();
		var techId = $('#technology :selected').val();
		var task_name = $("#task_name").val();
		if(task_name){
		$.ajax({
			type : 'POST',
			url : '/addTask',
			data : {
				'tech_name' : techName,
				'techId' : techId,
				'task_name' : $("#task_name").val(),
				'task_desc' : $("#task_desc").val()
			},
			cache : false,
			success : function(data) {
				alert(data);
			},
			error : function(e) {
				 if(xhr.status == 400  )
				        alert("Error: Please Enter all the details"); 
					 else
						 alert("Error Occured");
				    }

		});
	}
		else{
			alert("Enter all the details");
		}
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
		<div id="successMsgDiv" >
			<label id="successMsg" style="color:green">${message}</label>
		</div>
		<div class="form-content">
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
			<button type="button" class="btn btn-warning center"
				onclick="location.href = '/admin';">Back</button>
		</div>
	</div>

</body>
</html>
