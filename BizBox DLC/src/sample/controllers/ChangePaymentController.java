package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;
import sample.LogsClass;



public class ChangePaymentController extends LogsClass {
    private String regName = "";
    private boolean isCard;
    //ID РЕГИСТРАТОРА

    private String data="'Изменение платежа'";




    private static ObservableList<Payments> paymentData = FXCollections.observableArrayList();


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
    private TextField TranIdArea;

    @FXML
    private Button changePaymentButton;

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
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.findPayment(patName);

            PatPaymentTableName.setCellValueFactory(new PropertyValueFactory<Payments, String>("Name"));
            PatPaymentTableCash.setCellValueFactory(new PropertyValueFactory<Payments, String>("cash"));
            PatPaymentTableCard.setCellValueFactory(new PropertyValueFactory<Payments, String>("card"));
            PatPaymentTable.setItems(paymentData);


        });
        ChangeToCash.setOnAction(event -> {
            isCard = false;
        });
        ChangeToCard.setOnAction(event -> {
            isCard = true;
        });



        changePaymentButton.setOnAction(event -> {
            String paymentId= PatPaymentTable.getSelectionModel().getSelectedItem().getId();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.changePayment(paymentId,isCard,regName,data);
            aceptImageId.setVisible(true);
            sqlExecutor.getAnimation(aceptImageId,1);
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

    public static void initData(Payments payments) {
        paymentData.add(payments);
    }
    private void changeFrames(int x){
        Image imageIcon = new Image("sample/res/fav.png");
        ChangeFrame CF = new ChangeFrame();
        changePaymentButton.getScene().getWindow().hide();
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
