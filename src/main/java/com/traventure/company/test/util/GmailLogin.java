package com.traventure.company.test.util;

public class GmailLogin {

    private String name;
    private String email;


    public GmailLogin()
    {
        name ="";
        email="";


    }
    public GmailLogin(String name, String email)
    {
        name= name;
        email = email;

    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = this.name;
    }

    public String getemail() {return email;}
    public void setemail(String Email) {this.email = email;}


}

