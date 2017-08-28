<%--
  Created by IntelliJ IDEA.
  User: gagandhillon
  Date: 8/25/17
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <c:forEach items="${SavedPlaces}" var="SavedPlaces">
        ${SavedPlaces.title}<br />
    </c:forEach>
</head>
<body>

</body>
</html>
