package presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameOverView {

    public static void display(String title, String message){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(300);

        Label messageLbl = new Label(message);


        Button backToStartBtn = new Button("Start Menu");

        backToStartBtn.setOnAction(klik ->{
            UILoader.instance.changeCenter("startMenu");
            window.close();
        });

        Button watchBattleReportBtn = new Button("Battle Report");
        watchBattleReportBtn.setOnAction(Klik -> {
            UILoader.instance.changeCenter("visKampRapport");
            window.close();
        });

        HBox buttons = new HBox(backToStartBtn,watchBattleReportBtn);
        VBox layout = new VBox(messageLbl,buttons);
        layout.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("presentation/main.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
