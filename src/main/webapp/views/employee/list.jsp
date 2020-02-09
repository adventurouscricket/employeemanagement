<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
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
					<li class="active">Employee list</li>
				</ul>
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
						<!-- button edit & delete -->
						<div class="table-btn-controls">
							<div class="pull-right tableTools-container">
								<div class="dt-buttons btn-overlap btn-group">
									<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title="Add new" href='<c:url value="/admin-employee?action=addnew"/>'>
									<span><i class="fa fa-plus-circle bigger-110 purple"></i></span></a>
									
									<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title="Update" href='<c:url value="/admin-employee?action=edit"/>'>
									<span><i class="fa fa-pencil-square-o bigger-110 purple"></i></span></a>
									
									<a type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title="Delete" href='<c:url value="/admin-employee?action=delete"/>'>
										<span><i class="fa fa-trash-o bigger-110 pink"></i></span>
									</a>
								</div>
							</div>
						</div>
						<!-- table -->
						<div class="row">
							<div class="col-xs-12">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>GrID</th>
											<th>ID</th>
											<th>Name</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${models }">
											<tr>
												<td>${item.grid}</td>
												<td>${item.id}</td>
												<td>${item.name}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>