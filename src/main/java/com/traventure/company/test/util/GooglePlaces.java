package com.traventure.company.test.util;

public class GooglePlaces {
    private String PlaceName;
    private String PlaceAddress;
    private String Title;



    public GooglePlaces() {
        PlaceName = "";
        PlaceAddress = "";
        Title = "";

    }

    public GooglePlaces(String PlaceName, String PlaceAddress, String phoneNumber) {
        this.PlaceName = PlaceName;
        this.PlaceAddress = PlaceAddress;
        this.Title = phoneNumber;

    }


    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String PlaceName) {
        this.PlaceName = PlaceName;
    }


    public String getPlaceAddress() {
        return PlaceAddress;
    }

    public void setPlaceAddress(String PlaceAddress) {
        this.PlaceAddress = PlaceAddress;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }




}