import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class PlayGuitar {

    public static void main(String[] args) {
        //save chords list from file
        List<Chord> chordList = FileManager.readChordList();

        GuitarUI guitar = new GuitarUI();
        Scanner scanner = new Scanner(System.in);

        //user lambda to get chord from chordlist
        ChordList getList = (input) -> {
            for (Chord c : chordList) {
                if(c.getChordName() == input) return c;
            }
            return null;
        };

        while(true) {
            String userChordName = scanner.next();
            getList.getChord(userChordName);

            Chord userChord = getList.getChord(userChordName);

            /*Play Sound*/
            /*Print Guitar*/

            GuitarUI.clear();
        }
    }
}
