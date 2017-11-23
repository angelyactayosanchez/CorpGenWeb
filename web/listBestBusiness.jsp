<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22/11/17
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
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
    <jsp:useBean id="service" class="services.CgbService"/>

    <c:forEach var="business" items="${businesses}">
        <tr>
            <td><c:out value="${business.ruc}"/></td>
            <td><c:out value="${business.name}"/></td>
            <td><c:out value="${business.address}"/></td>
            <td><c:out value="${business.email}"/></td>
            <td><c:out value="${business.phone}"/></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
