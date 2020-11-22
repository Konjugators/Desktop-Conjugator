package desktop;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class ButtonListener implements ActionListener {
    public String clickedTense;
    public int clickedPronoun;
    ButtonListener() {
    }

    public static String getTenseClicked(){
        for (Enumeration<AbstractButton> buttons = GUI.tenseGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().strip();
            }
        }
        return "";
    }

    public static String getPronounClicked(){
        for (Enumeration<AbstractButton> buttons = GUI.pronounGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().strip();
            }
        }
        return "";
    }

    public static void changeGBCGrid(int x, int y){
        GUI.gbc.gridx = x;
        GUI.gbc.gridy = y;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Conjugate!")) {
            GUI.conjugatedVerb.setText("verb is "+GUI.infinitiveField.getText());
            GUI.clickedAmount += 1;
        }

        if (GUI.clickedAmount >= 1){
            // Placeholder Text
            // if (GUI.clickedAmount >= 2){
            //     GUI.container.remove(GUI.conjugatedLabel);
            // }
            changeGBCGrid(1, 7);
            GUI.gbc.ipadx = 0;
            GUI.gbc.ipady = 0;
            
            GUI.conjugatedLabel.setText(GUI.infinitiveField.getText());
            if (GUI.clickedAmount == 1){
                GUI.container.add(GUI.conjugatedLabel, GUI.gbc);
            }
            // GUI.conjugatedLabel.setText("");
        }
    }
  }

public class GUI extends JPanel{
    /**
     *
     */
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

    public void parameterSetup(){
        // Initializations
        JRadioButton temp;
        JLabel tensesLabel = new JLabel();
        JLabel pronounsLabel = new JLabel();


        // Availible Conjugations
        String[] tenses = new String[]{"present        ", "past              ", "perfect        ", "pastPerfect", "future          ", "conditional"};
        String[] pronouns = new String[]{"ich", "du  ", "er  ", "wir", "ihr", "sie"};

        //Initial Constraints
        GridBagConstraints gbctemp1  = new GridBagConstraints();
        gbctemp1.weightx = 0.5;

        // Tense Label
        gbctemp1.gridx = -1;
        gbctemp1.gridy = -1;
        tensesLabel.setText("Tenses: ");
        container.add(tensesLabel, gbctemp1);

        // Tense buttons starter grid
        gbctemp1.gridx = -1;
        gbctemp1.gridy= 0;

        for (String z : tenses){
            temp = new JRadioButton(z);
            temp.setSelected(z.equals("present        "));
            temp.setActionCommand(z);
            tenseGroup.add(temp);
            gbctemp1.gridy += 1;
            gbl.setConstraints(temp, gbctemp1);
            container.add(temp, gbctemp1);
        }

        // Initial Constraints
        GridBagConstraints gbctemp2  = new GridBagConstraints();
        gbctemp2.weightx = 0.5;

        // Pronouns Label
        gbctemp2.gridx = 1;
        gbctemp2.gridy = -1;
        pronounsLabel.setText("Pronouns: ");
        container.add(pronounsLabel, gbctemp2);

        // Pronoun buttons
        gbctemp2.gridx = 1;
        gbctemp2.gridy= 0;

        for (String z : pronouns){
            temp = new JRadioButton(z);
            temp.setActionCommand(z);
            temp.setSelected(z.equals("ich"));
            pronounGroup.add(temp);
            gbctemp2.gridy += 1;
            gbl.setConstraints(temp, gbctemp2);
            container.add(temp, gbctemp2);
        }
    }

    public void verbInputSetup(){
        // Instructions Label
        GridBagConstraints gbctemp1  = new GridBagConstraints();
        JLabel instructions = new JLabel();
        instructions.setText("Type the infinitive:");
        gbctemp1.gridx = 2;
        gbctemp1.gridy = -1;
        container.add(instructions, gbctemp1);

        // Pronouns Entry
        gbctemp1.gridx = 2;
        gbctemp1.gridy = 1;
        infinitiveField = new JTextField();
        infinitiveField.setColumns(14);
        container.add(infinitiveField, gbctemp1);

        // Enter button
        gbctemp1.gridx = 2;
        gbctemp1.gridy = 3;
        submitButton = new JButton("Conjugate!");
        submitButton.addActionListener(new ButtonListener());
        container.add(submitButton, gbctemp1);

        // Conjugated Verb placement
        gbctemp1.gridx = 2;
        gbctemp1.gridy = 4;
        conjugatedVerb = new JLabel();
        conjugatedVerb.setText("");
        container.add(conjugatedVerb, gbctemp1);
    }

    public GUI(){
        parameterSetup();
        verbInputSetup();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        container = frame.getContentPane();
        container.setLayout(gbl);
        container.add(new GUI());
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}