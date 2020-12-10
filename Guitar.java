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

        StringBuilder writeInfo = new StringBuilder(newChord.getChordName());
        for(pair<Integer, Integer> p : newChord.getPush()) {
            writeInfo.append(" " + p.first + " " + p.second);
        }

        boolean writeSuccess = new WriteChord().writeFile(writeInfo.toString());
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
