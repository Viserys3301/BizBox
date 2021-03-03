package sample.controllers;

import java.io.*;
import java.net.URL;
import java.sql.*;

import java.util.ResourceBundle;


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
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class UsersController {

    private static ObservableList<Users> usersData = FXCollections.observableArrayList();

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
    private MenuItem CorpMenuAddCorpId;

    @FXML
    private MenuItem CorpMenuZeroingCorpId;

    @FXML
    private MenuItem DeleteMenuDeletPaymentId;

    @FXML
    private MenuItem DeleteMenuDeletDiscountId;

    @FXML
    private MenuItem DeleteMenuDeletAmbulatoryId;

    @FXML
    private MenuItem DeleteMenuRecordReturnId;

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
            changeFrames(1);
        });

        QeryMenuChangePaymentId.setOnAction(event -> {
            changeFrames(2);
        });

        QeryMenuChangeDoctorId.setOnAction(event -> {
            changeFrames(3);
        });
        QeryMenuChangeAmbulatoryDateId.setOnAction(event -> {
            changeFrames(4);
        });
        QeryMenuChangeBirthdateId.setOnAction(event -> {
            changeFrames(5);
        });
        QeryMenuEnabledUltrasoundId.setOnAction(event -> {
            changeFrames(6);
        });
        QeryMenuRecoveryUltrasoundId.setOnAction(event -> {
            changeFrames(7);
        });
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        CorpMenuAddCorpId.setOnAction(event -> {
            changeFrames(8);
        });

        CorpMenuZeroingCorpId.setOnAction(event -> {
            changeFrames(9);
        });
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        DeleteMenuDeletAmbulatoryId.setOnAction(event -> {
            changeFrames(10);
        });


        DeleteMenuDeletDiscountId.setOnAction(event -> {
            changeFrames(11);
        });

        DeleteMenuDeletPaymentId.setOnAction(event -> {
            changeFrames(12);
        });

        DeleteMenuRecordReturnId.setOnAction(event -> {
            changeFrames(13);
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        OptionsMenuAccountId.setOnAction(event -> {
            changeFrames(14);
        });

        OptionsMenuLogsId.setOnAction(event -> {
            changeFrames(15);
        });

        OptionsMenuUsersId.setOnAction(event -> {
            changeFrames(16);
        });

        OptionsMenuRebookId.setOnAction(event -> {
            changeFrames(17);
        });

        OptionsMenuAboutId.setOnAction(event -> {
            changeFrames(18);
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        unLockAISbutton.setOnAction(event -> {
            String userId= userTable.getSelectionModel().getSelectedItem().getPK_appsysUsers();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.unLockAccount("lockAIS",userId);
        });

        unLockEMR.setOnAction(event -> {
            String userId= userTable.getSelectionModel().getSelectedItem().getPK_appsysUsers();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.unLockAccount("lockClinic",userId);
        });
        unLockAccount.setOnAction(event -> {
            String userId= userTable.getSelectionModel().getSelectedItem().getPK_appsysUsers();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.unLockAccount("lockaccount",userId);
        });

        unLockHIS.setOnAction(event -> {
            String userId= userTable.getSelectionModel().getSelectedItem().getPK_appsysUsers();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.unLockAccount("lockHIS",userId);
        });



        findUserButton.setOnAction(event -> {
            for (int i = 0; i <userTable.getItems().size() ; i++) {
                usersData.clear();
            }
            //СТРОКА ПОИСКА
            String userName = userIdArea.getText();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.findUsers(userName);

            userNameColumnId.setCellValueFactory(new PropertyValueFactory<Users, String>("userName"));
            lockAIS.setCellValueFactory(new PropertyValueFactory<Users, String>("lockAIS"));
            lockClinic.setCellValueFactory(new PropertyValueFactory<Users, String>("lockClinic"));
            lockHIS.setCellValueFactory(new PropertyValueFactory<Users, String>("lockHIS"));
            lockClinic.setCellValueFactory(new PropertyValueFactory<Users, String>("lockaccount"));
            userTable.setItems(usersData);
        });
    }

 public static void initData(Users users) {
        usersData.add(users);
    }
    private void changeFrames(int x){
        Image imageIcon = new Image("sample/res/fav.png");
        ChangeFrame CF = new ChangeFrame();
        findUserButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(CF.changeFrame(x)));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.getIcons().add(imageIcon);
        stage.show();
    }
}
