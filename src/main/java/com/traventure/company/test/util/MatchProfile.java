package com.traventure.company.test.util;

public class MatchProfile {
    private int UserID;
    private String UserName;
    private String Gender;
    private String Profession;
    private String Interests;
    private String DesiredDestination;
    private String Smoker;
    private String Drinker;



    public MatchProfile(int userID, String userName, String gender, String profession, String interests,
                        String desiredDestination, String smoker, String drinker) {
        UserID = userID;
        UserName = userName;
        Gender = gender;
        Profession = profession;
        Interests = interests;
        DesiredDestination = desiredDestination;
        Smoker = smoker;
        Drinker = drinker;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getInterests() {
        return Interests;
    }

    public void setInterests(String interests) {
        Interests = interests;
    }

    public String getDesiredDestination() {
        return DesiredDestination;
    }

    public void setDesiredDestination(String desiredDestination) {
        DesiredDestination = desiredDestination;
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


}
