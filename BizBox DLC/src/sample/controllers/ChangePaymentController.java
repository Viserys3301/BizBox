package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class ChangePaymentController {
    private String regName = "";
    private boolean isCard;
    //ID РЕГИСТРАТОРА

    private String DockChangeVar="'Изменение платежа'";

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



    private ObservableList<Payments> paymentData = FXCollections.observableArrayList();

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
    private Button changePaymentButton;

    @FXML
    private Label InfoQery;

    @FXML
    private RadioButton ChangeToCash;

    @FXML
    private RadioButton ChangeToCard;

    @FXML
    private Button findPatientPayment;

    @FXML
    private TableView<Payments> PatPaymentTable;

    @FXML
    private TableColumn<Payments, String> PatPaymentTableName;

    @FXML
    private TableColumn<Payments, String> PatPaymentTableCash;

    @FXML
    private TableColumn<Payments, String> PatPaymentTableCard;

    @FXML
    private ImageView aceptImageId;

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
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        ChangeToCard.setToggleGroup(group);
        ChangeToCash.setToggleGroup(group);

        changePaymentButton.setDisable(true);
        findPatientPayment.setDisable(true);
        TranIdArea.setDisable(true);
        ChangeToCash.setDisable(true);
        ChangeToCard.setDisable(true);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////-----ПЕРЕКЛЮЧЕНИЕ ОКОН-----//////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        QeryMenuZeroingAmbulatoryId.setOnAction(event -> {
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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
            findPatientPayment.getScene().getWindow().hide();
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


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        selectReg00.setOnAction(event -> {
            onButton("Reg00");
        });
        selectReg01.setOnAction(event -> {
            onButton("Reg01");
        });
        selectReg02.setOnAction(event -> {
            onButton("Reg02");
        });
        selectReg03.setOnAction(event -> {
            onButton("Reg03");
        });
        selectReg04.setOnAction(event -> {
            onButton("Reg04");
        });
        selectReg05.setOnAction(event -> {
            onButton("Reg05");
        });
        selectAdmin.setOnAction(event -> {
            onButton("Admin");
        });

        findPatientPayment.setOnAction(event -> {
            for (int i = 0; i <PatPaymentTable.getItems().size() ; i++) {
                paymentData.clear();
            }
            //СТРОКА ПОИСКА
            String patName = TranIdArea.getText();

            findPayment(patName);

            PatPaymentTableName.setCellValueFactory(new PropertyValueFactory<Payments, String>("Name"));
            PatPaymentTableCash.setCellValueFactory(new PropertyValueFactory<Payments, String>("cash"));
            PatPaymentTableCard.setCellValueFactory(new PropertyValueFactory<Payments, String>("card"));
            PatPaymentTable.setItems(paymentData);


        });
        ChangeToCash.setOnAction(event -> {
            isCard = false;
            System.out.println(isCard);
        });
        ChangeToCard.setOnAction(event -> {
            isCard = true;
            System.out.println(isCard);
        });



        changePaymentButton.setOnAction(event -> {
            String paymentId= PatPaymentTable.getSelectionModel().getSelectedItem().getId();
            changePayment(paymentId,isCard);
        });
    }
    private void onButton(String regName){
        selectRegistrations.setText(regName);
        this.regName = regName;
        changePaymentButton.setDisable(false);
        findPatientPayment.setDisable(false);
        TranIdArea.setDisable(false);
        ChangeToCash.setDisable(false);
        ChangeToCard.setDisable(false);

    }

    private void initData(Payments payments) {
        paymentData.add(payments);
    }

    private void findPayment(String patName){
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT payername, cashamount, cardamount,PK_TRXNO FROM faCRMstr WHERE payername like" + "'" + patName + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                initData(new Payments(executeQuery.getString("payername"),
                                      executeQuery.getString("cashamount"),
                                      executeQuery.getString("cardamount"),
                                      executeQuery.getString("PK_TRXNO")));
            }

            stmt.close();
            //  con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void changePayment(String tranId,boolean isCard){
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
           // changeDoctorLogs(regName,DockChangeVar,tranID,doctorID,stmt);

            aceptImageId.setVisible(true);
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
