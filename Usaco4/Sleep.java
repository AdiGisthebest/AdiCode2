import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Sleep {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("sleepy.in"));
            int cowNum = Integer.parseInt(scan.nextLine());
            int[] arr = new int[cowNum];
            String[] strArr = scan.nextLine().split(" ");
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            int count = 1;
            for(int i = cowNum-1; i > 0; i--) {
                if(arr[i] > arr[i-1]) {
                    count++;
                } else {
                    break;
                }
            }
            System.out.println(cowNum-count);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("sleepy.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Sleep sleep = new Sleep();
        sleep.read();
    }
}
