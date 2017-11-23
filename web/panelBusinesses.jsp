<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22/11/17
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="service" class="services.CgbService"/>
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
                    <a class="nav-link" href="users?action=index&userID=${user.id}">Inicio</a>
                </li>
                <li class="nav-item" id="Business">
                    <a class="nav-link disabled" href="#" target="">Negocios</a>
                </li>
                <li class="nav-item" id="Products">
                    <a class="nav-link" href="panelProducts.jsp">Productos</a>
                </li>
                <li class="nav-item" id="Promotions">
                    <a class="nav-link" href="panelPromotions.jsp">Promociones</a>
                </li>
            </ul>
            <a class="btn navbar-btn ml-2 text-white btn-secondary" href="" id="UseProfile"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Hola<c:out value="${user.firtName}"/> &nbsp;</a>
        </div>
    </div>
</nav>
<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-dark text-light" contenteditable="true">Ranking de negocios</div>
                            <div class="card-body">
                                <h5 contenteditable="false" class="">
                                    <p>
                                        <a href="businesses?action=bestBusinesses" id="linkBestplaces">De mayor a menor</a>
                                    </p>
                                </h5>
                                <h5 contenteditable="false" class="">
                                    <p>
                                        <a href="businesses?action=worst" id="linknull">De menor a mayor</a>
                                    </p>
                                </h5>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="btn-group btn-group-vertical btn-group-lg w-100 bg-dark">
                            <a href="businesses?action=type&type=Discoteca" class="btn text-light btn-outline-secondary" id="btnDisco" >Discotecas</a>
                            <a href="businesses?action=type&type=Bar" class="btn text-light btn-outline-secondary" id="btnBar">Bares</a>
                            <a href="businesses?action=type&type=Karaoke" class="btn text-light btn-outline-secondary" id="btnKara">Karaoke</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-10">
                <table class="table table-striped table-hover text-light border border-light text-left bg-dark" id="table">
                    <thead>
                    <tr>
                        <th>RUC</th>
                        <th>Nombre</th>
                        <th>Direccion</th>
                        <th>E-mail</th>
                        <th>Telefono</th>
                        <th>Ranking</th>
                        <th>Categoria</th>
                        <th>Ver locales</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="business" items="${businesses}">
                        <tr>
                            <td><c:out value="${business.ruc}"/></td>
                            <td><c:out value="${business.name}"/></td>
                            <td><c:out value="${business.address}"/></td>
                            <td><c:out value="${business.email}"/></td>
                            <td><c:out value="${business.phone}"/></td>
                            <td><c:out value="${business.rank}"/></td>
                            <td><c:out value="${business.type}"/></td>
                            <a class="btn btn-sm btn-outline-info" href="location?index&ruc=<c:out value="${business.ruc}"/>&user=<c:out value="${user.id}"/>" id="localesNegocio" data-toggle="">Ver locales</a>
                        </tr>
                    </tbody>
                    </c:forEach>
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