package logic;

import data.Team;
import java.util.ArrayList;
import java.util.Random;

public class UserFeedback {
    Team team1;
    Team team2;

    public String randomAttack(Team team1, Team team2) {

        ArrayList<String> givenList = new ArrayList<String>();
        givenList.add(team1.getTeamName()+ " smadrede "+ team2.getTeamName());
        givenList.add(team1.getTeamName()+ " tæskede "+ team2.getTeamName()+" med en våd avis");

//    "Tæsk med en våd avis","Slag med en kæp","Dask i næseryggen","Spark i knæhasen","Verbale beskeder på svensk"," Kilde under tæerne",
//                "Slog en prut"," Flemming fortæller en anekdote","Hold X får Jan til at kaste sin skrå pæl fra haven"," Kaster sand i øjnene"," To fingre i øjnene","Olfert",
//                "Lussing","Sheriff Stjerne","HoldX får Flemming til at smadre holdY i skak","HoldX  Kaster sin 95 siders powerpoint show i hovedet på holdY","Fortæller en din-mor joke",
//                "Fortæller død baby joke","Det plejede far at gøre","Smølfespark lige i øjet");


        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            String randomAttacks = givenList.get(random.nextInt(givenList.size()));
            return randomAttacks;
        }
        return null;
    }











}
