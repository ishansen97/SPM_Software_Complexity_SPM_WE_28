<!DOCTYPE html>
<html lang="en">
<%@page import="java.io.*" %>
<head>
  <title>Bootstrap 4 Website Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="./External/Bootstrap/css/bootstrap.min.css">
 <link rel="stylesheet" href="./External/Font-awesome/css/font-awesome.min.css">
 <script src="./External/Jquery/jquery.min.js"></script>
 <script src="./External/Bootstrap/js/bootstrap.min.js"></script>
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


</body>
</html>
