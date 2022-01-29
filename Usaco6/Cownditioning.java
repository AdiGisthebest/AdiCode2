import java.util.Scanner;

public class Cownditioning {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] strArr1 = scanner.nextLine().split(" ");
        String[] strArr2 = scanner.nextLine().split(" ");
        int[] perfectTemp = new int[length];
        int[] currTemp = new int[length];
        int[] diffs = new int[length];
        for(int i = 0; i < length; i++) {
            perfectTemp[i] = Integer.parseInt(strArr1[i]);
            currTemp[i] = Integer.parseInt(strArr2[i]);
        }
        boolean breakBool = true;
        int commandCnt = 0;
        while(breakBool) {
            int startIndex = -1;
            int subLength = 0;
            int prev = 0;
            for(int i = 0; i < length; i++) {
                if(perfectTemp[i] > currTemp[i]) {
                    diffs[i] = 1;
                } else if (perfectTemp[i] < currTemp[i]) {
                    diffs[i] = -1;
                } else {
                    diffs[i] = 0;
                }
            }
            int zeroCnt = 0;
            for(int i = 0; i < length; i++) {
                //System.out.println(currTemp[i] + "    " + diffs[i] + "   " + perfectTemp[i]);
                if(diffs[i] != 0) {
                    if(prev != diffs[i]) {
                        commandCnt++;
                    }
                    if(diffs[i] == 1) {
                        currTemp[i]++;
                    } else {
                        currTemp[i]--;
                    }
                } else {
                    zeroCnt++;
                }
                prev = diffs[i];
            }
            //System.out.println();
            if(zeroCnt == length) {
                breakBool = false;
            }
        }
        System.out.println(commandCnt);
    }

    public static void main(String[] args) {
        Cownditioning cownditioning = new Cownditioning();
        cownditioning.read();
    }
}
