<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>

<p>Please fill out your profile:</p>

<form action="formhandler2" method="post"> <!-- change action to addProfile-->
User Name: <input type="text" name="UserName" maxlength="10"><br/>

Profession: <input type="text" name="Profession"><br/> <!--change to drop down-->

Birthday: <input type="number" name="Birthday"><br/>

Gender: <select name="Gender">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
    </select><br/>

City: <input type="text" name="City" maxlength="20"><br/>

State: <input type="text" name="State" maxlength="20"><br/>

Desired Destination: <select name="DesiredDestination">
        <option value="StayCation">Staycation</option>
        <option value="Vaction">Vacation</option>
    </select><br/>

Interests: <input type="text" name="Interests" maxlength="40"><br/>

Smoker: <select name="Smoker">
        <option value="Rarely">Rarely</option>
        <option value="Occasionally">Occasionally</option>
        <option value="Socially">Socially</option>
        <option value="Always">Always</option>
        </select><br/>

Drinker: <select name="Drinker">
        <option value="Rarely">Rarely</option>
        <option value="Occasionally">Occasionally</option>
        <option value="Socially">Socially</option>
        <option value="Always">Always</option>
    </select><br/>

    <input type="submit" name="submit" value="Submit Profile">
</form>

</body>
</html>


