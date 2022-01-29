import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Cowstudy {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer lengthTokenizer = new StringTokenizer(scanner.nextLine(), " ");
        int length = Integer.parseInt(lengthTokenizer.nextToken());
        int amount = Integer.parseInt(lengthTokenizer.nextToken());
        int[] nums = new int[length];
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");
        for(int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(nums);
        System.out.println(this.addOptimal(amount,nums));
    }
    public int addOptimal(int amount, int[] nums) {
        int studyNum = 0;
        boolean inside = false;
        int studyIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= nums.length - i) {
                studyNum = nums[i];
                studyIndex = i;
            }
        }
        if(studyIndex == -1) {
            return 0;
        }
        int occurNum = 0;
        for(int i = studyIndex - 1; i < nums.length; i++) {
            if(nums[i] == studyNum) {
                occurNum++;
            }
        }
        if(amount >= occurNum) {
            return studyNum +1;
        } else {
            return studyNum;
        }
    }

    public static void main(String[] args) {
        Cowstudy cowstudy = new Cowstudy();
        cowstudy.read();
    }
}
