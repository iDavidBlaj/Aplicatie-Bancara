<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistici</title>
</head>
<body>

<%
    if(session.getAttribute("id_utilizator") == null)
    {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>

<%= request.getAttribute("afisare")%>

<br><br><br><form method="" action="MeniuUtilizator.jsp">
    <input type="submit" value="Inapoi in meniu">
</form>

</body>
</html>
