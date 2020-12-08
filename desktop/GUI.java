package desktop;

// awt imports
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

// Swing imports
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;


class ButtonListener implements ActionListener {
    public String clickedTense;
    public int clickedPronoun;
    Border blackline;
    ButtonListener() {
        // Initialize border for conjugated verb
        blackline = BorderFactory.createLineBorder(Color.BLACK);
    }

    // Get radiobutton pronoun
    public static String getTenseClicked() {
        for (Enumeration<AbstractButton> buttons = GUI.tenseGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().strip();
            }
        }
        return "";
    }

    // Get radiobutton pronoun
    public static String getPronounClicked() {
        for (Enumeration<AbstractButton> buttons = GUI.pronounGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().strip();
            }
        }
        return "";
    }

    // Quick method to change grid bag constraints
    public static void changeGBCGrid(int x, int y) {
        GUI.gbc.gridx = x;
        GUI.gbc.gridy = y;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Conjugate!")) {
            GUI.conjugatedVerb.setText("verb is " + GUI.infinitiveField.getText());
            GUI.clickedAmount += 1;
        }

        if (GUI.clickedAmount >= 1) {
            // Display conjugated verb
            changeGBCGrid(1, 8);
            GUI.gbc.ipadx = 0;
            GUI.gbc.ipady = 0;
            String temp = verbFinder.getConjugation(GUI.infinitiveField.getText(), getPronounClicked(),
                    getTenseClicked());
            //"                   "+
            GUI.conjugatedLabel.setText("      "+temp+"      ");
            GUI.conjugatedLabel.setBorder(blackline);
            GUI.conjugatedLabel.setMinimumSize(new Dimension(200, 50));
            if (GUI.clickedAmount == 1) {
                GUI.german.add(GUI.conjugatedLabel, GUI.gbc);
            }
            // GUI.conjugatedLabel.setText("");
        }
    }
}

public class GUI extends JPanel {

    private static final long serialVersionUID = 1L;
    public static GridBagLayout gbl = new GridBagLayout();
    public static GridBagConstraints gbc = new GridBagConstraints();
    public static Container container;
    public static ButtonGroup tenseGroup = new ButtonGroup();
    public static ButtonGroup pronounGroup = new ButtonGroup();
    public static JTextField infinitiveField;
    public static JButton submitButton;
    public static JLabel conjugatedVerb;
    public static Integer clickedAmount = 0;
    public static JLabel conjugatedLabel = new JLabel();
    public static JPanel paneller = new JPanel();
    public static JTabbedPane pane = new JTabbedPane();
    public static JPanel german = new JPanel();

    public void parameterSetup() {
        // Initializations
        JRadioButton temp;
        JLabel tensesLabel = new JLabel();
        JLabel pronounsLabel = new JLabel();

        // Availible Conjugations
        String[] tenses = new String[] { "present        ", "past              ", "perfect        ", "pastPerfect",
                "future          ", "conditional" };
        String[] pronouns = new String[] { "ich", "du  ", "er  ", "wir", "ihr", "sie" };

        // Initial Constraints
        GridBagConstraints gbctemp1 = new GridBagConstraints();
        gbctemp1.weightx = 0.5;

        // Tense Label
        gbctemp1.gridx = -1;
        gbctemp1.gridy = -1;
        tensesLabel.setText("Tenses: ");
        german.add(tensesLabel, gbctemp1);

        // Tense buttons starter grid
        gbctemp1.gridx = -1;
        gbctemp1.gridy = 0;

        // Add tense buttons
        for (String z : tenses) {
            temp = new JRadioButton(z);
            temp.setSelected(z.equals("present        "));
            temp.setActionCommand(z);
            tenseGroup.add(temp);
            gbctemp1.gridy += 1;
            gbl.setConstraints(temp, gbctemp1);
            german.add(temp, gbctemp1);
        }

        // Pronoun Label
        gbctemp1.gridx = 1;
        gbctemp1.gridy = -1;
        pronounsLabel.setText("Pronouns: ");
        german.add(pronounsLabel, gbctemp1);

        // Pronoun buttons starter grid
        gbctemp1.gridx = 1;
        gbctemp1.gridy = 0;

        // Add pronoun buttons
        for (String z : pronouns) {
            temp = new JRadioButton(z);
            temp.setActionCommand(z);
            temp.setSelected(z.equals("ich"));
            pronounGroup.add(temp);
            gbctemp1.gridy += 1;
            gbl.setConstraints(temp, gbctemp1);
            german.add(temp, gbctemp1);
        }
    }

    public void verbInputSetup() {
        // Instructions Label
        GridBagConstraints gbctemp1 = new GridBagConstraints();
        JLabel instructions = new JLabel();
        instructions.setText("Type the infinitive:");
        gbctemp1.gridx = 2;
        gbctemp1.gridy = -1;
        german.add(instructions, gbctemp1);

        // Pronouns Entry
        gbctemp1.gridx = 2;
        gbctemp1.gridy = 1;
        infinitiveField = new JTextField();
        infinitiveField.setColumns(14);
        german.add(infinitiveField, gbctemp1);

        // Enter button
        gbctemp1.gridx = 2;
        gbctemp1.gridy = 3;
        submitButton = new JButton("Conjugate!");
        submitButton.addActionListener(new ButtonListener());
        german.add(submitButton, gbctemp1);

        // Conjugated Verb placement
        gbctemp1.gridx = 2;
        gbctemp1.gridy = 4;
        conjugatedVerb = new JLabel();
        conjugatedVerb.setText("");
        german.add(conjugatedVerb, gbctemp1);
    }

    public GUI() {
        german.setLayout(gbl);
        pane.addTab("HOHO", german);
        parameterSetup();
        verbInputSetup();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        container = frame.getContentPane();
        // JPanel pannelllll = new JPanel();
        pane = new JTabbedPane();
        paneller = new JPanel();

        // pannelllll.add(pane);

        paneller.setLayout(gbl);
        // paneller.add(pane);
        
        paneller.add(new GUI());
        // container.add(pane);


        frame.add(paneller);
        frame.add(pane);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
        verbFinder.setup();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
