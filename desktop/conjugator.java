package desktop;

import java.util.ArrayList;
import java.util.HashMap;

public class conjugator {
    public static HashMap<String, Integer> conjugationMap = new HashMap<String, Integer>();
    
    public static void conjugatorSetup(){
        conjugationMap.put("ich", 0);
        conjugationMap.put("du", 1);
        conjugationMap.put("er", 2);
        conjugationMap.put("wir", 3);
        conjugationMap.put("ihr", 4);
        conjugationMap.put("sie", 5);
    }

    public static String pronounConjugate(ArrayList<String> list, String pronoun){
        return list.get(conjugationMap.get(pronoun));
    }
}