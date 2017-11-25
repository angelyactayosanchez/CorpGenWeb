<%@ page import="models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17/11/17
  Time: 12:06
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
    <title>Informacion</title>
</head>
<body>
    <h1></h1>
    <p>RUC: <c:out value="${business.ruc}"/></p>
    <p>Nombre de la empresa:  <c:out value="${business.name}"/></p>
    <p>Direccion: <c:out value="${business.address}"/></p>
    <p>Telefono: <c:out value="${business.phone}"/></p>
    <p>E-mail: <c:out value="${business.email}"/></p>
</body>
</html>
