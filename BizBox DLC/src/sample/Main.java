package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.ChangeDoctorController;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       //   Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/StartFrame.fxml")); //СТАРТ
      // Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/DeletPayment.fxml"));   //УДАЛЕНИЕ ПЛАТЕЖА RE------------------------------------------
    // Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/ChangeDoctor.fxml"));   //ИЗМЕНЕНИЕ ВРАЧА RE--------------------------
     //   Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/ZeroingAmbulatory.fxml")); //ОБНУДЕНИЕ АМБУЛАТОРИИ RE------------------------------
     //   Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/ZeroingCorpClient.fxml")); //ОБНУДЕНИЕ КОРП RE------------------------
      //  Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/ChangeAmbulatoryDate.fxml")); //ИЗМЕНЕНИЕ ДАТЫ АМБУЛАТОРИИ RE----------------------------------
         Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/ChangePayment.fxml")); //ИЗМЕНЕНИЕ ПЛАТЕЖА НАЛ БЕЗНАЛ
      //Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/EnabledUltrasound.fxml")); //РАЗБЛОКИРОВКА УЗИ RE------------------------------------
    //   Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/RecoveryUltrasound.fxml")); //ВОЗВРАТ УЗИ RE-----------------------------------
     //    Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/ChangeBirthdate.fxml")); //ИЗМЕНЕНИЕ ДАТЫ РОЖДЕНИЯ
        primaryStage.setTitle("BizBox (DLC)");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
