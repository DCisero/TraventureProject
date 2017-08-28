package model;
import com.mysql.jdbc.PreparedStatement;
import com.traventure.company.test.util.SavedPlaces;
import com.traventure.company.test.util.UserLogin;
import com.traventure.company.test.util.UserMatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


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
                String Drinker) {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection mysqlConnection;
                mysqlConnection = DriverManager.getConnection(
                        DBCredentials.DB_ADDRESS,
                        DBCredentials.USERNAME,
                        DBCredentials.PASSWORD);

                String addUsers2Command = "INSERT INTO userprofile " +
                        "(UserName, Profession, Birthday, Gender, City, State, DesiredDestination, Interests, Smoker, Drinker)" +
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
                        Drinker + "')";
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

                //if (result == 1)
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }

    public static boolean checkLogin(String email,  String password)
            throws SQLException {
        System.out.println("THE EXCEPTION HAS BEEN THROWN");

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
        System.out.println("THE EXCEPTION HAS BEEN THROWN");

        Connection connection = null; //manages connection
        PreparedStatement pt2 = null; //manages prepared statement


        {  //connect to database
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





        public static ArrayList<UserMatch> Matches(String UserName, String DesiredDestination) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection mysqlConnection;
                mysqlConnection = DriverManager.getConnection(
                        DBCredentials.DB_ADDRESS,
                        DBCredentials.USERNAME,
                        DBCredentials.PASSWORD);

                String sql = ("SELECT UserName, DesiredDestination FROM userprofile WHERE DesiredDestination = ?");

                PreparedStatement ps = (PreparedStatement) mysqlConnection.prepareStatement(sql);
                ps.setString(1, DesiredDestination);

                ResultSet result = ps.executeQuery();

                ArrayList<UserMatch> list = new ArrayList<UserMatch>();
                while (result.next()) {
                    UserMatch temp = new UserMatch(result.getString("UserName"), result.getString("DesiredDestination"));
                    list.add(temp);

                }



                return list;

            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }

        public static boolean addPlace(
                String Title
                ) {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection mysqlConnection;
                mysqlConnection = DriverManager.getConnection(
                        DBCredentials.DB_ADDRESS,
                        DBCredentials.USERNAME,
                        DBCredentials.PASSWORD);

                String addPlaceCommand = "INSERT INTO SavedPlaces " +
                        "(Title)" +
                        "VALUES ('" +
                        Title + "')";
                System.out.println("SQL Query " + addPlaceCommand);
                Statement st = mysqlConnection.createStatement();
                int results = st.executeUpdate(addPlaceCommand);

                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }

    public static ArrayList<SavedPlaces> SavedPlaces(String Title) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String sql = ("SELECT title FROM SavedPlaces");


            PreparedStatement ps = (PreparedStatement) mysqlConnection.prepareStatement(sql);
            ps.setString(1, Title);

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
    }

