<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Groupon</title>
</head>
<body>

<h1>Vacation Deals</h1>

<c:forEach var="deal" items="${group}">

            <li>${deal.title} </li> <br/>
            <li>${deal.aTitle} </li>
            <li>${deal.highlightsHtml} </li>
            <li>${deal.pitchHtml} </li>
            <li>${deal.url}</li>
        </ul>
    </c:forEach>

</body>
</html>
