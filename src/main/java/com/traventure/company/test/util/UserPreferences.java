package com.traventure.company.test.util;

public class UserPreferences {
    private String UserName;
    private String Gender;
    private String Profession;
    private String State;
    private String DesiredDestination;
    private String Interests;
    private String Smoker;
    private String Drinker;

    public UserPreferences(String userName, String gender, String profession, String interests, String desiredDestination, String smoker, String drinker) {
        UserName = userName;
        Gender = gender;
        Profession = profession;
        DesiredDestination = desiredDestination;
        Interests = interests;
        Smoker = smoker;
        Drinker = drinker;

    }

    public UserPreferences(String UserName, String Profession,String Gender, String State, String DesiredDestination, String Interests, String Smoker, String Drinker) {
        this.UserName = UserName;
        this.Gender = Gender;
        this.Profession = Profession;
        this.State = State;
        this.DesiredDestination = DesiredDestination;
        this.Interests = Interests;
        this.Smoker = Smoker;
        this.Drinker = Drinker;

    }

    public String getUserName() {

        return UserName;
    }

    public void setUserName(String UserName) {

        UserName = UserName;
    }

    public String getProfession() {

        return Profession;
    }

    public void setProfession(String Profession) {

        Profession = Profession;
    }


    public String getGender() {

        return Gender;
    }

    public void setGender(String Gender) {

        Gender = Gender;
    }


    public void setCity(String City) {

        City = City;
    }

    public String getState() {

        return State;
    }

    public void setState(String State) {

        State = State;
    }

    public String getDesiredDestination() {

        return DesiredDestination;
    }

    public void setDesiredDestination(String DesiredDestination) {

        DesiredDestination = DesiredDestination;
    }

    public String getInterests() {

        return Interests;
    }

    public void setInterests(String Interests) {

        Interests = Interests;
    }

    public String getSmoker() {

        return Smoker;
    }

    public void setSmoker(String Smoker) {

        Smoker = Smoker;
    }

    public String getDrinker() {

        return Drinker;
    }

    public void setDrinker(String Drinker) {

        Drinker = Drinker;
    }

}

