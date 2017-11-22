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
        <li class="nav-item" id="itemHome">
          <a class="nav-link active" href="#"><i class="fa d-inline fa-lg fa-home"></i>Inicio</a>
        </li>
        <li class="nav-item" id="itemInfo">
          <a class="nav-link active" href="info.jsp"><i class="fa d-inline fa-lg fa-info"></i>Acerca de</a>
        </li>
      </ul>
      <a class="btn navbar-btn btn-primary ml-2 text-white" id="new" href="testNew.jsp"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Sing up</a>
      <a class="btn navbar-btn btn-primary ml-2 text-white" id="login" href="login.jsp"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Iniciar Sesion</a>
    </div>
  </div>
</nav>
<div class="py-5 text-center opaque-overlay" style="background-image: url(&quot;https://www.vtactual.com/es/wp-content/uploads/2017/07/pagar-discoteca-imagen-985x673.jpg&quot;);" id="container1" >
  <div class="container py-5">
    <div class="row">
      <div class="col-md-12 text-white">
        <h1 class="display-3 mb-4">Pos no se v_v</h1>
        <p class="lead mb-5">Co</p>
        <a href="#" class="btn btn-lg mx-1 btn-dark" id="locales-buttom">Ver locales</a>
        <a href="#" class="btn btn-lg mx-1 btn-light border border-secondary" id="product-buttom">Ver productos</a>
      </div>
    </div>
  </div>
</div>
<div class="py-5">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1 class="text-center display-3 text-primary">En busca de un lugar bueno? v:</h1>
        <p class="">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
          irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
    </div>
  </div>
</div>
<div class="py-5 bg-light">
  <div class="container">
    <div class="row">
      <div class="py-5 col-md-6">
        <div class="row">
          <div class="text-center col-4"><i class="d-block mx-auto fa fa-5x fa-angle-double-up"></i></div>
          <div class="col-8">
            <h5 class="mb-3 text-primary"><b>Liutenant approved</b></h5>
            <p class="my-1">Code quality is a must. Pingendo generates clean, battle-tested, modular Bootstrap 4 code – with no messy dependencies. </p>
          </div>
        </div>
      </div>
      <div class="py-5 col-md-6">
        <div class="row">
          <div class="text-center col-4"><i class="d-block mx-auto fa fa-5x fa-map-o"></i></div>
          <div class="col-8">
            <h5 class="mb-3 text-primary"><b>Find your way</b></h5>
            <p class="my-1">Design unique interfaces by customizing Bootstrap theme. Modify colors, fonts and grid setting without opening any CSS file. </p>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="py-5 col-md-6">
        <div class="row">
          <div class="text-center col-4"><i class="d-block mx-auto fa fa-5x fa-file-o"></i></div>
          <div class="col-8">
            <h5 class="mb-3 text-primary"><b>Start from templates</b></h5>
            <p class="my-1">Build with blocks, yet modify easily. Customization is one click away and the graphic possibilities are infinite. </p>
          </div>
        </div>
      </div>
      <div class="py-5 col-md-6">
        <div class="row">
          <div class="text-center col-4"><i class="d-block mx-auto fa fa-5x fa-code"></i></div>
          <div class="col-8">
            <h5 class="mb-3 text-primary"><b>Made for everyone</b></h5>
            <p class="my-1">Work on top of native HTML and SASS files. Extending, customizing and integrating JavaScript is a breeze. With no limits. </p>
          </div>
        </div>
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