import java.util.Scanner;
import java.util.StringTokenizer;

public class Odd2 {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int evenBank = 0;
        int oddBank = 0;
        int cnt = 0;
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine()," ");
        for(int i = 0; i < length; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if(num%2 == 0) {
                evenBank++;
            } else {
                oddBank++;
            }
        }
        if(evenBank == oddBank) {
            System.out.println(length);
            return;
        } else if(evenBank == oddBank + 1) {
            System.out.println(length);
            return;
        }
        while (oddBank > evenBank) {
            oddBank-=2;
            evenBank++;
        }
        System.out.println((2 * oddBank) + 1);
    }

    public static void main(String[] args) {
        Odd2 odd2 = new Odd2();
        odd2.read();
    }
}
