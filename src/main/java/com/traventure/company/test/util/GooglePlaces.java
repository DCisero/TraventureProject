package com.traventure.company.test.util;

public class GooglePlaces {
    private String name;
    private String address;
    private String phoneNumber;
    private String lat;
    private String lng;


    public GooglePlaces() {
        name = "";
        address = "";
        phoneNumber = "";
        lat= "";
        lng = "";
    }

    public GooglePlaces(String name, String address, String phoneNumber, String lat, String lng) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.lat = lat;
        this.lng = lng;
    }


    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }


    public String getaddress() {
        return address;
    }

    public void setaaddress(String address) {
        this.address = address;
    }


    public String getphoneNumberl() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getlat() {return lat;}

    public void setlat(String lat) {this.lat = lat;}


    public String getlng() {return lng;}

    public void setlng(String lng) {this.lng = lng;}


}