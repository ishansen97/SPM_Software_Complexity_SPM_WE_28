<%@page import="entity.ProgramComplexityMeasurement"%>
<%@page import="service.ProgramComplexityService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<%@page import="java.io.*,models.*,java.util.*" %>
<head>
<meta charset="ISO-8859-1">
<title>Display Complexity</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
  
  <link rel="stylesheet" href="./External/Bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="./External/Font-awesome/css/font-awesome.min.css">
  <script src="./External/Jquery/jquery.min.js"></script>
  <script src="./External/Bootstrap/js/bootstrap.min.js"></script>
  
  <style>
  	.modal-dialog {
  		width: 1000px;
  		padding: 30px;
  	}
  </style>
</head>
<body>

	<script>
		var isChecked = false;
		var checkedCount = 0;
		var checkedIds = [];
		
		function func() {
			alert('hello babe');
		}
	
		$(document).ready(function () {
			$(".view_full_details").click(function () {
				$("#details").modal("show");
				var prog_Id = $(this).attr("data-id");
				
				$(".complexities").each(function () {
					var program = $(this).attr("data-id");
					
					if (prog_Id === program) {
						$(this).attr("hidden", false);
					}
				});
			});
			
			$(".checkboxes").click(function () {
				var checkedId = $(this).attr("data-id");
				
				alert('checked Id: ' + checkedId);
				
				var index = checkedIds.indexOf(checkedId);
				
				if (index > -1) {
					checkedIds.splice(index, 1);
					checkedCount--;
				}
				else {
					checkedIds.push(checkedId);
					checkedCount++;
				}
				
				
				if (checkedCount === 2) {
					$(".checkboxes").each(function() {
						var id = $(this).attr("data-id");
						var obj = $(this);
						
						if (!checkedIds.includes(id)) {
							obj.attr("hidden", true);
							$("#compareBtn").attr("hidden", false);
						}
					});
				}
			});
			
			$("#compareBtn").click(function() {
				$("#compareDiv").attr("hidden", false);
				
				$(".selected-programs1").each(function() {
					var id = $(this).attr("data-id");
					
					if (id === checkedIds[0]) {
						$(this).attr("hidden", false);
					}
				});
				
				$(".selected-programs2").each(function() {
					var id = $(this).attr("data-id");
					
					if (id === checkedIds[1]) {
						$(this).attr("hidden", false);
					}
				});
			});
			
			$(".delete").click(function() {
				var id = $(this).attr("data-id");
				/* alert('id: ' + id); */
				
				$.post("http://localhost:8180/SPM_RSE_WE_28_Software_Complexity/DeleteProrgramComplexityServlet", {programId: id}, function(data, status) {
					if (status) {
						alert('successfully deleted');
						document.location.reload();
					}
				});
			})
			
			
		});
	</script>
	<% ProgramComplexityService service = new ProgramComplexityService();
		List<GetProgrammingComplexityResponse> programComplexities = service.getAllProgramComplexities();
		
	%>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  		<a class="navbar-brand" href="#">Home</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="collapsibleNavbar">
    		<ul class="navbar-nav">
      			<li class="nav-item">
        			<a class="nav-link" href="#">Calculate Complexity</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="<%=request.getContextPath() %>/DisplayProgramComplexities.jsp">View Past Measurements</a>
      			</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">Compare</a>
		      	</li>    
    		</ul>
  		</div>  
	</nav>
	
	<div class="container">
		<div class="row">
			<div class="text-center">
				<h2 class="modal-header">Program Complexity Records</h2>
			</div>
		</div>
		
		<div class="row">
			<table class="table table-striped">
				<thead>
					<tr>
						<th></th>
						<th>Program ID</th>
						<th>Program Name</th>
						<th>Total Complexity</th>
						<th>No. of lines</th>
					</tr>
				</thead>
				
				<tbody>
					<% for (GetProgrammingComplexityResponse programComplexity: programComplexities) { %>
					<tr class="complexity_rows">
						<td><input type="checkbox" class="form-check-inline checkboxes" data-id="<%= programComplexity.getProgramId() %>" /></td>
						<td><%=programComplexity.getProgramId() %></td>
						<td><%=programComplexity.getProgramName() %></td>
						<td><%=programComplexity.getTotalComplexity() %></td>
						<td><%=programComplexity.getNoOfLines() %></td>
						<td><button type="button" class="btn btn-primary view_full_details" data-id="<%= programComplexity.getProgramId() %>">View Full Details</button></td>
						<td><button type="button" class="btn btn-danger delete" data-id="<%= programComplexity.getProgramId() %>">Delete</button></td>
					</tr>
					<% } %>
				</tbody>
					
			</table>
			<div class="form-group">
				<div col="col-10"></div>
				<div col="col-2">
					<button type="button" class="btn btn-success" id="compareBtn" hidden>Compare</button>
				</div>
			</div>
		</div>
		
		<div class="row" id="compareDiv" hidden>
			<div class="col-6">
				<h1>Program 1 <span id="program1"></span></h1>
				<% for (GetProgrammingComplexityResponse programComplexity: programComplexities) { %>
					<div class="form-group selected-programs1" data-id="<%=programComplexity.getProgramId() %>" hidden>
						<label>No. of lines</label>
						<input type="number" class="form-control" value="<%=programComplexity.getNoOfLines() %>" readonly />
						<label>Total Complexity</label>
						<input type="number" class="form-control" value="<%=programComplexity.getTotalComplexity() %>" readonly />
						<label>Average Complexity Per line</label>
						<input type="number" class="form-control" value="<%=programComplexity.getTotalComplexity() / (double) programComplexity.getNoOfLines() %>" onload="func()" readonly />
						<i class="fa fa-save icon" ></i>
					</div>
				<% } %>
			</div>
			<div class="col-6">
				<h1>Program 2 <span id="program2"></span></h1>
				<% for (GetProgrammingComplexityResponse programComplexity: programComplexities) { %>
					<div class="form-group selected-programs2" data-id="<%=programComplexity.getProgramId() %>" hidden>
						<label>No. of lines</label>
						<input type="number" class="form-control" value="<%=programComplexity.getNoOfLines() %>" readonly />
						<label>Total Complexity</label>
						<input type="number" class="form-control" value="<%=programComplexity.getTotalComplexity() %>" readonly />
						<label>Average Complexity Per line</label>
						<input type="number" class="form-control" value="<%=programComplexity.getTotalComplexity() / (double) programComplexity.getNoOfLines() %>" onload="func()" readonly />
						<i class="fa fa-save icon bg-danger" ></i>
					</div>
				<% } %>
			</div>
		</div>
	</div>
	
	<!-- modal content -->
	<div class="modal fade" id="details">
		<div class="modal-dialog modal-lg modal-dialog-scrollable modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<div class="col-10">
						<h2 class="modal-header">View Details</h2>
					</div>
					<div class="col-1">
						<button type="button" data-dismiss="modal" class="close">&times;</button>
					</div>
				</div>
				
				<div class="modal-body">
					<table class="table table-striped table-bordered">
						<thead>	
							<tr>
								<th></th>
								<th>Line no.</th>
								<th>Statement</th>
								<th>Size Count (Cs)</th>
								<th>Nested Control Count (CnC)</th>
								<th>Control Structure Count (CtC)</th>
								<th>Inheritance Count (Ci)</th>
								<th>Total Weight (TW)</th>
								<th>Program Statement Complexity (Cps)</th>
								<th>Recursion Count (Cr)</th>
								
							</tr>
						</thead>
						
						<tbody class="complexity_measurements">
							<% for (GetProgrammingComplexityResponse res: programComplexities) { %>
							<% List<ProgramComplexityMeasurement> list = res.getComplexityMeasurements(); %>
							<% for (ProgramComplexityMeasurement pcm: list) { %>
							<tr class="complexities" data-id="<%=res.getProgramId() %>" hidden>
								<td><%=pcm.getLineNo() %></td>
								<td><%=pcm.getStatement() %></td>
								<td><%=pcm.getSizeCount() %></td>
								<td><%=pcm.getNestedCount()%></td>
								<td><%=pcm.getControlCount() %></td>
								<td><%=pcm.getInheritanceCount() %></td>
								<td><%=pcm.getTotalWeight() %></td>
								<td><%=pcm.getStatementComplexity() %></td>
								<td><%=pcm.getRecusrionComplxity() %></td>
							</tr>
							<% } %>
							<% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>