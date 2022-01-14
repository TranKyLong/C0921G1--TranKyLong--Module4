<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>EMAIL</title>
</head>
<body>
<h3>SETTING</h3>
<form:form action="email" method="post" modelAttribute="email">
    <table>
        <tr>
            <td><p>Language</p></td>
            <td>
                <form:select multiple="none" path="language">
                    <form:option value="-1" label="------- Select One -------"/>
                    <form:options items="${langList}" />
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Page Size</td>
            <td>
                    <%--                <form:select multiple="true" path="pageSize">--%>
                    <%--                    <form:option value="-1" label="------- Select One -------"/>--%>
                    <%--                    <form:options items="${pageList}"/>--%>

                    <%--                </form:select>--%>
            </td>
        </tr>
        <tr>
            <td><p>Spams Filter</p></td>
            <td>
                <form:checkbox path="spamFilter" value="true"/> <span> Enable Spams Filter </span>
            </td>
        </tr>
        <tr>
            <td><p>Signature</p></td>
            <td style="border: black solid 1px">
                <form:input cssStyle="font-weight: bold" path="name"/> <br>
                <form:textarea cssStyle="width: 60px; height: 40px" path="signature"/>
            </td>
        </tr>
    </table>
    <button style="background: blue; color: white" type="submit"> Update</button>
    <button type="reset"> cancel</button>

</form:form>
<c:forEach items="${config}" var="configed">
    <h5>${configed.toString()}</h5>
</c:forEach>
</body>
</html>
