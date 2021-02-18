package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LogsClass {
    private java.util.Date date = new Date();
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat(" yyyy.MM.dd ' ' hh:mm:ss a zzz");
    private String dateTime = formatForDateNow.format(date);

    protected void changePaymentLogs(Statement stmt)  throws SQLException{
 //       stmt.executeUpdate();
    }

    protected void deletDiscountLogs(Statement stmt)  throws SQLException{
 //       stmt.executeUpdate();
    }

    protected void changeDoctorLogs(String regName,String data,String tranID, String doctorID, Statement stmt) throws SQLException {
        stmt.executeUpdate("INSERT INTO RegistryLogs (RegID,[Data],[Date],TranID_FK_TRXNO,newDocID) VALUES (" + "'" + regName + "'" + " ," + data + "," + "'" + dateTime + "'" + "," + tranID + "," + doctorID + ")");
    }

    protected void deletPaymentLogs(String tranID, String regName, String data, Statement stmt, ArrayList<String> SumPay)  throws SQLException{
        stmt.executeUpdate("INSERT INTO RegistryLogs (RegID,[Data],[Date],TranID_PK_psPatledgers,Payment) VALUES (" + "'" + regName + "'" + " ," + data + "," + "'" + dateTime + "'" + "," + tranID + "," + SumPay.get(0) + ")");
    }

    protected void zeroingClientsLogs(String tranID, String regName, String data, Statement stmt) throws SQLException {
        String SumPay ="";
        ResultSet executeQuery = stmt.executeQuery("SELECT renprice FROM psPatitem WHERE FK_TRXNO ="+ tranID);
        while (executeQuery.next()) { SumPay = executeQuery.getString("renprice"); }
        stmt.executeUpdate("INSERT INTO RegistryLogs (RegID,[Data],[Date],TranID_FK_TRXNO,Payment) VALUES (" + "'" + regName + "'" + " ," + data + "," + "'" + dateTime + "'" + "," + tranID + "," + SumPay + ")");
    }

    protected void zeroingCorpClientsLogs(String tranID,String regName,String data,Statement stmt)throws SQLException{
   //     stmt.executeUpdate();
    }

    protected void changeBirthDateLogs(String patId,String regName,String data,Statement stmt,String newDate)  throws SQLException{
        stmt.executeUpdate("INSERT INTO RegistryLogs (RegID,[Data],[Date],TranID_PK_psPatledgers,NewDate) VALUES ("+ "'" + regName + "'" +"," + data + "," + "'" + dateTime + "'"  + "," + patId + "," + newDate + ")" );
    }

    protected void changeAmbulatoryDateLogs(String tranID,String regName,String data,String newDate,Statement stmt)  throws SQLException{
        stmt.executeUpdate("INSERT INTO RegistryLogs (RegID,[Data],[Date],TranID_PK_psPatledgers,NewDate) VALUES (" + "'" + regName + "'" + " ," + data + "," + "'" + dateTime + "'" + "," + tranID + "," + newDate  + ")");
    }
    protected void recordReturn(String regName,String data,String tranID,Statement stmt) throws SQLException{
        stmt.executeUpdate("INSERT INTO RegistryLogs (RegID,[Data],[Date],TranID_PK_psPatledgers) VALUES (" + "'" + regName + "'" + " ," + data + "," + "'" + dateTime + "'" + "," + tranID + ")");
    }
}
