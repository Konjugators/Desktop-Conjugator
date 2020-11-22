package desktop;

public class verbFinder{
    
    public static String getConjugation(String infinitive, String pronoun, String tense){
        String[] temp = allMaps.map.get(infinitive).split(",");
        for (int i = 0; i < temp.length; i++){
            temp[i] = temp[i].strip();
        }
        
        int index=0;
        switch (tense) {
            case "present":
                index += 0;
                break;
            case "past":
                index += 6;
                break;
            case "perfect":
                index += 12;
                break;
            case "pastPerfect":
                index += 18;
                break;
            case "future":
                index += 24;
                break;
            case "conditional":
                index += 30;
                break;
            default:
                break;
        }
        switch (pronoun) {
            case ("ich"):
                break;
            case ("du"):
                index += 1;
                break;
            case ("er"):
                index += 2;
                break;
            case ("wir"):
                index += 3;
                break;
            case ("ihr"):
                index += 4;
                break;
            case ("sie"):
                index += 5;
                break;
            default:
                break;
        }
        return temp[index];
    }

    public static void main(String[] args){
        allMaps.setup1();
        allMaps.setup2();
        allMaps.setup3();
        allMaps.setup4();
        System.out.println(getConjugation("fahren", "er", "pastPerfect"));
    }
}