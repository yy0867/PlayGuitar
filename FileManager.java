import java.util.ArrayList;
import java.util.List;

public interface FileManager<T> {
    //read <type> files and change to List<T> forms
    List<T> readList();

    //extract name information in "input" string
    static String cutName(String input) { return input.split(" ")[0]; }

    //extract coordinate information in "input" string
    static List<pair<Integer, Integer>> cutCoords(String input) {
        List<pair<Integer, Integer>> coords = new ArrayList<>();
        String[] split = input.split(" ");

        for (int i = 1; i < split.length; i += 2) {
            coords.add(new pair<>(  Integer.parseInt(split[i]), Integer.parseInt(split[i + 1])));
        }

        return coords;
    }
}