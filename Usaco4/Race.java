import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Race {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("race.in"));
            String[] arr = scanner.nextLine().split(" ");
            long raceLength = Long.parseLong(arr[0]);
            int length = Integer.parseInt(arr[1]);
            int[] nums = new int[length];
            for(int i = 0; i < length; i++) {
                nums[i] = Integer.parseInt(scanner.nextLine());
            }
            for(int i  = 0; i < length; i++) {
                System.out.println(this.solve(raceLength, nums[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int solve(long raceLength,int endSpeed) {
        int speed = 0;
        int time = 0;
        long distLeft = raceLength;
        int[] sums = new int[100000];
        int sum = 0;
        for(int i = 0; i < sums.length; i++) {
            sum = sum + i;
            sums[i] = sum;
        }
        while(distLeft > 0) {
            if(speed >= endSpeed) {
                int endNum = sums[speed-1] - sums[endSpeed-1];
                int nextEndNum = sums[speed] - sums[endSpeed-1];
                //System.out.println(speed + " " + distLeft + " " + endNum);
                if(distLeft-speed >= endNum) {
                    if(distLeft -(speed+1) >= nextEndNum) {
                        speed++;
                    }
                } else {
                    speed--;
                }
            } else {
                speed++;
            }

            distLeft = distLeft - speed;
            time++;
        }
        //System.out.println(speed + " " + distLeft);
        return time;
    }

    public static void main(String[] args) {
        try {
            File file = new File("race.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Race race = new Race();
        race.read();
    }
}
