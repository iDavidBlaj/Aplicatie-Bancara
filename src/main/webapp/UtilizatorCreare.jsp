<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Inregistrare</title>
</head>
<body>

<form method="post" action="/UtilizatorCreare">
    <%= "username:" %>
    <input type="text" name="username">
    <%= " MIN 4 litere si MIN 2 cifre ALFABET ENGLEZ" %><br>

    <%= "parola:" %>
    <input type="text" name="parola">
    <%= " MIN 4 litere si MIN 2 cifre ALFABET ENGLEZ" %><br>

    <%= "nume:" %>
    <input type="text" name="nume">
    <%= " MIN 2 litere FARA cifre ALFABET ROMÂN" %><br>

    <%= "prenume:" %>
    <input type="text" name="prenume">
    <%= " MIN 2 litere FARA cifre ALFABET ROMÂN" %><br>

    <%= "data nasterii:" %>
    <input type="text" name="data_nasterii">
    <%= " FORMAT: ZI-LUNA-AN" %><br>

    <%= "email:" %>
    <input type="text" name="email">
    <%= " @gmail.com, @yahoo.com, @outlook.com" %><br>

    <%= "nr_telefon:" %>
    <input type="text" name="nr_telefon">
    <%= " FORMAT ROMÂN" %><br>

    <input type="submit" value="Inregistreaza-te">
</form>

<br><form method="" action="index.jsp">
    <input type="submit" value="Inapoi la pagina principala">
</form>

</body>
</html>