<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Profile Form</title>
    <link rel="stylesheet" href="/resources/styles.css">

    <script language="JavaScript">
        function validate2() {
            return validate2UserName() && validate2Birthday() && validate2City()
                && validate2State() && validate2Interests();
        }
        function validate2UserName(){

            var user = document.profile.UserName.value;
            var valid = true;

            if (user === null || user === "") {
               <!-- alert("User Name cannot be blank, please try again!");-->
                valid = false;
            }

            if (valid) {
               <!-- alert("User Name validation passed!");-->
            }
            return valid;
        }

        function validate2Birthday(){

            var birth = document.profile.Birthday.value;
            var valid = true;

            if (birth === null || birth === "") {
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
                valid = false;
            }

            if (valid) {
            }
            return valid;
        }
    </script>

    <script>
        UPLOADCARE_LOCALE = "en";
        UPLOADCARE_TABS = "file gphotos";
        UPLOADCARE_PUBLIC_KEY = "877ab06ecd65793fe640";

    </script>
    <script charset="utf-8" src="//ucarecdn.com/libs/widget/3.1.2/uploadcare.full.min.js"></script>

</head>
<body>

<p>Please fill out your profile:</p>

<form id="profile" name="profile" action="addUser2" method="post">
    Profile Pic:
    <input
            type="hidden"
            role="uploadcare-uploader"
            name="Image"
            data-public-key="877ab06ecd65793fe640"
            data-tabs="file gphotos"
            data-crop="300x200"
            data-images-only="true"
            data-image-shrink=""
            data-images-only="false"
            data-preview-step="false"
            data-clearable="false"
            data-multiple="true"
            data-system-dialog="false"
            data-multiple-min="1"
            data-multiple-max="1"
            data-crop=""
    /> <br />

User Name: <input type="text" name="UserName" maxlength="10"><br/>

Email: <input type="text" name="Email" maxlength="65"><br/>

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


