package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ZeroingCorpClientController {

    private String regName;

    @FXML
    private MenuBar mainMenuBar;

    @FXML
    private Menu ChangeMenuButton;

    @FXML
    private MenuItem ChangeBithDateButton;

    @FXML
    private Menu AddMenuButton;

    @FXML
    private Menu OptionsMenuButton;

    @FXML
    private TextField TranIdArea;

    @FXML
    private Button ZeroingClientButton;

    @FXML
    private RadioButton RadioReg00;

    @FXML
    private RadioButton RadioReg01;

    @FXML
    private RadioButton RadioReg02;

    @FXML
    private RadioButton RadioReg03;

    @FXML
    private RadioButton RadioReg04;

    @FXML
    private RadioButton RadioReg05;

    @FXML
    private Label infoLabel;

    @FXML
    private Label InfoQery;

    @FXML
    private Button clearButton;

    @FXML
    void initialize() {

        TranIdArea.setDisable(true);
        //РЕГИСТРАТОРЫ
        ToggleGroup group = new ToggleGroup();
        RadioReg00.setToggleGroup(group);
        RadioReg01.setToggleGroup(group);
        RadioReg02.setToggleGroup(group);
        RadioReg03.setToggleGroup(group);
        RadioReg04.setToggleGroup(group);
        RadioReg05.setToggleGroup(group);





        //ВЫБОР РЕГИСТРАТОРОВ
        RadioReg00.setOnAction(event1 -> {
            regName = "Reg00";
            TranIdArea.setDisable(false);

        });
        RadioReg01.setOnAction(event1 -> {
            regName = "Reg01";
            TranIdArea.setDisable(false);

        });
        RadioReg02.setOnAction(event1 -> {
            regName = "Reg02";
            TranIdArea.setDisable(false);

        });
        RadioReg03.setOnAction(event1 -> {
            regName = "Reg03";
            TranIdArea.setDisable(false);

        });
        RadioReg04.setOnAction(event1 -> {
            regName = "Reg04";
            TranIdArea.setDisable(false);

        });
        RadioReg05.setOnAction(event1 -> {
            regName = "Reg05";
            TranIdArea.setDisable(false);

        });

        clearButton.setOnAction(event -> {
            TranIdArea.setText("");
            infoLabel.setText("");
            RadioReg00.setSelected(false);
            RadioReg01.setSelected(false);
            RadioReg02.setSelected(false);
            RadioReg03.setSelected(false);
            RadioReg04.setSelected(false);
            RadioReg05.setSelected(false);
        });
    }

    private void zeroingClient(){

    }
}
