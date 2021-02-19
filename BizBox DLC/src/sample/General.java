package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class General extends LogsClass {
    protected String instanceName = "10.0.9.4\\hcdbsrv";
    protected String databaseName = "HCDB";
    protected String userName ="";
    protected String pass ="";
     protected String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
     protected String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
    protected Connection con;
    {
        try {
            con = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
