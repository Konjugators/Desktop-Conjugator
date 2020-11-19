package desktop;

import java.util.ArrayList;
import java.util.Collections;

interface Innerverb {
    
}

public class verb {
    private String infinitive;
    private ArrayList<String> conjugations = new ArrayList<String>();
    
    public verb(String inf){
        this.infinitive = inf;
    }
    
    public void setConjugations(String[] conj){
        Collections.addAll(this.conjugations, conj);
    }

    public String getInfinitive(){
        return this.infinitive;
    }

    public ArrayList<String> getConjugations(){
        return this.conjugations;
    }

    public ArrayList<String> getPresentConjugations(){
        ArrayList<String> PresentConjugations;
        PresentConjugations = new ArrayList<String>(conjugations.subList(0, 6));
        return PresentConjugations;
    }

    public ArrayList<String> getPastConjugations(){
        ArrayList<String> PastConjugations;
        PastConjugations = new ArrayList<String>(conjugations.subList(6, 12));
        return PastConjugations;
    }

    public ArrayList<String> getPerfectConjugations(){
        ArrayList<String> PerfectConjugations;
        PerfectConjugations = new ArrayList<String>(conjugations.subList(12, 18));
        return PerfectConjugations;
    }

    public ArrayList<String> getPastPerfectConjugations(){
        ArrayList<String> PastPerfectConjugations;
        PastPerfectConjugations = new ArrayList<String>(conjugations.subList(18, 24));
        return PastPerfectConjugations;
    }

    public ArrayList<String> getFutureConjugations(){
        ArrayList<String> FutureConjugations;
        FutureConjugations = new ArrayList<String>(conjugations.subList(24, 30));
        return FutureConjugations;
    }

    public ArrayList<String> getConditionalConjugations(){
        ArrayList<String> ConditionalConjugations;
        ConditionalConjugations = new ArrayList<String>(conjugations.subList(12, 18));
        return ConditionalConjugations;
    }

    public void info(){
        System.out.println( "For the infinitive: " +
        this.infinitive + ", the conjugation list is: "
        +this.conjugations.toString() );
    }

}
