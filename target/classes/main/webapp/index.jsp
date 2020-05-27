<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Pagina Principala</title>
</head>
<body>

<form method="post" action="/UtilizatorAcces">
    <%= "username: " %>
    <input type="text" name="username"><br>
    <%= "parola: " %>
    <input type="text" name="parola"><br>

    <input type="submit" value="Login">
</form>
<br><form method="" action="UtilizatorCreare.jsp">
    <input type="submit" value="Creeaza cont nou">

</form>
</body>
</html>