package presentation;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class StartMenu {


    public HBox createStartMenu(){
//        Button createTeamBtn = new Button("Create team");
//        Button battleBtn = new Button("Battle");
//        Button leagueTableViewBtn = new Button("Watch League");
//        Button watchTeamBtn = new Button("Inspect Team");
//        watchTeamBtn.setOnAction(klik -> UILoader.instance.changeCenter("seHold"));
//        battleBtn.setOnAction(klik -> UILoader.instance.changeCenter("kamp"));
//        leagueTableViewBtn.setOnAction(klik -> UILoader.instance.changeCenter("liga"));
//        createTeamBtn.setOnAction(klik -> UILoader.instance.changeCenter("opretHold"));
        HBox root = new HBox();//createTeamBtn,battleBtn,leagueTableViewBtn,watchTeamBtn)
        root.setId("startmenu");
        return root;
    }

}
