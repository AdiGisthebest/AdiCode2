import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Stall {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        long[] cowHeight = new long[length];
        long[] barnHeight = new long[length];
        int[] fitNum = new int[length];
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");
        for(int i = 0; i < length; i++) {
            cowHeight[i] = Long.parseLong(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(scanner.nextLine(), " ");
        for(int i = 0; i < length; i++) {
            barnHeight[i] = Long.parseLong(tokenizer.nextToken());
        }
        for(int i = 0; i < length; i++) {
            int count = 0;
            for(int j = 0; j < length; j++){
                if(cowHeight[i] <= barnHeight[j]) {
                    count++;
                }
            }
            fitNum[i] = count;
        }
        Arrays.sort(fitNum);
        int subNum = 0;
        long ans = 1;
        for(int i = 0; i < length; i++) {
            //System.out.println(fitNum[i]);
            ans = ans * (fitNum[i] - subNum);
            subNum ++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Stall stall = new Stall();
        stall.read();
    }
}
