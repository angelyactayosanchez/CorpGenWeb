<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Escritorio-Pc
  Date: 16/11/2017
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="3">
        <tr>
            <th>ruc</th>
            <th>name</th>
            <th>address</th>
            <th>phone</th>
            <th>email</th>
        </tr>
        <c:forEach var="business" items="${businesses}">
            <tr>
                <td><c:out value="${business.ruc}"/></td>
                <td><c:out value="${business.name}"/> </td>
                <td><c:out value="${business.address}"/></td>
                <td><c:out value="${business.phone}"/></td>
                <td><c:out value="${business.email}"/></td>
                <td>
                    <a href="businesses?action=show&ruc=${business.ruc}">Informacion</a>
                    <a href="businesses?action=edit&ruc=${business.ruc}">Informacion</a>

                </td>
            </tr>
        </c:forEach>
</table>
<p><a href="businesses?action=new">Nueva empresa</a> </p>
</body>
</html>
