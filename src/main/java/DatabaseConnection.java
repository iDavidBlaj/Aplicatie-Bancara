package main.java;

import java.sql.*;

public class DatabaseConnection
{
private static Connection connection;

    public DatabaseConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplicatie_bancara?autoReconnect=true&useSSL=false", "root", "admin");
        }

        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public static Connection getConnection()
    {
        if(connection==null)
            new DatabaseConnection();
        return connection;
    }
}




