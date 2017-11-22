<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22/11/17
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="service" class="services.CgbService"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/estiloHome.css">
</head>

<body>
<div class="py-5"></div>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" id="navSuperior">
    <a class="navbar-brand" href="index.jsp" id="nameCompany">Corpgenweb</a>
    <div class="container-fluid">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item active" id="Index">
                    <a class="nav-link" href="#">Inicio</a>
                </li>
                <li class="nav-item" id="Locations">
                    <a class="nav-link" href="#">Locales</a>
                </li>
                <li class="nav-item" id="Products">
                    <a class="nav-link" href="#">Productos</a>
                </li>
                <li class="nav-item" id="Promotions">
                    <a class="nav-link" href="#">Promociones</a>
                </li>
            </ul>
            <a class="btn navbar-btn ml-2 text-white btn-secondary" href="" id="UseProfile"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Hola&nbsp;</a>
        </div>
    </div>
</nav>
<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-dark text-light" contenteditable="true"> Ver promociones</div>
                            <div class="card-body">
                                <h5 contenteditable="false" class="">
                                    <p>
                                        <a href="" id="linkBestplaces">Los mejores locales</a>
                                    </p>
                                </h5>
                                <h5 contenteditable="false" class="">
                                    <p>
                                        <a href="" id="linknull">Ni idea v:</a>
                                    </p>
                                </h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="btn-group btn-group-vertical btn-group-lg w-100 bg-dark">
                            <a href="#" class="btn text-light btn-outline-secondary" id="btnDisco">Discotecas</a>
                            <a href="#" class="btn text-light btn-outline-secondary" id="btnBar">Bares</a>
                            <a href="#" class="btn text-light btn-outline-secondary" id="btnKara">Karaoke</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <table class="table table-striped table-hover text-light border border-light text-left bg-dark" id="table">
                    <thead>
                    <tr>
                        <th>RUC</th>
                        <th>Nombre</th>
                        <th>Direccion</th>
                        <th>E-mail</th>
                        <th>Telefono</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>

                        <jsp:useBean id="service" class="services.CgbService"/>
                        <c:forEach var="location" items="${service.allBusiness}">
                            <td><c:out value="${location.ruc}"/></td>
                            <td><c:out value="${location.name}"/></td>
                            <td><c:out value="${location.address}"/></td>
                            <td><c:out value="${location.email}"/></td>
                            <td><c:out value="${location.phone}"/></td>
                        </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="bg-dark text-white text-center py-4">
    <div class="container-fluid">
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