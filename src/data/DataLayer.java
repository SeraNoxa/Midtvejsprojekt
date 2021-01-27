package data;

import logic.AllTeams;

import java.sql.*;
import java.util.ArrayList;

public class DataLayer {

    public static DataLayer instance = new DataLayer("MidtvejsProjektDB");
    private Connection connection;

    public  DataLayer(String databaseName) {
        loadJdbcDriver();
        openConnection("MidtvejsProjektDB");
    }

    private boolean loadJdbcDriver() {
        try {
            System.out.println("Loading JDBC driver...");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("JDBC driver loaded");
            return true;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Could not load JDBC driver!");
            return false;
        }
    }

    private boolean openConnection(String databaseName) {
        String connectionString =
                "jdbc:sqlserver://localhost:1433;" +
                        "instanceName=SQLEXPRESS;" +
                        "databaseName=" + databaseName + ";" +
                        "integratedSecurity=true;";
        connection = null;
        try {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(connectionString);
            System.out.println("Connected to database");
            return true;
        }
        catch (SQLException e) {
            System.out.println("Could not connect to database!");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<Team> getAllTeams() {
        return getTeamsByCondition("0 = 0");
    }

    public boolean addTeams(Team team) {
        try {
            String sql = "INSERT INTO hold VALUES ('" +
                    team.getTeamName() + "', '" +
                    team.getWon() + "', '" +
                    team.getLost() + "', '" +
                    team.getDraws() + "', " +
                    team.getPoint() + ")";

            System.out.println(sql);
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(sql);

            ResultSet resultSet = statement.executeQuery("SELECT SCOPE_IDENTITY()");
            if (resultSet.next()){
                int autoKey = resultSet.getInt(1);
                team.setId(autoKey);
            }
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTeam(Team team) {
        try {
            String condition = "id=" + team.getId();
            String sql = "DELETE FROM hold WHERE " + condition;
            System.out.println(sql);
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(sql);

            return (affectedRows == 1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTeam(Team team) {
        try {
            StringBuffer assignments = new StringBuffer();
            assignments.append("Holdnavn='" + team.getTeamName() + "', ");
            assignments.append("Vundet='" + team.getWon() + "', ");
            assignments.append("Tabte='" + team.getLost() + "', ");
            assignments.append("Uafgjort='" + team.getDraws() + "', ");
            assignments.append("Point=" + team.getPoint());

            String condition = "id=" + team.getId();

            String sql = "UPDATE hold SET " + assignments +
                    " WHERE " + condition;

            System.out.println(sql);
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(sql);
            return (affectedRows == 1);

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private ArrayList<Team> getTeamsByCondition(String condition) {
        System.out.println("condition: " + condition);
        try {
            String sql = "SELECT * FROM hold WHERE " + condition;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {// iteration starter 'before first'
                int id = resultSet.getInt("id");
                String teamName = resultSet.getString("Holdnavn");
                int won = resultSet.getInt("Vundet");
                int lost = resultSet.getInt("Tabte");
                int draw = resultSet.getInt("Uafgjort");
                int point = resultSet.getInt("Point");

                Team team = new Team(id, teamName, won, lost, draw, point);
                AllTeams.allTeams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AllTeams.allTeams;
    }

    public ArrayList<Team> getLeague() {
         ArrayList<Team> leagueTable = new ArrayList<>();

        try {
            String sql = "SELECT * FROM hold ORDER BY point DESC, vundet DESC, uafgjort DESC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // iteration starter 'before first'
            while (resultSet.next()) {
                // hent data fra denne række
                int id = resultSet.getInt("id");
                String teamName = resultSet.getString("Holdnavn");
                int won = resultSet.getInt("Vundet");
                int lost = resultSet.getInt("Tabte");
                int draw = resultSet.getInt("Uafgjort");
                int point = resultSet.getInt("Point");

                Team team = new Team(id, teamName, won, lost, draw, point);
                leagueTable.add(team);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leagueTable;
    }
}
