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
import javafx.scene.image.ImageView;
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
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////-----ПЕРЕКЛЮЧЕНИЕ ОКОН-----//////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        QeryMenuZeroingAmbulatoryId.setOnAction(event -> {
            ZeroingClientButton.getScene().getWindow().hide();
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
                    ZeroingClientButton.getScene().getWindow().hide();
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
            ZeroingClientButton.getScene().getWindow().hide();
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
                    ZeroingClientButton.getScene().getWindow().hide();
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
            ZeroingClientButton.getScene().getWindow().hide();
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
                    ZeroingClientButton.getScene().getWindow().hide();
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
            ZeroingClientButton.getScene().getWindow().hide();
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
            ZeroingClientButton.getScene().getWindow().hide();
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
            ZeroingClientButton.getScene().getWindow().hide();
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
            ZeroingClientButton.getScene().getWindow().hide();
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
            ZeroingClientButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/DeletPayment.fxml"));
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

        OptionsMenuLogsId.setOnAction(event -> {
            ZeroingClientButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/CheckLogs.fxml"));
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

        OptionsMenuRebookId.setOnAction(event -> {
            ZeroingClientButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/Rebook.fxml"));
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

        DeleteMenuRecordReturnId.setOnAction(event -> {
            ZeroingClientButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/RecordReturn.fxml"));
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

        DeleteMenuDeletAmbulatoryId.setOnAction(event -> {
            ZeroingClientButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/DeletAmbulatory.fxml"));
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
        ZeroingClientButton.setDisable(true);

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

        ZeroingClientButton.setOnAction(event -> {
            String tranID = TranIdArea.getText();
            zeroingClient(tranID);
        });
    }

    private void onButton(String regname){
        this.regName = regname;
        selectRegistrations.setText(regname);
        TranIdArea.setDisable(false);
        ZeroingClientButton.setDisable(false);
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
            aceptImageId.setVisible(true);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
