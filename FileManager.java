import java.util.List;
import java.io.*;

public class FileManager {
    //read chord info from txt, returns to form of <Chord>
    public static List<Chord> readChordList() {
        try {
            //reads file by line
            FileReader reader = new FileReader(new File("./resources/chords.txt"));
            BufferedReader buf = new BufferedReader(reader);
            String line;
            List<Chord> inputList = null;

            while((line = buf.readLine()) != null) {
                inputList.add(new Chord(line));
            }
            reader.close();
            buf.close();

            return inputList;
        } catch (Exception e) {
            System.out.println("File Read Failed!");
        }
        return null;
    }

    //write
    public static void writeChordList(List<Chord> chordList) {

    }
}
