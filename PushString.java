import java.util.List;

public interface PushString {
    static boolean isPushed(int string, int fret, List<pair<Integer, Integer>> push) {
        //should push <string, fret> for playing "chordName"?
        for (pair<Integer, Integer> p : push) {
            if(p.first == string && p.second == fret)
                return true;
        }
        return false;
    }
}
