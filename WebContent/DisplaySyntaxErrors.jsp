<!DOCTYPE html>
<html lang="en">
<%@page import="java.util.List,logic.*" %>
<head>
  <title>Bootstrap 4 Website Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body>
	<% List<String> errorMessages = (List<String>) session.getAttribute("ErrorMessages");
	%>


<%@include file="header.jsp" %>

<%-- String fileName = session.getAttribute("FileName").toString(); --%>

<div class="container" style="margin-top:30px">
  <div class="row">
  
    <div class="col-sm-12">
      <h2 class="text-center text-danger">Your uploaded file contains the following errors</h2>
    
	     <div class="form-group">
	     	<textarea rows="60" cols="50" class="form-control jumbotron" style="font-size: 30px" readonly><% for (String error: errorMessages) { %><%=error %><% } %>		
	   		</textarea>
	     	<a href="index.jsp" class="btn btn-success">Upload New File</a>
	     </div>
	
    </div>
  </div>
</div>

</body>
</html>
