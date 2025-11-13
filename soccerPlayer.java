import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * This class handle connect to mySQL & perform query
 *
 * @author Cesar Marquez
 * @since November 17, 2025
 * @version 5.0
 * CEN 3024C - Software Development 1
 */
public class soccerPlayer {


    private Connection connection;

    /**
     * Connect to mySQl database
     *
     * @param database mysql database name
     * @param tableName mysql database table name
     * @param root username
     * @param password user password
     * @throws SQLException error detected while accessing mySQL
     * @return true if successfully connect to the mySQL and false if either table/database does not exit or wrong username/password
     */
    public boolean connectmySQL(String database, String tableName, String root, String password) {

        //database url
        String url = "jdbc:mysql://localhost:3306/"+database;
        boolean success = false;

        //try & catch to access mySQL
        try{

            connection = DriverManager.getConnection(url, root, password);
            String sql = "SHOW TABLES LIKE"+ "'"+tableName+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if(!resultSet.next()){
                JOptionPane.showMessageDialog(null,tableName +"does not exits");
                success = false;
            }
            else{
                success = true;
            }
        }
        catch(SQLException e){
            connection = null;
            JOptionPane.showMessageDialog(null,e);
            success = false;
        }

        return success;
    }

    /**
     * Fetch the data from mySQL to the JTable
     *
     * @param table the GUI default table model
     * @param columns the GUI table columns titles
     * @param userTable mySQL database table name
     * @throws SQLException error if fails to fetch the data
     */
    public void mySQLData(DefaultTableModel table, String[] columns ,String userTable) {

        //try & catch to access mySQL
        try{

            String sql = "SELECT * FROM "+ userTable;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            table.setRowCount(0);

            while(resultSet.next()) {
                Object[] row = new Object[columns.length];

                for(int i = 0; i < columns.length; i++) {
                    row[i] = resultSet.getObject(columns[i]);
                }

                table.addRow(row);
            }

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e + "\n Error: fetching the data from the database");
        }

    }

    /**
     * Add a new player to the database
     *
     * @param newPlayer all the soccer player information
     * @param userTable mySQL database table name
     * @throws SQLException error if fails to add data to mySQL
     * @return true if successfully added player to the database and false adding was unsuccessfully
     */
    public boolean signPlayer(String newPlayer, String userTable) {

        //brekaing the string into part
        int jersey = Integer.parseInt( newPlayer.split("-")[0]);
        String name =  newPlayer.split("-")[1];
        int age = Integer.parseInt( newPlayer.split("-")[2]);
        String nationality =  newPlayer.split("-")[3];
        String position =  newPlayer.split("-")[4];
        String foot =  newPlayer.split("-")[5];
        int playerAth = Integer.parseInt( newPlayer.split("-")[6]);
        int playerAtt = Integer.parseInt( newPlayer.split("-")[7]);
        int playerDef = Integer.parseInt( newPlayer.split("-")[8]);
        int playerSoc = Integer.parseInt( newPlayer.split("-")[9]);

        //try & catch to access mySQL
        try{

            String sql =    "INSERT INTO " + userTable+ " (JerseyID  ,Name, Age, Nationality, Position, DominantFoot, Athleticism, AttackingSkill, Defense, SoccerSkill) VALUES (" +
                    jersey + "," +
                    "'"+ name + "'," +
                    age + "," +
                    "'"+ nationality + "'," +
                    "'"+ position + "'," +
                    "'"+ foot + "'," +
                    playerAth + "," +
                    playerAtt + "," +
                    playerDef + "," +
                    playerSoc +  ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, " Error: inserting data to the database" + e.getMessage());
            return false;
        }

    }

    /**
     * Remove specific player from the database
     *
     * @param id player unique ID
     * @param userTable mySQL table name
     * @throws SQLException error if fails to delete data to mySQL
     * @return true if successfully remove specific soccer player from database and false if fail to remove the soccer player from the database
     */
    public boolean releasePlayer(String id, String userTable) {

        int playerID = Integer.parseInt(id);

        try{
            String sql = "DELETE FROM " + userTable+ " WHERE JerseyID = " + playerID;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    /**
     * Sort the JTable from the best overall rating player to the worst
     *
     * @param table the GUI default table model
     * @param columns table columns titles
     * @param userTable mySQL database table name
     * @throws SQLException error if query fails to sort
     * @return true if successfully sort the JTable and false if fail to sort the JTable
     */
    public boolean sortPlayer(DefaultTableModel table, String[] columns, String userTable){

        //try & catch to send a query
        try{

            String sql = "SELECT JerseyID,Name, Age, Nationality, Position, DominantFoot, Athleticism, AttackingSkill, Defense, SoccerSkill  FROM "+ userTable + " ORDER BY (Athleticism + AttackingSkill + Defense + SoccerSkill) / 4 DESC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            table.setRowCount(0);

            while(resultSet.next()) {
                Object[] row = new Object[columns.length];

                for(int i = 0; i < columns.length; i++) {
                    row[i] = resultSet.getObject(columns[i]);
                }

                table.addRow(row);
            }
            return true;

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }

    }

    /**
     * Update specific soccer player information from the database
     *
     * @param info all the soccer player information
     * @param userTable mySQL database table name
     * @throws SQLException error if fails to update the soccer player information
     * @return true if successfully updated the player information to the database and false to update
     */
    public boolean updatePlayer(String info, String userTable) {

        int id = Integer.parseInt(String.valueOf(info.split("-")[0]));
        String name = String.valueOf(info.split("-")[1]);
        int age = Integer.parseInt(String.valueOf(info.split("-")[2]));
        String nationality = String.valueOf(info.split("-")[3]);
        String position = String.valueOf(info.split("-")[4]);
        String foot = String.valueOf(info.split("-")[5]);
        int playerAth = Integer.parseInt(String.valueOf(info.split("-")[6]));
        int playerAtt = Integer.parseInt(String.valueOf(info.split("-")[7]));
        int playerDef = Integer.parseInt(String.valueOf(info.split("-")[8]));
        int playerSoc = Integer.parseInt(String.valueOf(info.split("-")[9]));

        //try & catch to access mySQL
        try{

            String sql =    "UPDATE " +userTable + " SET " +
                    "Name =  '"+ name + "'," +
                    "Age =  '"+ age + "'," +
                    "Nationality =  '"+ nationality + "'," +
                    "Position =  '"+ position + "'," +
                    "DominantFoot =  '"+ foot + "'," +
                    "Athleticism =  "+ playerAth + "," +
                    "AttackingSkill =  "+ playerAtt + "," +
                    "Defense =  "+ playerDef + "," +
                    "SoccerSkill =  "+ playerSoc +
                    " WHERE JerseyID = " + id;

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }

    }

    /**
     * Calculate the overall player rating based on player: athleticism, attacking skills, defense and soccer skills
     *
     * @param name soccer player name
     * @param ath soccer player athleticism
     * @param att soccer player attacking skill
     * @param def soccer player defense
     * @param soc soccer player soccer skill
     * @return the soccer player overall rating calculation
     */
    public String overallRating(String name,  int ath, int att, int def, int soc) {


        float result;

        //calculation
        result = (float) (ath + att + def + soc) / 4;
        return  "Player: " + name + "\n"+
                "Overall Rating: " + result;

    }

    /**
     * Attempts to disconnet mySQL database when exiting the program
     *
     * @throws SQLException error fail to disconnect the database
     * @return if successfully disconnect database
     */
    public boolean disconnectmySQL() {

        boolean disconnect = false;

        //try & catch to exit mySQL
        try{

            if(!connection.isClosed() && connection != null){
                connection.close();
                disconnect = true;
            }

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            disconnect = false;
        }

        return disconnect;
    }

}
