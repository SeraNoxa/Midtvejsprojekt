package data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import presentation.TeamInfoView;


public class Team {

    TeamInfoView teamInfoView;

    public int id;
    public StringProperty teamName;
    public IntegerProperty point, won, lost, draws;
    public IntegerProperty hp = new SimpleIntegerProperty(50);
    public boolean hasWon = true;

    public Team(int id, String teamName, int won, int lost, int draws, int point) {
        this.id = id;
        this.teamName = new SimpleStringProperty(teamName);
        this.won = new SimpleIntegerProperty(won);
        this.lost = new SimpleIntegerProperty(lost);
        this.draws = new SimpleIntegerProperty(draws);
        this.point = new SimpleIntegerProperty(point);

    }

    public Team(Team team) {
        this(team.getId(), team.getTeamName(), team.getWon(), team.getLost(), team.getDraws(), team.getPoint());
    }


    public void setTeamName(String teamName){
        this.teamName.set(teamName);
    }

    public Team(String teamName) {
        this(0, teamName, 0, 0, 0, 0);
    }

    public StringProperty teamNameProperty() {
        return teamName;
    }

    public String getTeamName() {
        return teamName.get();
    }

    public IntegerProperty wonProperty() {
        return won;
    }

    public int getWon() {
        return won.get();
    }

    public IntegerProperty lostProperty() {
        return lost;
    }

    public int getLost() {
        return lost.get();
    }

    public IntegerProperty drawsProperty() {
        return draws;
    }

    public int getDraws() {
        return draws.get();
    }

    public IntegerProperty pointProperty() {
        return point;
    }

    public int getPoint() {
        return point.get();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return teamName.get();
    }


}
