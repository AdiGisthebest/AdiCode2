import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Hoofball {
    public void read()  {
        try {
            Scanner scanner = new Scanner(new File("hoofball.in"));
            int length = Integer.parseInt(scanner.nextLine());
            if(length == 1) {
                System.out.println(1);
                return;
            }
            int[] positions = new int[length];
            String[] strArr = scanner.nextLine().split(" ");
            for(int i = 0; i < length; i++) {
                positions[i] = Integer.parseInt(strArr[i]);
            }
            Arrays.sort(positions);

        } catch(Exception e) {

        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("hoofball.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Hoofball hoofball = new Hoofball();
        hoofball.read();
    }
}
