import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Milk {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("measurement.in"));
            int length = Integer.parseInt(scan.nextLine());
            int[] days = new int[length];
            int[] best = new int[3];
            int[] previousBest = new int[3];
            int[] milkProduction = new int[3];
            HashMap<Integer,int[]> map = new HashMap<>();
            for(int i = 0; i < length; i++) {
                String[] arr = scan.nextLine().split(" ");
                int day = Integer.parseInt(arr[0]);
                days[i] = day;
                int cowNum = -1;
                switch(arr[1]) {
                    case "Mildred":
                        cowNum = 0;
                    break;
                    case "Bessie":
                        cowNum = 1;
                    break;
                    case "Elsie":
                        cowNum = 2;
                    break;
                }
                int[] cowValue = {cowNum,Integer.parseInt(arr[2])};
                map.put(day,cowValue);
            }
            Arrays.sort(days);
            int ans = 0;
            for(int i = 0; i < length; i++) {
                int[] currCowValue = map.get(days[i]);
                milkProduction[currCowValue[0]] = milkProduction[currCowValue[0]] + currCowValue[1];
                if(milkProduction[0] >= milkProduction[1] && milkProduction[0] >= milkProduction[2]) {
                    best[0] = 1;
                }
                if(milkProduction[1] >= milkProduction[0] && milkProduction[1] >= milkProduction[2]) {
                    best[1] = 1;
                }
                if(milkProduction[2] >= milkProduction[0] && milkProduction[2] >= milkProduction[1]) {
                    best[2] = 1;
                }
                for(int j = 0; j < 3; j++) {
                    if(best[j] != previousBest[j]) {
                        ans++;
                        break;
                    }
                }
                for(int j = 0; j < 3; j++) {
                    previousBest[j] = best[j];
                    best[j] = 0;
                }
            }
            System.out.println(ans);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("measurement.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {

        }
        Milk milk = new Milk();
        milk.read();
    }
}
