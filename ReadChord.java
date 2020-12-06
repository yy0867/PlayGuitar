import java.io.*;
import java.util.*;

//Read chords.txt
public class ReadChord implements FileManager {

    @Override
    public List<Chord> readList() {
        try {
            FileReader reader = new FileReader(new File("./resources/chords.txt"));
            BufferedReader buf = new BufferedReader(reader);
            List<Chord> source = new ArrayList<>();

            //reads file by line
            String line;
            while((line = buf.readLine()) != null) {
                source.add(new Chord(FileManager.cutName(line), FileManager.cutCoords(line)));
            }

            return source;
        } catch (Exception e) {
            System.out.println("read chord list error!" + e.getMessage());
        }
        //fail, return null
        return null;
    }
}
