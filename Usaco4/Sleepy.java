import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Sleepy {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("herding.in"));
            String[] strArr = scanner.nextLine().split(" ");
            int[] cowNums = new int[3];
            for(int i = 0; i < 3; i++) {
                cowNums[i] = Integer.parseInt(strArr[i]);
            }
            Arrays.sort(cowNums);
            int[] diffs = new int[2];
            diffs[0] = cowNums[1] - cowNums[0]-1;
            diffs[1] = cowNums[2] - cowNums[1]-1;
            Arrays.sort(diffs);
            if(diffs[1] == 0 && diffs[0] == 0) {
                System.out.println(0);
                System.out.println(0);
                return;
            }
            if(diffs[0] == 0) {
                if(diffs[1] > 1) {
                    System.out.println(2);
                    System.out.println(diffs[1]);
                } else {
                    System.out.println(1);
                    System.out.println(1);
                }
                return;
            }
            if(diffs[0] > 1) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
            System.out.println(diffs[1]);

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("herding.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Sleepy sleepy = new Sleepy();
        sleepy.read();
    }
}
