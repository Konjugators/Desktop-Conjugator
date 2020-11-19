package desktop;
import desktop.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
/*
interface csvread{
    //public ArrayList<String> getCsvInfinitives();
    //public ArrayList<String> getCsvConjugations();
}
*/

public class csvread{ //implements csvread{
    public static ArrayList<verb> csvverbs = new ArrayList<verb>();
    public static void readFile() throws FileNotFoundException{
        Scanner s;
        File f = new File(new File("desktop/verbs.csv").getAbsolutePath());
        s = new Scanner(f).useDelimiter(",");

        int lineNumber = 1;
        while(s.hasNextLine() && lineNumber < 10){
            String line = s.nextLine();
            String[] conjugs = line.split(",");
            for (int i = 0; i < conjugs.length; i++){
                conjugs[i] = conjugs[i].strip();
            }
            verb temp = new verb(conjugs[0]);
            temp.setConjugations(Arrays.copyOfRange(conjugs, 1, conjugs.length));
            csvverbs.add(temp);
            //System.out.println("line " + lineNumber + " :" + conjugs);
            lineNumber++;
        }
        s.close();
    }

    public static void main(String[] args) throws FileNotFoundException{
        csvread.readFile();
    }
}
