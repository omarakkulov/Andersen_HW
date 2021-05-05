<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: akk
  Date: 03.05.2021
  Time: 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World!</title>
</head>
<body>
<h2>Все пользователи</h2>

<c:forEach var="employee" items="${requestScope.employee}">
    <ul>
        <li>Имя: <c:out value="${employee.first_name}"/></li>
        <li>Фамилия: <c:out value="${employee.last_name}"/></li>
        <li>Почта: <c:out value="${employee.id}"/></li>
        <li>Номер: <c:out value="${employee.id}"/></li>
    </ul>
</c:forEach>


</body>
</html>
