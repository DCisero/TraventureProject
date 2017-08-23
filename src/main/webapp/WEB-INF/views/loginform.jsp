<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="/resources/styles.css">
    <meta name="google-signin-client_id" content="809665216554-0o5ksoq0eocj4c3sa1srm0u9qn451omk.apps.googleusercontent.com">

</head>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-client_id" content="809665216554-0o5ksoq0eocj4c3sa1srm0u9qn451omk.apps.googleusercontent.com">
</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
<img id="myImg"><br>
<p id="name"></p>
<div id="status">
</div>
<script type="text/javascript">
    function onSignIn(googleUser) {
        // window.location.href='success.jsp';
        var profile = googleUser.getBasicProfile();
        var imagurl=profile.getImageUrl();
        var name=profile.getName();
        var email=profile.getEmail();
        document.getElementById("myImg").src = imagurl;
        document.getElementById("name").innerHTML = name;
        document.getElementById("myP").style.visibility = "hidden";
        document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=/loginresponse?email='+email+'&name='+name+'/>Continue with Google login</a></p>'

    }
</script>
<button onclick="myFunction()">Sign Out</button>
<script>
    function myFunction() {
        gapi.auth2.getAuthInstance().disconnect();
        location.reload();
    }
</script>


</body>

<body>
<p>Login Information: </p>

<form action="addUser" method="post">
    First Name: <input type="text" name="FirstName" maxlength="20"><br/>
    Last Name: <input type="text" name="LastName" maxlength="20"><br/>
    Email: <input type="text" name="Email" maxlength="25" placeholder="name@email.com"><br/>
    Password: <input type="password" name="Password" maxlength="30"><br/>

    <input type="submit" name="submit" value="Submit">
</form>

</body>
</html>
