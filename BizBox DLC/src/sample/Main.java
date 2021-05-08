package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/StartFrame.fxml")); //СТАРТ
        primaryStage.setTitle("BizBox (DLC)");
        primaryStage.setScene(new Scene(root, 600, 400));
        Image imageIcon = new Image("sample/res/fav.png");
        primaryStage.getIcons().add(imageIcon);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
