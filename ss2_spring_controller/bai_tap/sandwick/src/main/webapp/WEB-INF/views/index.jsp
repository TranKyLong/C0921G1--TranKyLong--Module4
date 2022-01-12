<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SANDWICK</title>
</head>
<body>
<h1> SANDWICK CONDIMENTS</h1>
<form action="/save" method="post">
    <label for="lettuce"> lettuce
        <input type="checkbox" ID="lettuce" name="spice" value="lettuce">
    </label> |

    <label for="tomato">tomato
        <input type="checkbox" ID="tomato" name="spice" value="tomato">
    </label> |
    <label for="mustard">mustard
        <input type="checkbox" ID="mustard" name="spice" value="mustard">
    </label> |
    <label for="sprouts">sprouts
        <input type="checkbox" ID="sprouts" name="spice" value="sprouts">
    </label> |
    <button type="submit"> submit</button>
</form>
<h3> YOUR SANDWICK :</h3>

<p> ${totalSpice}</p>

</body>
</html>
