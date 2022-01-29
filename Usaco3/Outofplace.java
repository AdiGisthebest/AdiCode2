import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Outofplace {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("outofplace.in"));
            int length = Integer.parseInt(scan.nextLine());
            int[] nums = new int[length];
            for(int i = 0; i < length; i++) {
                nums[i] = Integer.parseInt(scan.nextLine());
            }
            int bessie = 0;
            int wrongBessieindex = 0;
            for(int i = 0; i < length - 1; i++) {
                if(nums[i] > nums[i+1]) {
                    if(i == 0) {
                        bessie = nums[i];
                    } else {
                        bessie = nums[i+1];
                        wrongBessieindex = i+1;
                    }
                }
            }
            if(bessie == 0) {
                System.out.println(0);
                return;
            }
            int bessieIndex = -1;
            int blockNum = 0;
            for(int i = 0; i < length - 1; i++) {
                if(nums[i] <= bessie && nums[i+1] >= bessie) {
                    bessieIndex = i + 1;
                    if(bessieIndex < wrongBessieindex) {
                        blockNum--;
                    }
                    break;
                }
            }
            if(bessieIndex == -1) {
                bessieIndex = length-1;
            }
            int prevNum = bessie;
            //System.out.println(bessie + " " + bessieIndex);
            for(int i = bessieIndex; i < length; i++) {
                //System.out.println(blockNum + " " + nums[i]);
                if(nums[i] != prevNum) {
                    blockNum++;
                }
                nums[i] = prevNum;
            }
            System.out.println(blockNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("outofplace.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Outofplace outofplace = new Outofplace();
        outofplace.read();
    }
}
