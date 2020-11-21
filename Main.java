import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import desktop.conjugator;
import desktop.verb;
import desktop.verbFind;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String arg1 = args[0];
        String arg2 = args[1];
        String arg3 = args[2];
        verbFind.verbDict();
        verb temp = verbFind.getVerbInterfaceMap().get(arg1);
        HashMap<String, Method> test = new HashMap<String, Method>();
        ArrayList<String> Conjugations = new ArrayList<String>();
        switch (arg3) {
            case ("present"):
                Conjugations = temp.getPresentConjugations();
                break;
            case ("past"):
                Conjugations = temp.getPastConjugations();
                break;
            case ("perfect"):
                Conjugations = temp.getPerfectConjugations();
                break;
            case ("past-perfect"):
                Conjugations = temp.getPastPerfectConjugations();
                break;
            case ("future"):
                Conjugations = temp.getFutureConjugations();
                break;
            default:
                Conjugations = temp.getPresentConjugations();
                break;
        }
        conjugator.conjugatorSetup();
        System.out.println(conjugator.pronounConjugate(Conjugations, arg2));
    }
}

//TODO: Checks (to prevent some thrown exceptions)
//TODO: Formatting Method