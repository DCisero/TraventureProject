<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User View</title>
    <link rel="stylesheet" href="/resources/styles.css">
</head>

<>

<h1>Welcome! </h1> <br/>

<p>
    ${sessionScope.username}${sessionScope.FirstName}, you are now ${sessionScope.loginStatus}.
</p>


<img src="${sessionScope.Image}nth/0/"> <br />


<p>Name: ${sessionScope.UserName}</p>
<p>Gender: ${sessionScope.Gender}</p>
<p>Profession: ${sessionScope.Profession}</p>
<p>Interests:${sessionScope.Interests}</p>
<p>Desired Destination:${sessionScope.DesiredDestination}</p>
<p>Smoker: ${sessionScope.Smoker} </p>
<p>Drinker: ${sessionScope.Drinker}</p>

<a href="/match?username=${UserName}&desiredDestination=${DesiredDestination}&smoker=${Smoker}&drinker=${Drinker}">Find Match </a> <br/>

<a href="messages">Match Messaging</a><br/>

<a href="/savedgoogleplaces"> Saved Places </a> <br>

 <a href="googleplaces">Search Staycation Destinations</a><br/>

<a href="groupon">Search Vacation Deals</a> <br/>

<a href="logout">Logout</a><br/>

</body>
</html>
