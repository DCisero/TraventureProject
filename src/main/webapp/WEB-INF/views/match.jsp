<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Match</title>
</head>
<body>

<c:forEach items="${matches}" var="match">
    ${match.userName} - ${match.desiredDestination} - ${match.smoker} - ${match.drinker} <br />
</c:forEach>



</body>
</html>
