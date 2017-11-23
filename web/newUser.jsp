<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 20/11/17
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/estiloNewUser.css" type="text/css"> </head>

<body>
<div class="py-5" style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/form_red.jpg&quot;);">
    <div class="container">
        <div class="row">
            <div class="align-self-center col-md-6 text-white">
                <h1 class="text-center text-md-left display-3">No te pierdas :v</h1>
                <p class="lead">:v</p>
            </div>
            <div class="col-md- col-md-6" id="book">
                <div class="card">
                    <div class="card-body p-5 text-justify">
                        <h3 class="pb-3">Crear una nueva cuenta</h3>
                        <form method="post" action="users">
                            <div class="form-group"> <label>Nombres</label>
                                <input class="form-control" placeholder="Your name, please" id="firstName" name="firstName" required> </div>
                            <div class="form-group"> <label>Apellidos</label>
                                <input class="form-control" type="text" id="lastName"  name="lastName"> </div>
                            <div class="form-group"> <label>Direccion</label>
                                <input type="text" class="form-control" placeholder="" id="address" name="address"> </div>
                            <div class="form-group"><label class="form-control-label">Genero</label> <select class="form-control" name="gender" id="gender">
                                <option value="0"  >Seleccione</option>
                                <option value="1">Hombre</option>
                                <option value="2">Mujer</option>
                            </select>
                            </div>
                            <div class="form-group"> <label>Correo</label>
                                <input type="email" class="form-control" placeholder="" name="email" REQUIRED> </div>
                            <div class="form-group"> <label>Contraseña</label>
                                <input type="password" class="form-control" placeholder="" name="password" REQUIRED> </div>
                            <input type="hidden" name="action" value="new"/>
                            <button input type="submit" class="btn mt-2 btn-block btn-outline-success" >Crear</button>

                            <%--<button  type="submit" class="btn mt-2 btn-block btn-outline-danger" href="index.jsp">Cancelar</button>--%>
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