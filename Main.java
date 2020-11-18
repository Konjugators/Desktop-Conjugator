import javax.swing.*;

class GUI{
    public GUI(){
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}


class Main{
    public static void main(String[] args){
        System.out.println("Testing.");
        GUI test = new GUI();
    }
}