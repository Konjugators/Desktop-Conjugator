package desktop;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class ButtonListener implements ActionListener {
    ButtonListener() {
    }

    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Conjugate!")) {
          System.out.println("Conjugated!");
      }
    }
  }

public class GUI extends JPanel{
    static GridBagLayout gbc;
    static Container container;
    static ButtonGroup tenseGroup = new ButtonGroup();
    static ButtonGroup pronounGroup = new ButtonGroup();
    public static JTextField infinitiveField;
    public static JButton submitButton;

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
            temp.setActionCommand(z);
            tenseGroup.add(temp);
            gbctemp1.gridy += 1;
            gbc.setConstraints(temp, gbctemp1);
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
            pronounGroup.add(temp);
            gbctemp2.gridy += 1;
            gbc.setConstraints(temp, gbctemp2);
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
        // submitButton.setSize(30, 30);
        container.add(submitButton, gbctemp1);
        
    }

    public GUI(){
        parameterSetup();
        verbInputSetup();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        container = frame.getContentPane();
        gbc = new GridBagLayout();
        container.setLayout(gbc);
        container.add(new GUI());
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
