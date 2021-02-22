package sample.controllers;

import sample.LogsClass;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlExecutor extends LogsClass {
    //СОЕДИНЕНИЕ С БАЗОЙ
    public String instanceName = "10.0.9.4\\hcdbsrv";
    public String databaseName = "HCDB";
    public String userName = "sa";
    public String pass = "Ba#sE5Ke";
    public String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
    public String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
    public Connection con;



    public SqlExecutor(){
        try {
            con = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
////////////////////////////////////----{ЗАФИКСИРОВАТЬ ВОЗВРАТ}----//////////////////////////////////////////////
    public void recordReturn(String regName,String tranId,String data){
        try {
            Statement stmt = con.createStatement();
            recordReturn(regName,data,tranId,stmt);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{УДАЛЕНИЕ ПЛАТЕЖА}----//////////////////////////////////////////////
    public void deletPayment(String tranID ,String regName,String data){
        try {
            ArrayList<String> idPay = new ArrayList<>();
            ArrayList<String> SumPay = new ArrayList<>();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE faCRMstrItems WHERE FK_psPatRegisters =" + tranID);
            stmt.executeUpdate("DELETE faCRMstr WHERE FK_psPatRegisters =" + tranID);
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM psPatLedgers WHERE FK_psPatRegisters=" + tranID + "and billtrancode = 'PAYMENT'");
            while (executeQuery.next()) {
                idPay.add(executeQuery.getString("PK_psPatledgers"));
                SumPay.add(executeQuery.getString("oramount"));
            }
            for (int i = 0; i < idPay.size(); i++) {
                stmt.executeUpdate("DELETE psPatLedgers WHERE PK_psPatledgers =" + idPay.get(i));
            }
            stmt.executeUpdate("UPDATE psPatitem SET oramount = 0 WHERE FK_psPatRegisters = " + tranID);
            deletPaymentLogs(tranID,regName,data,stmt,SumPay);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ////////////////////////////////////----{УДАЛЕНИЕ СКИДКИ}----//////////////////////////////////////////////
    public void deletDiscount(String tranId,String regName,String data){
        String SQL = "SELECT PK_psPatledgers,billtrancode FROM psPatLedgers WHERE FK_psPatRegisters = " + tranId + " and billtrancode ='DC0004'";

        try {
            ArrayList<String> DiscountId = new ArrayList<>();
            Statement stmt = con.createStatement();
            ResultSet executeQuery = stmt.executeQuery(SQL);
            while (executeQuery.next()) {
                DiscountId.add(executeQuery.getString("PK_psPatledgers"));
            }
            for (int i = 0; i < DiscountId.size(); i++) {
                stmt.executeUpdate("DELETE psPatLedgers WHERE PK_psPatledgers =" + DiscountId.get(i));
            }
            deletDiscountLogs(regName,tranId,data,stmt);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{УДАЛЕНИЕ АМБУЛАТОРИИ}----//////////////////////////////////////////////
    public void deletAmbulatory(String regName,String tranId,String data){
        String SQL_0 = "DELETE psPatDXMedPackages WHERE FK_psPatRegisters =" + tranId;
        String SQL_1 = "DELETE psPatitem WHERE FK_psPatRegisters = " + tranId;
        String SQL_2 = "DELETE psPatLedgers WHERE FK_psPatRegisters = " + tranId;
        String SQL_3 = "DELETE FROM psDctrLedgers WHERE FK_psPatRegisters = " + tranId;
        String SQL_4 = "DELETE FROM psPatFinalDXDtls WHERE FK_psPatRegisters = " + tranId;
        String SQL_5 = "DELETE FROM psGntrLedgers WHERE FK_psPatRegisters = " + tranId;
        String SQL_6 = "DELETE FROM psGntrLedgerItems WHERE FK_psPatRegisters = " + tranId;
        String SQL_7 = "DELETE FROM emdSOAPTranMstr WHERE FK_psPatRegisters = " + tranId;
        String SQL_8 = "DELETE psPatDiscounts WHERE FK_psPatRegisters = " + tranId;
        String SQL_9 = "DELETE psPatRegDiscounts WHERE FK_psPatRegisters = " + tranId;
        String SQL_10 = "DELETE psExamResultMstr WHERE FK_psPatRegisters = " + tranId;
        String SQL_11 = "DELETE LIS_request_patinv WHERE bb_pspatinv in (SELECT pk_trxno FROM psPatinv WHERE FK_psPatRegisters = " + tranId + ")";
        String SQL_12 = "DELETE emdSOAPTranMstr WHERE FK_psPatRegisters = " + tranId;
        String SQL_13 = "DELETE emdSOAPSubjCheckList WHERE FK_emdSOAPTranMstr = (SELECT PK_emdSOAPTranMstr FROM emdSOAPTranMstr WHERE FK_psPatRegisters = "+ tranId +") ";
        String SQL_14 = "DELETE emdSOAPObjCheckList WHERE FK_emdSOAPTranMstr = (SELECT PK_emdSOAPTranMstr FROM emdSOAPTranMstr WHERE FK_psPatRegisters ="+tranId + ")";
        String SQL_15 = "DELETE emdSOAPPlans WHERE FK_emdSOAPTranMstr = (SELECT PK_emdSOAPTranMstr FROM emdSOAPTranMstr WHERE FK_psPatRegisters =" + tranId + ")" ;
        String SQL_16 = "DELETE faCRMstrItems WHERE FK_psPatRegisters = " + tranId;
        String SQL_17 = "DELETE faCRMstr WHERE FK_psPatRegisters =" + tranId;
        String SQL_18 = "DELETE psPatinv_helper WHERE FK_psPatregisters =" + tranId;
        String SQL_19 = "DELETE psPatinv WHERE FK_psPatRegisters =" + tranId;
        String SQL_20 = "DELETE psOutpatients WHERE FK_psPatregisters =" + tranId;
        String SQL_21 = "DELETE psPatRegisters WHERE PK_psPatRegisters =" + tranId;

        Statement stmt = null;
        try {
            stmt = con.createStatement();

            stmt.executeUpdate(SQL_0);
            stmt.executeUpdate(SQL_1);
            stmt.executeUpdate(SQL_2);
            stmt.executeUpdate(SQL_3);
            stmt.executeUpdate(SQL_4);
            stmt.executeUpdate(SQL_5);
            stmt.executeUpdate(SQL_6);
            stmt.executeUpdate(SQL_7);
            stmt.executeUpdate(SQL_8);
            stmt.executeUpdate(SQL_9);
            stmt.executeUpdate(SQL_10);
            stmt.executeUpdate(SQL_11);
            stmt.executeUpdate(SQL_12);
            stmt.executeUpdate(SQL_13);
            stmt.executeUpdate(SQL_14);
            stmt.executeUpdate(SQL_15);
            stmt.executeUpdate(SQL_16);
            stmt.executeUpdate(SQL_17);
            stmt.executeUpdate(SQL_18);
            stmt.executeUpdate(SQL_19);
            stmt.executeUpdate(SQL_20);
            stmt.executeUpdate(SQL_21);
            //Логи
            deletAmbulatoryLogs(regName,tranId,data,stmt);


            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ОБНУЛЕНИЕ АМБУЛАТОРИИ}----//////////////////////////////////////////////
    public void zeroingClient(String tranID,String regName,String data){
        if(tranID.length()<7){
            JOptionPane.showMessageDialog(null,"ВВЕДЕНЫ НЕ КОРЕКТНЫЕ ДАННЫЕ");
        }else {
            String SQL = "UPDATE psPatitem SET prevprice = renprice,renprice = 0 WHERE FK_TRXNO =" + tranID;
            String SQL_2 = "UPDATE psPatinv SET renamount = 0,amount = 0,discount = 0,netamount = 0 WHERE PK_TRXNO =" + tranID;
            String SQL_3 = "UPDATE psPatLedgers SET debit = 0,discount = 0 WHERE FK_TRXNO =" + tranID;

            try {
                Statement stmt = con.createStatement();
                zeroingClientsLogs(tranID,regName,data,stmt);
                stmt.executeUpdate(SQL);
                stmt.executeUpdate(SQL_2);
                stmt.executeUpdate(SQL_3);
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ИЗМЕНЕНИЕ ДАТЫ АМБУЛАТОРИИ}----//////////////////////////////////////////////
    public void changeAmbulatoryDate(String tranId,String newDate,String regName, String data){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String SQL = "UPDATE psPatitem SET rendate =" + newDate + " WHERE FK_psPatRegisters = " + tranId;
            String SQL_2 = "UPDATE psPatLedgers SET docdate =" + newDate + " WHERE FK_psPatRegisters = " + tranId;
            String SQL_3 = "UPDATE psPatinv SET rendate =" + newDate + " WHERE FK_psPatRegisters = " + tranId;
            String SQL_4 = "UPDATE faCRMstr SET ordate =" + newDate + ", postdate =" + newDate + " WHERE FK_psPatRegisters = " + tranId;
            String SQL_5 = "UPDATE psPatRegisters SET registrydate =" + newDate + " WHERE PK_psPatRegisters = " + tranId;
            stmt.executeUpdate(SQL);
            stmt.executeUpdate(SQL_2);
            stmt.executeUpdate(SQL_3);
            stmt.executeUpdate(SQL_4);
            stmt.executeUpdate(SQL_5);
            changeAmbulatoryDateLogs(tranId,regName,data,newDate,stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ИЗМЕНЕНИЕ ДАТЫ РОЖДЕНИЯ}----//////////////////////////////////////////////
    public void changeBirthdate(String patId,String newDate,String regName,String data){
        //ОТКЛЮЧЕНИЕ ТРИГЕРА
        String SQL_TRIGGER_OFF = "DISABLE TRIGGER ApptTrans_Validator ON apptTrans";
        //ВКЛЮЧЕНИЕ ТРИГЕРА
        String SQL_TRIGGER_ON = "ENABLE TRIGGER ApptTrans_Validator ON apptTrans";
        //ПОИСК ПАЦИЕНТА
        String SQL = "SELECT PK_apptTrans FROM apptTrans WHERE FK_psDatacenter_Client =" + patId;
        //ИЗМЕНЕНИЕ ДАТЫ
        String SQL_2 = "UPDATE apptTrans SET birthDate =" + newDate + " WHERE PK_apptTrans =";
        String SQL_3 ="UPDATE psPersonaldata SET birthdate = " + newDate + " WHERE PK_psPersonalData=" + patId;




        try {
            //ЛИСТ СО ВСЕМИ ПЛАТЕЖАМИ
            ArrayList<String> birthdateList = new ArrayList<>();
            //СОЗДАНИЕ СТЕЙТМЕНТА
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL_TRIGGER_OFF);


            ResultSet executeQuery = stmt.executeQuery(SQL);
            //ЗАПИСЬ ID ПЛАТЕЖЕЙ В СПИСОК
            while (executeQuery.next()) {
                birthdateList.add(executeQuery.getString("PK_apptTrans"));
            }
            //УДАЛЕНИЕ ID ПЛАТЕЖЕЙ ИЗ ТАБЛИЦЫ
            for (int i = 0; i < birthdateList.size(); i++) {
                stmt.executeUpdate(SQL_2+birthdateList.get(i));
            }
            stmt.executeUpdate(SQL_3);
            stmt.executeUpdate(SQL_TRIGGER_ON);
            //СООБЩЕНИЕ О ВЫПОЛНЕНИИ (String patId,String regName,String data,Statement stmt,String newDate)
            changeBirthDateLogs(patId,regName,data,stmt,newDate);

            //ЗАКРЫТИЕ СОЕДИНЕНИЙ
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{РАЗБЛОКИРОВКА УЗИ}----//////////////////////////////////////////////
    public void enabledUltrasound(String tranId){
        Statement stmt = null;
        try {
            String SQL = "SELECT PK_psExamResultMstr FROM psExamResultMstr WHERE FK_TRXNO =" + tranId;

            String ultrasoundId = "";

            stmt = con.createStatement();

            ResultSet executeQuery = stmt.executeQuery(SQL);

            while (executeQuery.next()) {
                ultrasoundId = executeQuery.getString("PK_psExamResultMstr");
            }
            String SQL_2 = "UPDATE psExamResultMstr SET isCheckedOut = 0 WHERE PK_psExamResultMstr = " + ultrasoundId;
            stmt.executeUpdate(SQL_2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ОБНУЛЕНИЕ КОРП КЛИЕНТА}----//////////////////////////////////////////////
    public void zeroingCorpClient(String tranId,String regName,String data){
        String SQL = "exec Update_TRXNO " +tranId +  ", 'COM'";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            zeroingCorpClientsLogs(tranId,regName,data,stmt);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ИЗМЕНЕНИЕ ВРАЧА}----//////////////////////////////////////////////
    public void findDoctor(String DoctorName) throws SQLException {

    }
}
