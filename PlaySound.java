import javax.sound.sampled.*;
import java.io.File;
import java.util.List;

public class PlaySound extends Thread implements GuitarSound {
    public PlaySound(String path) {
        this.path = path;
    }

    @Override //play guitar sound which stored in "path"
    public void playSound(String path) {
        File sound;
        AudioInputStream soundStream;
        AudioFormat format;
        DataLine.Info info;

        Clip clip;
        try {
            //open file [resources/sounds/*.wav]
            sound = new File("./resources/sounds/" + path + ".wav");
            soundStream = AudioSystem.getAudioInputStream(sound);

            format = soundStream.getFormat();
            info = new DataLine.Info(Clip.class, format);

            clip = (Clip)AudioSystem.getLine(info);
            clip.open(soundStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override //playing sound with Thread for simultaneous
    public void run() {
        playSound(path);
    }

    private String path;
    private List<pair<String, pair<Integer, Integer>>> soundPosition;
}
