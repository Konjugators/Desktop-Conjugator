import java.io.FileNotFoundException;
import desktop.verbFind;

// import desktop.*;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        verbFind.verbDict();
        verbFind.getVerbInterfaceMap().get("Infinitive").getPresentConjugations();
    }
}