import javax.swing.*;

class GUI{
    public void GUI(){
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }
}


class Main{
    public static void main(String[] args){
        System.out.println("Testing.");
    }
}