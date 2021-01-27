package presentation;

import data.Team;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import logic.AllTeams;

import java.util.ArrayList;

public class AllTeamsView {
    public Team teamToSee;

    public VBox createSeeTeamView() {


        TilePane teamsTile = new TilePane();
        teamsTile.setHgap(10);
        teamsTile.setVgap(10);

        teamsTile.setPrefColumns(4);
        teamsTile.setVgap(20);
        teamsTile.setMinSize(100, 100);

        ArrayList<Button> buttonList = new ArrayList<Button>();


        for (Team team : AllTeams.allTeams) {
            buttonList.add(new Button(team.getTeamName()));
            for (Button button : buttonList) {
                button.setOnAction(klik -> {
                            getHoldInfo(button);
                            UILoader.instance.changeCenter("holdInfo");
                        }
                );
            }
        }


        TilePane holdTilePane = new TilePane();
        holdTilePane.getChildren().addAll(buttonList);

        Button backBtn = new Button("Back");
        backBtn.setOnAction(Klik -> UILoader.instance.changeCenter("startMenu"));

        VBox root = new VBox(holdTilePane, teamsTile, backBtn);
        root.setPadding(new Insets(20,20,20,20));
        root.setAlignment(Pos.CENTER);
        return root;
    }

    public Team getHoldInfo(Button button) {
        for (Team checkTeam : AllTeams.allTeams) {
            if (button.getText().equals(checkTeam.getTeamName())) {
                teamToSee = checkTeam;
                return teamToSee;
            }
        }
        return null;
    }
}



