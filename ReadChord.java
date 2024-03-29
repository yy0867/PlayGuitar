import java.io.*;
import java.util.*;

//Read chords.txt
public class ReadChord implements CodeDataFileReader {

    @Override
    public List<Chord> readList() {
        //read list from "chords.txt"
        try {
            FileReader reader = new FileReader(new File("./resources/chords.txt"));
            BufferedReader buf = new BufferedReader(reader);
            List<Chord> source = new ArrayList<>();

            //reads file by line
            String line;
            while((line = buf.readLine()) != null) {
                source.add(new Chord(CodeDataFileReader.cutName(line), CodeDataFileReader.cutCoords(line)));
            }

            //sort required for "help"
            source.sort((a, b) -> a.getChordName().compareTo(b.getChordName()));

            return source;
        } catch (Exception e) {
            System.out.println("read chord list error!" + e.getMessage());
        }
        //fail, return null
        return null;
    }
}
