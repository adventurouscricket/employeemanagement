<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="employeeAPI" value="/api-admin-employee" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mr Henry</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href="#">Home</a>
					</li>
					<li class="active">Delete</li>
				</ul>
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form id="edit">
							<div class="form-group paddingButtom">
								<label class="col-sm-2">ID</label>
								<div class="col-sm-10"><input type="text" class="form-control" name="id" id="idEm" value="${model.id}"/></div>
							</div>
						</form>
						<div class="row text-center btn-addsp">
							<button class="btn btn-success" id="btnDelete">Delete</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$('#btnDelete').click(function () {
		var idEm = $('#idEm').val();
		var data ={};
		data['id'] = idEm;
		alert("Do you want to delete this employee?");
		deleteBuilding(data);
	});

	function deleteBuilding(data){
		$.ajax({
			url:'${employeeAPI }',
			data: JSON.stringify(data),
			type: 'DELETE',
			contentType: 'application/json',
			//dataType: 'json',
			success: function(data){
				window.location.href="${employeeURL}?action=list";	
			},
			error: function() {
				window.location.href="${employeeURL}?action=list";
			}
		});
	}
	</script>
</body>
</html>