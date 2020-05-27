<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stergere</title>
</head>
<body>

<%
    if(session.getAttribute("id_utilizator") == null)
    {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>

<form method="post" action="/PrietenieStergere">
    <%= "Introdu IBAN: " %>
    <input type="text" name="iban">
    <input type="submit" value="Sterge cont cunoscut">
</form>
<br><form method="" action="MeniuPrietenie.jsp">
    <input type="submit" value="Inapoi in meniu">
</form>

</body>
</html>
