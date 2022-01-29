import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Roadcross {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("cowqueue.in"));
            int length = Integer.parseInt(scanner.nextLine());
            AdiPair[] arr = new AdiPair[length];
            for(int i = 0; i < length; i++) {
                AdiPair pair = new AdiPair();
                String[] strArr = scanner.nextLine().split(" ");
                pair.num1 = Integer.parseInt(strArr[0]);
                pair.num2 = Integer.parseInt(strArr[1]);
                arr[i] = pair;
            }
            Arrays.sort(arr);
            int t = 0;
            for(int i = 0; i < length; i++) {
                t = arr[i].num1 + arr[i].num2;
                if(i != length - 1) {
                    if(arr[i+1].num1 <= t) {
                        arr[i+1].num1 = t;
                    }
                }
            }
            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("cowqueue.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Roadcross roadcross = new Roadcross();
        roadcross.read();
    }
}
class AdiPair implements Comparable {
    int num1;
    int num2;

    @Override
    public int compareTo(Object obj) {
        AdiPair p = (AdiPair) obj;
        if(this.num1 > p.num1) {
            return 1;
        } else {
            return -1;
        }
    }
}
