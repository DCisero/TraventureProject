package model;
import com.mysql.jdbc.PreparedStatement;
import com.traventure.company.test.util.MatchProfile;
import com.traventure.company.test.util.SavedPlaces;
import com.traventure.company.test.util.UserMatch;
import com.traventure.company.test.util.UserProfile;
import com.traventure.company.test.util.UserPreferences;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;

public class DAO {


    public static boolean addUsers(
            String FirstName,
            String LastName,
            String Email,
            String Password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addUsersCommand = "INSERT INTO userlogin " +
                    "(FirstName, LastName, Email, Password) " +
                    "VALUES ('" +
                    FirstName + "', '" +
                    LastName + "', '" +
                    Email + "', '" +
                    Password + "')";
            System.out.println("SQL Query " + addUsersCommand);

            Statement st = mysqlConnection.createStatement();

            int results = st.executeUpdate(addUsersCommand);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean addUsers2(
            String UserName,
            String Profession,
            int Birthday,
            String Gender,
            String City,
            String State,
            String DesiredDestination,
            String Interests,
            String Smoker,
            String Drinker,
            String Image,
            String Email)
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addUsers2Command = "INSERT INTO userprofile " +
                    "(UserName, Profession, Birthday, Gender, City, State, DesiredDestination, Interests, Smoker, Drinker, Image, Email)" +
                    "VALUES ('" +
                    UserName + "', '" +
                    Profession + "', '" +
                    Birthday + "', '" +
                    Gender + "', '" +
                    City + "', '" +
                    State + "', '" +
                    DesiredDestination + "', '" +
                    Interests + "', '" +
                    Smoker + "', '" +
                    Drinker + "', '" +
                    Image + "', '" +
                    Email + "')";
            System.out.println("SQL Query " + addUsers2Command);

            Statement st = mysqlConnection.createStatement();

            int results = st.executeUpdate(addUsers2Command);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean addUsersG(
            String name,
            String email
    ) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addUsersGCommand = "INSERT INTO userlogin " +
                    "(FirstName, Email) " +
                    "VALUES ('" +
                    name + "', '" +
                    email + "')";

            System.out.println("SQL Query " + addUsersGCommand);
            Statement st = mysqlConnection.createStatement();
            int result = st.executeUpdate(addUsersGCommand);

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean userlogin(
            String email,
            String password)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String readuserloginCommand = "select * FROM userlogin WHERE email =('" + email + "')";
            System.out.println("SQL Query " + "userlogin");
            Statement st = mysqlConnection.createStatement();
            ResultSet result = st.executeQuery(readuserloginCommand);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean checkLogin(String email, String password)
            throws SQLException {
        System.out.println("DAO.CHECKLOGIN has been called");

        Connection connection = null; //manages connection
        PreparedStatement pt = null; //manages prepared statement


        {  //connect to database
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection mysqlConnection;
                mysqlConnection = DriverManager.getConnection(
                        DBCredentials.DB_ADDRESS,
                        DBCredentials.USERNAME,
                        DBCredentials.PASSWORD);


                String sql = "select Email,password from userlogin where email=?";
                PreparedStatement ps = (PreparedStatement) mysqlConnection.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet result = ps.executeQuery();
                String orgUname = "", orPass = "";

                while (result.next()) {
                    orgUname = result.getString("email");
                    orPass = result.getString("password");
                }

                if (orPass.equals(password)) {
                    return true;

                } else {

                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean checkGoogleLogin(String email)
            throws SQLException {
        System.out.println("DAO checkgooglelogin has been called");

        Connection connection = null; //manages connection
        PreparedStatement pt2 = null; //manages prepared statement

        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection mysqlConnection;
                mysqlConnection = DriverManager.getConnection(
                        DBCredentials.DB_ADDRESS,
                        DBCredentials.USERNAME,
                        DBCredentials.PASSWORD);


                String sql = "select Email from userlogin where email=?";
                PreparedStatement ps = (PreparedStatement) mysqlConnection.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet result = ps.executeQuery();
                String orgUname2 = "", orPass2 = "";

                while (result.next()) {
                    orgUname2 = result.getString("email");
                }

                if (orgUname2.equals(email)) {
                    return true;

                } else {

                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }


    public static boolean addPlace(
            String Title)
    {
        String Email = "dhillon7731@gmail.com";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addPlaceCommand = "INSERT INTO SavedPlaces " +
                    "(Title, Email) " +
                    "VALUES ('" +
                    Title + "', '" +
                    Email + "')";
            System.out.println("SQL Query " + addPlaceCommand);
            Statement st = mysqlConnection.createStatement();
            int results = st.executeUpdate(addPlaceCommand);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ArrayList<SavedPlaces> SavedPlaces(String Email) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String sql = ("SELECT title FROM SavedPlaces WHERE Email = ?");


            PreparedStatement ps = (PreparedStatement) mysqlConnection.prepareStatement(sql);
            ps.setString(1, Email);

            ResultSet result = ps.executeQuery();

            ArrayList<SavedPlaces> list2 = new ArrayList<SavedPlaces>();
            while (result.next()) {
                SavedPlaces temp = new SavedPlaces(result.getString("Title"));
                list2.add(temp);

            }
            return list2;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean addDeal(
            String pitchHtml) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addDealCommand = "INSERT INTO destinations WHERE vacations " +
                    "(pitchHtml) " +
                    "VALUES ('" +
                    pitchHtml + "')";
            System.out.println("SQL Query " + addDealCommand);

            Statement st = mysqlConnection.createStatement();

            int results = st.executeUpdate(addDealCommand);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ArrayList<UserMatch> Matches(String UserName, String DesiredDestination, String Smoker, String Drinker) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(DBCredentials.DB_ADDRESS, DBCredentials.USERNAME, DBCredentials.PASSWORD);

            String sql = ("SELECT UserName, DesiredDestination, Smoker, Drinker FROM userprofile WHERE DesiredDestination = ?" +
                    " AND Smoker = ? AND Drinker = ?");

            PreparedStatement ps = (PreparedStatement) mysqlConnection.prepareStatement(sql);
            ps.setString(1, DesiredDestination);
            ps.setString(2, Smoker);
            ps.setString(3, Drinker);


            ResultSet result = ps.executeQuery();

            ArrayList<UserMatch> list = new ArrayList<UserMatch>();
            while (result.next()) {
                UserMatch temp = new UserMatch(result.getString("UserName"), result.getString("DesiredDestination"), result.getString("Smoker"), result.getString("Drinker"));
                list.add(temp);

            }


            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static ArrayList<UserPreferences> Preferences(String Email) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String sql = ("SELECT UserName, Gender, Profession, Interests, DesiredDestination, Smoker, Drinker, Image FROM userprofile WHERE Email = ?");

            PreparedStatement ps = (PreparedStatement) mysqlConnection.prepareStatement(sql);
            ps.setString(1, Email);

            ResultSet result = ps.executeQuery();

            ArrayList<UserPreferences> list = new ArrayList<UserPreferences>();
            while (result.next()) {
                UserPreferences temp = new UserPreferences(
                        result.getString("UserName"),
                        result.getString("Gender"),
                        result.getString("Profession"),
                        result.getString("Interests"),
                        result.getString("DesiredDestination"),
                        result.getString("Smoker"),
                        result.getString("Drinker"),
                        result.getString("Image"));
                list.add(temp);
            }

            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static ArrayList<MatchProfile> Profiles(int UserID) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(DBCredentials.DB_ADDRESS, DBCredentials.USERNAME, DBCredentials.PASSWORD);

            String sql = ("SELECT UserName, Gender, Profession, Interests, DesiredDestination, Smoker, Drinker FROM userprofile WHERE UserID = ?");

            PreparedStatement ps = (PreparedStatement) mysqlConnection.prepareStatement(sql);
            ps.setInt(1, UserID);


            ResultSet result = ps.executeQuery();

            ArrayList<MatchProfile> proList = new ArrayList<MatchProfile>();
            while (result.next()) {
                MatchProfile temp = new MatchProfile(result.getInt("UserID"), result.getString("UserName"), result.getString("Gender"),
                        result.getString("Profession"), result.getString("Interests"), result.getString("DesiredDestination"),
                        result.getString("Smoker"), result.getString("Drinker"));
                proList.add(temp);

            }

            return proList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}