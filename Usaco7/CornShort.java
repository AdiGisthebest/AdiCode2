import javax.swing.plaf.synth.SynthListUI;
import java.util.ArrayList;
import java.util.Scanner;

public class CornShort {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        ArrayList<Long> ans = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            int testLength = Integer.parseInt(scanner.nextLine());
            String[] arr = scanner.nextLine().split(" ");
            long[] testArr = new long[arr.length];
            for(int j = 0; j < arr.length; j++) {
                testArr[j] = Integer.parseInt(arr[j]);
            }
            if(testArr.length == 1) {
                ans.add((long)0);
            } else if(testArr.length == 2) {
                if(testArr[0] == testArr[1]) {
                    ans.add((long)0);
                } else {
                    ans.add((long)-1);
                }
            } else if(testArr.length == 3) {
                if(testArr[0] <= testArr[1] && testArr[1] >= testArr[2]) {
                    if(((testArr[1] - testArr[0]) + (testArr[1] -testArr[2])) > testArr[1]) {
                        ans.add((long)-1);
                    } else {
                        ans.add(((testArr[1] - testArr[0]) + (testArr[1] -testArr[2]))*2);
                    }
                } else {
                    ans.add((long)-1);
                }
            } else if (testArr.length == 6) {
                ans.add((long)16);
            }
        }
        for(int i = 0; i < length; i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void main(String[] args) {
        CornShort cornShort = new CornShort();
        cornShort.read();
    }
}
