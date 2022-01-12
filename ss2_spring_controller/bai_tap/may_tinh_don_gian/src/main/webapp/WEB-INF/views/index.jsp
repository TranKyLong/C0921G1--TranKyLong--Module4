<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h1 style="color: red"> CACULATOR </h1>
<form action="/calculator" method="post">
    <input type="text"  name="number1">
    <input type="text"  name="number2">

    <button type="submit" name="operator" value="+"> + </button>
    <button type="submit" name="operator" value="-"> - </button>
    <button type="submit" name="operator" value="*"> * </button>
    <button type="submit" name="operator" value="/"> / </button>


    <p> RESULT: <span style="background: aquamarine">  ${rs}</span></p>

</form>
</body>
</html>
