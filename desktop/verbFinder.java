package desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Scanner;

public class verbFinder{
    
    public static ArrayList<String> Infinitives;
    public static ArrayList<ArrayList<String>> verbs;
    public static void readFile() throws FileNotFoundException{
        Scanner s;
        File f = new File(new File("desktop/verbs.csv").getAbsolutePath());
        s = new Scanner(f); //.useDelimiter(",");
        ArrayList<String> infinitiveList = new ArrayList<String>();
        ArrayList<ArrayList<String>> verbList = new ArrayList<ArrayList<String>>();
        while(s.hasNextLine()){//} && lineNumber < 4){
            String line = s.nextLine();
            String[] conjugs = line.split(",");
            infinitiveList.add(conjugs[0].strip());
            ArrayList<String> templist = new ArrayList<String>();
            for (int i = 1; i < conjugs.length; i++){
                templist.add(conjugs[i].strip());
            }
            verbList.add(templist);
        }
        s.close();
        Infinitives = infinitiveList;
        verbs = verbList;
    }

    public static int findIndex(String str){
        return Infinitives.indexOf(str);
    }

    public static int linBinSearch(String str){
        char temp = str.substring(0, 1).toCharArray()[0];
        if (temp < 'd'){
            return Infinitives.subList(0, 1794).indexOf(str)+0;//.indexOf(str, 4156);
        }
        else if (temp >= 'd' && temp <= 'j'){
            return Infinitives.subList(1794, 3628).indexOf(str)+1794;
        }
        else if (temp > 'j' && temp <= 'o'){
            return Infinitives.subList(3628, 4470).indexOf(str)+3628;
        }
        else if (temp > 'o' && temp <= 'ü'){
            return Infinitives.subList(4470, 5817).indexOf(str)+4470;
        }
        else if (temp > 'ü' && temp <= 'z'){
            return Infinitives.subList(5817, Infinitives.size()).indexOf(str)+5817;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        verbFinder.readFile();
        String arg = "fahren";
        int z = verbFinder.linBinSearch(arg);
        System.out.println(z);
        System.out.println(verbFinder.Infinitives.get(z));
        System.out.println(verbFinder.verbs.get(z));
    }
}

//TODO Conjugation indices must be marked