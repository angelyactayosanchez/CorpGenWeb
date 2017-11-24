<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 24/11/17
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user=(User)session.getAttribute("usuario");

    if(user==null){
        response.sendRedirect("index.jsp");
    }
    // session.setAttribute("id",user.getId());

%>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/profile.css" type="text/css"> </head>

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
                <li class="nav-item" id="Products">
                    <a class="nav-link" href="#">Productos</a>
                </li>
                <li class="nav-item" id="Promotions">
                    <a class="nav-link" href="promotion?action=index">Promociones</a>
                </li>
            </ul>
            <a class="btn navbar-btn ml-2 text-white btn-secondary" href="users?action=profile" id="UseProfile"> <i class="fa d-inline fa-lg fa-user-circle-o"></i>Hola ${sessionScope.name}&nbsp;</a>
            <a class="btn navbar-btn ml-2 text-white btn-secondary"><i class="fa fa-fw fa-sign-out"></i>Salir</a>
        </div>
    </div>
</nav>
<div class="py-5" style="background-image: url(images/background.jpg);">
    <div class="container">
        <div class="row">
            <div class="col-md- col-md-12" id="book">
                <div class="card">
                    <div class="card-body text-justify py-5">
                        <h3 class="pb-3 text-center">Perfil de usuario </h3>
                        <h4 class="pb-3">Estado :${sessionScope.statusID} </h4>
                        <form action="users" method="post">
                            <div class="form-group"> <label>Nombres</label>
                                <input class="form-control" placeholder="" id="firstName" name="firstName" type="text" value="${sessionScope.name}"> </div>
                            <div class="form-group"> <label>Apellidos</label>
                                <input class="form-control" type="text" id="lastName" name="lastName" value="${sessionScope.name2}"> </div>
                            <div class="form-group"> <label>Direccion</label>
                                <input type="text" class="form-control" placeholder="" id="address" name="address" value="${sessionScope.address}"> </div>
                            <div class="form-group" draggable="true"><label class="form-control-label">Genero</label> <select class="form-control" name="gender" id="gender" >
                                <option value="#" disabled="">Seleccione</option>
                                <option value="1">Hombre</option>
                                <option value="2">Mujer</option>

                            </select>
                            </div>
                            <div class="form-group"> <label>Correo</label>
                                <input type="email" class="form-control" placeholder="" name="email" value="${sessionScope.email}" disabled> </div>
                            <div class="form-group"> <label>Contraseña</label>
                                <input type="password" class="form-control" placeholder="" name="password" value="${sessionScope.password}"> </div>
                            <div class="form-group"> <label>Telefono</label>
                                <input type="text" class="form-control" placeholder="Fijo o movil" name="phone" value="${sessionScope.numPhone}"> </div>

                            <input type="hidden" value="updateUser" name="action"/>
                            <button type="submit" class="btn mt-2 btn-block btn-outline-success" id="updateData">Actualizar datos</button>
                            <button type="submit" class="btn mt-2 btn-block btn-outline-danger">Dar de baja</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>

</html>
