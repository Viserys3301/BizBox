package sample.controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.LogsClass;

import javax.xml.soap.Text;

public class ZeroingAmbulatoryController extends LogsClass   {

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

    String regName;
    String data = "'Обнуление платежа'";

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
    private Button ZeroingClientButton;

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
    private AnchorPane ChangeDoctorPane;

    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
        AnchorPane pane =  FXMLLoader.load(getClass().getResource("fxmlFiles/ZeroingAmbulatory.fxml"));
        ChangeDoctorPane.getChildren().setAll(pane);
    }


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

        ZeroingClientButton.setOnAction(event -> {
            String tranID = TranIdArea.getText();
            zeroingClient(tranID);
        });
    }


    private void zeroingClient(String tranID){
        String SQL = "UPDATE psPatitem SET prevprice = renprice,renprice = 0 WHERE FK_TRXNO =" + tranID;
        String SQL_2 = "UPDATE psPatinv SET renamount = 0,amount = 0,discount = 0,netamount = 0 WHERE PK_TRXNO =" + tranID;
        String SQL_3 = "UPDATE psPatLedgers SET debit = 0,discount = 0 WHERE FK_TRXNO =" + tranID;

        try {
            Statement stmt = con.createStatement();
            zeroingClientsLogs(tranID,regName,data,stmt);
            stmt.executeUpdate(SQL);
            stmt.executeUpdate(SQL_2);
            stmt.executeUpdate(SQL_3);
            infoLabel.setText("ПЛАТЁЖ ОБНУЛЁН ");
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
