package sample.controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class RebookController {


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

    private ObservableList<Rebooks> rebookData = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        findPatientButton.setOnAction(event -> {


            for (int i = 0; i <RebookTabel.getItems().size() ; i++) {
                rebookData.clear();
            }
            //СТРОКА ПОИСКА
            String patientName = patNameId.getText();

            findPatients(patientName);

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


    private void initData(Rebooks rebooks) {
        rebookData.add(rebooks);
    }

    private void findPatients(String patientName){
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT dbo.udf_GetFullName(FK_psDatacenter) as PatNameColumnId ,target_date, source_date, workstation,[date] as changeDate FROM apptTrans_log WHERE dbo.udf_GetFullName(FK_psDatacenter) Like '%" + patientName + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);
            while (executeQuery.next()) {
                initData(new Rebooks(executeQuery.getString("PatNameColumnId"),
                        executeQuery.getString("target_date"),
                        executeQuery.getString("source_date"),
                        executeQuery.getString("changeDate"),
                        executeQuery.getString("workstation")));
            }
            stmt.close();
            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DeletPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
