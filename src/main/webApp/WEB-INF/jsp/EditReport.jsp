<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<title>Report</title>
<script type="text/javascript">
var taskId = new Array();
var effort = new Array();
	$(document).ready(function() {
		loadScope();
		   $('#checkAll').click(function() {
			    var isChecked = $(this).prop("checked");
			    $('#taskTable tbody tr:has(td)').find('input[type="checkbox"]').prop('checked', isChecked);
			    $(".effortCls").attr("disabled", !isChecked); 
			  });
		  
	});
	function getCurrentRow(_this) {
		var isChecked = $(_this).find('input[type="checkbox"]').prop("checked");
		if (isChecked) {
			  $(_this).find(".effortCls").attr("disabled", !isChecked);
		 }
		else{
			$(_this).find(".effortCls").attr("disabled", !isChecked);
		}
	}
	function loadScope() {
		var custId = $('#custId').text();
		$.ajax({
			type : 'POST',
			url : '/loadScopeByCustId',
			data : {
				'custId' : custId
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
				$('#scope').html(html);
				loadTechnology();
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
		var scopeId = $('#scope :selected').val();
		$.ajax({
			type : 'POST',
			url : '/loadScopeTechnology',
			data : {
				'scopeId' : scopeId
			},
			cache : false,
			success : function(data) {
				var html = '';
				var len = data.length;
				if (len > 0) {
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i][0] + '">'
								+ data[i][1] + '</option>';
					}
				} else {
					html += '<option value= 0 >--SELECT-- </option>';
				}
				html += '</option>';
				$('#technology').html(html);
				loadTask();
			},
			error : function(e) {
				alert("error");
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
				$('#taskTable tbody').empty();
				if (len > 0) {
					$('#taskTable').show();
					$('#showTasks').hide();
					for (var i = 0; i < len; i++) {
								html = "<tr onclick='getCurrentRow(this)' class = 'taskRowCls'><td><input type='checkbox'></td><td>"
										+ " <label for=" + data[i][0] + ">"
										+ data[i][1] + "</label></td><td><input type='number' class = 'effortCls' disabled name='effort' ></td></tr>";
								$('#taskTable').append(html);
							}
						}
				else{
					$('#taskTable').hide();
					$('#showTasks').show();
				}
					},
					error : function(xhr, statusText, err) {
						if (xhr.status == 400)
							alert("Error: Please Enter all the details");
						else
							alert("Error Occured");
					}

				});
	}
	function getAllTaskId(){
		taskId= [];
		effort = [];
	$("tr.taskRowCls").each(
				function() {
					var isChecked = $(this).find('input[type="checkbox"]')
							.prop("checked");
					if (isChecked) {
						taskId.push($(this).find('label').attr("for"));
						var currentEffort = $(this).find('input[type="number"]').val();
						if (currentEffort === undefined || currentEffort === null || currentEffort === '' ) {
							effort.push(0);
						} else {
							effort.push(currentEffort);
						}
					}
				});

	}
	function saveReport() {
		getAllTaskId();
		var scopeId = $('#scope :selected').val();
		var techId = $('#technology :selected').val();
		var custId = $('#custId').text();
		var reportName = $('#reportName').val();
		if ((reportName)) {
			$.ajax({
				type : 'POST',
				url : '/saveReport',
				data : {
					'scopeId' : scopeId,
					'techId' : techId,
					'taskId' :taskId,
					'custId' : custId,
					'reportName' : reportName,
					'effort' : effort
				},
				traditional: true,
				cache : false,
				success : function(data) {
					$('#dynTable tbody').empty();
					if(data.length > 0){
					for (var i = 0; i < data.length; i++) {
						var rows = "<tr>" + "<td >" + data[i][0] + "</td>"
								+ "<td >" + data[i][1] + "</td>" + "<td >"
								+ data[i][2] + "</td>" + "<td >"
								+ data[i][3] + "</td>"+ "<td>"
								+ data[i][4] + "</td>"+ "</tr>";
						$('#dynTable tbody').append(rows);
						
					}
					alert("Report Created");
					}
				},
				error : function(xhr, statusText, err) {
					if (xhr.status == 400)
						alert("Error: Please Enter all the details");
					else
						alert("Error Occured");
				}

			});
		} else {
			alert("Please enter all the details")
		}

	}
</script>
</head>
<body>
	<div class="container register-form">
		<div class="note">
			<h4>Edit Report</h4>
		</div>

		<div class="form-content">
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Activity Name :</label>
				<div class="col-sm-10">
					<label id="activityName" class="col-sm-2 col-form-label ">${activityName}</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Customer Name :</label>
				<div class="col-sm-10">
					<label class="col-sm-2 col-form-label">${customerName}</label> <label
						id="custId" hidden="true">${custId}</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Report Name :</label>
				<div class="form-group mx-sm-3 mb-2">
					<input type="text" class="form-control" name="reportName" readonly="readonly"
						id="reportName" placeholder="Report Name" value="${reportName}">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Scope :</label>
				<div class="form-group mx-sm-3 mb-2">
					<select class="form-control" id="scope" onchange="loadTechnology()">
						<option value="0" selected="selected">--SELECT--</option>
					</select>
				</div>
				<button type="button" class="btn btn-primary"
					onclick="location.href = '/scopeTech';">Add Scope
					Technology</button>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Technology :</label>
				<div class="form-group mx-sm-3 mb-2">
					<select class="form-control" id="technology" onchange="loadTask()">
						<option value="0" selected="selected">--SELECT--</option>
					</select>
				</div>

			</div>
			<div class="form-group row">
				<label for="taskName" class="col-sm-2 col-form-label">Task
					Name :</label>
						<div id = "showTasks" style="font-weight: bold;" > Not Available</div>
				<table id="taskTable" class="table table-striped" style="display: none;">
					<thead class="thead-dark">
						<tr>
							<th><input type="checkbox" name="checkAll" id="checkAll"></th>
							<th>Task Name</th>
							<th >Effort(Phrs)</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			<div class="form-group row">
				<label for="details" class="col-sm-2 col-form-label">Selected Task Details :</label>
			<table class="table table-striped" id="dynTable" >
				<thead class="thead-dark">
					<tr >
						<th>Scope </th>
						<th>Technology </th>
						<th>Task </th>
						<th>Status</th>
						<th>Effort(Phrs)</th>
					</tr>
				</thead>
					<tbody>
					<c:forEach items="${results}" var="item">
						<tr>
							<td>${item.scope_name}</td>
							<td>${item.technology_name}</td>
							<td>${item.task_name}</td>
							<td>${item.scope_Flag}</td>
							<td>${item.effort}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			<button type="button" class="btn btn-primary center"
				onclick=" saveReport()">Save</button>
			<button type="button" class="btn btn-warning center"
				onclick="location.href = '/ShowCustomer';">Back</button>

		</div>
	</div>

</body>
</html>