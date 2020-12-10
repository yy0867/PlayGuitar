import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Read position.txt
public class ReadPosition implements CodeDataFileReader {
    @Override
    public List<Position> readList() {
        try {
            FileReader reader = new FileReader(new File("src/resources/position.txt"));
            BufferedReader buf = new BufferedReader(reader);
            List<Position> source = new ArrayList<>();

            //reads file by line
            String line;
            while((line = buf.readLine()) != null) {
                source.add(new Position(CodeDataFileReader.cutName(line), CodeDataFileReader.cutCoords(line)));
            }

            return source;
        } catch (Exception e) {
            System.out.println("read position list error!" + e.getMessage());
        }
        //fail, return null
        return null;
    }
}
