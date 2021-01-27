package presentation;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import logic.BattleEvents;
import logic.BattleSummary;


public class UILoader {

    public static UILoader instance = new UILoader();
    private StartMenu startMenu = new StartMenu();
    private AllTeamsView allTeamsView = new AllTeamsView();
    private BorderPane root = new BorderPane();
    private StartBattleView startBattleView = new StartBattleView();
    private LeagueTableView leagueTableView = new LeagueTableView();
    private CreateTeamView createTeamView = new CreateTeamView();
    private TopMenu topMenu = new TopMenu();
    public BattleEvents battleEvents = new BattleEvents();
    public BattleView battleView = new BattleView(battleEvents);
    private BattleReportView battleReportView = new BattleReportView();
    private TeamInfoView teamInfoView = new TeamInfoView();


    public Scene createScene() {

        Scene scene = new Scene(root,800,600);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        changeCenter("startMenu");
        return scene;
    }

    public void changeCenter(String viewName){
        switch (viewName){
            case "startMenu":
                root.setCenter(startMenu.createStartMenu());
                root.setTop(topMenu.createTopMenu());
                break;
            case "opretHold":
                root.setCenter(createTeamView.createTeamView());
                root.setTop(topMenu.createTopMenu());
                break;
            case "kamp":
                root.setCenter(startBattleView.createBattleView());
                root.setTop(topMenu.createTopMenu());
                break;
            case "liga":
                root.setCenter(leagueTableView.createLeagueTableView());
                root.setTop(topMenu.createTopMenu());
                break;
            case "seHold":
                root.setCenter(allTeamsView.createSeeTeamView());
                root.setTop(topMenu.createTopMenu());
                break;
            case "aktivKamp":
                root.setCenter(battleView.createAktivKamp(battleEvents.team1, battleEvents.team2));
                root.setTop(topMenu.createTopMenu());
                break;
            case "visKampRapport":
                root.setCenter(battleReportView.createBattleReportView(BattleSummary.instance.kampRapportSB.toString()));
                root.setTop(topMenu.createTopMenu());
                break;
            case "holdInfo":
                root.setCenter(teamInfoView.createTeamInfoView(allTeamsView.teamToSee));
                root.setTop(topMenu.createTopMenu());
                break;
        }

    }


}
