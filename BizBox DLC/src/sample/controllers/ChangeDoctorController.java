package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.LogsClass;

import javax.swing.*;
import javax.xml.soap.Text;


public class ChangeDoctorController extends LogsClass {



    //ДАТА И ВРЕМЯ
    private java.util.Date date = new Date();
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat(" yyyy.MM.dd ' ' hh:mm:ss a zzz");

    //ID РЕГИСТРАТОРА
    private String regName;
    private String DockChangeVar="'Изменение врача'";

    //СОЕДИНЕНИЕ С БАЗОЙ
    private String instanceName = "10.0.9.4\\hcdbsrv";
    private String databaseName = "HCDB";
    private String userName = "sa";
    private String pass = "Ba#sE5Ke";
    private String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
    private String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
    Connection con;

    {
        try {
            con = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






    private ObservableList<Doctors> usersData = FXCollections.observableArrayList();

    @FXML
    private MenuBar MainMenuBar;

    @FXML
    private Menu QeryMenuID;

    @FXML
    private MenuItem QeryMenuZeroingAmbulatoryId;

    @FXML
    private MenuItem QeryMenuChangePaymentId;

    @FXML
    private MenuItem QeryMenuChangeDoctorId;

    @FXML
    private MenuItem QeryMenuChangeAmbulatoryDateId;

    @FXML
    private MenuItem QeryMenuChangeBirthdateId;

    @FXML
    private MenuItem QeryMenuEnabledUltrasoundId;

    @FXML
    private MenuItem QeryMenuRecoveryUltrasoundId;

    @FXML
    private Menu CorpMenuId;

    @FXML
    private MenuItem CorpMenuAddCorpId;

    @FXML
    private MenuItem CorpMenuZeroingCorpId;

    @FXML
    private Menu DeleteMenuId;

    @FXML
    private MenuItem DeleteMenuDeletPaymentId;

    @FXML
    private MenuItem DeleteMenuDeletDiscountId;

    @FXML
    private MenuItem DeleteMenuDeletAmbulatoryId;

    @FXML
    private MenuItem DeleteMenuRecordReturnId;

    @FXML
    private Menu OptionsMenuId;

    @FXML
    private MenuItem OptionsMenuAccountId;

    @FXML
    private MenuItem OptionsMenuLogsId;

    @FXML
    private MenuItem OptionsMenuUsersId;

    @FXML
    private MenuItem OptionsMenuRebookId;

    @FXML
    private MenuItem OptionsMenuAboutId;

    @FXML
    private TextField TranIdArea;

    @FXML
    private Text titleArea;

    @FXML
    private RadioButton RadioReg00;

    @FXML
    private RadioButton RadioReg01;

    @FXML
    private RadioButton RadioReg02;

    @FXML
    private RadioButton RadioReg03;

    @FXML
    private RadioButton RadioReg04;

    @FXML
    private RadioButton RadioReg05;

    @FXML
    private Label infoLabel;

    @FXML
    private Label InfoQery;

    @FXML
    private Button changeDoctorButton;

    @FXML
    private Text titleArea1;

    @FXML
    private TextField FindDocTextFild;

    @FXML
    private Button FindDocButton;

    @FXML
    private TableView<Doctors> DocTables;

    @FXML
    private TableColumn<Doctors, String> DocTablesCollumID;

    @FXML
    private TableColumn<Doctors, String> DocTablesCollumName;



    @FXML
    void initialize() {
        TranIdArea.setDisable(true);
        FindDocTextFild.setDisable(true);
        //РЕГИСТРАТОРЫ
        ToggleGroup group = new ToggleGroup();
        RadioReg00.setToggleGroup(group);
        RadioReg01.setToggleGroup(group);
        RadioReg02.setToggleGroup(group);
        RadioReg03.setToggleGroup(group);
        RadioReg04.setToggleGroup(group);
        RadioReg05.setToggleGroup(group);


        //ВЫБОР РЕГИСТРАТОРОВ
        RadioReg00.setOnAction(event1 -> {
            regName = "Reg00";
            TranIdArea.setDisable(false);
            FindDocTextFild.setDisable(false);
        });
        RadioReg01.setOnAction(event1 -> {
            regName = "Reg01";
            TranIdArea.setDisable(false);
            FindDocTextFild.setDisable(false);
        });
        RadioReg02.setOnAction(event1 -> {
            regName = "Reg02";
            TranIdArea.setDisable(false);
            FindDocTextFild.setDisable(false);
        });
        RadioReg03.setOnAction(event1 -> {
            regName = "Reg03";
            TranIdArea.setDisable(false);
            FindDocTextFild.setDisable(false);
        });
        RadioReg04.setOnAction(event1 -> {
            regName = "Reg04";
            TranIdArea.setDisable(false);
            FindDocTextFild.setDisable(false);
        });
        RadioReg05.setOnAction(event1 -> {
            regName = "Reg05";
            TranIdArea.setDisable(false);
            FindDocTextFild.setDisable(false);
        });


        FindDocButton.setOnAction(event -> {

            for (int i = 0; i <DocTables.getItems().size() ; i++) {
                usersData.clear();
            }
            //СТРОКА ПОИСКА
            String DoctorName = FindDocTextFild.getText();

            findDoctor(DoctorName);

            DocTablesCollumID.setCellValueFactory(new PropertyValueFactory<Doctors, String>("Name"));
            DocTablesCollumName.setCellValueFactory(new PropertyValueFactory<Doctors, String>("ID"));
            DocTables.setItems(usersData);
        });

        changeDoctorButton.setOnAction(event -> {
            String tranID = TranIdArea.getText();
            String doctorID= DocTables.getSelectionModel().getSelectedItem().getID();
            changeDoctroe(tranID,doctorID,regName);
        });




    }

    private void initData(Doctors doctors) {
        usersData.add(doctors);
    }

    private void changeDoctroe(String tranID,String doctorID,String regName)   {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String SQL = "UPDATE psPatitem SET FK_emdDoctorsREQ = " +  doctorID + " where FK_TRXNO =" + tranID;
            stmt.executeUpdate(SQL);
            String dateTime = formatForDateNow.format(date);
            //Логи
            changeDoctorLogs(regName,DockChangeVar,tranID,doctorID,stmt);

            infoLabel.setText("ГОТОВО");
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private void findDoctor(String DoctorName ) {
        try {
            Statement stmt = con.createStatement();
            String SQL = "select dbo.udf_GetFullName(PK_appsysUsers) as DoctorName,PK_appsysUsers,usercode,lockAIS from appsysusers where dbo.udf_GetFullName(PK_appsysUsers) Like '%" + DoctorName + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                initData(new Doctors(executeQuery.getString("PK_appsysUsers"),executeQuery.getString("DoctorName")));
            }




            stmt.close();
          //  con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
