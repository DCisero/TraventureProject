package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

    public class DAO {


        public static boolean addUsers (
                String FirstName,
                String LastName,
                String Email,
                String Password)
        {

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
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                return false;
            }
        }

        public static boolean addUsers2 (
                String UserName,
                String Profession,
                int Birthday,
                String Gender,
                String City,
                String State,
                String DesiredDestination,
                String Interests,
                String Smoker,
                String Drinker)
        {

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
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                return false;
            }
        }
}
