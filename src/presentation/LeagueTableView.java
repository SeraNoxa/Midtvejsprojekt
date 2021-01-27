package presentation;

import data.DataLayer;
import data.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class LeagueTableView {

    public VBox createLeagueTableView(){
        TableView table = new TableView();
        ObservableList<Team> LeagueTeams = FXCollections.observableArrayList(DataLayer.instance.getLeague());

        table.setEditable(false);
        table.setMinWidth(700);
        table.setMaxWidth(798);


        TableColumn teamNameColumn = new TableColumn<>("Team");
        teamNameColumn.setMinWidth(200);
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<Team, String>("teamName"));

        TableColumn wonColumn = new TableColumn<>("Won");
        wonColumn.setMinWidth(150);
        wonColumn.setCellValueFactory(new PropertyValueFactory<Team, Integer>("won"));

        TableColumn drawColumn = new TableColumn<>("Draw");
        drawColumn.setMinWidth(150);
        drawColumn.setCellValueFactory(new PropertyValueFactory<Team, Integer>("draws"));

        TableColumn lostColumn = new TableColumn<>("Lost");
        lostColumn.setMinWidth(150);
        lostColumn.setCellValueFactory(new PropertyValueFactory<Team, Integer>("lost"));

        TableColumn pointColumn = new TableColumn<>("Points");
        pointColumn.setMinWidth(146);
        pointColumn.setCellValueFactory(new PropertyValueFactory<Team, Integer>("point"));

        table.getColumns().addAll(teamNameColumn,wonColumn,drawColumn,lostColumn,pointColumn);

        table.setItems(LeagueTeams);


        VBox root = new VBox(table);
        return root;
    }
}
