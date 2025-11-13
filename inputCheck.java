import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * This class will handle the user inputs
 *
 * @author Cesar Marquez
 * @since November 17, 2025
 * @version 5.0
 * CEN 3024C - Software Development 1
 */
public class inputCheck {


    /**
     * Handles user input for player jersey and checks if the jersey number is taken
     *
     * @param table the GUI default table model
     * @param input user input
     * @throws NumberFormatException if the input is not a number
     * @return true if the jersey number is unique and valid and false if the jersey is not valid, taken or not an integer
     */
    public boolean jerseyNumber(DefaultTableModel table, String input ) {

        try{
            int number = Integer.parseInt(input);
            boolean takenJersey = false;
            int jerseyID;

            for(int i = 0; i < table.getRowCount(); i++) {

                jerseyID = Integer.parseInt(table.getValueAt(i, 0).toString());

                if(jerseyID == number) {
                    takenJersey = true;
                    JOptionPane.showMessageDialog(null,"Sorry, " + input + " is taken");
                    return false;
                }

            }

            if(number <= 0 || number >= 100){
                JOptionPane.showMessageDialog(null,"Sorry, jersey number need to be from 1-99");
                return false;
            }
            else if(!takenJersey) {
                return true;
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Invalid input, it needs to be a integer");
            return false;
        }

        return false;

    }


    /**
     * Handles user input for player name & nationality
     *
     * @param input user input either name or nationality
     * @return true if the input is a string and false if the input is blank or if the input is just numbers
     */
    public boolean playerInfo(String input) {

        if(input.isBlank() || input.isEmpty()){
            JOptionPane.showMessageDialog(null,"Sorry, you need to enter the player information");
            return false;
        }

        //checks for input that is only numbers
        else if(input.matches("\\d+")){
            JOptionPane.showMessageDialog(null,"Sorry, the player information cannot be only numbers");
            return false;
        }
        else {
            return true;
        }

    }

    /**
     * Handles user input for player age
     *
     * @param input user input age
     * @throws NumberFormatException if the input is not a number
     * @return true if input(age) is from (18 - 45) and false if the input is outside the range and if the input is a string.
     */
    public boolean playerAge(String input) {

        try{
            int age = Integer.parseInt(input);

            if(age < 18 || age > 45 ){
                JOptionPane.showMessageDialog(null,"Sorry, age need to be from 18-45");
                return false;
            }

            else{
                return true;
            }
        }

        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Invalid input, it needs to be a integer");
            return false;

        }

    }

    /**
     * Handles user input for player stats
     *
     * @param input user input stats
     * @throws NumberFormatException if the input is not a number
     * @return true if input(stat) is from (0 - 100) and false if the input is outside the range and if the input is a string.
     */
    public boolean playerStat(String input) {

        try{

            int stat = Integer.parseInt(input);

            if(stat < 0 || stat > 100 ){
                JOptionPane.showMessageDialog(null,"Sorry, player stat need to be from 0-100");
                return false;
            }

            else{
                return true;
            }
        }

        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Invalid input, it needs to be a integer");
            return false;

        }

    }

}
