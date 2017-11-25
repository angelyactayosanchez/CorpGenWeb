<%--
Index principal
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> </head>

<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" id="navSuperior">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp" id="nameCompany">Corpgenweb</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
      <ul class="navbar-nav" style="opacity: 0.5;">

      </ul>
      <a class="btn navbar-btn btn-primary ml-2 text-white" id="new" href="users?action=new"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Crear un cuenta nueva</a>
      <a class="btn navbar-btn btn-primary ml-2 text-white" id="login" href="login.jsp"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Iniciar Sesion</a>
    </div>
  </div>
</nav>
<div class="py-5 text-center opaque-overlay" style="background-image: url(&quot;https://www.vtactual.com/es/wp-content/uploads/2017/07/pagar-discoteca-imagen-985x673.jpg&quot;);" id="container1" >
  <div class="container py-5">
    <div class="row">
      <div class="col-md-12 text-white">
        <h1 class="display-3 mb-4"></h1>
        <p class="lead mb-5"></p>
      </div>
    </div>
  </div>
</div><div class="py-5 bg-light">
  <div class="container">
    <div class="row">
      <div class="py-5 col-md-6">
        <div class="row">
          <div class="text-center col-4"><i class="d-block mx-auto fa fa-5x fa-angellist"></i></div>
          <div class="col-8">
            <h5 class="mb-3 text-primary"><b>¿Desearias ver los eventos que preparan?</b></h5>
          </div>
        </div>
      </div>
      <div class="py-5 col-md-6">
        <div class="row">
          <div class="text-center col-4"><i class="d-block mx-auto fa fa-5x fa-beer"></i></div>
          <div class="col-8">
            <h5 class="mb-3 text-primary"><b>Tipico, vas a un bar,discoteca u karaoke y tu bebida favorita se acabo v':</b></h5>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="py-5">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1 class="text-center display-3 text-success">Corpgen te ayudara a encontrar un buen lugar donde relajarte.</h1>
      </div>
    </div>
  </div>
</div>
<div class="py-5 bg-dark text-white">
  <div class="container">
    <div class="row">
      <div class="col-md-12 mt-3 text-center">
        <p>© Copyright 2017 Corpgen - All rights reserved.</p>
      </div>
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>

</html>
