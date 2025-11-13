import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class will have all the GUI components
 *
 * @author Cesar Marquez
 * @since November 17, 2025
 * @version 5.0
 * CEN 3024C - Software Development 1
 */
public class programUI extends JFrame {

    //GUI Components

    //inputs components
    JTextField root;
    JLabel rootLabel = new JLabel("Please Enter User Name");

    JPasswordField password;
    JLabel passwordLabel = new JLabel("Please Enter Password");

    JTextField databaseName;
    JLabel databaseNameLabel = new JLabel("Please Database Name");

    JTextField tableName;
    JLabel tableNameLabel = new JLabel("Please Table Name");

    JTextField jerseyNumber;
    JLabel jerseyLabel = new JLabel("Please enter player's jersey number from 1-99");

    JTextField playerName;
    JLabel nameLabel = new JLabel("Please enter player's name");

    JTextField playerAge;
    JLabel ageLabel = new JLabel("Please enter player's age from 18-45");

    JTextField playerNationality;
    JLabel nationalityLabel = new JLabel("Please enter player's nationality");

    JTextField athleticism;
    JLabel athLabel = new JLabel("Please enter player's athleticism from 0-100");

    JTextField attackingSkills;
    JLabel attLabel = new JLabel("Please enter player's attacking skill from 0-100");

    JTextField defense;
    JLabel defLabel = new JLabel("Please enter player's defense skill from 0-100");

    JTextField soccerSkills;
    JLabel socLabel = new JLabel("Please enter player's soccer skill from 0-100");

    String[] position = {"GoalKeeper", "Center Back", "Sweeper", "Full back", "Wing back", "Right Back", "Left Back",
            "Center Midfielder", "Defensive MidFielder", "Attacking Midfielder", "Central Attacking Midfielder", "Central Defensive Midfielder", "Wide Midfielder", "Right Midfield", "Left Midfielder",
            "Striker", "Center Forward", "Winger", "Right Winger", "Left Winger"};
    JComboBox<String> playerPosition = new JComboBox<>(position);
    JLabel positionsLabel = new JLabel("Please enter player's position");

    String[] foot = {"L", "B", "R"};
    JComboBox<String> playerDominantFoot = new JComboBox<>(foot);
    JLabel footsLabel = new JLabel("Please enter player's dominant foot");

    JLabel welcomeMessage = new JLabel("Liverpool F.C Roster Manager");

    //Buttons
    JButton submitSQL = new JButton("Submit");
    JButton signPlayer = new JButton("Sign Player");
    JButton sortPlayer = new JButton("Sort Player by Best Rating");
    JButton overallRating = new JButton("Calculate Overall Rating");
    JButton updatePlayer = new JButton("Update Player Data");
    JButton releasePlayer = new JButton("Release Player");
    JButton exit = new JButton("Exit Program");
    JButton welcomeExit = new JButton("Exit Program");
    JButton addButton = new JButton("Submit");
    JButton updateButton = new JButton("Submit Update");


    //data Tabel list
    String[] columns = {"JerseyID", "Name", "Age", "Nationality", "Position", "DominantFoot",
            "Athleticism", "AttackingSkill", "Defense", "SoccerSkill"};

    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    JTable table = new JTable(tableModel);
    JScrollPane scrollPaneTable = new JScrollPane(table);
    ArrayList<String> playerList = new ArrayList<>();

    //image
    ImageIcon image = new ImageIcon("image/Liverpool_F.C._Logo.png");
    Image finalImage = image.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
    JLabel imageLabel = new JLabel(new ImageIcon(finalImage));

    //Layout and boxes
    JPanel welcometopRow = new JPanel();
    JPanel welcomemiddleRow = new JPanel();
    JPanel welcomebottomRow = new JPanel();
    JPanel welcomeinput = new JPanel();

    JPanel topRow = new JPanel();
    JPanel middleRow = new JPanel();
    JPanel bottomRow = new JPanel();
    JPanel input = new JPanel();

    //calling the other classes
    private final soccerPlayer soccerPlayer;
    private final inputCheck inputCheck;

    String userRoot = "";
    char[] userPassword;
    String userFinalPassword = "";
    String userDataBase ="";
    String usertableName = "";

    //GUI Layout and body

    /**
     * GUI layout and display
     *
     * @param soccerPlayer connect the soccerPLayer class to the programUI
     * @param inputCheck connect the inputClass class to the programUI
     */
    public programUI(soccerPlayer soccerPlayer, inputCheck inputCheck) {

        this.soccerPlayer = soccerPlayer;
        this.inputCheck = inputCheck;

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame welcomeFrame = new JFrame();
        welcomeFrame.setSize(1000, 600);
        welcomeFrame.setLayout(new BoxLayout(welcomeFrame.getContentPane(), BoxLayout.Y_AXIS));

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();


        welcomeFrame.setTitle("Liverpool F.C Roster Manager");
        welcomeFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        /*
            Welcome frame GUI top area: title and text
        */

        welcomeMessage.setFont(new Font("Serif", Font.BOLD, 50));
        welcometopRow.add(welcomeMessage);

        /*
            Welcome frame GUI Middles area: inputs and image
         */

        //forms and data
        welcomeinput.setLayout(new BoxLayout(welcomeinput, BoxLayout.Y_AXIS));
        welcomeinput.add(Box.createVerticalGlue());

        rootLabel.setPreferredSize(new Dimension(300, 30));
        rootLabel.setHorizontalAlignment(SwingConstants.LEFT);
        rootLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeinput.add(rootLabel);

        welcomeinput.setBackground(Color.lightGray);
        root = new JTextField("");
        root.setPreferredSize(new Dimension(300,30));
        root.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeinput.add(root);
        welcomemiddleRow.add(welcomeinput);

        passwordLabel.setPreferredSize(new Dimension(300, 30));
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeinput.add(passwordLabel);
        welcomeinput.setBackground(Color.lightGray);
        password = new JPasswordField();
        password.setPreferredSize(new Dimension(300,30));
        password.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeinput.add(password);
        welcomemiddleRow.add(welcomeinput);

        databaseNameLabel.setPreferredSize(new Dimension(300, 30));
        databaseNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        databaseNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeinput.add(databaseNameLabel);

        welcomeinput.setBackground(Color.lightGray);
        databaseName = new JTextField("");
        databaseName.setPreferredSize(new Dimension(300,30));
        databaseName.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeinput.add(databaseName);
        welcomemiddleRow.add(welcomeinput);

        tableNameLabel.setPreferredSize(new Dimension(300, 30));
        tableNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tableNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeinput.add(tableNameLabel);

        welcomeinput.setBackground(Color.lightGray);
        tableName = new JTextField("");
        tableName.setPreferredSize(new Dimension(300,30));
        tableName.setAlignmentX(Component.LEFT_ALIGNMENT);
        welcomeinput.add(tableName);
        welcomemiddleRow.add(welcomeinput);

        submitSQL.setPreferredSize(new Dimension(200, 35));
        submitSQL.setBackground(Color.cyan);
        //submitSQL button action listener
        submitSQL.addActionListener(new ActionListener() {

            boolean exits;

            @Override
            public void actionPerformed(ActionEvent e) {


                userRoot = root.getText();
                userPassword = password.getPassword();
                userFinalPassword = new String(userPassword);
                userDataBase = databaseName.getText();
                usertableName = tableName.getText();

                exits = soccerPlayer.connectmySQL(userDataBase, usertableName, userRoot, userFinalPassword);

                if (exits == false) {
                    JOptionPane.showMessageDialog(welcomeFrame, "Fail to connect to MySQL");
                }
                else{
                    JOptionPane.showMessageDialog(welcomeFrame, "Success to connect to MySQL");
                    userDataBase = databaseName.getText();
                    usertableName = tableName.getText();

                    //getting the data from mysql
                    soccerPlayer.mySQLData(tableModel, columns, usertableName);
                    welcomeFrame.setVisible(false);
                    frame.setVisible(true);

                }
            }

        });
        welcomeinput.add(submitSQL);

        welcomemiddleRow.add(imageLabel);

         /*
            Welcome frame GUI botton area : exit
         */
        welcomeExit.setPreferredSize(new Dimension(200, 35));
        welcomeExit.setForeground(Color.lightGray);
        welcomeExit.setBackground(Color.red);
        //Exit button action listener
        welcomeExit.addActionListener(e -> {
            System.exit(0);
        });
        welcomebottomRow.add(welcomeExit);

        welcomeFrame.add(welcometopRow);
        welcomeFrame.add(welcomemiddleRow);
        welcomeFrame.add(welcomebottomRow);
        welcomeFrame.pack();
        welcomeFrame.setVisible(true);


        /*
            Second frame,this framw will have the CRUD
         */

        //vertical display
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.setTitle("Liverpool F.C Roster Manager");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //vertical display
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        /*
            Frame GUI top area: Buttons
         */
        topRow.setLayout(new BoxLayout(topRow, BoxLayout.X_AXIS));

        signPlayer.setPreferredSize(new Dimension(200, 35));
        signPlayer.setBackground(Color.cyan);
        //sign player button action listener
        signPlayer.addActionListener(e -> {

            input.setVisible(true);
            addButton.setVisible(true);
            addButton.setEnabled(true);
            updateButton.setVisible(false);
            updateButton.setEnabled(false);

            jerseyNumber.setEnabled(true);
            jerseyNumber.setText("");
            jerseyNumber.setBorder(null);

            playerName.setText("");
            playerName.setBorder(null);

            playerAge.setText("");
            playerAge.setBorder(null);

            playerNationality.setText("");
            playerNationality.setBorder(null);

            athleticism.setText("");
            athleticism.setBorder(null);

            attackingSkills.setText("");
            attackingSkills.setBorder(null);

            defense.setText("");
            defense.setBorder(null);

            soccerSkills.setText("");
            soccerSkills.setBorder(null);

        });
        topRow.add(signPlayer);

        sortPlayer.setPreferredSize(new Dimension(200, 35));
        sortPlayer.setBackground(Color.cyan);
        //sort PLayer rating button action listener
        sortPlayer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                boolean sortSuccess = false;
                sortSuccess = soccerPlayer.sortPlayer(tableModel, columns, usertableName);

                if (sortSuccess == false) {
                    JOptionPane.showMessageDialog(frame, "Error: sorting data");
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Successfully sort data");
                }

            }
        });
        topRow.add(sortPlayer);

        overallRating.setPreferredSize(new Dimension(200, 35));
        overallRating.setBackground(Color.cyan);
        //overall rating button action listener
        overallRating.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int index = table.getSelectedRow();

                if((index == -1)) {
                    JOptionPane.showMessageDialog(frame, "Please select a a player from the roster");
                }
                else if (index != -1){

                    //the data needed
                    String name = tableModel.getValueAt(index, 1).toString();
                    int ath = Integer.parseInt(tableModel.getValueAt(index, 6).toString());
                    int att = Integer.parseInt(tableModel.getValueAt(index, 7).toString());
                    int def = Integer.parseInt(tableModel.getValueAt(index, 8).toString());
                    int soc = Integer.parseInt(tableModel.getValueAt(index,9).toString());

                    String answer = soccerPlayer.overallRating(name, ath, att, def, soc);
                    JOptionPane.showMessageDialog(frame, answer);
                }
            }
        });
        topRow.add(overallRating);

        updatePlayer.setPreferredSize(new Dimension(200, 35));
        updatePlayer.setBackground(Color.cyan);
        //updated player button action listener
        updatePlayer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int index = table.getSelectedRow();

                if((index == -1)) {
                    JOptionPane.showMessageDialog(frame, "Please select a a player from the roster");
                }
                else if (index != -1){

                    input.setVisible(true);
                    updateButton.setVisible(true);
                    updateButton.setEnabled(true);
                    addButton.setVisible(false);
                    addButton.setEnabled(false);

                    //the data needed
                    String number = tableModel.getValueAt(index, 0).toString();
                    String name = tableModel.getValueAt(index, 1).toString();
                    String age = tableModel.getValueAt(index, 2).toString();
                    String nationality = tableModel.getValueAt(index, 3).toString();
                    String position = tableModel.getValueAt(index, 4).toString();
                    String foot = tableModel.getValueAt(index, 5).toString();
                    String playerAth = tableModel.getValueAt(index, 6).toString();
                    String playerAtt = tableModel.getValueAt(index, 7).toString();
                    String playerDef = tableModel.getValueAt(index, 8).toString();
                    String playerSoc = tableModel.getValueAt(index, 9).toString();

                    jerseyNumber.setEnabled(false);
                    jerseyNumber.setText(number);

                    playerName.setText(name);
                    playerName.setBorder(null);

                    playerAge.setText(age);
                    playerAge.setBorder(null);

                    playerNationality.setText(nationality);
                    playerNationality.setBorder(null);

                    playerPosition.setSelectedItem(position);

                    playerDominantFoot.setSelectedItem(foot);

                    athleticism.setText(playerAth);
                    athleticism.setBorder(null);

                    attackingSkills.setText(playerAtt);
                    attackingSkills.setBorder(null);

                    defense.setText(playerDef);
                    defense.setBorder(null);

                    soccerSkills.setText(playerSoc);
                    soccerSkills.setBorder(null);
                }
            }

        });
        topRow.add(updatePlayer);

        releasePlayer.setPreferredSize(new Dimension(200, 35));
        releasePlayer.setBackground(Color.cyan);
        //release player button action listener
        releasePlayer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int index = table.getSelectedRow();

                if((index == -1)) {
                    JOptionPane.showMessageDialog(frame, "Please select a a player from the roster");
                }

                else if (index != -1){

                    //the data needed
                    String id = tableModel.getValueAt(index, 0).toString();
                    String name = tableModel.getValueAt(index, 1).toString();
                    String age = tableModel.getValueAt(index, 2).toString();
                    String nat = tableModel.getValueAt(index, 3).toString();
                    String pos = tableModel.getValueAt(index, 4).toString();
                    String dom = tableModel.getValueAt(index, 5).toString();
                    String ath = tableModel.getValueAt(index, 6).toString();
                    String att = tableModel.getValueAt(index, 7).toString();
                    String def = tableModel.getValueAt(index, 8).toString();
                    String soc = tableModel.getValueAt(index, 9).toString();

                    boolean succcessRelease = soccerPlayer.releasePlayer(id , usertableName);

                    if(succcessRelease == false)
                    {
                        JOptionPane.showMessageDialog(frame, "Error: on releasing player" );

                    }
                    else{

                        soccerPlayer.mySQLData(tableModel, columns, usertableName);
                        JOptionPane.showMessageDialog(frame, "Successfully Release Player: \n" +
                                "Jersey Number: " + id + "\n" +
                                "Player Name: " + name + "\n" +
                                "Age: " + age + "\n" +
                                "Nationality: " + nat + "\n" +
                                "Position: " + pos + "\n" +
                                "Dominant Foot: " + dom + "\n" +
                                "Athleticism: " + ath + "\n" +
                                "Attacking Skill: " + att + "\n" +
                                "Defense: " + def + "\n" +
                                "Soccer Skill: " + soc + "\n");

                    }

                }
            }
        });
        topRow.add(releasePlayer);

        /*
             Frame GUI Middles area: inputs and display
         */

        //forms and data
        input.setVisible(false);
        input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
        input.add(Box.createVerticalGlue());


        jerseyLabel.setPreferredSize(new Dimension(300, 30));
        jerseyLabel.setHorizontalAlignment(SwingConstants.LEFT);
        jerseyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(jerseyLabel);

        input.setBackground(Color.lightGray);
        jerseyNumber = new JTextField("");
        jerseyNumber.setPreferredSize(new Dimension(300,30));
        jerseyNumber.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(jerseyNumber);
        //Checking jersey Number
        jerseyNumber.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {

                String inputVerify = jerseyNumber.getText();
                boolean pass = inputCheck.jerseyNumber(tableModel, inputVerify);

                if(pass == false){
                    jerseyNumber.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    jerseyNumber.setText("");
                    return false;

                }
                else if (pass == true){
                    //JOptionPane.showMessageDialog(frame,"Successful");
                    jerseyNumber.setBorder(BorderFactory.createLineBorder(Color.green, 3));
                    return true;
                }
                return pass;
            }
        });
        middleRow.add(input);

        nameLabel.setPreferredSize(new Dimension(300, 30));
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(nameLabel);
        input.setBackground(Color.lightGray);
        playerName = new JTextField("");
        playerName.setPreferredSize(new Dimension(300,30));
        playerName.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(playerName);

        //Checking player name
        playerName.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {

                String inputVerify = playerName.getText();
                boolean pass = inputCheck.playerInfo(inputVerify);

                if(pass == false){
                    playerName.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    playerName.setText("");
                    return false;

                }
                else if (pass == true){
                    //JOptionPane.showMessageDialog(frame,"Successful");
                    playerName.setBorder(BorderFactory.createLineBorder(Color.green, 3));
                    return true;
                }
                return pass;
            }
        });
        middleRow.add(input);

        ageLabel.setPreferredSize(new Dimension(300, 30));
        input.setBackground(Color.lightGray);
        ageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(ageLabel);
        playerAge = new JTextField("");
        playerAge.setPreferredSize(new Dimension(300,30));
        playerAge.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(playerAge);
        //Checking player age
        playerAge.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {

                String inputVerify = playerAge.getText();
                boolean pass = inputCheck.playerAge(inputVerify);

                if(pass == false){
                    playerAge.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    playerAge.setText("");
                    return false;

                }
                else if (pass == true){
                    //JOptionPane.showMessageDialog(frame,"Successful");
                    playerAge.setBorder(BorderFactory.createLineBorder(Color.green, 3));
                    return true;
                }
                return pass;
            }
        });
        middleRow.add(input);

        nationalityLabel.setPreferredSize(new Dimension(300, 30));
        nationalityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(nationalityLabel);
        input.setBackground(Color.lightGray);
        playerNationality = new JTextField("");
        playerNationality.setPreferredSize(new Dimension(300,30));
        playerNationality.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(playerNationality);
        //Checking player nationality
        playerNationality.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {

                String inputVerify = playerNationality.getText();
                boolean pass = inputCheck.playerInfo(inputVerify);

                if(pass == false){
                    playerNationality.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    playerNationality.setText("");
                    return false;

                }
                else if (pass == true){
                    //JOptionPane.showMessageDialog(frame,"Successful");
                    playerNationality.setBorder(BorderFactory.createLineBorder(Color.green, 3));
                    return true;
                }
                return pass;
            }
        });
        middleRow.add(input);

        positionsLabel.setPreferredSize(new Dimension(300, 30));
        positionsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(positionsLabel);
        input.setBackground(Color.lightGray);
        playerPosition = new JComboBox<>(position);
        playerPosition.setPreferredSize(new Dimension(300,30));
        playerPosition.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(playerPosition);
        middleRow.add(input);

        footsLabel.setPreferredSize(new Dimension(300, 30));
        footsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(footsLabel);
        input.setBackground(Color.lightGray);
        playerDominantFoot = new JComboBox<>(foot);
        playerDominantFoot.setPreferredSize(new Dimension(300,30));
        playerDominantFoot.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(playerDominantFoot);
        middleRow.add(input);

        athLabel.setPreferredSize(new Dimension(300, 30));
        athLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(athLabel);
        input.setBackground(Color.lightGray);
        athleticism = new JTextField("");
        athleticism.setPreferredSize(new Dimension(300,30));
        athleticism.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(athleticism);
        //Checking player athleticism
        athleticism.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {

                String inputVerify =  athleticism.getText();
                boolean pass = inputCheck.playerStat(inputVerify);

                if(pass == false){
                    athleticism.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    athleticism.setText("");
                    return false;

                }
                else if (pass == true){
                    //JOptionPane.showMessageDialog(frame,"Successful");
                    athleticism.setBorder(BorderFactory.createLineBorder(Color.green, 3));
                    return true;
                }
                return pass;
            }
        });
        middleRow.add(input);

        attLabel.setPreferredSize(new Dimension(300, 30));
        attLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(attLabel);
        input.setBackground(Color.lightGray);
        attackingSkills = new JTextField("");
        attackingSkills.setPreferredSize(new Dimension(300,30));
        attackingSkills.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(attackingSkills);
        //Checking player attacking skills
        attackingSkills.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {

                String inputVerify = attackingSkills.getText();
                boolean pass = inputCheck.playerStat(inputVerify);

                if(pass == false){
                    attackingSkills.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    attackingSkills.setText("");
                    return false;

                }
                else if (pass == true){
                    //JOptionPane.showMessageDialog(frame,"Successful");
                    attackingSkills.setBorder(BorderFactory.createLineBorder(Color.green , 3));
                    return true;
                }
                return pass;
            }
        });
        middleRow.add(input);

        defLabel.setPreferredSize(new Dimension(300, 30));
        defLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(defLabel);
        input.setBackground(Color.lightGray);
        defense = new JTextField("");
        defense.setPreferredSize(new Dimension(300,30));
        defense.setAlignmentX(Component.LEFT_ALIGNMENT);
        //Checking player defense
        defense.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {

                String inputVerify = defense.getText();
                boolean pass = inputCheck.playerStat(inputVerify);

                if(pass == false){
                    defense.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    defense.setText("");
                    return false;

                }
                else if (pass == true){
                    //JOptionPane.showMessageDialog(frame,"Successful");
                    defense.setBorder(BorderFactory.createLineBorder(Color.green, 3));
                    return true;
                }
                return pass;
            }
        });
        input.add(defense);

        middleRow.add(input);

        socLabel.setPreferredSize(new Dimension(300, 30));
        socLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(socLabel);
        input.setBackground(Color.lightGray);
        soccerSkills = new JTextField("");
        soccerSkills.setPreferredSize(new Dimension(300,30));
        soccerSkills.setAlignmentX(Component.LEFT_ALIGNMENT);
        input.add(soccerSkills);
        //Checking player defense
        soccerSkills.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {

                String inputVerify = soccerSkills.getText();
                boolean pass = inputCheck.playerStat(inputVerify);

                if(pass == false){
                    soccerSkills.setBorder(BorderFactory.createLineBorder(Color.red, 3));
                    soccerSkills.setText("");
                    return false;

                }
                else if (pass == true){
                    //JOptionPane.showMessageDialog(frame,"Successful");
                    soccerSkills.setBorder(BorderFactory.createLineBorder(Color.green, 3));
                    return true;
                }
                return pass;
            }
        });
        middleRow.add(input);

        addButton.setPreferredSize(new Dimension(200, 35));
        addButton.setBackground(Color.cyan);
        //addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //add button action listener
        addButton.addActionListener(e -> {

            String inputJersey = jerseyNumber.getText();
            String inputName = playerName.getText();
            String inputAge = playerAge.getText();
            String inputNationality = playerNationality.getText();
            String inputPosition  = Objects.requireNonNull(playerPosition.getSelectedItem()).toString();
            String inputDominantFoot = Objects.requireNonNull(playerDominantFoot.getSelectedItem()).toString();
            String ath = athleticism.getText();
            String att = attackingSkills.getText();
            String def = defense.getText();
            String soc = soccerSkills.getText();

            if(inputJersey.isEmpty() || inputName.isEmpty() || inputAge.isEmpty() || inputNationality.isEmpty() || ath.isEmpty() || att.isEmpty() || def.isEmpty() ) {
                JOptionPane.showMessageDialog(frame, "Please enter all the information");
            }

            else{

                boolean successSign = false;
                String newPlayer= inputJersey +"-" + inputName + "-" + inputAge + "-" + inputNationality + "-" + inputPosition + "-" + inputDominantFoot + "-" + ath + "-" + att + "-" + def + "-" + soc;
                successSign = soccerPlayer.signPlayer(newPlayer , usertableName);

                if(successSign == false){
                    JOptionPane.showMessageDialog(frame, " Error: inserting data to the database");
                }
                else{
                    //UPDATE the table
                    soccerPlayer.mySQLData(tableModel, columns, usertableName);
                    JOptionPane.showMessageDialog(frame,    "Successfully Signed Player: \n" +
                            "Jersey Number: " + inputJersey + "\n" +
                            "Player Name: " + inputName + "\n" +
                            "Age: " + inputAge + "\n" +
                            "Nationality: " + inputNationality + "\n" +
                            "Position: " + inputPosition + "\n" +
                            "Dominant Foot: " + inputDominantFoot + "\n" +
                            "Athleticism: " + ath + "\n" +
                            "Attacking Skill: " + att + "\n" +
                            "Defense: " + def + "\n" +
                            "Soccer Skill: " + soc + "\n");

                    jerseyNumber.setText("");
                    jerseyNumber.setBorder(null);

                    playerName.setText("");
                    playerName.setBorder(null);

                    playerAge.setText("");
                    playerAge.setBorder(null);

                    playerNationality.setText("");
                    playerNationality.setBorder(null);

                    athleticism.setText("");
                    athleticism.setBorder(null);

                    attackingSkills.setText("");
                    attackingSkills.setBorder(null);

                    defense.setText("");
                    defense.setBorder(null);

                    soccerSkills.setText("");
                    soccerSkills.setBorder(null);

                    input.setVisible(false);

                }
            }

        });
        input.add(addButton);

        updateButton.setPreferredSize(new Dimension(200, 35));
        updateButton.setBackground(Color.cyan);
        //add button action listener
        updateButton.addActionListener(e -> {

            String inputJersey = jerseyNumber.getText();
            String inputName = playerName.getText();
            String inputAge = playerAge.getText();
            String inputNationality = playerNationality.getText();
            String inputPosition  = Objects.requireNonNull(playerPosition.getSelectedItem()).toString();
            String inputDominantFoot = Objects.requireNonNull(playerDominantFoot.getSelectedItem()).toString();
            String ath = athleticism.getText();
            String att = attackingSkills.getText();
            String def = defense.getText();
            String soc = soccerSkills.getText();

            if(inputJersey.isEmpty() || inputName.isEmpty() || inputAge.isEmpty() || inputNationality.isEmpty() || ath.isEmpty() || att.isEmpty() || def.isEmpty() ) {
                JOptionPane.showMessageDialog(frame, "Please enter all the information");
            }

            else{

                boolean successUpdate;
                String newPlayer= inputJersey +"-" + inputName + "-" + inputAge + "-" + inputNationality + "-" + inputPosition + "-" + inputDominantFoot + "-" + ath + "-" + att + "-" + def + "-" + soc;
                successUpdate = soccerPlayer.updatePlayer(newPlayer, usertableName);

                //UPDATE the table
                if(successUpdate == false){
                    JOptionPane.showMessageDialog(frame, "Error: updating data to the database");
                }
                else{

                    soccerPlayer.mySQLData(tableModel, columns, usertableName);
                    JOptionPane.showMessageDialog(frame,  "\n==============================================\n" +
                            "Update Player Information: \n" +
                            "Jersey Number: " + inputJersey + "\n" +
                            "Player Name: " + inputName + "\n" +
                            "Age: " + inputAge + "\n" +
                            "Nationality: " + inputNationality + "\n" +
                            "Position: " + inputPosition + "\n" +
                            "Dominant Foot: " + inputDominantFoot + "\n" +
                            "Athleticism: " + ath + "\n" +
                            "Attacking Skill: " + att + "\n" +
                            "Defense: " + def + "\n" +
                            "Soccer Skill: " + soc + "\n" +
                            "==============================================\n");

                    jerseyNumber.setText("");
                    jerseyNumber.setBorder(null);

                    playerName.setText("");
                    playerName.setBorder(null);

                    playerAge.setText("");
                    playerAge.setBorder(null);

                    playerNationality.setText("");
                    playerNationality.setBorder(null);

                    athleticism.setText("");
                    athleticism.setBorder(null);

                    attackingSkills.setText("");
                    attackingSkills.setBorder(null);

                    defense.setText("");
                    defense.setBorder(null);

                    soccerSkills.setText("");
                    soccerSkills.setBorder(null);

                    input.setVisible(false);
                }
            }
        });
        input.add(updateButton);

        scrollPaneTable.setPreferredSize(new Dimension(900, 500));
        scrollPaneTable .setFont(new Font("Arial", Font.PLAIN, 15));
        middleRow.add(scrollPaneTable);

         /*
             Frame GUI button area : exit
         */
        exit.setPreferredSize(new Dimension(200, 35));
        exit.setForeground(Color.lightGray);
        exit.setBackground(Color.red);
        //Exit button action listener
        exit.addActionListener(e -> {

            boolean exit = false;
            exit = soccerPlayer.disconnectmySQL();

            if(exit == true) {
                JOptionPane.showMessageDialog(frame, "Successfully exit the database.");
                System.exit(0);
            }
            else{
                JOptionPane.showMessageDialog(frame, "Error when exiting the database.");
            }
        });
        bottomRow.add(exit);

        frame.add(topRow);
        frame.add(middleRow);
        frame.add(bottomRow);
        frame.pack();
        frame.setVisible(false);

    }

}
