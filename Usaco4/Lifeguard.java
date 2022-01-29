import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Lifeguard {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("lifeguards.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[] watchTimes = new int[length];
            int[][] lifeguards = new int[length][2];
            int[] time = new int[1001];
            for(int i = 0; i < length; i++) {
                String[] strArr = scanner.nextLine().split(" ");
                lifeguards[i][0] = Integer.parseInt(strArr[0]);
                lifeguards[i][1] = Integer.parseInt(strArr[1]);
            }
            for(int i = 0; i < length; i++) {
                for(int j = 0; j < length; j++) {
                    if(j != i) {
                        int index1 = lifeguards[j][0];
                        int index2 = lifeguards[j][1];
                        for(int k = index1; k < index2; k++) {
                            time[k] = 1;
                        }
                    }
                }
                int count = 0;
                for(int j = 0; j < 1001; j++) {
                    if(time[j] == 1) {
                        count++;
                    }
                }
                watchTimes[i] = count;
                time = new int[1001];
            }
            int maxNum = -1;
            for(int i = 0; i < length; i++) {
                //System.out.println(watchTimes[i]);
                if(watchTimes[i] > maxNum) {
                    maxNum = watchTimes[i];
                }
            }
            System.out.println(maxNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("lifeguards.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Lifeguard lifeguard = new Lifeguard();
        lifeguard.read();
    }
}
