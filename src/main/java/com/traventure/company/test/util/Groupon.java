package com.traventure.company.test.util;

public class Groupon {
    private String title;
    private String aTitle;
    private String highlightsHtml;
    private String pitchHtml;
    //private String formattedAmount;
    private String url;


    public Groupon() {
        title = "";
        aTitle = "";
        highlightsHtml = "";
        pitchHtml = "";
        //formattedAmount = "";
        url = "";
    }

    public Groupon(String title, String aTitle, String highlightsHtml, String pitchHtml,
                    String url) {
        this.title = title;
        this.aTitle = aTitle;
        this.highlightsHtml = highlightsHtml;
        this.pitchHtml = pitchHtml;
        //this.formattedAmount = formattedAmount;
        this.url = url;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getHighlightsHtml() {
        return highlightsHtml;
    }

    public void setHighlightsHtml(String highlightsHtml) {
        this.highlightsHtml = highlightsHtml;
    }

    public String getPitchHtml() {
        return pitchHtml;
    }

    public void setPitchHtml(String pitchHtml) {
        this.pitchHtml = pitchHtml;
    }


//   public String getFormattedAmount() {
//        return formattedAmount;
//    }
//
//   public void setFormattedAmount(String formattedAmount) {
//       this.formattedAmount = formattedAmount;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}
