import java.util.ArrayList;
import java.util.List;

public class Chord extends Thread implements PushString {

    public Chord(String chordName, List<pair<Integer, Integer>> push) {
        this.chordName = chordName;
        this.push = push;
    }

    public String getChordName() { return chordName; }
    public boolean isPushed(pair<Integer, Integer> p) {
        return PushString.isPushed(p.first, p.second, this.push);
    }

    public void playChord() {
        //play sets of position to make chord sound
        List<Position> play = new ArrayList<>();
        for (pair<Integer, Integer> p : push) {
            play.add(new Position(chordName, p));
        }

        for(Position p : play) {
            p.playSound();
        }

        try {
            //while playing sound, another process should stop
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //chord name and which position user should push
    private String chordName;
    private List<pair<Integer, Integer>> push;
}
