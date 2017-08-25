<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Existing User Login</title>

    <script language="JavaScript">
        function validate3() {
            return validate3Email() && validate3Password();
        }
        function validate3Email(){

            var email = document.userlogin.Email.value;
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

            var pass = document.userlogin.Password.value;
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
