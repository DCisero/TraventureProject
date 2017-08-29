<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User View</title>
    <link rel="stylesheet" href="/resources/styles.css">
</head>

<body>

<h1>Welcome! </h1> <br/>

<img src="${Image}nth/0/"> <br />

<p>Name: ${UserName}</p>
<p>Gender: ${Gender}</p>
<p>Profession: ${Profession}</p>
<p>Interests:${Interests}</p>
<p>Desired Destination:${DesiredDestination}</p>
<p>Smoker: ${Smoker} </p>
<p>Drinker: ${Drinker}</p>

<a href="/match?username=${UserName}&desiredDestination=${DesiredDestination}&smoker=${Smoker}&drinker=${Drinker}">Find Match </a> <br/>

 <a href="googleplaces">Search Staycation Destinations</a><br/>

<a href="groupon">Search Vacation Deals</a>

</body>
</html>
