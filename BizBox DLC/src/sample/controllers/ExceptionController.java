package sample.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.nio.file.Paths;


public class ExceptionController   {

    @FXML
    private MediaView VideoId;

    @FXML
    public Label LabelEx;

    @FXML
    void initialize() {
        String url = "E:/BiBox/BizBox DLC/src/sample/res/Ex2.mp4";
        Media media = new Media(Paths.get(url).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        VideoId.setMediaPlayer(mediaPlayer);
        mediaPlayer.setVolume(2);
        mediaPlayer.play();
    }
}
