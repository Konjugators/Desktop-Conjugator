package desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
interface csvread{
    //public ArrayList<String> getCsvInfinitives();
    //public ArrayList<String> getCsvConjugations();
}
*/

public class csvread{ //implements csvread{
    public ArrayList<String> csvinfinitives;
    public ArrayList<ArrayList<String>> csvall;
    public static void readFile() throws FileNotFoundException{
        Scanner s;
        File f = new File(new File("desktop/verbs.csv").getAbsolutePath());
        s = new Scanner(f).useDelimiter(",");

        int lineNumber = 1;
        while(s.hasNextLine() && lineNumber < 10){
            String line = s.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        csvread.readFile();
    }
}
