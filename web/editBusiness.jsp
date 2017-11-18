<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17/11/17
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Empresa <c:out value=""/></title>
</head>
<body>
<form action="businesses" method="post">
    <fieldset>
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="ruc" value="${business.ruc}"/>
        <jsp:include page="_business_fieldset.jsp"/>
    </fieldset>
</form>
<p><a href="regions?action=index">Regions List</a> </p>


</body>
</html>
