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
      }
    }
  }

public class GUI extends JPanel{
    static GridBagConstraints gbc;
    static Container container;
    static ButtonGroup tenseGroup = new ButtonGroup();
    static ButtonGroup pronounGroup = new ButtonGroup();

    public void parameterSetup(){
        // Initializations
        GridBagConstraints gbctemp1  = new GridBagConstraints();
        JRadioButton temp;
        JLabel tensesLabel = new JLabel();
        JLabel pronounsLabel = new JLabel();

        // Availible Conjugations
        String[] tenses = new String[]{"present        ", "past              ", "perfect        ", "pastPerfect", "future          ", "conditional"};
        String[] pronouns = new String[]{"ich", "du  ", "er  ", "wir", "ihr", "sie"};

        // Tense Label
        gbctemp1.gridx = -6;
        gbctemp1.gridy = -1;
        container.add(tensesLabel, gbctemp1);

        // Tense buttons starter grid
        gbctemp1.gridx = -6;
        gbctemp1.gridy= 0;

        for (String z : tenses){
            temp = new JRadioButton(z);
            temp.setActionCommand(z);
            tenseGroup.add(temp);
            gbctemp1.gridy += 1;
            container.add(temp, gbctemp1);
        }
        verbInputSetup();
        GridBagConstraints gbctemp2  = new GridBagConstraints();
        // Pronouns Label
        gbctemp2.gridx = 11;
        gbctemp2.gridy = -1;
        container.add(pronounsLabel, gbctemp2);

        // Pronoun buttons
        gbctemp2.gridx = 11;
        gbctemp2.gridy= 0;

        for (String z : pronouns){
            temp = new JRadioButton(z);
            temp.setActionCommand(z);
            pronounGroup.add(temp);
            gbctemp2.gridy += 1;
            container.add(temp, gbctemp2);
        }
    }

    public void verbInputSetup(){

        JLabel instructions = new JLabel();
        instructions.setText("Type the infinitive:");
        gbc.gridx = 5;
        gbc.gridy = 0;
        container.add(instructions, gbc);

    }

    public GUI(){
        gbc = new GridBagConstraints();
        parameterSetup();
        // verbInputSetup();
    }



    public static void main(String[] args) {
        // GUI gui = new GUI();
        JFrame frame = new JFrame();
        container = frame.getContentPane();
        container.setLayout(new GridBagLayout());
        container.add(new GUI());
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
