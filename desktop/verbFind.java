package desktop;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class verbFind {
    private static HashMap<String, verb> verbInterfaceMap
    = new HashMap<String, verb>();
    
    public static verb findIndex(String v){
        return verbInterfaceMap.get(v);
    }
    
    public static void verbDict() throws FileNotFoundException{
        csvread.readFile();
        ArrayList<verb> csvverbs = csvread.getVerbs();
        for (verb z : csvverbs){
            verbInterfaceMap.put(z.getInfinitive(), z);
        }
    }

    public static HashMap<String, verb> getVerbInterfaceMap(){
        return verbInterfaceMap;
    }
}
