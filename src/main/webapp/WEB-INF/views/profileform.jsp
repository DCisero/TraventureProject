<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Profile Form</title>

    <script language="JavaScript">
        function validate2() {
            return validate2UserName() && validate2Birthday() && validate2City()
                && validate2State() && validate2Interests();
        }
        function validate2UserName(){

            var user = document.profile.UserName.value;
            var valid = true;

            if (user === null || user === "") {
                alert("User Name cannot be blank, please try again!");
                valid = false;
            }

            if (valid) {
                alert("User Name validation passed!");
            }
            return valid;
        }

        function validate2Birthday(){

            var birth = document.profile.Birthday.value;
            var valid = true;

            if (birth === null || birth === "") {
                alert("Please enter your birthday");
                valid = false;
            }

            if (valid) {
            }
            return valid;
        }

        function validate2City(){

            var cit = document.profile.City.value;
            var valid = true;

            if (cit === null || cit === "") {
                alert("Please enter your city");
                valid = false;
            }

            if (valid) {
            }
            return valid;
        }

        function validate2State(){

            var st = document.profile.State.value;
            var valid = true;

            if (st === null || st === "") {
                alert("Please enter your state");
                valid = false;
            }

            if (valid) {
            }
            return valid;
        }

        function validate2Interests(){

            var int = document.profile.Interests.value;
            var valid = true;

            if (int === null || int === "") {
                alert("Please enter your interests");
                valid = false;
            }

            if (valid) {
            }
            return valid;
        }
    </script>


</head>
<body>

<p>Please fill out your profile:</p>

<form id="profile" name="profile" action="addUser2" method="post">
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
        <option value="Staycation">Staycation</option>
        <option value="Vacation">Vacation</option>
    </select><br/>

Interests: <input type="text" name="Interests" maxlength="20"><br/>

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

    <input type="submit" name="submit" onclick="return validate2()" value="Submit Profile">
</form>

</body>
</html>


