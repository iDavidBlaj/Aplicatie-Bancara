<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creare</title>
</head>
<body>

<%
    if(session.getAttribute("id_utilizator") == null)
    {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>

<form method="post" action="/PrietenieCreare">
    <%= "Introdu IBAN: " %>
    <input type="text" name="iban">
    <input type="submit" value="Adauga cont cunoscut">
</form>
<br><form method="" action="MeniuPrietenie.jsp">
    <input type="submit" value="Inapoi in meniu">
</form>

</body>
</html>
