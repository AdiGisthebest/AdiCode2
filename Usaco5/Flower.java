import java.util.Scanner;

public class Flower {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] strArr = scanner.nextLine().split(" ");
        int[] petals = new int[length];
        int ans = 0;
        for(int i = 0; i < length; i++) {
            petals[i] = Integer.parseInt(strArr[i]);
        }
        int[] petalArr = new int[length+1];
        int count = 0;
        for(int i = 1; i <= length; i++) {
            count = count+petals[i-1];
            petalArr[i] = count;
        }
        for(int i = 0; i < length; i++) {
            for(int j = i+1; j <= length; j++) {
                int sum = petalArr[j] - petalArr[i];
                if(sum%(j-i) == 0) {
                    int num = sum/(j-i);
                    for (int k = i; k < j; k++) {
                        if(petals[k] == num) {
                            ans++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.read();
    }
}
