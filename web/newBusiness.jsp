<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17/11/17
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar nueva Empresa</title>
</head>
<body>
<form action="businesses" method="post">
    <fieldset>
        <input type="hidden" name="action" value="create"/>
        <jsp:include page="_business_fieldset.jsp"/>
    </fieldset>
</form>
    <p><a href="businesses?action=index">Ver lista de negocios</a> </p>
</body>
</html>
