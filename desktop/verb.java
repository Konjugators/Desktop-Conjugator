package desktop;
import java.util.ArrayList;

public class verb {
    private String infinitive;
    private ArrayList<String> conjugations = new ArrayList<String>();
    
    verb(String inf){
        this.infinitive = inf;
    }
    
    public void setConjugations(ArrayList<String> conj){
        this.conjugations.addAll(conj);
    }

    public String getInfinitive(){
        return this.infinitive;
    }
    
    public ArrayList<String> getConjugations(){
        return this.conjugations;
    }
}
