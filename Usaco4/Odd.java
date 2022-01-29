import java.util.Scanner;
import java.util.StringTokenizer;

public class Odd {
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
        for(int i = 0; i >= 0; i++) {
            //System.out.println(evenBank + " " + oddBank);
            if(i%2 == 0) {
                if(evenBank > 0) {
                    evenBank--;
                    cnt++;
                } else {
                    if(oddBank == 0) {
                        break;
                    }
                    if(oddBank - 2 == 2) {
                        oddBank -= 4;
                        cnt++;
                    } else {
                        oddBank-=2;
                        cnt++;
                    }
                }
            } else {
                if(oddBank <= 0) {
                    break;
                } else {
                    oddBank--;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Odd odd = new Odd();
        odd.read();
    }
}
