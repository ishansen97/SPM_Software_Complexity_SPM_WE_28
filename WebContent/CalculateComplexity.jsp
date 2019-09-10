<!DOCTYPE html>
<html lang="en">
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

<!-- <div class="jumbotron text-center" style="margin-bottom:0">
  <h1>My First Bootstrap 4 Page</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div> -->

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

<div class="container" style="margin-top:30px">
  <div class="row">
  
<!--     <div class="col-sm-4"> -->
<!--       <h2>About Me</h2> -->
<!--       <h5>Photo of me:</h5> -->
<!--       <div class="fakeimg">Fake Image</div> -->
<!--       <p>Some text about me in culpa qui officia deserunt mollit anim..</p> -->
<!--       <h3>Some Links</h3> -->
<!--       <p>Lorem ipsum dolor sit ame.</p> -->
<!--       <ul class="nav nav-pills flex-column"> -->
<!--         <li class="nav-item"> -->
<!--           <a class="nav-link active" href="#">Active</a> -->
<!--         </li> -->
<!--         <li class="nav-item"> -->
<!--           <a class="nav-link" href="#">Link</a> -->
<!--         </li> -->
<!--         <li class="nav-item"> -->
<!--           <a class="nav-link" href="#">Link</a> -->
<!--         </li> -->
<!--         <li class="nav-item"> -->
<!--           <a class="nav-link disabled" href="#">Disabled</a> -->
<!--         </li> -->
<!--       </ul> -->
<!--       <hr class="d-sm-none"> -->
<!--     </div> -->
    <div class="col-sm-12">
      <h2 class="text-center">File Name</h2>
      <h5>No. of lines: 10</h5>

		<form action="<%=request.getContextPath() %>/DisplayProgramComplexityServlet" method="POST">     
	     <div class="form-group">
	     	<textarea rows="60" cols="50" class="form-control jumbotron" style="font-size: 25px" readonly>public class Ishan
	   		</textarea>
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
