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

public class CreateTeamView {

    public VBox createTeamView(){
        Label teamName = new Label("Team:");
        TextField teamNameField = new TextField();
        teamNameField.setPromptText("Team name");
        teamNameField.setFocusTraversable(false);
        HBox teamNameHBox = new HBox(teamName,teamNameField);

        Label teamCaptain = new Label("Team Captain");
        TextField teamCaptainField = new TextField();
        teamCaptainField.setPromptText("Team Captain(disabled in alpha version)");
        teamCaptainField.setFocusTraversable(false);
        HBox teamCaptainHBox = new HBox(teamCaptain,teamCaptainField);

        Label player1 = new Label("Player 1");
        TextField player1Field = new TextField();
        player1Field.setPromptText("Player 1(disabled in alpha version)");
        player1Field.setFocusTraversable(false);
        HBox player1HBox = new HBox(player1,player1Field);

        Label player2 = new Label("Player 2");
        TextField player2Field = new TextField();
        player2Field.setPromptText("Player 2(disabled in alpha version)");
        player2Field.setFocusTraversable(false);
        HBox player2HBox = new HBox(player2,player2Field);

        Label teamInformation = new Label("Team Information");
        TextArea teamInformationArea = new TextArea();
        teamInformationArea.setPromptText("Team Information(disabled in alpha version)");
        teamInformationArea.setFocusTraversable(false);
        HBox teamInformationHBox = new HBox(teamInformation,teamInformationArea);

        Label empty = new Label();

        Button saveBtn = new Button("Save");
        Button cancelBtn = new Button("Cancel");
        HBox buttonHBox = new HBox(saveBtn,cancelBtn);
        //buttonHBox.setPadding(new Insets(0,0,0,200));
        //buttonHBox.setAlignment(Pos.CENTER);

        GridPane gridRoot = new GridPane();
        gridRoot.addRow(1,teamName,teamNameField);
        gridRoot.addRow(2,teamCaptain,teamCaptainField);
        gridRoot.addRow(3,player1,player1Field);
        gridRoot.addRow(4,player2,player2Field);
        gridRoot.addRow(5,teamInformation,teamInformationArea);
        gridRoot.addRow(6,empty,buttonHBox);
        gridRoot.setHgap(10);
        gridRoot.setVgap(10);


        VBox root = new VBox(gridRoot);

        saveBtn.setOnAction(klik -> newTeam(teamNameField,teamCaptainField,player1Field,player2Field,teamInformationArea));
        //gemBtn.setOnAction(Klik -> nytHold());


        cancelBtn.setOnAction(klik -> UILoader.instance.changeCenter("startMenu"));
        return root;
    }
    public void newTeam(TextField teamName, TextField teamCaptain, TextField player1, TextField player2, TextArea teamInformation){
        AllTeams allTeams = new AllTeams();
        Team team = new Team(teamName.getText());//,holdKaptajn.getText(),spiller1.getText(),spiller2.getText(),holdInformation.getText()
        allTeams.addTeam(team);
        DataLayer.instance.addTeams(team);
        for (Team teamNames : AllTeams.allTeams) {
            System.out.println(teamNames);
        }
        teamName.clear();
        teamCaptain.clear();
        player1.clear();
        player2.clear();
        teamInformation.clear();
    }

}
