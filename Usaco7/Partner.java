import java.util.Scanner;

public class Partner {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] answers = new int[length];
        for(int i = 0; i < length; i++) {
            String[] strArr = scanner.nextLine().split(" ");
            answers[i] = solve(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1]));
        }
        for(int i = 0; i < length; i++) {
            System.out.println(answers[i]);
        }
    }
    public int solve(int num1, int num2) {
        int ans = 0;
        while(num1 != num2) {
            if(num1 > num2) {
                if(num1%2 == 0) {
                    num1 = num1/2;
                    ans++;
                } else {
                    num1 = (num1+1)/2;
                    ans+=2;
                }
            } else {
                int topDiff = 0;
                int tempNum1 = num1;
                int iters = 0;
                while ((tempNum1*2) < num2) {
                    tempNum1 = tempNum1*2;
                    iters++;
                }
                topDiff = num2 - tempNum1;
                int directCost = iters+topDiff;
                int scaledCost = 0;
                int scale = 0;
                while() {
                    int downNum = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Partner partner = new Partner();
        partner.read();
    }
}
