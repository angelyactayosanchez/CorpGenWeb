<%@ page import="models.User" %>
<%@ page import="models.Business" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 23/11/17
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user=(User)session.getAttribute("usuario");

    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/estilo.css" type="text/css"> </head>

<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" id="navSuperior">
    <a class="navbar-brand" href="index.jsp" id="nameCompany">Corpgenweb</a>
    <div class="container-fluid">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item active" id="Index">
                    <a class="nav-link" href="users?action=index"/>">Inicio</a>
                </li>
                <li class="nav-item" id="Products">
                    <a class="nav-link" href="#">Productos</a>
                </li>
                <li class="nav-item" id="Promotions">
                    <a class="nav-link" href="promotion?action=index">Promociones</a>
                </li>
            </ul>
            <a class="btn navbar-btn ml-2 text-white btn-secondary" href="users?action=profile" id="UseProfile"> <i class="fa d-inline fa-lg fa-user-circle-o"></i>Hola ${sessionScope.name}&nbsp;</a>
            <a class="btn navbar-btn ml-2 text-white btn-secondary" href="logout.jsp"><i class="fa fa-fw fa-sign-out"></i>Salir</a>
        </div>
    </div>
</nav>
<div class="py-5"></div>
<div class="py-5 bg-dark">
    <div class="container">
        <div class="row">
            <div class="col-md-8 my-3">
                <h1 class="display-4 text-white text-md-left text-center"> Locales de: <c:out value="${business.name}"/> &nbsp;</h1>
            </div>
            <div class="col-md-4  text-center align-self-center">
                <a href="<c:out value="${business.social}"/>" target="_blank"><i class="fa fa-fw fa-facebook fa-3x text-white mx-3" id="facebooPage"></i></a>
                <a href="https://twitter.com/" target="_blank"><i class="fa fa-fw fa-twitter fa-3x text-white mx-3"></i></a>
                <a href="https://www.instagram.com/" target="_blank"><i class="fa fa-fw fa-instagram fa-3x text-white mx-3"></i></a>
            </div>
        </div>
    </div>
</div>
<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <table class="table table-striped table-bordered" id="tableLocations">
                    <thead>
                    <tr>
                        <th>Direccion</th>
                        <th colspan="2">Horario</th>
                        <th>Capacidad Máxima</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="location" items="${locations}">
                    <tr>
                        <td><c:out value="${location.address}"/></td>
                        <td><c:out value="${business.startTime}"/></td>
                        <td><c:out value="${business.closeTime}"/></td>
                        <td><c:out value="${business.maxCapacity}"/></td>
                    </tr>
                    </tbody>
                    </c:forEach>
                    </tbody>
                </table>
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