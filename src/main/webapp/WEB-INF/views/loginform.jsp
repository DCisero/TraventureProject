
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
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
