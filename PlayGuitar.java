import javax.swing.*;

public class PlayGuitar {

    public static void main(String[] args) {
        FileManager.readChordList();

        GuitarUI guitar = new GuitarUI();
        PlaySound playC = new PlaySound("D1");
        PlaySound playE = new PlaySound("Gb1");
        PlaySound playG = new PlaySound("A1");

        playC.run();
        playE.run();
        playG.run();

        JOptionPane.showMessageDialog(null, "Press OK to continue");

        guitar.printGuitar();
    }
}
