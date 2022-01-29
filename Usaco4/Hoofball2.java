import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Hoofball2 {
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
            int[] diffs = new int[length - 1];
            for(int i = 1; i < length; i++) {
                diffs[i-1] = positions[i] - positions[i-1];
                System.out.println(positions[i]);
            }
            int startElem = 0;
            int direction = 0;
            int ballCnt = 1;
            int prevElem = 0;
            for(int i = diffs.length - 1; i >= 0; i--) {
                //System.out.println(diffs[i]);
                if(direction == 0 && startElem == 0) {
                    startElem = diffs[i];
                } else if (direction == 0) {
                    if(diffs[i] <= startElem) {
                        direction = -1;
                    } else {
                        direction = 1;
                    }
                    prevElem = diffs[i];
                } else {
                    if(diffs[i] > prevElem && direction == -1) {
                        direction = 0;
                        startElem = 0;
                        //System.out.println(diffs[i] + " diff " + direction);
                        ballCnt++;
                    } else if (diffs[i] <= prevElem && direction == 1) {
                        direction = 0;
                        startElem = 0;
                        //System.out.println(diffs[i] + " Diff"  + direction);
                        ballCnt++;
                    } else {
                        prevElem = diffs[i];
                    }
                }
            }
            System.out.println(ballCnt);
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
        Hoofball2 hoofball = new Hoofball2();
        hoofball.read();
    }
}
