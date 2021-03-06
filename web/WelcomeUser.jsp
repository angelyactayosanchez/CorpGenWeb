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

<jsp:useBean id="service" class="services.CgbService"/>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/estilo.css" type="text/css"> </head>

<body>
<div class="py-5 text-white bg-white">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="display-1" id="user1"  > Bienvenido ${sessionScope.name} </h1>
            </div>
        </div>
        <div class="row">
            <div class="align-self-center p-5 col-md-6">
                <h1 class="mb-4">¿En busca de donde divertirte?</h1>
                <p class="mb-5">Corpgen te facilita la búsqueda de los mejores neogocios nocturnos, para que te diviertas sin preocupaciones</p>
               <%-- <a class="btn btn-lg btn-outline-light" href="businesses?action=index" id="localesbuttom" type="">Ver negocios
                    <br> </a>--%>
                <a class="btn btn-lg text-light btn-outline-success" href="businesses?action=index" id="localesbuttom">Ver Locales
                    <br> </a>
            </div>
            <div class="col-md-6 p-0">
                <div id="carousel1" class="carousel slide" data-ride="carousel" data-interval="3500">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item">
                            <img src="images/discoteca1.jpg" atl="first slide" class="d-block img-fluid w-100">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid w-100" src="images/discoteca2.jpg" data-holder-rendered="true">

                        </div>
                        <div class="carousel-item active" id="carouselLocations">
                            <img class="d-block img-fluid w-100" src="images/discoteca4.jpg" data-holder-rendered="true">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carousel1" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a>
                    <a class="carousel-control-next" href="#carousel1" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="text-white bg-secondary py-4">
    <div class="container">
        <div class="row">
            <div class="col-md-6 p-0">
                <div id="carousel2" class="carousel slide" data-ride="carousel" data-interval="3500">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item">
                            <img src="images/product1.jpg" atl="first slide" class="d-block img-fluid w-100">
                        </div>
                        <div class="carousel-item active carousel-item-left">
                            <img class="d-block img-fluid w-100" src="images/product2.jpg" data-holder-rendered="true">
                        </div>
                        <div class="carousel-item active carousel-item-left">
                            <img class="d-block img-fluid w-100" src="images/product3.jpg" data-holder-rendered="true">
                        </div>

                    </div>
                    <a class="carousel-control-prev" href="#carousel1" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a>
                    <a class="carousel-control-next" href="#carousel1" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
                </div>
            </div>
            <div class="align-self-center p-5 col-md-6">
                <h1 class="mb-4">¿O buscas los mejores productos?</h1>
                <p class="mb-5"></p>
                <a class="btn btn-lg btn-outline-light" href="products?action=index" id="productsButtom">Ver productos</a>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" id="navSuperior">
    <a class="navbar-brand" href="users?action=index" id="nameCompany">Corpgenweb</a>
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
            <a class="btn navbar-btn btn-primary ml-2 text-white" href="users?action=profile" id="UseProfile"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Mi perfil&nbsp;</a>

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