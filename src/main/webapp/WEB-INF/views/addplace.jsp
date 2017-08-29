<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Place</title>
    <link rel="stylesheet" href="/resources/styles.css">
</head>

<body>

<c:forEach items="${SavedPlaces}" var="SavedPlaces">
    ${SavedPlaces.title}<br />
</c:forEach>

</body>
</html>

