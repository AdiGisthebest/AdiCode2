import java.util.Arrays;
import java.util.Scanner;

public class ABC {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int[] nums = new int[7];
        for(int i = 0; i < 7; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[1];
        int c = nums[6] - (nums[0] + nums[1]);
        System.out.println(a + " " + b + " " + c);
    }

    public static void main(String[] args) {
        ABC abc = new ABC();
        abc.read();
    }
}
