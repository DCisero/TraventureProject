package com.traventure.company.test.util;

public class UserMatch {
    private String UserName;
    private String DesiredDestination;
    private String Smoker;
    private String Drinker;


    public UserMatch() {
        UserName = "";
        DesiredDestination = "";
        Smoker = "";
        Drinker = "";
    }


    public UserMatch(String username, String desiredDestination, String smoker, String drinker) {
        UserName = username;
        DesiredDestination = desiredDestination;
        Smoker = smoker;
        Drinker = drinker;
    }

    public String getUserName() {

        return UserName;
    }

    public void setUserName(String userName) {

        UserName = userName;
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
