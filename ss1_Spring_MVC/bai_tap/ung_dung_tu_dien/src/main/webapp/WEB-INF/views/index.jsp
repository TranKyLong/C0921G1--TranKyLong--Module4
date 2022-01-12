<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<form method="post">
    <p> Nhập từ muốn tìm kiếm</p>
    <input type="text" name="word">
    <a href="dictionary">
        <button type="submit"> Find</button>
    </a>
        <p style="color: red; font-size: 23px"> Result: ${result} </p>
</form>
</body>
</html>
