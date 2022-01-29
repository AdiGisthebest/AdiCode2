import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Shuffle {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("shuffle.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[] inverseShuffle = new int[length];
            String[] arr = scanner.nextLine().split(" ");
            String[] ids = scanner.nextLine().split(" ");
            for(int i = 0; i < length; i++) {
                int index = Integer.parseInt(arr[i]);
                inverseShuffle[index-1] = i;
            }
            for(int i = 0 ; i < 3; i++) {
                String[] emptyCopy = new String[length];
                for(int j = 0; j < length; j++) {
                    emptyCopy[inverseShuffle[j]] = ids[j];
                }
                ids = emptyCopy;
            }
            for(int i = 0; i < length; i++) {
                System.out.println(ids[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("shuffle.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Shuffle shuffle = new Shuffle();
        shuffle.read();
    }
}
