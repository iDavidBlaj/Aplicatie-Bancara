<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conturi</title>
</head>
<body>

<%
    if(session.getAttribute("id_utilizator") == null)
    {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>

<form method="get" action="/ContBancarAfisare">
    <input type="submit" value="Afiseaza conturi">
</form>
<form method="get" action="/ContBancarCreare">
    <input type="submit" value="Deschide cont">
</form>
<br><form method="" action="MeniuUtilizator.jsp">
    <input type="submit" value="Inapoi in meniu">
</form>

</body>
</html>