import javax.sound.sampled.*;
import java.io.File;

public class PlaySound extends Thread implements GuitarSound {
    public PlaySound(String path) {
        this.path = path;
    }

    @Override
    public void playSound(String path) {
        File sound;
        AudioInputStream soundStream;
        AudioFormat format;
        DataLine.Info info;

        Clip clip;
        try {
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

    @Override
    public void run() {
        playSound(path);
    }

    private String path;
}
