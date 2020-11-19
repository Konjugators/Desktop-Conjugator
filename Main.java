import java.io.FileNotFoundException;
import java.util.ArrayList;

import desktop.conjugator;
import desktop.verb;
import desktop.verbFind;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        verbFind.verbDict();
        ArrayList<String> temp = verbFind.getVerbInterfaceMap().get("putzen").getPastConjugations();
        conjugator.conjugatorSetup();
        System.out.println(conjugator.pronounConjugate(temp, "er"));
    }
}

//TODO: Checks (to prevent some thrown exceptions)
//TODO: Formatting Method