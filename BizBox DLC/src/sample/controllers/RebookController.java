package sample.controllers;

import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;

public class RebookController   {

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
    private TextField patNameId;

    @FXML
    private Button findPatientButton;

    @FXML
    private TableView<Rebooks> RebookTabel;

    @FXML
    private TableColumn<Rebooks, String> PatNameColumnId;

    @FXML
    private MenuItem computerNameColumnId;

    @FXML
    private TableColumn<Rebooks, String> DateCreatePatientColumnId;

    @FXML
    private TableColumn<Rebooks, String> DateRebookColumnId;

    @FXML
    private TableColumn<Rebooks, String> NewDatePatientColumnId;

    private static ObservableList<Rebooks> rebookData = FXCollections.observableArrayList();




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

        findPatientButton.setOnAction(event -> {


            for (int i = 0; i <RebookTabel.getItems().size() ; i++) {
                rebookData.clear();
            }
            //СТРОКА ПОИСКА
            String patientName = patNameId.getText();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.findPatients(patientName);

            PatNameColumnId.setCellValueFactory(new PropertyValueFactory<Rebooks, String>("PatNameColumnId"));
            DateCreatePatientColumnId.setCellValueFactory(new PropertyValueFactory<Rebooks, String>("DateCreatePatientColumnId"));
            DateRebookColumnId.setCellValueFactory(new PropertyValueFactory<Rebooks, String>("DateRebookColumnId"));
            NewDatePatientColumnId.setCellValueFactory(new PropertyValueFactory<Rebooks, String>("NewDatePatientColumnId"));

            RebookTabel.setItems(rebookData);
        });

        computerNameColumnId.setOnAction(event -> {
            String userId = RebookTabel.getSelectionModel().getSelectedItem().getComputerNameColumnId();
            JOptionPane.showMessageDialog(null,"Имя компьютера: " + userId);
        });
    }


    public static void initData(Rebooks rebooks) {
        rebookData.add(rebooks);
    }
    private void changeFrames(int x){
        Image imageIcon = new Image("sample/res/fav.png");
        ChangeFrame CF = new ChangeFrame();
        findPatientButton.getScene().getWindow().hide();
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
