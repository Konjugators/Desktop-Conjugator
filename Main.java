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
  ButtonListener() {
  }

  public void actionPerformed(ActionEvent e) {
    // System.out.println(e.toString());
    if (e.getActionCommand().equals("Conjugate!")) {
      Main.infinitiveField.setText("HOHO");
    }
  }
}
public class Main extends JPanel {
    public static JLabel nameLabel;
    public static Container z;
    public static JTextField infinitiveField;
    public static ButtonGroup group;
    
    public Main() {
      GridBagConstraints gbc  = new GridBagConstraints();
      gbc.gridx = 5;
      gbc.gridy = 4;
      JButton btn1 = new JButton("Conjugate!");
      nameLabel  = new JLabel("Conjugate");
        btn1.addActionListener(new ButtonListener());
        z.add(btn1, gbc);
      gbc.gridx = 7;
        z.add(nameLabel, gbc);

      
      group = new ButtonGroup();
      JRadioButton aRadioButton = new JRadioButton("A");
      JRadioButton bRadioButton = new JRadioButton("B");
      infinitiveField = new JTextField("machen");
      aRadioButton.setActionCommand("hoho");
      bRadioButton.setActionCommand("BOHOBOB");

      gbc.gridx=0;
      gbc.gridy=0;
      z.add(infinitiveField);
      // aRadioButton.addActionListener(new ButtonListener());
      gbc.gridx = 4;
      gbc.gridy= -4;
      group.add(aRadioButton);
      group.add(bRadioButton);
      z.add(aRadioButton, gbc);
      gbc.gridx = 4;
      gbc.gridy= -8;
      z.add(bRadioButton, gbc);
      
      ButtonGroup group2 = new ButtonGroup();
      JRadioButton cRadioButton = new JRadioButton("C");
      JRadioButton dRadioButton = new JRadioButton("D");

      group2.add(cRadioButton); group2.add(dRadioButton);
      gbc.gridx = 6; gbc.gridy= -4;
      z.add(cRadioButton, gbc); gbc.gridx = 6; gbc.gridy= -8;
      z.add(dRadioButton, gbc);

    }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    GridBagConstraints gbc  = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    z = frame.getContentPane();
    frame.getContentPane().setLayout(new GridBagLayout());
    frame.getContentPane().add(new Main());
    
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
    
  }
}



//TODO: Checks (to prevent some thrown exceptions)
//TODO: Formatting Method