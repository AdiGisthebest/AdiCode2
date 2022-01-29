import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Bucket {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("blist.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[] timeArray = new int[1000];
            for(int i = 0; i < length; i++) {
                String[] arr = scanner.nextLine().split(" ");
                int startIndex = Integer.parseInt(arr[0]);
                int endIndex = Integer.parseInt(arr[1]);
                int buckets = Integer.parseInt(arr[2]);
                for(int j = startIndex - 1; j < endIndex - 1; j++) {
                    timeArray[j] = timeArray[j] + buckets;
                }

            }
            int maxNum = 0;
            for(int i = 0; i < 1000; i++) {
                if(timeArray[i] > maxNum) {
                    maxNum = timeArray[i];
                }
            }
            System.out.println(maxNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("blist.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bucket bucket = new Bucket();
        bucket.read();
    }
}
