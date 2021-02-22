package sample.controllers;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UsersController {

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
    private ObservableList<Users> usersData = FXCollections.observableArrayList();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private TextField PK_appsysUsersId;

    @FXML
    private TextField usercodeId;

    @FXML
    private TextField userNameId;

    @FXML
    private TextField FK_appsysUserGroupsId;

    @FXML
    private TextField logdateId;

    @FXML
    private TextField EMRid;

    @FXML
    private TextField AISid;

    @FXML
    private TextField HISid;

    @FXML
    private TextField lockaccountId;

    @FXML
    private Button ChangeEMRButton;

    @FXML
    private Button ChangeAISButton;

    @FXML
    private Button ChangeHISButton;

    @FXML
    private Button ChangeAccButton;


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    private TextField userIdArea;

    @FXML
    private Button findUserButton;

    @FXML
    private TableView<Users> userTable;

    @FXML
    private TableColumn<Users, String> userNameColumnId;

    @FXML
    private MenuItem changeUserData;

    @FXML
    private TableColumn<Users, String> lockAIS;

    @FXML
    private TableColumn<Users, String> lockClinic;

    @FXML
    private TableColumn<Users, String> lockHIS;

    @FXML
    private TableColumn<Users, String> lockaccount;

    @FXML
    private MenuItem unLockAccount;

    @FXML
    private MenuItem unLockHIS;

    @FXML
    private MenuItem unLockEMR;

    @FXML
    private MenuItem unLockAISbutton;

    @FXML
    void initialize() {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        QeryMenuZeroingAmbulatoryId.setOnAction(event -> {
            findUserButton.getScene().getWindow().hide();
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
            findUserButton.getScene().getWindow().hide();
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
            findUserButton.getScene().getWindow().hide();
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
            findUserButton.getScene().getWindow().hide();
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
            findUserButton.getScene().getWindow().hide();
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
            findUserButton.getScene().getWindow().hide();
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
            findUserButton.getScene().getWindow().hide();
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        CorpMenuAddCorpId.setOnAction(event -> {
            findUserButton.getScene().getWindow().hide();
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
            findUserButton.getScene().getWindow().hide();
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        DeleteMenuDeletAmbulatoryId.setOnAction(event -> {
            findUserButton.getScene().getWindow().hide();
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


        DeleteMenuDeletDiscountId.setOnAction(event -> {
            findUserButton.getScene().getWindow().hide();
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
            findUserButton.getScene().getWindow().hide();
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

        DeleteMenuRecordReturnId.setOnAction(event -> {
            findUserButton.getScene().getWindow().hide();
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
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        OptionsMenuAccountId.setOnAction(event -> {
            findUserButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/Account.fxml"));
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
            findUserButton.getScene().getWindow().hide();
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

        OptionsMenuUsersId.setOnAction(event -> {
            findUserButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/Users.fxml"));
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
            findUserButton.getScene().getWindow().hide();
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

        OptionsMenuAboutId.setOnAction(event -> {
            findUserButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/About.fxml"));
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        unLockAISbutton.setOnAction(event -> {
            String userId= userTable.getSelectionModel().getSelectedItem().getPK_appsysUsers();
            unLockAccount("lockAIS",userId);
        });

        unLockEMR.setOnAction(event -> {
            String userId= userTable.getSelectionModel().getSelectedItem().getPK_appsysUsers();
            unLockAccount("lockClinic",userId);
        });
        unLockAccount.setOnAction(event -> {
            String userId= userTable.getSelectionModel().getSelectedItem().getPK_appsysUsers();
            unLockAccount("lockaccount",userId);
        });

        unLockHIS.setOnAction(event -> {
            String userId= userTable.getSelectionModel().getSelectedItem().getPK_appsysUsers();
            unLockAccount("lockHIS",userId);
        });



        findUserButton.setOnAction(event -> {
            for (int i = 0; i <userTable.getItems().size() ; i++) {
                usersData.clear();
            }
            //СТРОКА ПОИСКА
            String userName = userIdArea.getText();

            findUsers(userName);

            userNameColumnId.setCellValueFactory(new PropertyValueFactory<Users, String>("userName"));
            lockAIS.setCellValueFactory(new PropertyValueFactory<Users, String>("lockAIS"));
            lockClinic.setCellValueFactory(new PropertyValueFactory<Users, String>("lockClinic"));
            lockHIS.setCellValueFactory(new PropertyValueFactory<Users, String>("lockHIS"));
            lockClinic.setCellValueFactory(new PropertyValueFactory<Users, String>("lockaccount"));
            userTable.setItems(usersData);
        });
    }
    private void findUsers(String userName){

        try {
            Statement stmt = con.createStatement();
            String SQL ="SELECT PK_appsysUsers,dbo.udf_GetFullName(PK_appsysUsers) as userName,FK_appsysUserGroups,usercode,logdate," +
                    "systemHIS,systemClinic,systemAIS,lockHIS,lockClinic,lockAIS,lockaccount FROM appsysusers where dbo.udf_GetFullName(PK_appsysUsers) like '%" + userName  + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);
            while (executeQuery.next()) {
                initData(new Users(executeQuery.getString("PK_appsysUsers"),
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
            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void unLockAccount(String columnName,String PKey){
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


    private void initData(Users users) {
        usersData.add(users);
    }
}
