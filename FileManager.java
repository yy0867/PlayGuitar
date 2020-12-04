import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class FileManager {
    //read chord info from txt, returns to form of List<Chord>
    public static List<Chord> readChordList() {
        try {
            //reads file by line
            FileReader reader = new FileReader(new File("./resources/chords.txt"));
            BufferedReader buf = new BufferedReader(reader);
            String line;
            List<Chord> inputList = new ArrayList<>();

            while((line = buf.readLine()) != null) {
                //add information to LIST
                inputList.add(new Chord(line));
            }
            reader.close();
            buf.close();

            //return result
            return inputList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //fail, return null
        return null;
    }

    //read info about matching sound and position
    public static List<SoundPosition> readPositionList() {
        try {
            //reads file by line
            FileReader reader = new FileReader(new File("./resources/position.txt"));
            BufferedReader buf = new BufferedReader(reader);
            String line;

            List<SoundPosition> inputList = new ArrayList<>();

            while((line = buf.readLine()) != null) {
                //add information to LIST
                String[] split = line.split(" ");
                String soundName = split[0];
                List<pair<Integer, Integer>> coords = new ArrayList<>();

                for (int i = 1; i < split.length; i += 2) {
                    coords.add(new pair(Integer.parseInt(split[i]), Integer.parseInt(split[i+1])));
                }
                inputList.add(new SoundPosition(soundName, coords));
            }
            reader.close();
            buf.close();

            //return result
            return inputList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
