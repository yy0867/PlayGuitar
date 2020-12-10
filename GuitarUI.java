public class GuitarUI extends Guitar {
    public GuitarUI() {
        super();
    }

    public void clearScreen() {
        for(int i = 0; i < 30; i++)
            System.out.println();
    }

    public void printGuitar(Chord chord) {
        System.out.print("       ");
        for (int i = 0; i <= fret; i++) {
            String s = (i < 10) ? i + "    " : i + "   ";
            System.out.print(s);
        }
        System.out.println();

        for (int i = 1; i <= string; i++) {
            System.out.print(i + "(" + openStrings.get(string - i + 1).charAt(0) + ")" + " | ");
            for (int j = 0; j <= fret; j++) {
                if(chord.isPushed(new pair<>(i, j)))
                    System.out.print("─x─  ");
                else
                    System.out.print("───  ");
            }
            System.out.println();
        }
    }
}
