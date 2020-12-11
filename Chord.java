import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.List;

public class Chord extends Thread implements PushString {

    //Constructor
    public Chord(String chordName, List<pair<Integer, Integer>> push) {
        this.chordName = chordName;
        this.push = push;
    }

    //getter
    public String getChordName() { return chordName; }
    public List<pair<Integer, Integer>> getPush() { return push; }

    //return push positions when program plays chord
    public boolean isPushed(pair<Integer, Integer> p) {
        return PushString.isPushed(p.first, p.second, this.push);
    }

    @Override   //change chord to string -> [Chord Name] [p1.row] [p1.col] [p2.row] [p2.col] ...
    public String toString() {
        StringBuilder res = new StringBuilder(chordName);

        for(pair<Integer, Integer> p : push) {
            res.append(" " + p.first + " " + p.second);
        }

        return res.toString();
    }

    //play each position's sound to make chord
    public void playChord() {
        List<Position> positionList = Guitar.getPositionList(); //get all Guitar's position
        List<Position> play = new ArrayList<>(); //Contains which position to play

        //put position in [play]
        for(pair<Integer, Integer> p : push) {
            for(Position pos : positionList) {
                if(pos.getPositionName(p.first, p.second) != null) {
                    play.add(new Position(pos.getPositionName(p.first, p.second), p));
                    break;
                }
            }
        }

        //play sound file which matches [play] list, with Thread
        for(Position p : play) {
            p.playSound();
        }

        try {
            //while playing sound, another process should stop
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //chord name and which position user should push
    private String chordName;
    private List<pair<Integer, Integer>> push;
}
