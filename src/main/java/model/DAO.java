package model;

import com.mysql.jdbc.PreparedStatement;
import com.traventure.company.test.util.UserMatch;
import com.traventure.company.test.util.UserProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;

public class DAO {


    public static boolean addUsers(String FirstName, String LastName, String Email, String Password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(DBCredentials.DB_ADDRESS, DBCredentials.USERNAME, DBCredentials.PASSWORD);

            String addUsersCommand = "INSERT INTO userlogin " + "(FirstName, LastName, Email, Password) " + "VALUES ('" + FirstName + "', '" + LastName + "', '" + Email + "', '" + Password + "')";
            System.out.println("SQL Query " + addUsersCommand);

            Statement st = mysqlConnection.createStatement();

            int results = st.executeUpdate(addUsersCommand);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean addUsers2(String UserName, String Profession, int Birthday, String Gender, String City, String State, String DesiredDestination, String Interests, String Smoker, String Drinker) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(DBCredentials.DB_ADDRESS, DBCredentials.USERNAME, DBCredentials.PASSWORD);

            String addUsers2Command = "INSERT INTO userprofile " + "(UserName, Profession, Birthday, Gender, City, State, DesiredDestination, Interests, Smoker, Drinker)" + "VALUES ('" + UserName + "', '" + Profession + "', '" + Birthday + "', '" + Gender + "', '" + City + "', '" + State + "', '" + DesiredDestination + "', '" + Interests + "', '" + Smoker + "', '" + Drinker + "')";
            System.out.println("SQL Query " + addUsers2Command);

            Statement st = mysqlConnection.createStatement();

            int results = st.executeUpdate(addUsers2Command);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean addUsersG(String name, String email) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(DBCredentials.DB_ADDRESS, DBCredentials.USERNAME, DBCredentials.PASSWORD);

            String addUsersGCommand = "INSERT INTO userlogin " + "(FirstName, Email) " + "VALUES ('" + name + "', '" + email + "')";

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

    public static boolean userlogin(String email, String password)

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(DBCredentials.DB_ADDRESS, DBCredentials.USERNAME, DBCredentials.PASSWORD);

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


    public static ArrayList<UserMatch> Matches(String UserName, String DesiredDestination, String Smoker, String Drinker) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            // below is static
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
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
                // extract data from that row
//                    String name = result.getString("UserName");
//                    System.out.println("SQL Query" + UserName);

            }


            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}

