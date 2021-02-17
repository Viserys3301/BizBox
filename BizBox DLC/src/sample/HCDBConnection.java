package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HCDBConnection extends LogsClass {
     String instanceName = "10.0.9.4\\hcdbsrv";
     String databaseName = "HCDB";
     String userName ;
     String pass ;
     String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
     String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
     Connection con;

    {
        try {
            con = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public HCDBConnection(String login,String password){
        this.userName = login;
        this.pass = password;

    }
}
