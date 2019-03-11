
<%@page language="java" import="run.*"%>

<!doctype html>
<html lang="en">

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Custom styles for this page -->
    <link href="index.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	    crossorigin="anonymous">
    <title></title>
  </head>

  <body>

    <h1>Works</h2>

    <form id="goform" action="Suggestion" method="POST">
      <div class="input-group mb-3">
        <input type="text" class="form-control"
          placeholder="Enter a phrase." id="goinput" name="goinput">
        <div class="input-group-append">
          <button class="btn btn-dark" type="submit" id="gobutton">Go</button>
        </div>
      </div>
    </form>

    <div id="result"></div>

     <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	   <script src="https://code.jquery.com/jquery-3.3.1.js"
		   integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
		   crossorigin="anonymous"></script>
	   <script
		   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		   integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		   crossorigin="anonymous"></script>
	   <script
       src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		   integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		   crossorigin="anonymous"></script>
	   <!-- Optional JavaScript -->
	   <script src="./index.js" type="text/javascript"></script>
  </body>

</html>
