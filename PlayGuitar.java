import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PlayGuitar {

    //When user input "add"
    static Chord inputChordInfo() {
        Scanner scanner = new Scanner(System.in);
        String chordName;
        List<pair<Integer, Integer>> push = new ArrayList<>();

        System.out.print("Input Chord Name [ex. Cm7] >> ");
        chordName = scanner.next(); //input new chord name
        if (Guitar.getChord(chordName) != null) { // if exist
            System.out.println("Chord Already Exist");
            return null;
        }
        System.out.print("Input the number of strings what you push [1 ~ 6] >> ");

        int n;
        while(true) {
            try {
                n = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                //if input is float, string, etc.
                System.out.print("Please Input Number [1 ~ 6] >> ");
            }
        }

        System.out.println("Input the [string fret] set");
        System.out.println("ex)\n1 0 \n2 1 \n4 2 \n5 3 \n6 0 \n>> ");
        for(int i = 0; i < n; i++) {
            int string = 0, fret = 0;
            try {
                string = scanner.nextInt();
                fret = scanner.nextInt();
            } catch (InputMismatchException e) {
                //if input is float, string, etc.
                System.out.print("Input correct number! >> ");
                i--;
            }
            push.add(new pair(string, fret));
        }

        //make a new chord
        return new Chord(chordName, push);
    }

    public static void main(String[] args) {
        //create guitar
        Guitar myGuitar = new Guitar();
        GuitarUI guitarPrinter = new GuitarUI();

        //user lambda to simplify printouts & compare inputs
        Consumer<String> notice = s -> System.out.println("Play " + s + " Chord!");
        Consumer<String> fail = s -> System.out.println("[" + s + "] Chord is not exist!");
        Predicate<String> quit = s -> s.compareTo("Q") == 0 || s.compareTo("q") == 0;
        Predicate<String> help = s -> s.compareTo("help") == 0;
        Predicate<String> add = s -> s.compareTo("add") == 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Input chord what you want to play! or 'help' to print chord list, 'add' to add chord, 'Q' to exit >> ");

            String input = scanner.next();
            Chord play = Guitar.getChord(input);

            if (quit.test(input)) { // input -> Q / q
                System.out.println("Exit Program!");
                return;
            } else if (help.test(input)) { // input -> help
                myGuitar.printChordList();
            } else if (add.test(input)) { // input -> add
                Chord newChord = inputChordInfo();
                if (newChord != null) {
                    myGuitar.addChord(newChord);
                    myGuitar.updateChordList();
                }
            } else if (play == null) { // input matches nothing
                fail.accept(input);
                System.out.println("'help' to show chord list or input chord again, 'add' to add chord, 'Q' to exit >> ");
            } else { //find input in "ChordList"
                notice.accept(play.getChordName()); // play [input] chord!
                guitarPrinter.printGuitar(play); //print guitar frame
                play.playChord(); //play sound
            }

        }
    }
}
