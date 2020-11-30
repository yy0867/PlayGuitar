package PlayGuitar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chords {
    public String getOpenString(int index) { return openStrings.get(index); }

    private List<String> openStrings = new ArrayList<>(Arrays.asList("E", "A", "D", "G", "B", "E"));
}
