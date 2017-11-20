<%--
  Created by IntelliJ IDEA.
  User: Escritorio-Pc
  Date: 16/11/2017
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:useBean id="service" class="services.CgbService"/>
  <p><a href="businesses?action=index">List Business</a> </p>

  <table border="3">
    <tr>
      <th>ruc</th>
      <th>name</th>
      <th>address</th>
      <th>phone</th>
      <th>email</th>
    </tr>
    <c:forEach var="business" items="${service.allBusiness}">
    <tr>
      <td><c:out value="${business.ruc}"/></td>
      <td><c:out value="${business.name}"/> </td>
      <td><c:out value="${business.address}"/></td>
      <td><c:out value="${business.phone}"/></td>
      <td><c:out value="${business.email}"/></td>
      <td>
        <a href="businesses?action=show&ruc=${business.ruc}">Informacion</a>
        <a href="businesses?action=edit&ruc=${business.ruc}">Editar</a>

      </td>
    </tr>
    </c:forEach>


  </body>
</html>
--%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> </head>

<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark" id="navbarindex
indexnav">
  <a class="navbar-brand" href="#"><i class="fa fa-lg fa-trademark pull-left fa-fw d-inline" id="icono"></i><b class="text-uppercase" id="inicioBrand">Corpgenweb</b></a>
  <div class="container">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
      <a class="btn navbar-btn ml-2 text-white btn-secondary" id="login"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Iniciar Sesion</a>
      <a class="btn navbar-btn ml-2 text-white btn-secondary" id="newUser">Crear usuario<i class="fa d-inline fa-lg fa-user-circle-o"></i></a>
    </div>
  </div>
</nav>
<div class="py-5 text-center opaque-overlay" style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_event.jpg&quot;);">
  <div class="container py-5">
    <div class="row">
      <div class="col-md-12 text-white">
        <h1 class="display-3 mb-4">Hero image intro</h1>
        <p class="lead mb-5">Pingendo is a HTML editor for everyone. Easy for newbies, useful for professionals.
          <br>Code quality is a must. Pingendo generates clean, battle-tested, modular Bootstrap 4 code. </p>
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
<div class="py-5">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="row">
          <div class="col-md-6">
            <img class="img-fluid d-block w-100 mb-3 rounded" src="https://pingendo.github.io/templates/sections/assets/gallery_4.jpg">
            <p class="">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
              aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
          </div>
          <div class="col-md-6">
            <img class="img-fluid d-block w-100 mb-3 rounded" src="https://pingendo.github.io/templates/sections/assets/gallery_6.jpg">
            <p class="">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
              aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="py-5 bg-dark text-white">
  <div class="container">
    <div class="row">
      <div class="col-md-9">
        <p class="lead">Sign up to our newsletter for the latest news</p>
        <form class="form-inline">
          <div class="form-group">
            <input type="email" class="form-control" placeholder="Your e-mail here"> </div>
          <button type="submit" class="btn btn-primary ml-3">Subscribe</button>
        </form>
      </div>
      <div class="col-4 col-md-1 align-self-center">
        <a href="https://www.facebook.com" target="_blank"><i class="fa fa-fw fa-facebook fa-3x text-white"></i></a>
      </div>
      <div class="col-4 col-md-1 align-self-center">
        <a href="https://twitter.com" target="_blank"><i class="fa fa-fw fa-twitter fa-3x text-white"></i></a>
      </div>
      <div class="col-4 col-md-1 align-self-center">
        <a href="https://www.instagram.com" target="_blank"><i class="fa fa-fw fa-instagram text-white fa-3x"></i></a>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12 mt-3 text-center">
        <p>© Copyright 2017 Pingendo - All rights reserved.</p>
      </div>
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>

</html>