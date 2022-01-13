<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>LOGIN</title>
</head>
<body>
<h1 style="color: red"> LOGIN </h1>

<form:form action="login" method="post" modelAttribute="loginAccount">

    <label for="idinput">ID: </label> <form:input path="id" id="idinput"></form:input>
    <label for="passinput" >PASSWORD: </label><form:input path="password" id="passinput"></form:input>
    <button type="submit">LOGIN</button>

</form:form>

<h3>${msg}</h3>
<h4>${detail}</h4>
<p>${acc.fullName}</p>
<p>${acc.contactNumber}</p>
<p>${acc.age}</p>
<p>${acc.gender}</p>
<p>${acc.mail}</p>



</body>
</html>




