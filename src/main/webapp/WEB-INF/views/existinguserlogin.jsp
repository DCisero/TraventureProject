<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Existing User Login</title>
</head>

<body>

<p>Login: </p>

<form action="checklogin" method="post">
    Email: <input type="text" name="email" maxlength="25" placeholder="name@email.com"><br/>
    Password: <input type="password" name="password" maxlength="30"><br/>

    <input type="submit" name="submit" value="Submit">
</form>

</body>


</html>
