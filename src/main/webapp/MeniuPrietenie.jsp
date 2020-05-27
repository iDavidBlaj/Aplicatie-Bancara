<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cunoscuti</title>
</head>
<body>

<%
    if(session.getAttribute("id_utilizator") == null)
    {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>

<form method="get" action="/PrietenieAfisare">
    <input type="submit" value="Afiseaza conturi cunoscuti">
</form>
<form method="" action="PrietenieCreare.jsp">
    <input type="submit" value="Adauga cont cunoscut">
</form>
<form method="" action="PrietenieStergere.jsp">
    <input type="submit" value="Sterge cont cunoscut">
</form>
<br><form method="" action="MeniuUtilizator.jsp">
    <input type="submit" value="Inapoi in meniu">
</form>

</body>
</html>
