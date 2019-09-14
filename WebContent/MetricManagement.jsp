<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.*, entity.*, repository.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Metric Management</title>
<link rel="stylesheet" href="./External/Bootstrap/css/bootstrap.min.css">
 <link rel="stylesheet" href="./External/Font-awesome/css/font-awesome.min.css">
 <script src="./External/Jquery/jquery.min.js"></script>
 <script src="./External/Bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<% MetricMeasurementRepository repository = new MetricMeasurementRepository();
	List<MetricMeasurement> metrices =  repository.getAllParkings();
	
	%>
	
	<script>
	
		$(document).ready(function() {
			$(".updateMetric").click(function() {
				var Id = $("#Id").val();
				var size = $("#size_complexity").val();
				var control = $("#control_complexity").val();
				var nested = $("#nested_complexity").val();
				var inheritance = $("#inheritance_complexity").val();
				var recursion = $("#recursion_complexity").val();
				
				$.post("http://localhost:8180/SPM_RSE_WE_28_Software_Complexity/UpdateMetricManagementServlet", {
					Id: Id,
					size: size,
					control: control,
					nested: nested,
					inheritance: inheritance,
					recursion: recursion
				}, function(data, status) {
					if (status) {
						alert(data);
						document.localtion.reload();
					}
				})
			});	
		});
		
	</script>
	
	<div class="container">
		<div class="row">
			<div class="text-center">
				<h2 class="modal-header">Metric Management</h2>
			</div>
		</div>
		
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header">
						<div class="card-title">
							<h2>Managing the Complexity Metrics</h2>
						</div>
					</div>
					
					<div class="card-body">
					<form action="<%=request.getContextPath() %>/InsertMetrics" method="POST">
						<% if (metrices.size() == 0) { %>
						<div class="form-group">
							<label>Size Complexity</label>
							<input type="number" class="form-control" name="size_complexity" required>
						</div>
						<div class="form-group">
							<label>Control Structure Complexity</label>
							<input type="number" class="form-control" name="control_complexity" required>
						</div>
						<div class="form-group">
							<label>Nested Complexity</label>
							<input type="number" class="form-control" name="nested_complexity" required>
						</div>
						<div class="form-group">
							<label>Inheritance Complexity</label>
							<input type="number" class="form-control" name="inheritance_complexity" required>
						</div>
						<div class="form-group">
							<label>Recursion Complexity</label>
							<input type="number" class="form-control" name="recursion_complexity" required>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
					</form>
						<% } else { %>
						<% for (MetricMeasurement m: metrices) { %>
							<div class="form-group">
								<label>Size Complexity</label>
								<input type="number" class="form-control" name="size_complexity" id="size_complexity" value="<%=m.getSize_metric() %>" required>
								<input type="hidden" class="form-control" name="Id" id="Id" value="<%=m.getId() %>">
							</div>
							<div class="form-group">
								<label>Control Structure Complexity</label>
								<input type="number" class="form-control" name="control_complexity" id="control_complexity" value="<%=m.getControl_metric() %>" required>
							</div>
							<div class="form-group">
								<label>Nested Complexity</label>
								<input type="number" class="form-control" name="nested_complexity" id="nested_complexity" value="<%=m.getNested_metric() %>" required>
							</div>
							<div class="form-group">
								<label>Inheritance Complexity</label>
								<input type="number" class="form-control" name="inheritance_complexity" id="inheritance_complexity" value="<%=m.getInheritance_metric() %>" required>
							</div>
							<div class="form-group">
								<label>Recursion Complexity</label>
								<input type="number" class="form-control" name="recursion_complexity" id="recursion_complexity" value="<%=m.getRecursion_metric() %>" required>
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-primary updateMetric">Update</button>
							</div>
						<% } %>
						<% } %>
					
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>