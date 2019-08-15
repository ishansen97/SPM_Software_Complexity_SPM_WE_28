<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<%@page import="java.io.*,models.*,java.util.*" %>
<head>
<meta charset="ISO-8859-1">
<title>Display Complexity</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<% String fileName = session.getAttribute("FileName").toString();
		List<ProgramStatementComplexity> programComplexity = (List<ProgramStatementComplexity>) session.getAttribute("ProgramComplexity");
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String statement = null;
		int line_number = 0;
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
        			<a class="nav-link" href="#">View Past Measurements</a>
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
			<h2 class="modal-header">Display Complexity</h2>
		</div>
			<form action="">
				<table class="table table-striped table-bordered">
					<thead>	
						<tr>
							<th>Line no.</th>
							<th>Statement</th>
							<!-- <th>Size Tokens</th> -->
							<th>Cs</th>
							<th>CnC</th>
							<th>CtC</th>
							<th>Ci</th>
							<th>TW</th>
							<th>Cps</th>
							<th>Cr</th>
							
						</tr>
					</thead>
					
					<tbody>
					<% try { %>
						<% while ((statement = br.readLine()) != null) { %>
						
						<tr>
							<td><%=line_number %></td>
							<td><%=statement %></td>
							<td><%=programComplexity.get(line_number).getSize_count() %></td>
							<td><%=programComplexity.get(line_number).getNested_level_count() %></td>
							<td><%=programComplexity.get(line_number).getControl_count() %></td>
							<td><%=programComplexity.get(line_number).getInheritance_count() %></td>
							<td><%=programComplexity.get(line_number).getTotal_weight() %></td>
							<td><%=programComplexity.get(line_number).getTotal_complexity() %></td>
							<td><%=programComplexity.get(line_number).getRecursion_count() %></td>
						</tr>
						<% line_number++; %>
						
						<% } %>
						
					</tbody>
				</table>
				<div class="form-actions">
                     <div class="row">
                         <div class="col-md-12">
                             <button type="submit" id="btnSubmit" class="btn btn-primary">
                                 <i class="fa fa-save"></i> Save
                             </button>
                         </div>
                     </div>
                 </div>
			</form>
		</div>
	</div>
	<% } catch (Exception ex) { %>
	<div><%=ex.getMessage() %></div>
	<% } %>
</body>
</html>