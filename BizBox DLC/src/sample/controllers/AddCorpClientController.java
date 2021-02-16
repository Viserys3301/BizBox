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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AddCorpClientController {
    String companyId;
    boolean showPackage = false;
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





    private ObservableList<Company> companyList = FXCollections.observableArrayList();
    private ObservableList<Packages> packagesList = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane axeptImageId;

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
    private Label InfoQery;

    @FXML
    private TextField patiendId;

    @FXML
    private TextField refPatiendId;

    @FXML
    private Button addCorpButtonId;

    @FXML
    private Button LoadExcelFileButton;

    @FXML
    private TextField findCorpArea;

    @FXML
    private Button findCorpId;

    @FXML
    private TextField patMidleNameId;

    @FXML
    private TextField patFirstNameId;

    @FXML
    private TextField patSecondNameId;

    @FXML
    private TextField DateDayId;

    @FXML
    private TextField DateMonthId;

    @FXML
    private TextField DateYerId;

    @FXML
    private RadioButton PatGenderMaleId;

    @FXML
    private RadioButton PatGenderFemaleId;

    @FXML
    private RadioButton addNewPatId;

    @FXML
    private ImageView acepImageId;

    @FXML
    private TableView<Company> CorpTable;

    @FXML
    private TableColumn<Company, String> CompanyNameId;

    @FXML
    private TableView<Packages> PackageTable;

    @FXML
    private TableColumn<Packages, String> PackageNameId;

    @FXML
    void initialize() {



        patFirstNameId.setDisable(true);
        patSecondNameId.setDisable(true);
        patMidleNameId.setDisable(true);
        DateDayId.setDisable(true);
        DateMonthId.setDisable(true);
        DateYerId.setDisable(true);
        PatGenderFemaleId.setDisable(true);
        PatGenderMaleId.setDisable(true);
        LoadExcelFileButton.setDisable(true);
        addCorpButtonId.setDisable(true);

        addNewPatId.setOnAction(event -> {
            patFirstNameId.setDisable(false);
            patSecondNameId.setDisable(false);
            patMidleNameId.setDisable(false);
            DateDayId.setDisable(false);
            DateMonthId.setDisable(false);
            DateYerId.setDisable(false);
            PatGenderFemaleId.setDisable(false);
            PatGenderMaleId.setDisable(false);

            refPatiendId.setDisable(true);
            refPatiendId.setText(null);
            patiendId.setDisable(true);
            patiendId.setText(null);
        });

        addCorpButtonId.setOnAction(event -> {

        });





        findCorpId.setOnAction(event -> {
            addCorpButtonId.setDisable(false);

            for (int i = 0; i <CorpTable.getItems().size() ; i++) {
                companyList.clear();
            }
            //СТРОКА ПОИСКА
            String companyName = findCorpArea.getText();
            findCompany(companyName);
            CompanyNameId.setCellValueFactory(new PropertyValueFactory<Company, String>("Name"));
            CorpTable.setItems(companyList);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    showPackage = true;
                    while (showPackage){
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        companyId= CorpTable.getSelectionModel().getSelectedItem().getId();
                        findPackages(companyId);
                        PackageNameId.setCellValueFactory(new PropertyValueFactory<Packages, String>("Name"));
                        PackageTable.setItems(packagesList);
                    }
                }
            }).start();
        });
    }
    private void findCompany(String companyName){
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT ID,Name FROM Assistance_clients WHERE Name Like '%" + companyName + "%'";
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                initData(new Company(executeQuery.getString("ID"),executeQuery.getString("Name")));
            }
            stmt.close();
            //  con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddCorpClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void findPackages(String companyId){
        try {
            Statement stmt = con.createStatement();
            String SQL = "SELECT ap.ID, ac.Name, ap.Assistance_clients_ID, ap.Name as packageName FROM Assistance_packages ap join Assistance_clients ac on ac.ID = ap.Assistance_clients_ID WHERE ap.Assistance_clients_ID =" + companyId;
            ResultSet executeQuery = stmt.executeQuery(SQL);


            while (executeQuery.next()) {
                initData2(new Packages(executeQuery.getString("ID"),executeQuery.getString("packageName")));
            }
            stmt.close();
            //  con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddCorpClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    private void initData(Company company) {
        companyList.add(company);
    }

    private void initData2(Packages packages) {
        packagesList.add(packages);
    }


    private void addCorpClient(String patId,String refPaid,String companyId,String packageId){
        String SQL = "INSERT INTO Assistance_list (psDatacenter_ID, psDatacenter_REF, Assistance_clients_ID,Assistance_packages_ID, isDiscontinued) VALUES()";
    }
    private void addNewCorpClient(){

    }
    private void loadFile(){

    }
}
