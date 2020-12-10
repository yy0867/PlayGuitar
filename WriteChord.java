import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteChord implements CodeDataFileWriter {
    @Override
    public boolean writeFile(Chord write) {
        try {
            List<Chord> sortList = new ReadChord().readList();
            sortList.add(write);
            //use lambda to sort by chord alphabet
            sortList.sort((a, b) -> a.getChordName().compareTo(b.getChordName()));

            String writeString = null;
            for(Chord chord : sortList) {
                writeString += (chord.toString() + '\n');
            }

            FileWriter writer = new FileWriter("src/resources/chords.txt");
            writer.write(writeString);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
