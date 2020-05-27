<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer</title>
</head>
<body>

<%
    if(session.getAttribute("id_utilizator") == null)
    {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>

<%= "CONTURI PERSONALE"%>
<br><br>
<%= request.getAttribute("afisarePersonale") %>
<%= "CONTURI CUNOSCUTI"%>
<br><br>
<%= request.getAttribute("afisareCunoscuti") %>
<br>
<form method="post" action="/Transfer">
    <%= "Transfera din IBAN: "%>
    <input type="text" name="ibanDebitor"><br>
    <%= "Transfera catre IBAN: " %>
    <input type="text" name="ibanCreditor"><br>
    <%= "Suma: " %>
    <input type="text" name="suma"><br>

    <input type="submit" value="Transfera">
</form>

<br><form method="" action="MeniuUtilizator.jsp">
    <input type="submit" value="Inapoi in meniu">
</form>

</body>
</html>
