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
    private Button DeletePaymentButton;

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
    private Button clearButton;






    @FXML
    void initialize() {
        //ПОЛЕ ДЛЯ ID
        TranIdArea.setDisable(true);

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
        });
        RadioReg01.setOnAction(event1 -> {
            regName = "Reg01";
            TranIdArea.setDisable(false);
        });
        RadioReg02.setOnAction(event1 -> {
            regName = "Reg02";
            TranIdArea.setDisable(false);
        });
        RadioReg03.setOnAction(event1 -> {
            regName = "Reg03";
            TranIdArea.setDisable(false);
        });
        RadioReg04.setOnAction(event1 -> {
            regName = "Reg04";
            TranIdArea.setDisable(false);
        });
        RadioReg05.setOnAction(event1 -> {
            regName = "Reg05";
            TranIdArea.setDisable(false);
        });

        //ЗАПУСК УДАЛЕНИЯ
        DeletePaymentButton.setOnAction(event1 -> {
            String tranID = TranIdArea.getText();
            deletPayment(tranID, regName);
        });

        //ОТЧИЩЕНИЕ ПОЛЕЙ
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
            infoLabel.setText("ПЛАТЁЖ УДАЛЁН " + SumPay.get(0));

            //ЗАКРЫТИЕ СОЕДИНЕНИЙ
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
