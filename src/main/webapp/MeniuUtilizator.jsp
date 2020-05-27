<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Bun venit!</title>
</head>
<body>

<%
    if(session.getAttribute("id_utilizator") == null)
    {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>

<%= "Bine ai venit, " + session.getAttribute("nume") + " " + session.getAttribute("prenume") + "!" %><br><br>

<form method="get" action="/UtilizatorEditare">
    <input type="submit" value="Editeaza contul">
</form>
<form method="" action="MeniuContBancar.jsp">
    <input type="submit" value="Conturi bancare">
</form>
<form method="" action="MeniuPrietenie.jsp">
    <input type="submit" value="Conturi cunoscuti">
</form>
<form method="get" action="/Transfer">
    <input type="submit" value="Fa un transfer">
</form>
<form method="post" action="/Statistici">
    <input type="hidden" name="anSetat" value="0">
    <input type="hidden" name="lunaSetat" value="0">
    <input type="submit" value="Statistici">
</form>
<br>
<form method="get" action="/UtilizatorAcces">
    <input type="submit" value="Delogare">
</form>

</body>
</html>