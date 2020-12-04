import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chord {
    public Chord(String chordName) {
        this.chordName = chordName;
        setChord(chordName);
    }

    @Override //make Chord to String | form -> ChordName StringNum FretNum StringNum FretNum ...
    public String toString() {
        StringBuilder res = new StringBuilder(chordName);
        for(pair<Integer, Integer> p : push)
            res.append(" " + p.first.toString() + " " + p.second.toString());
        return res.toString();
    }

    //make String to Chord
    public void setChord(String chordString) {
        chordName = "";
        push.clear();
        String[] chordInfo = chordString.split(" ");
        chordName = chordInfo[0];
        for (int i = 1; i < chordInfo.length; i += 2) {
            pair<Integer, Integer> info = new pair<>(Integer.parseInt(chordInfo[i]), Integer.parseInt(chordInfo[i]));
            push.add(info);
        }
    }

    public boolean isPushed(int string, int fret) {
        for(pair<Integer, Integer> p : push) {
            if(p.first == string && p.second == fret) return true;
        }
        return false;
    }

    public String getChordName() { return chordName; }
    public List<pair<Integer, Integer>> getPushList() { return push; }

    //name of chord
    private String chordName;

    //coords which guitar player should push when play this chord
    //pair<string num, fret num>
    private List<pair<Integer, Integer>> push;
    public static List<String> openStrings = new ArrayList<>(Arrays.asList("E0", "A0", "D0", "G1", "B1", "E2"));
}
