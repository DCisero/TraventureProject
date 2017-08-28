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


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld() {
        return new
                ModelAndView("welcome", "message", "Hello World");
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
            @RequestParam("Password") String Password) {


        boolean result = DAO.addUsers(FirstName, LastName, Email, Password);

        if (result == false) {

            return new ModelAndView("existingusererror", "existingusererror", "Adding user failed!");
        }


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
    public ModelAndView addUser2(
            @RequestParam("UserName") String UserName,
            @RequestParam("Profession") String Profession,
            @RequestParam("Birthday") int Birthday,
            @RequestParam("Gender") String Gender,
            @RequestParam("City") String City,
            @RequestParam("State") String State,
            @RequestParam("DesiredDestination") String DesiredDestination,
            @RequestParam("Interests") String Interests,
            @RequestParam("Smoker") String Smoker,
            @RequestParam("Drinker") String Drinker, HttpSession session)


    {


        boolean result = DAO.addUsers2(UserName, Profession, Birthday, Gender, City, State, DesiredDestination, Interests, Smoker, Drinker);

        if (result == false) {

            return new ModelAndView("error", "ermsg", "Adding profile failed!");
        }

        session.setAttribute("username", UserName);
        session.setAttribute("profession", Profession);
        session.setAttribute("birthday", Birthday);
        session.setAttribute("gender", Gender);
        session.setAttribute("city", City);
        session.setAttribute("State", State);
        session.setAttribute("desiredDestination", DesiredDestination);
        session.setAttribute("interests", Interests);
        session.setAttribute("Smoker", Smoker);
        session.setAttribute("Drinker", Drinker);


        ModelAndView mv = new ModelAndView("userview");
        mv.addObject("UserName", UserName);
        mv.addObject("Profession", Profession);
        mv.addObject("Birthday", Birthday);
        mv.addObject("Gender", Gender);
        mv.addObject("City", City);
        mv.addObject("State", State);
        mv.addObject("DesiredDestination", DesiredDestination);
        mv.addObject("Interests", Interests);
        mv.addObject("Smoker", Smoker);
        mv.addObject("Drinker", Drinker);

        return mv;
    }

    @RequestMapping("/loginresponse")
    public ModelAndView loginresponse(
            @RequestParam("name") String name,
            @RequestParam("email") String email, HttpSession session)

    {
        boolean result = DAO.addUsersG(name, email);

        if (result == false) {

            return new ModelAndView("existingusererror", "existingusererror", "Adding user failed!");
        }

        session.setAttribute("loginStatus", "logged in");
        session.setAttribute("username", name);

        {
            return new ModelAndView("loginresponse");

        }

    }


    //added sessions
    @RequestMapping("/existinggooglelogin")
    public ModelAndView existinguserlogin(
            @RequestParam("email") String email,
            @RequestParam("name") String name, HttpSession session) throws SQLException
    {


        boolean result = DAO.checkGoogleLogin(email);

        if (result == false) {
            return new ModelAndView("emailandorpasswordincorrect", "emailandorpasswordincorrect", "Adding user failed!");
        }

        session.setAttribute("loginStatus", "logged in");
        session.setAttribute("username", name);

        return new ModelAndView("userview");
    }



    @RequestMapping("/checklogin")
    public ModelAndView checklogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password) throws SQLException {

        boolean result = DAO.checkLogin(email, password);

        if (result == false) {
            return new ModelAndView("emailandorpasswordincorrect", "emailandorpasswordincorrect", "Adding user failed!");
        }

        return new ModelAndView("userview");
    }





    @RequestMapping("/existinguserlogin")
    public ModelAndView existinguserlogin() {

        return new ModelAndView("existinguserlogin");
    }

    @RequestMapping("/about")
    public ModelAndView about() {

        return new ModelAndView("about");
    }

    @RequestMapping("/googleplaces")
    public ModelAndView googleplaces() {

        return new ModelAndView("googleplaces");
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
                group.add(new Groupon(deals.getJSONObject(i).getString("title"),
                        deals.getJSONObject(i).getString("announcementTitle"),
                        deals.getJSONObject(i).getString("highlightsHtml"),
                        deals.getJSONObject(i).getString("pitchHtml"),
                        deals.getJSONObject(i).getString("dealUrl")));

            }
            return new ModelAndView("groupon", "group", group);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/match")
    public ModelAndView match(@RequestParam("username") String UserName,
                              @RequestParam("destination") String DesiredDestination) {

        ArrayList<UserMatch> matches = DAO.Matches(UserName, DesiredDestination);


        //return new ModelAndView("match","result",matches);
        ModelAndView mv = new ModelAndView("match", "matches", matches);
        mv.addObject("UserName", UserName);
        mv.addObject("DesiredDestination", DesiredDestination);

        return mv;
    }

    @RequestMapping(value = "/addplace")
    public ModelAndView savedplaces
            (
            @RequestParam("title") String Title
            )

    {

        boolean result = DAO.addPlace(Title);

        if (result == false) {

            return new ModelAndView("error", "ermsg", "Adding profile failed!");
        }

        ModelAndView mv = new ModelAndView("addplace");
        mv.addObject("Title", Title);

        return mv;

    }

    @RequestMapping("/savedplaces")
    public ModelAndView places(
            @RequestParam("Title") String Title) {

        ArrayList<SavedPlaces> savedPlaces= DAO.SavedPlaces(Title);

        ModelAndView mv = new ModelAndView("/addplace", "SavedPlaces", savedPlaces);
        mv.addObject("Title", Title);
        System.out.println(Title);


        return mv;
    }

}

