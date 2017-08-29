<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Match</title>
    <link rel="stylesheet" href="/resources/styles.css">
</head>

<body>

<h1>TraVenture Matches</h1>

<p>We have matched you with people who share your same Desired Destination, Smoker, and Drinker preference.
 Now, you have the power to choose one of the matches listed below and notify them via our Match Messenger. Happy traventuring!</p><br/>

<form action="addMatch" method="post">
<c:forEach items="${matches}" var="match">
    <c:if test="${UserName.equals(match.userName) == false}">
    <td> <input type="submit" value="Submit Match"></td> ${match.userName} : ${match.desiredDestination}, ${match.smoker}, ${match.drinker} <br />
    </c:if>
</c:forEach>
</form>

<form action="Profiles" method="post" >
    <input type="submit" value="View Profile">
    <input type="hidden" name="Userid" value="${UserID}">
</form>

</body>

</html>