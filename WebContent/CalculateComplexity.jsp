<!DOCTYPE html>
<html lang="en">
<%@page import="java.io.*" %>
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


<%@include file="header.jsp" %>

<% String fileName = request.getAttribute("fileName").toString();
	String filePath = request.getAttribute("filePath").toString();
   File file = new File(filePath);
   BufferedReader br = new BufferedReader(new FileReader(file));
   String st = null;
   
     
%>

<div class="container" style="margin-top:30px">
  <div class="row">
  

    <div class="col-sm-12">
      <h2 class="text-center">File Name: <%= fileName %></h2>
      <h5>No. of lines: 10</h5>

		<form action="<%=request.getContextPath() %>/DisplayProgramComplexityServlet" method="POST">     
	     <div class="form-group">
	     	<textarea rows="60" cols="50" class="form-control jumbotron" style="font-size: 25px" readonly>
	     	<% while ((st = br.readLine()) != null) { %>
	     	<%=st %>   
	       <% } %>
	   		</textarea>
	   		<input type="hidden" name="filePath" value="<%=filePath %>"/>
	     	<button type="submit" class="btn btn-success">Calculate Complexity</a>
	     </div>
		</form>
	
    </div>
  </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>

</body>
</html>
