import java.util.*;

public class Guitar {
    public Guitar() {
        //normal guitars have 22 frets, 6 strings
        fret = 22;
        string = 6;
    }

    public void updateChordList() { chordList = new ReadChord().readList(); }

    public void printChordList() {
        String prevName = chordList.get(0).getChordName();
        System.out.println(prevName);
        for (int i = 1; i < chordList.size(); i++) {
            String chordName = chordList.get(i).getChordName();
            prevName = chordList.get(i - 1).getChordName();
            if(prevName.charAt(0) != chordName.charAt(0))
                System.out.println();
            System.out.println(chordName);
        }
    }

    public static List<Position> getPositionList() { return positionList; }

    public static Chord getChord(String s) {
        for(Chord c : chordList) {
            if(c.getChordName().equals(s)) return c;
        }
        return null;
    }

    public void addChord(Chord newChord) {
        //check if chord is exist
        if (Guitar.getChord(newChord.getChordName()) != null) {
            System.out.println("Chord Already Exist");
            return;
        }

        boolean writeSuccess = new WriteChord().writeFile(newChord);
        if(writeSuccess) {
            System.out.println("Chord Add Success!");
        } else {
            System.out.println("Chord Add Failed!");
        }
    }

    //get list sets
    private static List<Chord> chordList = new ReadChord().readList();
    private static List<Position> positionList = new ReadPosition().readList();

    //it must not be changed after set
    //open strings are string when you make a sound without pushing it with your finger
    protected final List<String> openStrings = new ArrayList<>(Arrays.asList("", "E", "A", "D", "G", "B", "E"));
    protected final int fret;
    protected final int string;
}
