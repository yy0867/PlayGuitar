import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PlayGuitar {

    public static void main(String[] args) {
        //create guitar
        Guitar myGuitar = new Guitar();
        GuitarUI guitarPrinter = new GuitarUI();

        Consumer<String> notice = s -> System.out.println("Play " + s + " Chord!");
        Consumer<String> fail = s -> System.out.println("[" + s + "] Chord is not exist!");
        Predicate<String> quit = s -> s.compareTo("Q") == 0 || s.compareTo("q") == 0;
        Predicate<String> help = s -> s.compareTo("help") == 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Input chord what you want to play! or 'Q' to exit >> ");

            String input = scanner.next();
            Chord play;

            if(quit.test(input)) {
                System.out.println("Exit Program!");
                return;
            }

            else if(help.test(input))
                myGuitar.printChordList();

            else {
                while ((play = myGuitar.getChord(input)) == null) {
                    fail.accept(input);
                    System.out.println("Input [help] to show chord list or input chord again >> ");
                    input = scanner.next();

                    if (quit.test(input)) {
                        System.out.println("Exit Program!");
                        return;
                    }
                }
                notice.accept(play.getChordName());
                guitarPrinter.printGuitar(play);
                play.playChord();
            }

            guitarPrinter.clearScreen();

            //소리 출력
        }
    }
}
