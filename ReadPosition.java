import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Read position.txt
public class ReadPosition implements FileManager {
    @Override
    public List<Position> readList() {
        try {
            FileReader reader = new FileReader(new File("./resources/chords.txt"));
            BufferedReader buf = new BufferedReader(reader);
            List<Position> source = new ArrayList<>();

            //reads file by line
            String line;
            while((line = buf.readLine()) != null) {
                source.add(new Position(FileManager.cutName(line), FileManager.cutCoords(line)));
            }

            return source;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //fail, return null
        return null;
    }
}
