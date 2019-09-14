<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
        <link rel="stylesheet" href="./External/Bootstrap/css/bootstrap.min.css">
	  <link rel="stylesheet" href="./External/Font-awesome/css/font-awesome.min.css">
	  <script src="./External/Jquery/jquery.min.js"></script>
	  <script src="./External/Bootstrap/js/bootstrap.min.js"></script>
    </head>
  
    <body> 
    
    <%@include file="header.jsp" %>
	
	<div class="container p-4">
	
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header text-center bg-primary text-white">
						<div class="card-title">
							<h2>Code Complexity Tool</h2>
						</div>
					</div>
					
					<div class="card-body">
						<div class="form-group">
							<h3> Choose File to Upload in Server </h3>
					          <form action="<%=request.getContextPath() %>/upload" method="post" enctype="multipart/form-data">
							<div class="row">
					           	<div class="form-group">
					           		<input type="file" name="file" class="form-control" enctype="multipart/form-data"/>
					           	</div>
					      		</div>
					      		<div class="row">
					      			<div class="form-group">
					            	<input type="submit" class="btn btn-success" value="upload" />
					            </div>
					      		</div>
					      		
					      		<% try { 
					      		String message = request.getAttribute("error").toString(); 
					      		%>
					      		<p class="bg-danger text-white"><%=message %></p>
					      		<% } catch (Exception ex) { %>
					      		<% } %>
					               
					               
					          </form>
						</div>
						
					</div>
				</div>
			</div>
		</div>
                  
	</div>
        
       
    </body>
</html>