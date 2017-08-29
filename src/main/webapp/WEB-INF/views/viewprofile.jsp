<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Match Profile</title>
    <link rel="stylesheet" href="/resources/styles.css">

</head>
<body>

<c:forEach items="${proList}" var="pro" >

    Name: ${pro.userName}
    Gender: ${pro.gender}
    Profession: ${pro.profession}
    Interests: ${pro.interests}
    Desired Destination: ${pro.desiredDestination}
    Smoker: ${pro.smoker}
    Drinker ${pro.drinker}

</c:forEach>

</body>
</html>
