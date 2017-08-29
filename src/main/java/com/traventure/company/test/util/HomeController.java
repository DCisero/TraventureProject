package com.traventure.company.test.util;

import model.DAO;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.*;

@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld() {
        return new ModelAndView("welcome", "message", "Hello World");
    }

    @RequestMapping("/loginform")
    public ModelAndView userform() {

        return new ModelAndView("loginform", "log", "Login Information");
    }


    @RequestMapping(value = "/addUser")

    public ModelAndView addUser(
            @RequestParam("FirstName") String FirstName,
            @RequestParam("LastName") String LastName,
            @RequestParam("Email") String Email,
            @RequestParam("Password") String Password, HttpSession session) {



        boolean result = DAO.addUsers(FirstName, LastName, Email, Password);

        if (result == false) {

            return new ModelAndView("error", "errmsg", "Adding user failed!");
        }

        session.setAttribute("FirstName", FirstName);
        session.setAttribute("loginStatus", "logged in");


        ModelAndView mv = new ModelAndView("loginresponse");
        mv.addObject("FirstName", FirstName);
        mv.addObject("LastName", LastName);
        mv.addObject("Email", Email);
        mv.addObject("Password", Password);

        return mv;
    }

    @RequestMapping("/profileform")
    public ModelAndView profileform() {

        return new ModelAndView("profileform", "profile", "Profile Information");
    }

    @RequestMapping(value = "/addUser2")
    public ModelAndView addUser2 (
            @RequestParam("UserName") String UserName,
            @RequestParam("Profession") String Profession,
            @RequestParam("Birthday") int Birthday,
            @RequestParam("Gender") String Gender,
            @RequestParam("City") String City,
            @RequestParam("State") String State,
            @RequestParam("DesiredDestination") String DesiredDestination,
            @RequestParam("Interests") String Interests,
            @RequestParam("Smoker") String Smoker,
            @RequestParam("Drinker") String Drinker,
            @RequestParam("Image") String Image, HttpSession session) throws SQLException {


        boolean result = DAO.addUsers2(UserName,Profession,Birthday,Gender,City,State,DesiredDestination,Interests,Smoker,Drinker,Image+"nth/0/");
        if (result == false) {

            return new ModelAndView("error", "ermsg", "Adding profile failed!");
        }

        ModelAndView mv = new ModelAndView("userview");
        session.setAttribute("UserName", UserName);
        session.setAttribute("Profession", Profession);
        session.setAttribute("Birthday", Birthday);
        session.setAttribute("Gender", Gender);
        session.setAttribute("City", City);
        session.setAttribute("State", State);
        session.setAttribute("DesiredDestination", DesiredDestination);
        session.setAttribute("Interests", Interests);
        session.setAttribute("Smoker", Smoker);
        session.setAttribute("Drinker", Drinker);


        return new ModelAndView("userview");
    }




    @RequestMapping("/loginresponse")
    public ModelAndView loginresponse(@RequestParam("name") String name, @RequestParam("email") String email)

    {
        boolean result = DAO.addUsersG(name, email);

        if (result == false) {

            return new ModelAndView("error", "errmsg", "customer add failed");
        }

        {
            ModelAndView mv = new ModelAndView("loginresponse");
            mv.addObject("name", name);
            mv.addObject("email", email);
            return mv;
        }

    }






    @RequestMapping("/existinggooglelogin")
    public ModelAndView existinguserlogin(
            @RequestParam("email") String email,
            @RequestParam("name") String name, HttpSession session) throws SQLException
    {

        session.setAttribute("loginStatus", "logged in");
        session.setAttribute("username", name);

        //copy and paste code to retrieve prefs and set in sessions

        return new ModelAndView("userview");
    }





    @RequestMapping("/checklogin")
    public ModelAndView checklogin(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session) throws SQLException {

        boolean result = DAO.checkLogin(email, password);
        System.out.println("password is correct");

        if (result == false) {
            return new ModelAndView("emailandorpasswordincorrect", "emailandorpasswordincorrect", "Adding user failed!");
        }

        UserPreferences prefs = fetchingpreferences(username);
        System.out.println("Retrieved user prefs");
        System.out.println("Username: " + prefs.getUserName());
        System.out.println("Drinking: " + prefs.getDrinker());

        //add these to the session not the model
        session.setAttribute("UserName", prefs.getUserName());
        session.setAttribute("Gender", prefs.getProfession());
        session.setAttribute("Profession", prefs.getProfession());
        session.setAttribute("Interests", prefs.getInterests());
        session.setAttribute("DesiredDestination", prefs.getDesiredDestination());
        session.setAttribute("Smoker", prefs.getSmoker());
        session.setAttribute("Drinker", prefs.getDrinker());

        return new ModelAndView("userview");
    }



    @RequestMapping("/existinguserlogin")
    public ModelAndView existinguserlogin() {

        return new ModelAndView("existinguserlogin");
    }

    @RequestMapping("/findmatch")
    public ModelAndView findmatch() {

        return new ModelAndView("findmatch");
    }

    @RequestMapping("/about")
    public ModelAndView about() {

        return new ModelAndView("about");
    }

    @RequestMapping("/googleplaces")
    public ModelAndView googleplaces() {

        return new ModelAndView("googleplaces");
    }


    @RequestMapping("/userview")
    public ModelAndView userview() {

            return new ModelAndView("userview");
        }

    @RequestMapping("/savedgoogleplaces")
    public ModelAndView savedgoogleplaces() {

        return new ModelAndView("savedgoogleplaces");

    }


    @RequestMapping("/groupon")
    public ModelAndView groupon() {
        try {

            HttpClient http = HttpClientBuilder.create().build();

            HttpHost host = new HttpHost("partner-api.groupon.com", 80, "http");

            HttpGet getPage = new HttpGet("/deals.json?tsToken=US_AFF_0_201236_212556_0&channel_id=getaways&categories=Europe%2C%20Asia%2C%20Africa%2C%20%26%20Oceania&offset=0&limit=30");

            HttpResponse resp = http.execute(host, getPage);

            String jsonString = EntityUtils.toString(resp.getEntity());

            JSONObject json = new JSONObject(jsonString);

            //the int status will execute the success of the method or not(ex. local 404 error)
            int status = resp.getStatusLine().getStatusCode();

            JSONArray deals = json.getJSONArray("deals");
            //JSONArray opt = json.getJSONObject("0").getJSONObject("price").getJSONArray("options");


            JSONArray title = json.getJSONArray("deals");
            JSONArray aTitle = json.getJSONArray("deals");
            JSONArray highlightsHtml = json.getJSONArray("deals");
            JSONArray pitch = json.getJSONArray("deals");
            JSONArray url = json.getJSONArray("deals");
            //JSONArray formattedAmount = json.getJSONObject("0").getJSONObject("price").getJSONArray("options");


            ArrayList<Groupon> group = new ArrayList<Groupon>();

            for (int i = 0; i < deals.length(); i++) {
                group.add(new Groupon(deals.getJSONObject(i).getString("title"), deals.getJSONObject(i).getString("announcementTitle"), deals.getJSONObject(i).getString("highlightsHtml"), deals.getJSONObject(i).getString("pitchHtml"), deals.getJSONObject(i).getString("dealUrl")));

            }
            return new ModelAndView("groupon", "group", group);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/addMatch")
    public ModelAndView addMatch2() {
        Frame frame = new JFrame("Option Pane Text Area");

        final SpringLayout layout = new SpringLayout();

        final JPanel panel = new JPanel(layout);
        panel.setPreferredSize(new Dimension(250, 160));

        JLabel lblName = new JLabel("Name:");
        panel.add(lblName);
        JTextField txtName = new JTextField(10);
        txtName.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(txtName);

        JLabel lblMessage = new JLabel("Message:");
        panel.add(lblMessage);
        JTextArea txtMessage = new JTextArea();
        txtMessage.setBorder(BorderFactory.createLineBorder(Color.black));
        txtMessage.setLineWrap(true);
        txtMessage.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtMessage,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 120));
        panel.add(scrollPane);

        layout.putConstraint(SpringLayout.WEST, lblName,
                0,
                SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblMessage,
                10,
                SpringLayout.SOUTH, lblName);


        layout.putConstraint(SpringLayout.WEST, txtName,
                25,
                SpringLayout.EAST, lblName);
        layout.putConstraint(SpringLayout.NORTH, scrollPane,
                10,
                SpringLayout.SOUTH, lblMessage);

        int result = JOptionPane.showConfirmDialog(frame, panel,
                "Match Messenger", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE); JOptionPane.showConfirmDialog( null, "Awesome your match has been notified!","Confirmation", JOptionPane.DEFAULT_OPTION);


        if (result == JOptionPane.YES_OPTION) {
            System.out
                    .println(txtName.getText() + ",\n" + txtMessage.getText());
        } else {
            System.out.println("Canceled");
        }


        return new ModelAndView("matchresponse", "JOptionPane", "Match message");
    }


    @RequestMapping(value = "/addplace")
    public ModelAndView savedgoogleplaces
            (@RequestParam("title") String Title)
    {

        boolean result = DAO.addPlace(Title);

        if (result == false) {

            return new ModelAndView("error", "ermsg", "Adding profile failed!");
        }

        ModelAndView mv = new ModelAndView("savedgoogleplaces");
        mv.addObject("Title", Title);

        return mv;

    }

    @RequestMapping("/savedplaces")

    public ModelAndView places(@RequestParam("Title") String Title)
    {

        ArrayList<SavedPlaces> savedPlaces= DAO.SavedPlaces(Title);
        ModelAndView mv = new ModelAndView("/savedgoogleplaces", "SavedPlaces", savedPlaces);
        mv.addObject("title", Title);

        return mv;
    }


    @RequestMapping("/addDeal")
    public ModelAndView addDeal ()
    {
        try {

            HttpClient http = HttpClientBuilder.create().build();

            HttpHost host = new HttpHost("partner-api.groupon.com", 80, "http");

            HttpGet getPage = new HttpGet("/deals.json?tsToken=US_AFF_0_201236_212556_0&channel_id=getaways&categories=Europe%2C%20Asia%2C%20Africa%2C%20%26%20Oceania&offset=0&limit=30");

            HttpResponse resp = http.execute(host, getPage);

            String jsonString = EntityUtils.toString(resp.getEntity());

            JSONObject json = new JSONObject(jsonString);

            //the int status will execute the success of the method or not(ex. local 404 error)
            int status = resp.getStatusLine().getStatusCode();

            JSONArray deals = json.getJSONArray("deals");

            JSONArray pitch = json.getJSONArray("deals");

            ArrayList<AddDeal> saveDeal = new ArrayList<AddDeal>();

            for (int i = 0; i < deals.length(); i++) {
                saveDeal.add(new AddDeal(deals.getJSONObject(i).getString("pitchHtml")));

            }
            return new ModelAndView("matchresponse", "saveDeal", saveDeal);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("/match")
    public ModelAndView match(@RequestParam("username") String UserName,
                              @RequestParam("desiredDestination") String desiredDestination,
                              @RequestParam("smoker") String Smoker,
                              @RequestParam("drinker") String Drinker)
    {

        ArrayList<UserMatch> matches = DAO.Matches(UserName, desiredDestination, Smoker, Drinker);


        //return new ModelAndView("match","result",matches);
        ModelAndView mv = new ModelAndView("match", "matches", matches);
        mv.addObject("UserName", UserName);
        mv.addObject("desiredDestination", desiredDestination);
        mv.addObject("Smoker", Smoker);
        mv.addObject("Drinker", Drinker);

        return mv;
    }

    public UserPreferences fetchingpreferences(String UserName) {
        ArrayList<UserPreferences> list = DAO.Preferences(UserName);
        UserPreferences prefs = list.get(0);

        return prefs;
    }




    @RequestMapping("/Profiles")
    public ModelAndView Profiles (@RequestParam ("UserID") int UserID) {

        ArrayList<MatchProfile> proList = DAO.Profiles(UserID);

        return new ModelAndView("viewprofile", "proList", proList);
        //mv.addObject("UserID", UserID);

    }


}
