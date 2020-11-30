package PlayGuitar;

import java.util.List;

public class GuitarUI implements Guitar {

    @Override //Interface Guitar - printGuitar
    public void printGuitar(/*List<pair<Integer, Integer>> push*/) {
        Chords chords = new Chords();

        System.out.print("       ");
        for (int i = 1; i <= fret; i++) {
            String s = (i < 10) ? i + "   " : i + "  ";
            System.out.print(s);
        }
        System.out.println();

        for (int i = 0; i < strings; i++) {
            System.out.print((i + 1) + "(" + chords.getOpenString(strings - i - 1) + ")" + " | ");
            for (int j = 0; j < fret; j++) {
                System.out.print("──  ");
            }
            System.out.println();
        }
    }
}
