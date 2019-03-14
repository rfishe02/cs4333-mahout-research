
<%@page language="java" import="run.*"%>

<!doctype html>
<html lang="en">

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">

    <!-- CHART JS -->

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.js"></script>

    <!-- Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"
  	   integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  	   crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    <!-- Custom styles for this page -->
    <link href="index.css" rel="stylesheet">
    <script src="index.js" type="text/javascript"></script>

    <title></title>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

  </head>

 <body>
 <header>
  <div class="bg-dark collapse" id="navbarHeader" style="">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-md-7 py-4">
          <h4 class="text-white">About</h4>
          <p class="text-muted"> This application uses the PearsonCorrelationSimilarity class from the Mahout library to generate a list of recommended items for a given user. It also shows how the top three similar users rated the objects they chose. The pictures are insignificant placeholders, but each IMG number comes from the recommendation algorithm.</p>
        </div>
        <div class="col-sm-4 offset-md-1 py-4">
          <!--
          <h4 class="text-white">Contact</h4>
          <ul class="list-unstyled">
            <li><a href="#" class="text-white">Follow on Twitter</a></li>
            <li><a href="#" class="text-white">Like on Facebook</a></li>
            <li><a href="#" class="text-white">Email me</a></li>
          </ul>
          -->
        </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container d-flex justify-content-between">
      <a href="#" class="navbar-brand d-flex align-items-center">
        <i class="fas fa-cat"></i> &nbsp;
        <strong>Album</strong>
      </a>
      <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </div>
</header>

<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">User-Based Recommendation App</h1>
      <p class="lead text-muted"><br><br></p>
    <form id="myform" action="Suggestion" method="POST">
      <div class="input-group">
        <select class="custom-select" id="userID" name="userID">
          <option selected>Choose user...</option>
          <option value="1">Alice</option>
          <option value="2">Bob</option>
          <option value="3">Ciara</option>
          <option value="4">Diane</option>
          <option value="5">Esteban</option>
          <option value="6">Franklin</option>
          <option value="7">George</option>
          <option value="8">Hailey</option>
          <option value="9">Isadora</option>
          <option value="10">Janet</option>
          <option value="11">Kathleen</option>
          <option value="12">Lupita</option>
          <option value="13">Maura</option>
          <option value="14">Nina</option>
          <option value="15">Oberto</option>
          <option value="16">Paula</option>
        </select>
      <div class="input-group-append">
        <button class="btn btn-outline-secondary" type="submit" id="mybutton">Button</button>
      </div>
    </div>
    </form>
    <br><br>

      <canvas id="scatter" width="1" height="1"></canvas>

    </div>
    </div>
  </section>

  <div class="album py-5 bg-light">
    <div class="container">

      <div class="row" id = "cardDeck">

        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <img class="card-img-top" src="https://loremflickr.com/320/240?random=31" alt="Card image cap">
              <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                  <small class="text-muted"> </small>
                </div>
              </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <img class="card-img-top" src="https://loremflickr.com/320/240?random=32" alt="Card image cap">
              <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                  <small class="text-muted"> </small>
                </div>
              </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <img class="card-img-top" src="https://loremflickr.com/320/240?random=33" alt="Card image cap">
              <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                  <small class="text-muted"> </small>
                </div>
              </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <img class="card-img-top" src="https://loremflickr.com/320/240?random=34" alt="Card image cap">
              <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                  <small class="text-muted"> </small>
                </div>
              </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <img class="card-img-top" src="https://loremflickr.com/320/240?random=35" alt="Card image cap">
              <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                  <small class="text-muted"> </small>
                </div>
              </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <img class="card-img-top" src="https://loremflickr.com/320/240?random=36" alt="Card image cap">
              <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                  <small class="text-muted"> </small>
                </div>
              </div>
            </div>
        </div>

      </div>
    </div>
  </div>

</main>

<footer class="text-muted">
  <div class="container">
    <p class="float-right">
      <a href="#">Back to top</a>
    </p>
  </div>
</footer>
<script src="Album%20example%20%C2%B7%20Bootstrap_files/jquery-3.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="Album%20example%20%C2%B7%20Bootstrap_files/bootstrap.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>

</body>

<!--  <body>
    <h1>Works</h2>
    <form id="goform" action="Suggestion" method="POST">
      <div class="input-group mb-3">
        <input type="text" class="form-control"
          placeholder="Enter an id." id="userID" name="userID">
        <div class="input-group-append">
          <button class="btn btn-dark" type="submit" id="gobutton">Go</button>
        </div>
      </div>
    </form>

    <div id="result"></div>
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
	   <script src="./index.js" type="text/javascript"></script>
  </body>
</html>-->
