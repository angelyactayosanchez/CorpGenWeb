<%@ page import="models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 21/11/17
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user=(User)session.getAttribute("usuario");

    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<jsp:useBean id="service" class="services.CgbService"/>
<html>
<head>
    <title>Login success</title>
</head>
<body>
Otra vez lo mismo
    <jsp:include page="WelcomeUser.jsp"/>
</body>
</html>
