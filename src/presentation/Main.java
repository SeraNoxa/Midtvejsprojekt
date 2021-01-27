package presentation;

import data.DataLayer;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import logic.AllTeams;

import java.io.File;

public class Main extends Application {
    AllTeams allTeams = new AllTeams();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Datamatiker Fight Night! (Rikke Rune Lars Henrik)");

        String musicFile = "tristram.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.02);
        mediaPlayer.play();

        primaryStage.setScene(UILoader.instance.createScene());
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println(DataLayer.instance.getAllTeams());
        launch(args);
    }
}
