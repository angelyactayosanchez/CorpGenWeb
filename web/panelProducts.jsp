<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    User user=(User)session.getAttribute("usuario");

    if(user==null){
        response.sendRedirect("index.jsp");
    }else{
        //session.setAttribute("id",user.getId());
    }

%>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> </head>

<body>
<!--Cambiar background--><%--
<div class="modal" id="miModal">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">×</span> </button>
            </div>
            <div class="modal-body">
                <p></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>--%>
<div class="py-5 text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="mb-4 text-white">Productos</h1>
            </div>
        </div>
        <div class="row" >


                    <c:forEach var="product" items="${products}">
                <div class="col-md-3 col-6 p-1">
                    <a href="products?action=info&id=${product.id}" >

                        <img class="d-block img-fluid" src="${product.image}"> </a>


                </div>
                </c:forEach>

        </div>

    </div>
</div>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" id="navSuperior">
    <a class="navbar-brand" href="users?action=index" id="nameCompany">Corpgenweb</a>
    <div class="container-fluid">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
            <ul class="navbar-nav"><li class="nav-item active" id="Index">
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
            <a class="btn navbar-btn ml-2 text-white btn-secondary" href="users?action=profile" id="UseProfile"> <i class="fa d-inline fa-lg fa-user-circle-o"></i>Mi perfil</a>
            <a class="btn navbar-btn ml-2 text-white btn-secondary" href="logout.jsp"><i class="fa fa-fw fa-sign-out"></i>Salir</a>
        </div>
    </div>
</nav>
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