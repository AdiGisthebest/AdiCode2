

import java.io.File;
import java.util.Scanner;

public class Comfy {
    public void read() {
        try {
            Scanner scan = new Scanner(System.in);
            int length = Integer.parseInt(scan.nextLine());
            int[][] coords = new int[length][2];
            for(int i = 0; i < length; i++) {
                String[] splitStr = scan.nextLine().split(" ");
                coords[i][0] = Integer.parseInt(splitStr[0]);
                coords[i][1] = Integer.parseInt(splitStr[1]);
            }
            int[][] cowMatrix = new int[1000][1000];
            for(int i = 0; i < length; i++) {
                int count = 0;
                cowMatrix[coords[i][0]][coords[i][1]] = 1;
                for(int j = 0; j < 1000; j++) {
                    for(int k = 0; k < 1000; k++) {
                        if(cowMatrix[j][k] == 1) {
                            int cowCount = 0;
                            if(j != 0 && cowMatrix[j-1][k] == 1) {
                                cowCount++;
                            }
                            if(j != 1000 && cowMatrix[j+1][k] == 1) {
                                cowCount++;
                            }
                            if(k != 1000 && cowMatrix[j][k+1] == 1) {
                                cowCount++;
                            }
                            if(k != 0 && cowMatrix[j][k-1] == 1) {
                                cowCount++;
                            }
                            if(cowCount == 3) {
                                count++;
                            }
                        }
                    }
                }
                System.out.println(count);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Comfy comfy = new Comfy();
        comfy.read();
    }
}
