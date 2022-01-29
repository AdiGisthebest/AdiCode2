import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Diamond {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("diamond.in"));
            String[] arr = scanner.nextLine().split(" ");
            int length = Integer.parseInt(arr[0]);
            int diff = Integer.parseInt(arr[1]);
            int[] intArr = new int[length];
            for(int i = 0; i < length; i++) {
                intArr[i] = Integer.parseInt(scanner.nextLine());
            }
            Arrays.sort(intArr);
            int maxLen = 0;
            for(int i = 0; i < length; i++) {
                int startInt = intArr[i];
                int len = 0;
                for(int j = i; j < length; j++) {
                    if(intArr[j] - startInt > diff) {
                        len = j - i;
                        break;
                    } else if(j == length-1) {
                        len = length - i;
                    }
                }
                if(len > maxLen) {
                    maxLen = len;
                }
            }
            System.out.println(maxLen);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("diamond.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        Diamond diamond = new Diamond();
        diamond.read();
    }
}
