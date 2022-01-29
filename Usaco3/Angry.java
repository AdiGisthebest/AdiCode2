import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Angry {
    public int findCntRight(int[] arr, int position, int t) {
        int cnt = 0;
        for(int i = position + 1; i < arr.length; i++) {
            if(arr[i] - arr[position] <= t) {
                System.out.println(arr[i] + " " + arr[position] + " " + t);
                cnt++;
            } else {
                System.out.println();
                return cnt + this.findCntRight(arr, i-1, t+1);
            }
        }
        return 0;
    }
    public int findCntLeft(int[] arr, int position,int t) {
        int cnt = 0;
        for(int i = position - 1; i > 0 ; i--) {
            if(arr[position] - arr[i] <= t) {
                System.out.println(arr[i] + " " + arr[position]+ " " + t);
                cnt++;
            } else {
                return cnt + this.findCntRight(arr, i-1, t+1);
            }
        }
        return 0;
    }
    public void read() {
        try {
            Scanner scan = new Scanner(new File("angry.in"));
            int length = Integer.parseInt(scan.nextLine());
            int[] arr = new int[length];
            int maxNum = 0;
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(scan.nextLine());
            }
            Arrays.sort(arr);
            for (int i = 0; i < length; i++) {
                int num = this.findCntRight(arr, i, 0) + this.findCntLeft(arr,i,0) + 1;
                //System.out.println(this.findCntRight(arr, i, 1) + this.findCntLeft(arr,i,1) + 1);
                if(num > maxNum) {
                    maxNum = num;
                }
            }
            System.out.println(maxNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("angry.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Angry angry = new Angry();
        angry.read();
    }
}
