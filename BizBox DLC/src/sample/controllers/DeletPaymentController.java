package sample.controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.LogsClass;

import javax.xml.soap.Text;


public class DeletPaymentController  extends LogsClass {
    //ДАТА И ВРЕМЯ
    private java.util.Date date = new Date();
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat(" yyyy.MM.dd ' ' hh:mm:ss a zzz");

    //ID РЕГИСТРАТОРА
    private String regName;

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
    private Button DeletePaymentButton;

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

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////-----ПЕРЕКЛЮЧЕНИЕ ОКОН-----//////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        QeryMenuZeroingAmbulatoryId.setOnAction(event -> {
            DeletePaymentButton.getScene().getWindow().hide();
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
            DeletePaymentButton.getScene().getWindow().hide();
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
            DeletePaymentButton.getScene().getWindow().hide();
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
            DeletePaymentButton.getScene().getWindow().hide();
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
            DeletePaymentButton.getScene().getWindow().hide();
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
            DeletePaymentButton.getScene().getWindow().hide();
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
            DeletePaymentButton.getScene().getWindow().hide();
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

        CorpMenuAddCorpId.setOnAction(event -> {
            DeletePaymentButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/AddCorpClient.fxml"));
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

        CorpMenuZeroingCorpId.setOnAction(event -> {
            DeletePaymentButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/ZeroingCorpClient.fxml"));
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

        DeleteMenuDeletDiscountId.setOnAction(event -> {
            DeletePaymentButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/DeleteDiscount.fxml"));
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

        DeleteMenuDeletPaymentId.setOnAction(event -> {
            DeletePaymentButton.getScene().getWindow().hide();
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        //ПОЛЕ ДЛЯ ID
        TranIdArea.setDisable(true);
        DeletePaymentButton.setDisable(true);
        //РЕГИСТРАТОРЫ


        //ВЫБОР РЕГИСТРАТОРОВ
        selectReg00.setOnAction(event1 -> {
            onButton("Reg00");
        });
        selectReg01.setOnAction(event1 -> {
            onButton("Reg01");
        });
        selectReg02.setOnAction(event1 -> {
            onButton("Reg02");
        });
        selectReg03.setOnAction(event1 -> {
            onButton("Reg03");
        });
        selectReg04.setOnAction(event1 -> {
            onButton("Reg04");
        });
        selectReg05.setOnAction(event1 -> {
            onButton("Reg05");
        });
        selectAdmin.setOnAction(event1 -> {
            onButton("Admin");
        });

        //ЗАПУСК УДАЛЕНИЯ
        DeletePaymentButton.setOnAction(event1 -> {
            String tranID = TranIdArea.getText();
            deletPayment(tranID, regName);
        });

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //НОВЫЙ ФРЕЙМ ОБНУЛЕНИЕ АМБУЛАТОРИИ
        QeryMenuZeroingAmbulatoryId.setOnAction(event -> {
            MainMenuBar.getScene().getWindow().hide();
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
            stage.showAndWait();
        });


    }

    private void onButton(String regName){
        this.regName = regName;
        selectRegistrations.setText(regName);
        DeletePaymentButton.setDisable(false);
        TranIdArea.setDisable(false);
    }

    private void deletPayment(String tranID, String RegID) {
        try {
            //ЛИСТ СО ВСЕМИ ПЛАТЕЖАМИ
            ArrayList<String> idPay = new ArrayList<>();
            ArrayList<String> SumPay = new ArrayList<>();

            //СОЗДАНИЕ СТЕЙТМЕНТА
            Statement stmt = con.createStatement();

            //УДАЛЕНИЕ ДОЧЕРНИХ ПЛАТЕЖЕЙ
            stmt.executeUpdate("DELETE faCRMstrItems WHERE FK_psPatRegisters =" + tranID);
            stmt.executeUpdate("DELETE faCRMstr WHERE FK_psPatRegisters =" + tranID);

            //ПОИСК ГЛАВНОГО ПЛАТЕЖА
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM psPatLedgers WHERE FK_psPatRegisters=" + tranID + "and billtrancode = 'PAYMENT'");

            //ЗАПИСЬ ID ПЛАТЕЖЕЙ В СПИСОК
            while (executeQuery.next()) {
                idPay.add(executeQuery.getString("PK_psPatledgers"));
                SumPay.add(executeQuery.getString("oramount"));
            }

            //УДАЛЕНИЕ ID ПЛАТЕЖЕЙ ИЗ ТАБЛИЦЫ
            for (int i = 0; i < idPay.size(); i++) {
                stmt.executeUpdate("DELETE psPatLedgers WHERE PK_psPatledgers =" + idPay.get(i));
            }
            //ОБНОВЛЕНИЕ ДЛЯ ПОВТОРНОГО ПРИЁМА
            stmt.executeUpdate("UPDATE psPatitem SET oramount = 0 WHERE FK_psPatRegisters = " + tranID);

            //ЗАПИСЬ ДАТЫ
            String dateTime = formatForDateNow.format(date);

            //ЛОГИРОВАНИЕ ДЕЙСТВИЙ
            deletPaymentLogs(tranID,regName,pay,stmt,SumPay);

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
