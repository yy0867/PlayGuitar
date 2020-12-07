import java.util.*;

public class Guitar {
    public Guitar() {
        //normal guitars have 22 frets, 6 strings
        fret = 22;
        string = 6;
    }

    public void printChordList() {
        for (int i = 0; i < chordList.size(); i++) {
            System.out.println(chordList.get(i).getChordName() + "   ");
            if((i + 1) % 5 == 0)
                System.out.println();
        }
    }

    public Chord getChord(String s) {
        for(Chord c : chordList) {
            if(c.getChordName().equals(s)) return c;
        }
        return null;
    }

    //it must not be changed after set
    //get list sets
    private final List<Chord> chordList = new ReadChord().readList();
    //private static final List<Position> positions = new ReadPosition().readList();
    //open strings are string when you make a sound without pushing it with your finger
    protected final List<String> openStrings = new ArrayList<>(Arrays.asList("", "E", "A", "D", "G", "B", "E"));
    protected final int fret;
    protected final int string;
}
