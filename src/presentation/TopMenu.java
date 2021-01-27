package presentation;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class TopMenu {

    public ToolBar createTopMenu(){
        Button startMenuBtn = new Button("Start screen");
        Button createTeamBtn = new Button("Create team");
        Button startBattleBtn = new Button("Start Battle");
        Button teamBtn = new Button("Inspect team");
        Button leagueBtn = new Button("Watch League");

        startMenuBtn.setOnAction(Klik -> UILoader.instance.changeCenter("startMenu"));
        createTeamBtn.setOnAction(Klik -> UILoader.instance.changeCenter("opretHold"));
        startBattleBtn.setOnAction(Klik -> UILoader.instance.changeCenter("kamp"));
        teamBtn.setOnAction(Klik -> UILoader.instance.changeCenter("seHold"));
        leagueBtn.setOnAction(Klik -> UILoader.instance.changeCenter("liga"));



        ToolBar root = new ToolBar(startMenuBtn,createTeamBtn,startBattleBtn,teamBtn,leagueBtn);
        root.setPrefWidth(590);
        return root;
    }
}
