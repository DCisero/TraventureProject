<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Groupon</title>
    <link rel="stylesheet" href="/resources/styles.css">
</head>
<body>

<h1>TraVenture Vacation Deals</h1>

<form action="addDeal" method="post">

<c:forEach var="deal" items="${group}">
     ${deal.pitchHtml}<br/>
        <ul>
            <li>${deal.highlightsHtml} </li>
            <li>${deal.title} </li>
            <li>${deal.aTitle} </li>
            <a href="https://www.groupon.com/deals/"> <li>${deal.url}</li> </a>
        </ul>
    <input type="submit" value="Save Deal">
    </c:forEach>

</form>

</body>
</html>
