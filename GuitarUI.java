public class GuitarUI extends Guitar {
    public GuitarUI() {
        super();
    }

    //print guitar shape to console
    public void printGuitar(Chord chord) {
        System.out.print("       ");
        //print frets
        for (int i = 0; i <= fret; i++) {
            String s = (i < 10) ? i + "    " : i + "   ";
            System.out.print(s);
        }
        System.out.println();

        //print strings
        for (int i = 1; i <= string; i++) {
            System.out.print(i + "(" + openStrings.get(string - i + 1).charAt(0) + ")" + " | ");
            for (int j = 0; j <= fret; j++) {
                if(chord.isPushed(new pair<>(i, j)))    //when playing "chord", mark it when user have to press with "x"
                    System.out.print("─x─  ");
                else                                    //user doesn't need to push
                    System.out.print("───  ");
            }
            System.out.println();
        }
    }
}
