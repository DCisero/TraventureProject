<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Profile</title>
</head>
<body>

<p>Please fill out your profile:</p>

<form action="addUser2" method="post">
User Name: <input type="text" name="UserName" maxlength="10"><br/>

Profession: <select name="Profession">
    <option value="IT">IT</option>
    <option value="Sales">Sales</option>
    <option value="Healthcare">Healthcare</option>
    <option value="Communication">Communication</option>
    <option value="Hospitality">Hospitality</option>
    <option value="Business">Business</option>
    <option value="Education">Education</option>
    <option value="Other">Other</option>
        </select><br/>

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
        <option value="Never">Never</option>
        <option value="Occasionally">Occasionally</option>
        <option value="Socially">Socially</option>
        <option value="Always">Always</option>
        </select><br/>

Drinker: <select name="Drinker">
        <option value="Never">Never</option>
        <option value="Occasionally">Occasionally</option>
        <option value="Socially">Socially</option>
        <option value="Always">Always</option>
    </select><br/>

    <input type="submit" name="submit" value="Submit Profile">
</form>

</body>
</html>


