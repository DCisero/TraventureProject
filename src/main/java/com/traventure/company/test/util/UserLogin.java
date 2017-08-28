package com.traventure.company.test.util;

public class UserLogin {
   private String FirstName;
   private String LastName;
    private String Email;
    private String Password;

    public UserLogin(String string, String resultString) {
        FirstName = "";
        LastName = "";
        Email = "";
        Password = "";
    }

    public UserLogin(String firstName, String lastName, String email, String password) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }




}
