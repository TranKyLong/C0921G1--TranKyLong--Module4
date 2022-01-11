<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<form method="post">
<p>nhap tu khoa muon tim kiem</p><input type="text" name="word">
    <a href="index"> <button type="submit"> submit </button></a>
<p> ${result}</p>

</form>

</body>
</html>
