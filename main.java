import javax.swing.*;

/**
 * This is the main class for the Liverpool F.C Roster Manager
 *
 * @author Cesar Marquez
 * @since November 17, 2025
 * @version 5.0
 * CEN 3024C - Software Development 1
 */

public class main {

    /**
     *This is the main method of the program.
     *It will run the programs GUI
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        //Starts the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                soccerPlayer soccerPlayer = new soccerPlayer();
                inputCheck input = new inputCheck();

                new programUI(soccerPlayer, input);

            }
        });
    }
}


