package sample.controllers;

import java.io.*;
import java.util.List;

import com.sun.prism.shader.Solid_Color_Loader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class CheckLogsController {

    private String regId ="'%%'" ;

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
    private TextField FK_TRXNO_Id;

    @FXML
    private TextField PK_psPAtreg_Id;

    @FXML
    private Button upLoadLogsButton;

    @FXML
    private Button FindLogsButton;

    @FXML
    private TableView<Logs> LogsTable;

    @FXML
    private TableColumn<Logs, String> RegColumnsId;

    @FXML
    private TableColumn<Logs, String> DateLogsColumnId;

    @FXML
    private TableColumn<Logs, String> FK_TRXNO_ColumnId;

    @FXML
    private TableColumn<Logs, String> PK_pspatColumnId;

    @FXML
    private TableColumn<Logs, String> dateLogsColumnId;

    @FXML
    private MenuItem selectDeletPayment;

    private static ObservableList<Logs> logsData = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

        selectReg00.setOnAction(event -> {
            regId = "'Reg00'";
        });
        selectReg01.setOnAction(event -> {
            regId = "'Reg01'";
        });
        selectReg02.setOnAction(event -> {
            regId = "'Reg02'";
        });
        selectReg03.setOnAction(event -> {
            regId = "'Reg03'";
        });
        selectReg04.setOnAction(event -> {
            regId = "'Reg04'";
        });
        selectReg05.setOnAction(event -> {
            regId = "'Reg05'";
        });
        selectAdmin.setOnAction(event -> {
            regId = "'Admin'";
        });

        FindLogsButton.setOnAction(event -> {

            for (int i = 0; i <LogsTable.getItems().size() ; i++) {
                logsData.clear();
            }

            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.findLogs(regId);

            RegColumnsId.setCellValueFactory(new PropertyValueFactory<Logs, String>("regIdListId"));
            DateLogsColumnId.setCellValueFactory(new PropertyValueFactory<Logs, String>("DataListId"));
            FK_TRXNO_ColumnId.setCellValueFactory(new PropertyValueFactory<Logs, String>("TranID_FK_TRXNOListId"));
            PK_pspatColumnId.setCellValueFactory(new PropertyValueFactory<Logs, String>("TranID_PK_psPatledgersListId"));
            dateLogsColumnId.setCellValueFactory(new PropertyValueFactory<Logs, String>("DateListId"));

            LogsTable.setItems(logsData);

        });

        upLoadLogsButton.setOnAction(event -> {
            loadFile();
        });
    }

    private void loadFile(){



        try {
            //Создание Фaйла
            FileOutputStream fos;
            Workbook wb = new HSSFWorkbook();
            Sheet sh = wb.createSheet("Логи");
            Row row = sh.createRow(0);

            sh.setColumnWidth(0,5000);
            Cell RegID = row.createCell(0);
            sh.setColumnWidth(1,7000);
            Cell Data = row.createCell(1);
            sh.setColumnWidth(2,8000);
            Cell Date = row.createCell(2);
            sh.setColumnWidth(3,5000);
            Cell TranIDFK = row.createCell(3);
            sh.setColumnWidth(4,5000);
            Cell TranIDPK = row.createCell(4);

            CellStyle style = wb.createCellStyle();
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            style.setBorderBottom(BorderStyle.MEDIUM);
            style.setBorderTop(BorderStyle.MEDIUM);
            style.setBorderLeft(BorderStyle.MEDIUM);
            style.setBorderRight(BorderStyle.MEDIUM);

            RegID.setCellValue("ID Регистратора");
            Data.setCellValue("Действия");
            Date.setCellValue("Дата");
            TranIDFK.setCellValue("ID услуг");
            TranIDPK.setCellValue("ID амбулатории");

            RegID.setCellStyle(style);
            Data.setCellStyle(style);
            Date.setCellStyle(style);
            TranIDFK.setCellStyle(style);
            TranIDPK.setCellStyle(style);

            /////////////////////////////////////////

            for (int j = 1; j <logsData.size() ; j++) {
                Row nonrow = sh.createRow(j);
                nonrow.createCell(0).setCellValue(logsData.get(j).getRegIdListId());
                nonrow.createCell(1).setCellValue(logsData.get(j).getDataListId());
                nonrow.createCell(2).setCellValue(logsData.get(j).getDateListId());
                nonrow.createCell(3).setCellValue(logsData.get(j).getTranID_FK_TRXNOListId());
                nonrow.createCell(4).setCellValue(logsData.get(j).getTranID_PK_psPatledgersListId());
            }

            ////////////////////////////////////////////

            fos = new FileOutputStream("C:/Users/vdrugov/Desktop/Logs.xls");
            wb.write(fos);
            fos.close();
        } catch (Exception e) {
            changeFrames(19);
        }
    }

    public static void initData(Logs logs) {
        logsData.add(logs);
    }
    private void changeFrames(int x){
        Image imageIcon = new Image("sample/res/fav.png");
        ChangeFrame CF = new ChangeFrame();
        upLoadLogsButton.getScene().getWindow().hide();
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
