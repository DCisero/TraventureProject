<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer View</title>


<body>

<h1>Welcome! </h1> <br/>

(profile pic)

<p>Name: ${UserName}</p>
<p>Gender: ${Gender}</p>
<p>Profession: ${Profession}</p>
<p>Interests:${Interests}</p>
<p>Desired Destination:${DesiredDestination}</p>
<p>Smoker: ${Smoker} </p>
<p>Drinker: ${Drinker}</p>

<a href="/match?username=${UserName}&destination=${DesiredDestination}">Find Match </a> <br/>

<a href="/googleplaces">Search Google Places</a>


</body>
</html>
