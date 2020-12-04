import java.util.ArrayList;
import java.util.List;

public class SoundPosition {
    public SoundPosition(String soundName, List<pair<Integer, Integer>> position) {
        this.position = position;
        this.soundName = soundName;
    }

    String soundName;
    List<pair<Integer, Integer>> position;
}
