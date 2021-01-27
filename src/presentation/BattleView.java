package presentation;

import data.Team;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Scale;
import logic.BattleEvents;
import logic.TimeTasker;

import java.util.Timer;

public class BattleView {

    BattleEvents battleEvents;
    Team team1;
    Team team2;
    public Timer timer = new Timer();
    Label timeLeftLabel;
    public static boolean timeIsLeft =true;
    public static  Label battleTextLbl;

    public VBox createAktivKamp(Team team1, Team team2){

        this.team1 = battleEvents.team1;
        this.team2 = battleEvents.team2;
        battleEvents.startTime();

        Label teamNameLeft = new Label(team1.getTeamName());
        Label teamNameRight = new Label(team2.getTeamName());
        Label leftHp = new Label();
        leftHp.textProperty().bind(team1.hp.asString());
        Label rightHp = new Label();
        rightHp.textProperty().bind(team2.hp.asString());
        System.out.println(team1.getTeamName() +"har vundet: "+ team1.hasWon);
        System.out.println(team2.getTeamName() +"har vundet: "+ team2.hasWon);
        Button leftAttackBtn = new Button("Angrib");
        Button rightAttackBtn = new Button("Angrib");
        leftAttackBtn.setId("attack");
        leftAttackBtn.setOpacity(50);
        rightAttackBtn.setId("attack");
        rightAttackBtn.setOpacity(50);
        Button leftHealBtn = new Button("");
        Button rightHealBtn = new Button("");
        leftHealBtn.setId("heal");
        rightHealBtn.setId("heal");

        Scale scaleTransformation = new Scale();
        scaleTransformation.setX(0);
        scaleTransformation.setY(0);

        timeLeftLabel = new Label();
        timeLeftLabel.setAlignment(Pos.CENTER);
        timeLeftLabel.setPadding(new Insets(50, 50, 50, 50));

        battleTextLbl = new Label();
        battleTextLbl.setAlignment(Pos.CENTER);
        battleTextLbl.setPadding(new Insets(50, 50, 50, 50));

        leftAttackBtn.setOnAction(klik ->{ battleEvents.attack(team1, team2);
        battleEvents.BattleDecided(team1, team2);

        });
        rightAttackBtn.setOnAction(klik ->{ battleEvents.attack(team2, team1);
            battleEvents.BattleDecided(team1, team2);
        });
        leftHealBtn.setOnAction(klik ->{
            battleEvents.heal(team1);
            leftHealBtn.setDisable(true);
            leftHealBtn.getTransforms().add(scaleTransformation);
        });
        rightHealBtn.setOnAction(klik -> {
            battleEvents.heal(team2);
            rightHealBtn.setDisable(true);
            rightHealBtn.getTransforms().add(scaleTransformation);
        });

    VBox leftSideVBox = new VBox(teamNameLeft, leftHp,leftAttackBtn,leftHealBtn);
    leftSideVBox.setMinWidth(200);
    leftSideVBox.setAlignment(Pos.CENTER);

    VBox rightSideVBox = new VBox(teamNameRight,rightHp,rightAttackBtn,rightHealBtn);
    rightSideVBox.setMinWidth(200);
    rightSideVBox.setAlignment(Pos.CENTER);

    HBox bothSidesVBox= new HBox(leftSideVBox,rightSideVBox);
    bothSidesVBox.setMinWidth(590);
    bothSidesVBox.setAlignment(Pos.CENTER);

    VBox root = new VBox(timeLeftLabel,bothSidesVBox, battleTextLbl);
    root.setAlignment(Pos.TOP_CENTER);
    return root;
    }

    public BattleView(BattleEvents battleEvents) {
        this.battleEvents = battleEvents;
    }

    public void setGameTime(int time){
        timeLeftLabel.setText("Tid: "+time);
    }

    public boolean tidsCheck(){
        if(TimeTasker.timeLeft.getValue().intValue() <= 0)
            timeIsLeft =false;
        return timeIsLeft;
    }

    public void timeRunOut(){
        battleEvents.BattleDraw(team1, team2);
    }
}
