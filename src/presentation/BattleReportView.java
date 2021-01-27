package presentation;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import logic.BattleSummary;

public class BattleReportView {

    public VBox createBattleReportView(String string) {

        Label titleLbl = new Label("Battle Summary");
        Label battleReportLbl = new Label(BattleSummary.instance.toString());
        ScrollPane pane = new ScrollPane(battleReportLbl);

        VBox root = new VBox(titleLbl,pane);

        root.setAlignment(Pos.CENTER);
        return root;
    }
}
