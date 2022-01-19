<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: KILL YOU
  Date: 1/13/2022
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="student" action="/student/edit" method="post">
        <table>
            <tr>
                <td>ID:</td>
                <td>
                    <form:input path="id" />
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>
                    <form:input path="name" />
                </td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <form:radiobutton path="gender" value="1" label="Male" />
                    <form:radiobutton path="gender" value="0" label="FeMale" />
                    <form:radiobutton path="gender" value="2" label="LGBT" />
                </td>
            </tr>
            <tr>
                <td>Languages:</td>
                <td>
                    <form:checkboxes path="languages" items="${languageList}" />
                    <form:checkbox path="languages" value="JAVA/
                    dsdsdsdlala" label="JAVA" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
