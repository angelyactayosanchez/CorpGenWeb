<%@ page import="models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 25/11/17
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

        User user=(User)session.getAttribute("usuario");
        if(user==null){
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
%>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> </head>

<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" id="navSuperior">
    <a class="navbar-brand" href="index.jsp" id="nameCompany">Corpgenweb</a>
    <div class="container-fluid">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item active" id="Index">
                    <a class="nav-link" href="users?action=index">Inicio</a>
                </li>
                <li class="nav-item" id="Locations">
                    <a class="nav-link" href="businesses?action=index">Negocios</a>
                </li>
                <li class="nav-item" id="Products">
                    <a class="nav-link" href="products?action=index">Productos</a>
                </li>
                <li class="nav-item" id="Promotions">
                    <a class="nav-link" href="event?action=index">Eventos</a>
                </li>
            </ul>
            <a class="btn navbar-btn ml-2 text-white btn-secondary" href="" id="UseProfile"> <i class="fa d-inline fa-lg fa-user-circle-o"></i>Hola&nbsp;</a>
            <a class="btn navbar-btn ml-2 text-white btn-secondary"><i class="fa fa-fw fa-sign-out"></i>Salir</a>
        </div>
    </div>
</nav>
<div class="py-3">
    <div class="container py-5">
        <div class="row py-2">
            <div class="col-md-10">
                <a class="btn btn-primary btn-lg" href="products?action=index">Regresar</a>
            </div>
        </div>
    </div>
</div>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header"> Informacion del producto </div>
                    <div class="card-body">
                        <h4>Nombre: <c:out value="${product.name}"/></h4><br>
                        <h4>Marca   <c:out value="${product.brand}"/></h4><br>
                        <h4>Categoria</h4><br>
                        <h4>Precio(S/.)   <c:out value="${product.price}"/></h4><br>
                        <h4>Descripcion</h4>
                        <p class=" p-y-1">
                            <c:out value="${product.description}"/></p>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <img class="img-fluid d-block" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg">
            </div>
        </div>
    </div>
</div>
<div class="py-5 bg-dark text-white">
    <div class="container">
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