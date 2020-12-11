import java.util.*;
import javax.sound.sampled.*;
import java.io.File;

public class Position extends Thread implements PushString {
    public Position(String sound, List<pair<Integer, Integer>> push) {
        //if several positions have same sound
        this.sound = sound;
        this.push = push;
        //need to sort by larger [first], use lambda
        push.sort((p, q) -> p.compareTo(q));
    }

    public Position(String sound, pair<Integer, Integer> p) {
        //if only one position has sound
        this.sound = sound;
        this.push = new ArrayList<>(Arrays.asList(p));
    }

    //play guitar sound which stored in "path"
    public void playSound() {
        File file;
        AudioInputStream soundStream;
        AudioFormat format;
        DataLine.Info info;

        Clip clip;
        try {
            //open file [resources/sounds/*.wav]
            file = new File("./resources/sounds/" + sound + ".wav");
            soundStream = AudioSystem.getAudioInputStream(file);

            format = soundStream.getFormat();
            info = new DataLine.Info(Clip.class, format);

            //run "clip" to play sound
            clip = (Clip)AudioSystem.getLine(info);
            clip.open(soundStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //getter
    public String getPositionName(int string, int fret) {
        //if pushed, return "sound"
        if(PushString.isPushed(string, fret, push)) return sound;
        return null;
    }

    @Override //playing sound with Thread for simultaneous
    public void run() {
        playSound();
    }

    //sound matches in positions.txt [ex) E1, C2, Bb1, ...]
    private String sound;
    //push matches coordinates which can play "sound"
    private List<pair<Integer, Integer>> push;
}
