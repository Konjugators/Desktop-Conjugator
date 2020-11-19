package desktop;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class verbFind {
    private static HashMap<String, ArrayList<String>> verbInterfaceMap;
    
    public static ArrayList<String> findIndex(String v){
        return verbInterfaceMap.get(v);
    }
    
    public static void verbDict() throws FileNotFoundException{
        verbInterfaceMap = new HashMap<String, ArrayList<String>>();
        csvread.readFile();
        ArrayList<verb> csvverbs = csvread.getVerbs();
        for (verb z : csvverbs){
            verbInterfaceMap.put(z.getInfinitive(), z.getConjugations());
        }
    }

    public static HashMap<String, ArrayList<String>> getVerbInterfaceMap(){
        return verbInterfaceMap;
    }
}
