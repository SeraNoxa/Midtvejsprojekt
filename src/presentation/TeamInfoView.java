package presentation;

import data.DataLayer;
import data.Team;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.AllTeams;

public class TeamInfoView {

    Team team;
    AllTeamsView allTeamsView = new AllTeamsView();

    public TeamInfoView(){
        this.team = allTeamsView.teamToSee;
    }

    public VBox createTeamInfoView(Team team){
        Label teamName = new Label("Team:");
        TextField teamNameField = new TextField(team.getTeamName());
        teamNameField.setEditable(false);
        teamNameField.setPromptText("Team name");
        teamNameField.setFocusTraversable(false);
        HBox teamNameHBox = new HBox(teamName,teamNameField);

        Label holdInformation = new Label("Team Information");
        TextArea holdInformationArea = new TextArea();
        holdInformationArea.setEditable(false);
        holdInformationArea.setPromptText("(disabled in alpha version)");
        holdInformationArea.setFocusTraversable(false);
        HBox holdInformationHBox = new HBox(holdInformation,holdInformationArea);

        Label empty = new Label();

        Button saveBtn = new Button("Save");
        Button backBtn = new Button("Back");
        Button editBtn = new Button("Edit");
        Button deleteBtn = new Button("Delete");
        HBox buttonHBox = new HBox(saveBtn,backBtn, editBtn, deleteBtn);

        GridPane gridRoot = new GridPane();
        gridRoot.addRow(1,teamName,teamNameField);
        gridRoot.addRow(2,holdInformation,holdInformationArea);
        gridRoot.addRow(3,empty,buttonHBox);
        gridRoot.setHgap(10);
        gridRoot.setVgap(10);


        VBox root = new VBox(gridRoot);
        deleteBtn.setOnAction(klik ->{
            DataLayer.instance.deleteTeam(team);
            AllTeams.allTeams.remove(team);
            UILoader.instance.changeCenter("seHold");

        });
        backBtn.setOnAction(klik -> UILoader.instance.changeCenter("seHold"));

        saveBtn.setOnAction(klik -> {
            team.setTeamName(teamNameField.getText());
            DataLayer.instance.updateTeam(team);
        });


        editBtn.setOnAction(klik ->{
            teamNameField.setEditable(true);
            holdInformationArea.setEditable(false);//safety measure
        });

        return root;
    }

}
