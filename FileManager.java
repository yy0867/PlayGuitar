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

        for (int i = 1; i < input.length(); i += 2) {
            coords.add(new pair<>(  Character.getNumericValue(input.charAt(i)),
                                    Character.getNumericValue(input.charAt(i + 1))));
        }

        return coords;
    }
}