<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="mail" method="post">
    <p>enter mail here</p>
    <input type="text" name="inputMail">

    <button type="submit"> VALIDATE</button>

</form>
<p>RESULT: ${message}</p>
</body>
</html>
