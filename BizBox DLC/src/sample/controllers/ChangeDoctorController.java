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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.LogsClass;

import javax.swing.*;
import javax.xml.soap.Text;


public class ChangeDoctorController extends LogsClass   {


    //ID РЕГИСТРАТОРА
    private String regName;
    private String data="'Изменение врача'";

    private static ObservableList<Doctors> usersData = FXCollections.observableArrayList();

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
    private Button changeDoctorButton;

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
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////






        TranIdArea.setDisable(true);
        FindDocTextFild.setDisable(true);
        changeDoctorButton.setDisable(true);
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

        FindDocButton.setOnAction(event -> {
            for (int i = 0; i <DocTables.getItems().size() ; i++) {
                usersData.clear();
            }
            //СТРОКА ПОИСКА
            String DoctorName = FindDocTextFild.getText();
            SqlExecutor sqlExecutor = new SqlExecutor();
            try {
                sqlExecutor.findDoctor(DoctorName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DocTablesCollumID.setCellValueFactory(new PropertyValueFactory<Doctors, String>("Name"));
            DocTablesCollumName.setCellValueFactory(new PropertyValueFactory<Doctors, String>("ID"));
            DocTables.setItems(usersData);
        });

        changeDoctorButton.setOnAction(event -> {
            String tranID = TranIdArea.getText();
            String doctorID= DocTables.getSelectionModel().getSelectedItem().getID();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.changeDoctroe(tranID,doctorID,regName,data);
            aceptImageId.setVisible(true);
            sqlExecutor.getAnimation(aceptImageId,1);
        });
    }
    private void onButton(String regName){
        selectRegistrations.setText(regName);
        this.regName = regName;
        TranIdArea.setDisable(false);
        FindDocTextFild.setDisable(false);
        changeDoctorButton.setDisable(false);

    }

    public static void initData(Doctors doctors) {
        usersData.add(doctors);
    }
    private void changeFrames(int x){
        Image imageIcon = new Image("sample/res/fav.png");
        ChangeFrame CF = new ChangeFrame();
        changeDoctorButton.getScene().getWindow().hide();
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
