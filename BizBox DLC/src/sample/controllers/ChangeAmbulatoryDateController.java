package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.LogsClass;

public class ChangeAmbulatoryDateController extends LogsClass {

    //ID РЕГИСТРАТОРА
    private String regName;

    String data = "'Изменение даты амбулатории'";

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


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Button clearButton;

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
    private Button ChangeAmbulatoryDateButton;

    @FXML
    private TextField DateDayId;

    @FXML
    private TextField DateMonthId;

    @FXML
    private TextField DateYerId;

    @FXML
    void initialize() {

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////-----ПЕРЕКЛЮЧЕНИЕ ОКОН-----//////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        QeryMenuZeroingAmbulatoryId.setOnAction(event -> {
            clearButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/ZeroingAmbulatory.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        QeryMenuChangePaymentId.setOnAction(event -> {
            clearButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/ChangePayment.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        QeryMenuChangeDoctorId.setOnAction(event -> {
            clearButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/ChangeDoctor.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        QeryMenuChangeAmbulatoryDateId.setOnAction(event -> {
            clearButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/ChangeAmbulatoryDate.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        QeryMenuChangeBirthdateId.setOnAction(event -> {
            clearButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/ChangeBirthdate.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        QeryMenuEnabledUltrasoundId.setOnAction(event -> {
            clearButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/EnabledUltrasound.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        QeryMenuRecoveryUltrasoundId.setOnAction(event -> {
            clearButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/RecoveryUltrasound.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //ПОЛЕ ДЛЯ ID
        TranIdArea.setDisable(true);
        ChangeAmbulatoryDateButton.setDisable(true);
        DateDayId.setDisable(true);
        DateMonthId.setDisable(true);
        DateYerId.setDisable(true);

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
            Onvisible();
        });
        RadioReg01.setOnAction(event1 -> {
            regName = "Reg01";
            Onvisible();
        });
        RadioReg02.setOnAction(event1 -> {
            regName = "Reg02";
            Onvisible();
        });
        RadioReg03.setOnAction(event1 -> {
            regName = "Reg03";
            Onvisible();
        });
        RadioReg04.setOnAction(event1 -> {
            regName = "Reg04";
            Onvisible();
        });
        RadioReg05.setOnAction(event1 -> {
            regName = "Reg05";
            Onvisible();
        });


        clearButton.setOnAction(event -> {
            TranIdArea.setText("");
            infoLabel.setText("");
            RadioReg00.setSelected(false);
            RadioReg01.setSelected(false);
            RadioReg02.setSelected(false);
            RadioReg03.setSelected(false);
            RadioReg04.setSelected(false);
            RadioReg05.setSelected(false);
        });

    }

    private void changeAmbulatoryDate(String tranId,String newDate)   {

        //СОЗДАНИЕ СТЕЙТМЕНТА
        Statement stmt = null;
        try {
            stmt = con.createStatement();

            String SQL = "UPDATE psPatitem SET rendate =" + newDate + " WHERE FK_psPatRegisters = " + tranId;
            String SQL_2 = "UPDATE psPatLedgers SET docdate =" + newDate + " WHERE FK_psPatRegisters = " + tranId;
            String SQL_3 = "UPDATE psPatinv SET rendate =" + newDate + " WHERE FK_psPatRegisters = " + tranId;
            String SQL_4 = "UPDATE faCRMstr SET ordate =" + newDate + ", postdate =" + newDate + " WHERE FK_psPatRegisters = " + tranId;
            String SQL_5 = "UPDATE psPatRegisters SET registrydate =" + newDate + " WHERE PK_psPatRegisters = " + tranId;


            //УДАЛЕНИЕ ДОЧЕРНИХ ПЛАТЕЖЕЙ
            stmt.executeUpdate(SQL);
            stmt.executeUpdate(SQL_2);
            stmt.executeUpdate(SQL_3);
            stmt.executeUpdate(SQL_4);
            stmt.executeUpdate(SQL_5);
            changeAmbulatoryDateLogs(tranId,regName,data,newDate,stmt);
            infoLabel.setText("ГОТОВО");

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    private void Onvisible(){
        TranIdArea.setDisable(false);
        ChangeAmbulatoryDateButton.setDisable(false);
        DateDayId.setDisable(false);
        DateMonthId.setDisable(false);
        DateYerId.setDisable(false);
    }
}
