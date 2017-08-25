package com.traventure.company.test.util;

public class UserMatch {
    private String UserName;
    private String DesiredDestination;

    public UserMatch(String userName, String desiredDestination) {
        UserName = userName;
        DesiredDestination = desiredDestination;
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



}
