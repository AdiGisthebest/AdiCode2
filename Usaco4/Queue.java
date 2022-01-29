import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Queue {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("cowqueue.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[][] arrival = new int[length][2];
            for(int i = 0; i < length; i++) {
                String[] arr = scanner.nextLine().split(" ");
                arrival[i][0] = Integer.parseInt(arr[0]);
                arrival[i][1] = Integer.parseInt(arr[1]);
            }
            Arrays.sort(arrival,(a,b) -> Integer.compare(a[0],b[0]));
            for(int i = 0; i < length-1; i++) {
                if(arrival[i][0] + arrival[i][1] >= arrival[i+1][0]) {
                    arrival[i+1][0] = arrival[i][0] + arrival[i][1];
                }
            }
            int ans = arrival[arrival.length - 1][0] + arrival[arrival.length - 1][1];
            System.out.println(ans);
        } catch (Exception e) {

        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("cowqueue.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {

        }
        Queue queue = new Queue();
        queue.read();
    }
}
