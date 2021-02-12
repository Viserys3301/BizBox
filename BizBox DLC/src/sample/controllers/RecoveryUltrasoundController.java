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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RecoveryUltrasoundController {


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


    private ObservableList<Services> servicesData = FXCollections.observableArrayList();

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
    private Label infoLabel;

    @FXML
    private Label InfoQery;

    @FXML
    private TextField TranIdArea;

    @FXML
    private Button RecoveryUltrasoundButton;

    @FXML
    private TableView<Services> UltrasoundTable;

    @FXML
    private TableColumn<Services, String> UltrasoundNameId;

    @FXML
    private TableColumn<Services, String> UltrasoundId;

    @FXML
    private Button FindServicesButton;


    @FXML
    void initialize() {

        RecoveryUltrasoundButton.setOnAction(event -> {
            String servicesId= UltrasoundTable.getSelectionModel().getSelectedItem().getId();
            recoveryUltrasound(servicesId);
        });
    }

    private void recoveryUltrasound(String servicesId){

        String SQL  = "UPDATE psExamResultMstr SET withresultflag = 0 WHERE PK_psExamResultMstr ="+servicesId;


        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            infoLabel.setText("ГОТОВО");
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    private void findServices(String servicesName){
        try {
            Statement stmt = con.createStatement();
            String SQL  = "SELECT dbo.udf_GetItemDescription(FK_iwItems) as servicesName, PK_psExamResultMstr FROM psExamResultMstr WHERE FK_TRXNO =" + servicesName;
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                initData(new Services(executeQuery.getString("servicesName"),executeQuery.getString("PK_psExamResultMstr")));
            }

            stmt.close();
            //  con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initData(Services services) {
        servicesData.add(services);
    }

}



