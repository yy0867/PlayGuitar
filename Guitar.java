import java.util.*;
import java.util.function.Predicate;

public class Guitar {
    public Guitar() {
        //normal guitars have 22 frets, 6 strings
        fret = 22;
        string = 6;
        //get lists
        chordList = new ReadChord().readList();
        positions = new ReadPosition().readList();
    }

    public void printChordList() {
        for (int i = 0; i < chordList.size(); i++) {
            System.out.println(chordList.get(i).getChordName() + "   ");
            if (i != 0 && i % 4 == 0)
                System.out.println();
        }
    }

    public boolean isExistChord(String s) {
        for(Chord c : chordList) {
            if(s == c.getChordName()) return true;
        }
        return false;
    }

    //it must not be changed after set
    private final List<Chord> chordList;
    private final List<Position> positions;
    //open strings are string when you make a sound without pushing it with your finger
    protected final List<String> openStrings = new ArrayList<>(Arrays.asList("", "E", "A", "D", "G", "B", "E"));
    protected final int fret;
    protected final int string;
}
