<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>

<table>
    <tr>
        <th> ID</th>
        <th> NAME</th>
        <th> CONTACT NUMBER</th>
    </tr>
    <c:forEach items="${empoyeeList}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.contactNumber}</td>
        </tr>
    </c:forEach>
</table>
<h3>${success}</h3>

<a href="/employee/create"> Create New Employee</a>
</body>
</html>
