import java.util.List;

public class GuitarUI implements Guitar {

    @Override //Interface Guitar - printGuitar
    public void printGuitar(/*List<pair<Integer, Integer>> push*/) {

        System.out.print("       ");
        for (int i = 0; i <= fret; i++) {
            String s = (i < 10) ? i + "   " : i + "  ";
            System.out.print(s);
        }
        System.out.println();

        for (int i = 0; i < strings; i++) {
            System.out.print((i + 1) + "(" + Chord.openStrings.get(strings - i - 1).charAt(0) + ")" + " | ");
            for (int j = 0; j <= fret; j++) {
                System.out.print("──  ");
            }
            System.out.println();
        }
    }
}
