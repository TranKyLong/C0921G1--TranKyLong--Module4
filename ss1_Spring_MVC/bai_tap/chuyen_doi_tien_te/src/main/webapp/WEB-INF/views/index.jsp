<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MONEY CONVERTER</title>
</head>
<body>

<h1>MONEY CONVERTER</h1>
<form action="convert" method="post">
    <table>
        <tr>
            <td><p>enter exchange rate</p>

            </td>
            <td><input type="number" name="rate" id="rate"></td>
        </tr>
        <tr>
            <td><p> Enter the amount of USD you want to transfer </p>
            <td><input type="number" name="usd" id="usd"></td>

        </tr>
        <tr >
            <td colspan="2" >

                    <button type="submit">CONVERT</button>

            </td>
        </tr>
        <tr>
            <td> result: </td>
            <td >
                <p style="color: red; font-size: 20px "> ${resultfail}</p>
                <p style="color: green; font-size: 20px "> ${result}</p>
            </td>
        </tr>
    </table>


</form>
</body>
</html>
