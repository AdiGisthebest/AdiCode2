import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Taming {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("taming.in"));
            int length = Integer.parseInt(scanner.nextLine());
            String[] strArr = scanner.nextLine().split(" ");
            int[] arr = new int[length];
            for(int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            for(int i = 0; i < length; i++) {
                if(arr[i] >= 0) {
                    arr[i - arr[i]] = -3;
                    for(int j = i-arr[i] + 1; j <= i; j++) {
                        if(arr[j] == -3) {
                            System.out.println(-1);
                            return;
                        }
                        arr[j] = -2;
                    }
                }
            }
            arr[0] = -3;
            int minCount = 0;
            int possible = 0;
            for(int i = 0; i < length; i++) {
                //System.out.print(arr[i] + " ");
                if(arr[i] == -3) {
                    minCount++;
                } else if (arr[i] == -1) {
                    possible++;
                }
            }
            //System.out.println();
            System.out.println(minCount + " " + (minCount + possible));
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("taming.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Taming taming = new Taming();
        taming.read();
    }
}
