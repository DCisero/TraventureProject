<%@ page contentType="text/html;charset=UTF-8" language="java" %>



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
        document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=/existinggooglelogin?email='+email+'&name='+name+'/>Continue with Google login</a></p>'

    }
</script>
<html>
<head>
    <title>Existing User Login</title>

    <script language="JavaScript">
        function validate3() {
            return validate3Email() && validate3Password();
        }
        function validate3Email(){

            var email = document.userlogin.email.value;
            var valid = true;

            if (email === null || email  === "") {
                alert("Please enter your email");
                valid = false;
            }

            if (valid) {
            }
            return valid;
        }

        function validate3Password(){

            var pass = document.userlogin.password.value;
            var valid = true;

            if (pass === null || pass === "") {
                alert("Please enter your password");
                valid = false;
            }

            if (valid) {
            }
            return valid;
        }
    </script>

</head>

<body>

<h1>Login:</h1>

<form id="userlogin" name="userlogin" action="checklogin" method="post">
    Email: <input type="text" name="email" maxlength="25" placeholder="name@email.com"><br/>
    Password: <input type="password" name="password" maxlength="30"><br/>

    <input type="submit" name="submit" onclick="return validate3()" value="Submit">
</form>

</body>


</html>
