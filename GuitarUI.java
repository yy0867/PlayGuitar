import java.util.List;

public class GuitarUI extends Guitar {
    public static void clear() {
        //clear console
    }

    public void printGuitar(Chord chord) {
        System.out.print("       ");
        for (int i = 0; i <= fret; i++) {
            String s = (i < 10) ? i + "   " : i + "  ";
            System.out.print(s);
        }
        System.out.println();

        for (int i = 1; i <= strings; i++) {
            System.out.print(i + "(" + Chord.openStrings.get(strings - i).charAt(0) + ")" + " | ");
            for (int j = 0; j <= fret; j++) {
                if(chord.isPushed(i, j))
                    System.out.print("─x  ");
                else
                    System.out.print("──  ");
            }
            System.out.println();
        }
    }
}
