import java.io.FileWriter;
import java.io.IOException;

public class WriteChord implements CodeDataFileWriter {
    @Override
    public boolean writeFile(String write) {
        try {
            FileWriter writer = new FileWriter("./resources/chords.txt", true);
            writer.write(write);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
