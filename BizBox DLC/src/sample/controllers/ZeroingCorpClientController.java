package sample.controllers;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;


public class ZeroingCorpClientController {
    //ИНФОРМАЦИЯ ПО ДЕЙСТВИЮ
    private String pay = "'Удаление платежа'";

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


    private String regName;

    @FXML
    private MenuBar mainMenuBar;

    @FXML
    private Menu ChangeMenuButton;

    @FXML
    private MenuItem ChangeBithDateButton;

    @FXML
    private Menu AddMenuButton;

    @FXML
    private Menu OptionsMenuButton;

    @FXML
    private TextField TranIdArea;

    @FXML
    private Button ZeroingClientButton;

    @FXML
    private Label InfoQery;

    @FXML
    private MenuButton selectRegistrations;

    @FXML
    private MenuItem selectReg00;

    @FXML
    private MenuItem selectReg01;

    @FXML
    private MenuItem selectReg02;

    @FXML
    private MenuItem selectReg03;

    @FXML
    private MenuItem selectReg04;

    @FXML
    private MenuItem selectReg05;

    @FXML
    private MenuItem selectAdmin;

    @FXML
    private ImageView aceptImageId;

    @FXML
    void initialize() {

        TranIdArea.setDisable(true);
        ZeroingClientButton.setDisable(true);

        //ВЫБОР РЕГИСТРАТОРОВ
        selectReg00.setOnAction(event1 -> {
            regName = "Reg00";
            onButton();

        });
        selectReg01.setOnAction(event1 -> {
            regName = "Reg01";
            onButton();

        });
        selectReg02.setOnAction(event1 -> {
            regName = "Reg02";
            onButton();

        });
        selectReg03.setOnAction(event1 -> {
            regName = "Reg03";
            onButton();

        });
        selectReg04.setOnAction(event1 -> {
            regName = "Reg04";
            onButton();

        });
        selectReg05.setOnAction(event1 -> {
            regName = "Reg05";
            onButton();

        });

        selectAdmin.setOnAction(event1 -> {
            regName = "Admin";
            onButton();

        });

        ZeroingClientButton.setOnAction(event -> {
            String tranId = TranIdArea.getText();
            zeroingClient(tranId,regName);
        });

    }

    private void onButton(){
        TranIdArea.setDisable(false);
        ZeroingClientButton.setDisable(false);
    }

    private void zeroingClient(String tranId,String regName){
        String SQL = "exec Update_TRXNO " +tranId +  ", 'COM'";
        try {
            //СОЗДАНИЕ СТЕЙТМЕНТА
            Statement stmt = con.createStatement();

            stmt.executeUpdate(SQL);

            //СООБЩЕНИЕ О ВЫПОЛНЕНИИ
            aceptImageId.setVisible(true);

            //ЗАКРЫТИЕ СОЕДИНЕНИЙ
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
