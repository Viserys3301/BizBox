package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class SigInController {
    private String login ;
    private String password ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginArea;

    @FXML
    private PasswordField PasswordArea;

    @FXML
    private Button SignInButton;

    @FXML
    void initialize() {
        SignInButton.setOnAction(event -> {
            String userLogin = LoginArea.getText();
            String userPassword = PasswordArea.getText();
            checkLogAndPass(userLogin,userPassword);
        });
    }

    private void checkLogAndPass(String userLogin,String userPassword){
        if(checkLogAndPassInDB(userLogin,userPassword)){
            SignInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmlFiles/ZeroingAmbulatory.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        else {
            JOptionPane.showMessageDialog(null,"НЕ ВЕРНЫЕ ДАННЫЕ");
        }
    }
    private Boolean checkLogAndPassInDB(String userLogin,String userPassword){
        String SQL = "SELECT [Login] , [Password] FROM BizBoxDLC_Users";
        return true;
    }
}