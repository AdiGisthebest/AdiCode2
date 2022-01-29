import com.sun.source.tree.CaseTree;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

public class Traffic {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("traffic.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[][] fTraffic = new int[length][3];
            int[][] bTraffic = new int[length][3];
            for(int i = 0; i < length; i++) {
                String[] arr = scanner.nextLine().split(" ");
                fTraffic[i][1] = Integer.parseInt(arr[1]);
                fTraffic[i][2] =  Integer.parseInt(arr[2]);
                bTraffic[length-1-i][1] = Integer.parseInt(arr[1]);
                bTraffic[length-1-i][2] = Integer.parseInt(arr[2]);
                switch(arr[0]) {
                    case "on":
                        bTraffic[length-1-i][0] = 2;
                        fTraffic[i][0] = 1;
                    break;
                    case "off":
                        bTraffic[length-1-i][0] = 1;
                        fTraffic[i][0] = 2;
                    break;
                }
            }
            for(int i = 0; i < length; i++) {
                switch(fTraffic[i][0]) {
                    case 1:
                       for(int j = i+1; j < length; j++) {
                           fTraffic[j][1] = fTraffic[j][1] - fTraffic[i][1];
                           fTraffic[j][2] = fTraffic[j][2] - fTraffic[i][2];
                       }
                    break;
                    case 2:
                        for(int j = i+1; j < length; j++) {
                            fTraffic[j][1] = fTraffic[j][1] + fTraffic[i][2];
                            fTraffic[j][2] = fTraffic[j][2] + fTraffic[i][1];
                        }
                }
            }
            for(int i = 0; i < length; i++) {
                switch(bTraffic[i][0]) {
                    case 1:
                        for(int j = i+1; j < length; j++) {
                            bTraffic[j][1] = bTraffic[j][1] - bTraffic[i][2];
                            bTraffic[j][2] = bTraffic[j][2] - bTraffic[i][1];
                        }
                        break;
                    case 2:
                        for(int j = i+1; j < length; j++) {
                            bTraffic[j][1] = bTraffic[j][1] + bTraffic[i][1];
                            bTraffic[j][2] = bTraffic[j][2] + bTraffic[i][2];
                        }
                }
            }
            int[] forward = new int[2];
            boolean first = false;
            for(int i = 0; i < length; i++) {
                if(fTraffic[i][0] == 0) {
                    if(!first) {
                        first = true;
                        forward[0] = fTraffic[i][1];
                        forward[1] = fTraffic[i][2];
                    } else {
                        if(forward[0] < fTraffic[i][1]) {
                            forward[0] = fTraffic[i][1];
                        } else if (forward[1] > fTraffic[i][2]) {
                            forward[1] = fTraffic[i][2];
                        }
                    }
                }
            }
            System.out.println(forward[0] + " " + forward[1]);
            first = false;
            int[] backward = new int[2];
            for(int i = 0; i < length; i++) {
                if(bTraffic[i][0] == 0) {
                    if(!first) {
                        first = true;
                        backward[0] = bTraffic[i][1];
                        backward[1] = bTraffic[i][2];
                    } else {
                        if(backward[0] < bTraffic[i][1]) {
                            backward[0] = bTraffic[i][1];
                        } else if (backward[1] > bTraffic[i][2]) {
                            backward[1] = bTraffic[i][2];
                        }
                    }
                }
            }
            System.out.println(backward[0] + " " + backward[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("traffic.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Traffic traffic = new Traffic();
        traffic.read();
    }
}
