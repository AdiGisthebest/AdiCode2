import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Race {
    int[] sums;
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("race.in"));
            String[] strArr = scanner.nextLine().split(" ");
            int distance = Integer.parseInt(strArr[0]);
            int speedLen = Integer.parseInt(strArr[1]);
            int[] endSpeeds = new int[speedLen];
            for(int i = 0; i < speedLen; i++) {
                endSpeeds[i] = Integer.parseInt(scanner.nextLine());
            }
            for(int i = 0; i < speedLen; i++) {
                int speed = endSpeeds[i];
                int currSpeed = 0;
                int currTime = 0;
                int distLeft = distance;
                while(distLeft > 0) {
                    if (findSlowdownSpeed(currSpeed + 1, speed) < distLeft-currSpeed) {
                        currSpeed++;
                    } else if (findSlowdownSpeed(currSpeed, speed) > distLeft-currSpeed) {
                        currSpeed--;
                    }
                    //System.out.println(currSpeed + " speed " +findSlowdownSpeed(currSpeed, speed) + " " + (distLeft-currSpeed));
                    distLeft = distLeft - currSpeed;
                    currTime++;
                }
                System.out.println(currTime);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public int findSlowdownSpeed(int speed, int targetSpeed) {
        if(speed <= targetSpeed) {
            return 0;
        } else {
            return (((speed-1)*(speed))/2) - (((targetSpeed-1)*(targetSpeed))/2);
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("race.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
        }
        Race race = new Race();
        race.read();
    }
}
