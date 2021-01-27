package logic;

import data.Team;

import java.util.ArrayList;

public class AllTeams {
    public static ArrayList<Team> allTeams = new ArrayList<>();

    public void addTeam(Team team){
        allTeams.add(team);
    }


}
