package desktop;
import java.awt.Container;
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

// // import jdk.internal.org.jline.terminal.MouseEvent.Button;
// class ButtonListener implements ActionListener {

//     ButtonListener() {
//     }

//     // public void actionPerformed(ActionEvent e) {
//     //     if (e.getActionCommand().equals("Button1")) {
//     //         Main.nameLabel.setText(Main.infinitiveField.getText());
//     //     }
//     // }
// }

class Initialization{

}

public class GUI extends JPanel{
    static GridBagConstraints gbc;
    static Container container;
    ButtonGroup tenseGroup = new ButtonGroup();
    ButtonGroup pronounGroup = new ButtonGroup();
    ButtonGroup conjugations;

    public void parameterSetup(){
        // Initializations
        GridBagConstraints gbctemp  = new GridBagConstraints();
        JRadioButton temp;
        JLabel tensesLabel = new JLabel();
        JLabel pronounsLabel = new JLabel();

        // Availible Conjugations
        String[] tenses = new String[]{"present        ", "past              ", "perfect        ", "pastPerfect", "future          ", "conditional"};
        String[] pronouns = new String[]{"ich", "du  ", "er  ", "wir", "ihr", "sie"};

        // Tense Label
        gbctemp.gridx = -3;
        gbctemp.gridy = -1;
        container.add(tensesLabel, gbctemp);

        // Tense buttons starter grid
        gbctemp.gridx = -3;
        gbctemp.gridy= 0;
        
        for (String z : tenses){
            temp = new JRadioButton(z);
            temp.setActionCommand(z);
            tenseGroup.add(temp);
            gbctemp.gridy += 1;
            container.add(temp, gbctemp);
        }
        
        // Pronouns Label
        gbctemp.gridx = 3;
        gbctemp.gridy = -1;
        container.add(pronounsLabel, gbctemp);

        // Pronoun buttons
        gbctemp.gridx = 3;
        gbctemp.gridy= 0;

        for (String z : pronouns){
            temp = new JRadioButton(z);
            temp.setActionCommand(z);
            pronounGroup.add(temp);
            gbctemp.gridy += 1;
            container.add(temp, gbctemp);
        }
    }

    public GUI(){
        parameterSetup();
    }



    public static void main(String[] args) {
        // GUI gui = new GUI();
        JFrame frame = new JFrame();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        container = frame.getContentPane();
        container.setLayout(new GridBagLayout());
        container.add(new GUI());
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
