package sample.controllers;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;

public class AddCorpClientController {
    String patId;
    static String refPaid;

    String companyId;
    String packageId;

    String firstname;
    String secondNmae;


    String birthdateDay;
    String birthdateMonth;
    String birthdateYer;
    String corpBirthdate;
    String gender;
    String PatIIN;
    String key;


    private static ObservableList<Company> companyList = FXCollections.observableArrayList();
    private static ObservableList<Packages> packagesList = FXCollections.observableArrayList();

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
    private ImageView acepImageId2;

    @FXML
    private TableView<Company> CorpTable;

    @FXML
    private TableColumn<Company, String> CompanyNameId;

    @FXML
    private TableView<Packages> PackageTable;

    @FXML
    private TableColumn<Packages, String> PackageNameId;

    @FXML
    private Button findPackageId;

    @FXML
    private Button addFullPatButton;

    @FXML
    private TextField IINarea;

    @FXML
    private TextField TextKey;

    @FXML
    private RadioButton IsHaveRef;

    @FXML
    void initialize() {

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ToggleGroup group = new ToggleGroup();
        PatGenderFemaleId.setToggleGroup(group);
        PatGenderMaleId.setToggleGroup(group);



        IsHaveRef.setDisable(true);
        IINarea.setDisable(true);
        patFirstNameId.setDisable(true);
        patSecondNameId.setDisable(true);
        DateDayId.setDisable(true);
        DateMonthId.setDisable(true);
        DateYerId.setDisable(true);
        PatGenderFemaleId.setDisable(true);
        PatGenderMaleId.setDisable(true);
        LoadExcelFileButton.setDisable(false);

        findPackageId.setDisable(true);
        addFullPatButton.setDisable(true);





        PatGenderFemaleId.setOnAction(event -> {
             gender = "Female";
        });
        PatGenderMaleId.setOnAction(event -> {
            gender = "Male";
        });

        addFullPatButton.setOnAction(event -> {
             PatIIN = IINarea.getText();
             firstname = patFirstNameId.getText();
             secondNmae = patSecondNameId.getText();
             key = TextKey.getText();

             birthdateDay = DateDayId.getText();
             birthdateMonth = DateMonthId.getText();
             birthdateYer = DateYerId.getText();
             corpBirthdate = "'" + birthdateYer + "-" + birthdateMonth + "-" + birthdateDay + " 00:00:00.000'";
            SqlExecutor sqlExecutor = new SqlExecutor();
            companyId= CorpTable.getSelectionModel().getSelectedItem().getId();
            packageId = PackageTable.getSelectionModel().getSelectedItem().getId();
            sqlExecutor.addNewCorpClient(firstname,secondNmae,corpBirthdate,gender,PatIIN,key,companyId,packageId,refPaid);
            acepImageId.setVisible(true);
            sqlExecutor.getAnimation(acepImageId,1);
        });

        addNewPatId.setOnAction(event -> {

            IsHaveRef.setDisable(false);
            addFullPatButton.setDisable(false);
            patFirstNameId.setDisable(false);
            patSecondNameId.setDisable(false);
            DateDayId.setDisable(false);
            DateMonthId.setDisable(false);
            DateYerId.setDisable(false);
            PatGenderFemaleId.setDisable(false);
            PatGenderMaleId.setDisable(false);
            addCorpButtonId.setDisable(false);
            IINarea.setDisable(false);

            LoadExcelFileButton.setDisable(true);
            addCorpButtonId.setDisable(true);
            refPatiendId.setDisable(true);
            refPatiendId.setText(null);
            patiendId.setDisable(true);
            patiendId.setText(null);
        });

        addCorpButtonId.setOnAction(event -> {
             patId = patiendId.getText();
             refPaid = refPatiendId.getText();
            packageId = PackageTable.getSelectionModel().getSelectedItem().getId();
            boolean close = true;
            SqlExecutor sqlExecutor = new SqlExecutor();

            if(sqlExecutor.addCorpClient(patId,refPaid,companyId,packageId,close)){
                acepImageId.setVisible(true);
                sqlExecutor.getAnimation(acepImageId,1);
            }else {
                acepImageId2.setVisible(true);
                sqlExecutor.getAnimation(acepImageId2,0.5f);
            }
        });

        findCorpId.setOnAction(event -> {
            addCorpButtonId.setDisable(false);

            for (int i = 0; i <CorpTable.getItems().size() ; i++) {
                companyList.clear();
            }
            //СТРОКА ПОИСКА
            String companyName = findCorpArea.getText();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.findCompany(companyName);
            CompanyNameId.setCellValueFactory(new PropertyValueFactory<Company, String>("Name"));
            CorpTable.setItems(companyList);
            findPackageId.setDisable(false);
        });

        IsHaveRef.setOnAction(event -> {
            refPaid = JOptionPane.showInputDialog("ВВЕДИТЕ ID ОСНОВНОГО СОТРУДНИКА");
        });

        findPackageId.setOnAction(event -> {
            for (int i = 0; i <CorpTable.getItems().size() ; i++) {
                packagesList.clear();
            }
            companyId= CorpTable.getSelectionModel().getSelectedItem().getId();
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.findPackages(companyId);
            PackageNameId.setCellValueFactory(new PropertyValueFactory<Packages, String>("Name"));
            PackageTable.setItems(packagesList);
        });

        LoadExcelFileButton.setOnAction(event -> {
            loadFile();
        });

    }

    public static void initData(Company company) {
        companyList.add(company);
    }

    public static void initData2(Packages packages) {
        packagesList.add(packages);
    }

    private void loadFile(){
        int counter = 0;
        try {
          counter  = Integer.parseInt(JOptionPane.showInputDialog("УКАЖИТЕ ЧИСЛО ПАЦИЕНТОВ"));
     }catch (Exception e){
         JOptionPane.showMessageDialog(null,"НЕКОРРЕКТНЫЕ ДАННЫЕ");
         return;
     }

        SqlExecutor sqlExecutor = new SqlExecutor();
        boolean close = false;
        try {
            File file = new File("C:/Users/vdrugov/Desktop/Corp.xlsx");
            FileInputStream  in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            ArrayList<String> corps = new ArrayList<>();
            for (int i = 0; i <counter ; i++) {
                for (int j = 0; j <9 ; j++) {
                    corps.add(workbook.getSheetAt(0).getRow(i).getCell(j).getStringCellValue());
                }
                if(i+1 == counter) close =true;
                sqlExecutor.addNewCorpClientFromFile(corps.get(0),corps.get(1), "'" + corps.get(2) + "'",corps.get(3),corps.get(4),corps.get(5),corps.get(6),corps.get(7),refPaid,corps.get(8),close);
                System.out.println(corps);
                corps.clear();
            }
            workbook.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void changeFrames(int x){
        Image imageIcon = new Image("sample/res/fav.png");
        ChangeFrame CF = new ChangeFrame();
        findPackageId.getScene().getWindow().hide();
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
