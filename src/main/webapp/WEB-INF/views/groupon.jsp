<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Groupon</title>
</head>
<body>

<h1>Traventure Vactaion Deals</h1>

<c:forEach var="deal" items="${group}">
        <ul>
            <li>${deal.pitchHtml} </li><br/>
            <li>${deal.highlightsHtml} </li>
            <li>${deal.title} </li>
            <li>${deal.aTitle} </li>
            <a href="https://www.groupon.com/deals/"> <li>${deal.url}</li> </a>
        </ul>
    </c:forEach>

</body>
</html>
