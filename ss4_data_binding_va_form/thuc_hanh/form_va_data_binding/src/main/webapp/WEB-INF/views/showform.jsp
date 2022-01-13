<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create</title>
</head>
<body>

<h2> CREATE EMPLOYEE </h2>
<form:form modelAttribute="employee" action="/create" method="post">
    <table>
        <tr>
            <td>
                <p>ID: </p>
            </td>
            <td>
                <p>NAME: </p>
            </td>
            <td>
                <p>CONTACT NUMBER: </p>
            </td>
        </tr>
        <tr>
            <td>
                <form:input path="id"></form:input>
            </td>
            <td>
                <form:input path="name"></form:input>
            </td>
            <td>
                <form:input path="contactNumber"></form:input>
            </td>
        </tr>
    </table>
    <button type="submit">CREATE</button>
</form:form>
</body>
</html>
