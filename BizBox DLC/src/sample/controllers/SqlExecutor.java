package sample.controllers;

import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
            stmt.close();
            con.close();
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
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ОБНУЛЕНИЕ КОРП КЛИЕНТА}----//////////////////////////////////////////////
    public boolean zeroingCorpClient(String tranId,String regName,String data ){

        String patId ="";
        String patId2 = null;


        String SQL = "exec Update_TRXNO " +tranId +  ", 'COM'";
        try {
            Statement stmt = con.createStatement();
            String checkCorp = "SELECT FK_emdPatients FROM psPatitem WHERE FK_TRXNO =" + tranId;
            ResultSet executeQuery = stmt.executeQuery(checkCorp);
            while (executeQuery.next()) {
                patId = executeQuery.getString("FK_emdPatients");

            }

            String search = "SELECT psDatacenter_ID FROM Assistance_list WHERE psDatacenter_ID =" + patId;
            ResultSet executeQuery2 = stmt.executeQuery(search);
            while (executeQuery2.next()) {
                patId2 = executeQuery2.getString("psDatacenter_ID");
            }
                if(patId2!=null){
                    stmt.executeUpdate(SQL);
                    zeroingCorpClientsLogs(tranId,regName,data,stmt);
                    stmt.close();
                    con.close();
                    return true;
                }else {
                    JOptionPane.showMessageDialog(null,"ПАЦИЕНТА НЕТ В КОМПАНИИ");
                }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ИЗМЕНЕНИЕ ВРАЧА}----//////////////////////////////////////////////
    public void findDoctor(String DoctorName) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            String SQL = "select dbo.udf_GetFullName(PK_appsysUsers) as DoctorName,PK_appsysUsers,usercode,lockAIS from appsysusers where dbo.udf_GetFullName(PK_appsysUsers) Like '%" + DoctorName + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);
            while (executeQuery.next()) {
                ChangeDoctorController.initData(new Doctors(executeQuery.getString("PK_appsysUsers"),executeQuery.getString("DoctorName")));
            }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changeDoctroe(String tranID,String doctorID,String regName,String data){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String SQL = "UPDATE psPatitem SET FK_emdDoctorsREQ = " +  doctorID + " where FK_TRXNO =" + tranID;
            stmt.executeUpdate(SQL);
            //Логи
            changeDoctorLogs(regName,data,tranID,doctorID,stmt);
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ИЗМЕНЕНИЕ ПЛАТЕЖА}----//////////////////////////////////////////////
    public void findPayment(String patName){
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT payername, cashamount, cardamount,PK_TRXNO FROM faCRMstr WHERE payername like" + "'" + patName + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                ChangePaymentController.initData(new Payments(executeQuery.getString("payername"),
                        executeQuery.getString("cashamount"),
                        executeQuery.getString("cardamount"),
                        executeQuery.getString("PK_TRXNO")));
            }

            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void changePayment(String tranId,boolean isCard,String regName,String data){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            if(isCard){
                //НАЛ НА БЕЗНАЛ
                String SQL = "UPDATE faCRMstr SET cardamount = cashamount,cashamount = 0  WHERE PK_TRXNO =" + tranId;
                stmt.executeUpdate(SQL);
            }
            else if(!isCard){
                //БЕЗНАЛ НА НАЛ
                String SQL = "UPDATE faCRMstr SET cashamount = cardamount,cardamount = 0  WHERE PK_TRXNO =" + tranId;
                stmt.executeUpdate(SQL);
            }


            //Логи
            changePaymentLogs(regName,data,tranId,stmt);


            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ВОЗВРАТ УЗИ}----//////////////////////////////////////////////
    public void findServices(String servicesName){
        try {
            Statement stmt = con.createStatement();
            String SQL  = "SELECT dbo.udf_GetItemDescription(FK_iwItems) as servicesName, PK_psExamResultMstr FROM psExamResultMstr WHERE FK_TRXNO =" + servicesName;
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                RecoveryUltrasoundController.initData(new Services(executeQuery.getString("servicesName"),executeQuery.getString("PK_psExamResultMstr")));
            }

            stmt.close();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recoveryUltrasound(String servicesId){
        String SQL  = "UPDATE psExamResultMstr SET withresultflag = 0 WHERE PK_psExamResultMstr ="+servicesId;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);

            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ЛОГИ}----//////////////////////////////////////////////
    public void findLogs(String regId){
        String SQL = "SELECT RegID,Data,TranID_FK_TRXNO,TranID_PK_psPatledgers,Date FROM RegistryLogs WHERE RegID like " + regId ;

        try {

            //СОЗДАНИЕ СТЕЙТМЕНТА
            Statement stmt = con.createStatement();

            //ПОИСК ГЛАВНОГО ПЛАТЕЖА
            ResultSet executeQuery = stmt.executeQuery(SQL);

            //ЗАПИСЬ ID ПЛАТЕЖЕЙ В СПИСОК
            while (executeQuery.next()) {
                CheckLogsController.initData(new Logs(executeQuery.getString("RegID"),
                        executeQuery.getString("Data"),
                        executeQuery.getString("TranID_FK_TRXNO"),
                        executeQuery.getString("TranID_PK_psPatledgers"),
                        executeQuery.getString("Date")));
            }

            //ЗАКРЫТИЕ СОЕДИНЕНИЙ
            stmt.close();
            con.close();
        } catch (
                SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ПОЛЬЗОВАТЕЛИ}----//////////////////////////////////////////////
    public void findUsers(String userName){

        try {
            Statement stmt = con.createStatement();
            String SQL ="SELECT PK_appsysUsers,dbo.udf_GetFullName(PK_appsysUsers) as userName,FK_appsysUserGroups,usercode,logdate," +
                    "systemHIS,systemClinic,systemAIS,lockHIS,lockClinic,lockAIS,lockaccount FROM appsysusers where dbo.udf_GetFullName(PK_appsysUsers) like '%" + userName  + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);
            while (executeQuery.next()) {
                UsersController.initData(new Users(executeQuery.getString("PK_appsysUsers"),
                        executeQuery.getString("userName"),
                        executeQuery.getString("FK_appsysUserGroups"),
                        executeQuery.getString("usercode"),
                        executeQuery.getString("logdate"),
                        executeQuery.getString("systemHIS"),
                        executeQuery.getString("systemClinic"),
                        executeQuery.getString("systemAIS"),
                        executeQuery.getString("lockHIS"),
                        executeQuery.getString("lockClinic"),
                        executeQuery.getString("lockAIS"),
                        executeQuery.getString("lockaccount")));
            }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unLockAccount(String columnName,String PKey){
        try {
            Statement stmt = con.createStatement();
            String SQL = "UPDATE appsysusers SET " + columnName + " = 0 WHERE PK_appsysUsers =" + PKey;
            stmt.executeUpdate(SQL);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ПЕРЕБРОНЬ}----//////////////////////////////////////////////

    public void findPatients(String patientName){
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT dbo.udf_GetFullName(FK_psDatacenter) as PatNameColumnId ,target_date, source_date, workstation,[date] as changeDate FROM apptTrans_log WHERE dbo.udf_GetFullName(FK_psDatacenter) Like '%" + patientName + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);
            while (executeQuery.next()) {
                RebookController.initData(new Rebooks(executeQuery.getString("PatNameColumnId"),
                        executeQuery.getString("target_date"),
                        executeQuery.getString("source_date"),
                        executeQuery.getString("changeDate"),
                        executeQuery.getString("workstation")));
            }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{ДОБАВЛЕНИЕ КОРП}----//////////////////////////////////////////////
    public void findCompany(String companyName){
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT ID,Name FROM Assistance_clients WHERE Name Like '%" + companyName + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                AddCorpClientController.initData(new Company(executeQuery.getString("ID"),executeQuery.getString("Name")));
            }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddCorpClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findPackages(String companyId){
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT ap.ID, ac.Name, ap.Assistance_clients_ID, ap.Name as packageName FROM Assistance_packages ap join Assistance_clients ac on ac.ID = ap.Assistance_clients_ID WHERE ap.Assistance_clients_ID =" + companyId;
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                AddCorpClientController.initData2(new Packages(executeQuery.getString("ID"),executeQuery.getString("packageName")));
            }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddCorpClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addCorpClient(String patId,String refPaid,String companyId,String packageId,boolean close){

        try {
            String isHave = null;
            String check ="SELECT psDatacenter_ID FROM Assistance_list WHERE psDatacenter_ID =" + patId;
            String SQL = "INSERT INTO Assistance_list (psDatacenter_ID, psDatacenter_REF, Assistance_clients_ID,Assistance_packages_ID, isDiscontinued) VALUES(" + patId + "," + refPaid + "," + companyId + "," + packageId +  "," + "0" +")";
            Statement stmt = con.createStatement();

            ResultSet executeQuery = stmt.executeQuery(check);
            while (executeQuery.next()) {
                isHave = executeQuery.getString("psDatacenter_ID");
            }
            if(isHave==null){
                stmt.executeUpdate(SQL);
                stmt.close();
                if(close){
                    con.close();
                }

                return true;
            }
            JOptionPane.showMessageDialog(null,"КЛИЕНТ УЖЕ ИМЕЕТСЯ В КОМПАНИИ" );

                stmt.close();
                con.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void addNewCorpClient(String firstname,String secondNmae,String corpBirthdate,String gender,String PatIIN,String key,String companyId,String packageId,String refPaid ){
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String PK_psDatacenter = null;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String SQLDatacenter = "INSERT INTO psDatacenter (hs7dcno,rectype,fullname,fullname2,customname,email,prcountry,billflag,delvflag,lcustomer," +
                "  lvendor,lemployee,lpatient,ldoctor,lsysuser,lapplicant,localization,prcountrycode) VALUES (0,'P'," +
                "'"+ firstname +", " + secondNmae + "',' " + secondNmae + " " + firstname + "',' " + secondNmae + " " + firstname +"','" + key +"','Казахстан (Kazakhstan)',0,0,0,0,0,1,0,0,0,'Russian (Russia)',7)";
            stmt.executeUpdate(SQLDatacenter);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String search = "SELECT PK_psDatacenter FROM psDatacenter WHERE fullname = '" + firstname + ", " + secondNmae +"' and email = '" + key + "'";
        ResultSet executeQuery = stmt.executeQuery(search);
        while (executeQuery.next()) {
            PK_psDatacenter = executeQuery.getString("PK_psDatacenter");
        }
        String SQLPersonal = "  INSERT INTO psPersonaldata (PK_psPersonalData, firstname,lastname,gender,birthdate,civilstatus,empaddress,cpcountry," +
                "isBlackAmerican,isAsian,isIndianAmerican,isHispanicLatino,isNativeHawaiian,isWhite,isFictitiousBirthdate,  isnonlocal," +
                "FK_mscIndustry,FK_mscWorkLevel,empcountrycode,cpcountrycode,isnopersonaldata,isnocommfrmcompany) VALUES " +
                "( " + PK_psDatacenter + ",'" + secondNmae + "',' " + firstname +"','" + gender + "'," + corpBirthdate +",'M',' Казахстан (Kazakhstan)','Казахстан (Kazakhstan)',0,0,0,0,0,0,0,0,0,0,7,7,0,0)";
            stmt.executeUpdate(SQLPersonal);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String SQLEmdPatient = "INSERT INTO emdPatients (PK_emdPatients,holdacct,confidential,patid,FK_faCustomers,FK_mscContracts,isBlacklisted,PrincipalClass,SAPCode,  " +
                "FK_faCustomersInteg,FK_facustomersPlan,KeyPersonnel)   VALUES (" + PK_psDatacenter + ",0,0,'" + PatIIN +"',0,0,0,'A',0,0,0,0)";
            stmt.executeUpdate(SQLEmdPatient);
            stmt.close();
            if(refPaid==null){
                refPaid=PK_psDatacenter;
            }
            boolean close =true ;
            addCorpClient(PK_psDatacenter,refPaid,companyId,packageId,close);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addNewCorpClientFromFile(String firstname,String secondNmae,String corpBirthdate,String gender,String PatIIN,String key,String companyId,String packageId,String refPaid,String isGeneral,boolean close){



        Statement stmt = null;
        try {

            stmt = con.createStatement();
            String PK_psDatacenter = null;
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            String SQLDatacenter = "INSERT INTO psDatacenter (hs7dcno,rectype,fullname,fullname2,customname,email,prcountry,billflag,delvflag,lcustomer," +
                    "  lvendor,lemployee,lpatient,ldoctor,lsysuser,lapplicant,localization,prcountrycode) VALUES (0,'P'," +
                    "'"+ firstname +", " + secondNmae + "',' " + secondNmae + " " + firstname + "',' " + secondNmae + " " + firstname +"','" + key +"','Казахстан (Kazakhstan)',0,0,0,0,0,1,0,0,0,'Russian (Russia)',7)";
            stmt.executeUpdate(SQLDatacenter);
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            String search = "SELECT PK_psDatacenter FROM psDatacenter WHERE fullname = '" + firstname + ", " + secondNmae +"' and email = '" + key + "'";
            ResultSet executeQuery = stmt.executeQuery(search);
            while (executeQuery.next()) {
                PK_psDatacenter = executeQuery.getString("PK_psDatacenter");
            }
            String SQLPersonal = "  INSERT INTO psPersonaldata (PK_psPersonalData, firstname,lastname,gender,birthdate,civilstatus,empaddress,cpcountry," +
                    "isBlackAmerican,isAsian,isIndianAmerican,isHispanicLatino,isNativeHawaiian,isWhite,isFictitiousBirthdate,  isnonlocal," +
                    "FK_mscIndustry,FK_mscWorkLevel,empcountrycode,cpcountrycode,isnopersonaldata,isnocommfrmcompany) VALUES " +
                    "( " + PK_psDatacenter + ",'" + secondNmae + "',' " + firstname +"','" + gender + "'," + corpBirthdate +",'M',' Казахстан (Kazakhstan)','Казахстан (Kazakhstan)',0,0,0,0,0,0,0,0,0,0,7,7,0,0)";
            stmt.executeUpdate(SQLPersonal);
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            String SQLEmdPatient = "INSERT INTO emdPatients (PK_emdPatients,holdacct,confidential,patid,FK_faCustomers,FK_mscContracts,isBlacklisted,PrincipalClass,SAPCode,  " +
                    "FK_faCustomersInteg,FK_facustomersPlan,KeyPersonnel)   VALUES (" + PK_psDatacenter + ",0,0,'" + PatIIN +"',0,0,0,'A',0,0,0,0)";
            stmt.executeUpdate(SQLEmdPatient);
            stmt.close();

            if(isGeneral.equalsIgnoreCase("isGeneral")){
                AddCorpClientController.refPaid = PK_psDatacenter;
                refPaid=PK_psDatacenter;
            }else if(isGeneral.equalsIgnoreCase("isFamily")){
                refPaid = AddCorpClientController.refPaid;
            }

            addCorpClient(PK_psDatacenter,refPaid,companyId,packageId,close);
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////----{АНИМАЦИЯ}----//////////////////////////////////////////////

    public  void getAnimation(ImageView aceptImageId,float time){
        RotateTransition rt = new RotateTransition(Duration.seconds(time),aceptImageId);
        rt.setByAngle(360);
        rt.setCycleCount(1);
        rt.setAutoReverse(false);
        rt.play();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
}
