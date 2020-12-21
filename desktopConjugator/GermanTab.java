package desktopConjugator;

import java.awt.*;
import java.util.Enumeration;
import javax.swing.*;
import java.awt.event.*;

public class GermanTab extends JPanel {
    public static GridBagLayout gbl = new GridBagLayout();
    public JPanel german = new JPanel();
    public static ButtonGroup tenseGroup = new ButtonGroup();
    public static ButtonGroup pronounGroup = new ButtonGroup();
    public static JLabel conjugatedVerb;
    public static JTextField infinitiveField;
    
    public static String getTenseClicked() {
        for (Enumeration<AbstractButton> buttons = GermanTab.tenseGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().strip();
            }
        }
        return "";
    }

    // Get radiobutton pronoun
    public static String getPronounClicked() {
        for (Enumeration<AbstractButton> buttons = GermanTab.pronounGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().strip();
            }
        }
        return "";
    }

    public void setupGerman(){
        JRadioButton temp;

        // Availible Conjugations
        String[] tenses = new String[] { "present        ", "past              ", "perfect        ", "pastPerfect",
                "future          ", "conditional" };
        String[] pronouns = new String[] { "ich", "du  ", "er  ", "wir", "ihr", "sie" };

        GridBagConstraints gbctemp = new GridBagConstraints();
        gbctemp.weightx = 0.5;

        // Tense Label
        gbctemp.gridx = -1; gbctemp.gridy = -1;
        german.add(new JLabel("Tenses: "), gbctemp);

        // Tense buttons starter grid
        gbctemp.gridx = -1; gbctemp.gridy = 0;

        // Add tense buttons
        for (String z : tenses) {
            temp = new JRadioButton(z);
            temp.setSelected(z.equals("present        "));
            temp.setActionCommand(z);
            tenseGroup.add(temp);
            gbctemp.gridy++;
            german.add(temp, gbctemp);
        }

        // Pronoun labels starter grid
        gbctemp.gridx = 1;
        gbctemp.gridy = -1;
        german.add(new JLabel("Pronouns: "), gbctemp);

        // Pronoun buttons starter grid
        gbctemp.gridx = 1; gbctemp.gridy = 0;

        // Add pronoun buttons
        for (String z : pronouns) {
            temp = new JRadioButton(z);
            temp.setActionCommand(z);
            temp.setSelected(z.equals("ich"));
            pronounGroup.add(temp);
            gbctemp.gridy++;
            german.add(temp, gbctemp);
        }

        JLabel instructions = new JLabel();
        instructions.setText("Type the infinitive:");
        gbctemp.gridx = 2; gbctemp.gridy = -1;
        german.add(instructions, gbctemp);

        // Pronouns Entry
        gbctemp.gridx = 2; gbctemp.gridy = 1;
        infinitiveField = new JTextField();
        infinitiveField.setColumns(14);
        german.add(infinitiveField, gbctemp);

        // Conjugated Verb placement
        gbctemp.gridx = 2; gbctemp.gridy = 4;
        conjugatedVerb = new JLabel("");
        german.add(conjugatedVerb, gbctemp);

        // Enter button
        gbctemp.gridx = 2; gbctemp.gridy = 3;
        var submitButton = new JButton("Conjugate!");
        class ButtonListener implements ActionListener{
        int clickedAmount = 0;
        
            public ButtonListener(){

            }
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (e.getActionCommand().equals("Conjugate!")) {
                    GermanTab.conjugatedVerb.setText("verb is " + GermanTab.infinitiveField.getText());
                    clickedAmount += 1;
                }
        
                if (clickedAmount >= 1) {
                    // Display conjugated verb
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 1; gbc.gridy = 8;
                    String temp = verbFinder.getConjugation(GermanTab.infinitiveField.getText(), GermanTab.getPronounClicked(),
                            GermanTab.getTenseClicked());
                    //"                   "+
                    GermanTab.conjugatedVerb.setText("      "+temp+"      ");
                    // GermanTab.conjugatedVerb.setBorder(blackline);
                    GermanTab.conjugatedVerb.setMinimumSize(new Dimension(200, 50));
                }
            }
        }
        submitButton.addActionListener(new ButtonListener());
        german.add(submitButton, gbctemp);

    }

    public GermanTab(){
        german.setLayout(gbl);
        setupGerman();
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        var pane = new JTabbedPane();

        verbFinder.setup();
        var z = new GermanTab();
        pane.addTab("German", z.german);
        frame.add(pane);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
