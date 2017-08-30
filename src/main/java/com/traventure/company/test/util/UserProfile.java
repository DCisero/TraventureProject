package com.traventure.company.test.util;

public class UserProfile {
    private String UserName;
    private String Profession;
    private int Birthday;
    private String Gender;
    private String City;
    private String State;
    private String DesiredDestination;
    private String Interests;
    private String Smoker;
    private String Drinker;
    private String Image;
    private String Email;

    public UserProfile() {
        UserName = "";
        Profession = "";
        Birthday = 0;
        Gender = "";
        City = "";
        State = "";
        DesiredDestination = "";
        Interests = "";
        Smoker = "";
        Drinker = "";
        Image = "";
        Email = "";

    }

    public UserProfile(String userName, String profession, int birthday, String gender, String city,
                       String state, String desiredDestination, String interests, String smoker,
                       String drinker, String image, String email) {
        UserName = userName;
        Profession = profession;
        Birthday = birthday;
        Gender = gender;
        City = city;
        State = state;
        DesiredDestination = desiredDestination;
        Interests = interests;
        Smoker = smoker;
        Drinker = drinker;
        Image = image;
        Email = email;

    }

    public String getUserName() {

        return UserName;
    }

    public void setUserName(String userName) {

        UserName = userName;
    }

    public String getProfession() {

        return Profession;
    }

    public void setProfession(String profession) {

        Profession = profession;
    }

    public int getBirthday() {

        return Birthday;
    }

    public void setBirthday(int birthday) {

        Birthday = birthday;
    }

    public String getGender() {

        return Gender;
    }

    public void setGender(String gender) {

        Gender = gender;
    }

    public String getCity() {

        return City;
    }

    public void setCity(String city) {

        City = city;
    }

    public String getState() {

        return State;
    }

    public void setState(String state) {

        State = state;
    }

    public String getDesiredDestination() {

        return DesiredDestination;
    }

    public void setDesiredDestination(String desiredDestination) {

        DesiredDestination = desiredDestination;
    }

    public String getInterests() {

        return Interests;
    }

    public void setInterests(String interests) {

        Interests = interests;
    }

    public String getSmoker() {

        return Smoker;
    }

    public void setSmoker(String smoker) {

        Smoker = smoker;
    }

    public String getDrinker() {

        return Drinker;
    }

    public void setDrinker(String drinker) {

        Drinker = drinker;
    }

    public String getImage() {

        return Image;
    }

    public void setImage(String image) {

        Image = image;
    }

    public String getEmail() {

        return Email;
    }

    public void setEmail(String email) {

        Email = email;
    }

}
