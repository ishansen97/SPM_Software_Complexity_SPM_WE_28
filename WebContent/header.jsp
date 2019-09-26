
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="./External/Bootstrap/css/bootstrap.min.css">
	  <link rel="stylesheet" href="./External/Font-awesome/css/font-awesome.min.css">
	  <script src="./External/Jquery/jquery.min.js"></script>
	  <script src="./External/Bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="<%=request.getContextPath() %>/index.jsp">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath() %>/CalculateComplexity.jsp">Calculate Complexity</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath() %>/DisplayProgramComplexities.jsp">View Past Measurements</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath() %>/MetricManagement.jsp">Manage Complexity Metrics</a>
      </li>    
    </ul>
  </div>  
</nav>
</body>
</html>