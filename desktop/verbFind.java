package desktop;

import java.io.FileNotFoundException;
import java.util.ArrayList;
// import desktop.verb;

public class verbFind {
    
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<verb> csvverbs= csvread.readFile();
        int i = 1;
        for (verb z : csvverbs){
            z.info();
            if (i == 1){
                break;
            }
        }
    }
}
