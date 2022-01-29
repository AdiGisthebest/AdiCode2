import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Socdist1 {
    public void read() {
        try {
           Scanner scanner = new Scanner(new File("socdist1.in"));
           int length = Integer.parseInt(scanner.nextLine());
           int[] stallArr = new int[length];
           int[] stallArr2 = new int[length];
           String[] strArr = scanner.nextLine().split("");
           for(int i = 0; i < length; i++) {
               stallArr[i] = Integer.parseInt(strArr[i]);
               stallArr2[i] = stallArr[i];
           }
           stallArr = this.addCows(stallArr);
           stallArr = this.addCows(stallArr);
           stallArr2 = this.addCowsInSameGap(stallArr2);
           int gapLength = 0;
           int minGap = Integer.MAX_VALUE;
           for(int i = 1; i < length; i++) {
               //System.out.print(stallArr[i]);
               if(stallArr[i] == 0) {
                   gapLength++;
               } else {
                   if(gapLength < minGap) {
                       minGap = gapLength;
                   }
                   gapLength = 0;
               }
           }
            //System.out.println();
            int gapLength2 = 0;
            int minGap2 = Integer.MAX_VALUE;
            for(int i = 1; i < length; i++) {
                //System.out.print(stallArr2[i]);
                if(stallArr2[i] == 0) {
                    gapLength2++;
                } else {
                    if(gapLength2 < minGap2) {
                        minGap2 = gapLength2;
                    }
                    gapLength2 = 0;
                }
            }
            //System.out.println();
            if(minGap > minGap2) {
                System.out.println(minGap+1);
            } else {
                System.out.println(minGap2+1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public int[] addCowsInSameGap(int[] stallArr) {
        int gapLength = 0;
        int maxGap = 0;
        int maxGapStart = 0;
        int gapStart = -1;
        boolean prev = false;
        for(int i = 0; i < stallArr.length; i++) {
            if(stallArr[i] == 0) {
                if(!prev) {
                    gapStart = i;
                }
                prev = true;
                gapLength++;
                if(gapLength > maxGap) {
                    maxGap = gapLength;
                    maxGapStart = gapStart;
                }
            } else {
                gapLength = 0;
                gapStart = -1;
                prev = false;
            }
        }
        stallArr[maxGapStart + maxGap/3] = 1;
        stallArr[maxGapStart + maxGap * 2/3] = 1;
        return stallArr;
    }
    public int[] addCows(int[] stallArr) {
        int gapLength = 0;
        int maxGap = 0;
        int maxGapStart = 0;
        int gapStart = -1;
        boolean prev = false;
        for(int i = 0; i < stallArr.length; i++) {
            if(stallArr[i] == 0) {
                if(!prev) {
                    gapStart = i;
                }
                prev = true;
                gapLength++;
                if(gapLength > maxGap) {
                    maxGap = gapLength;
                    maxGapStart = gapStart;
                }
            } else {
                gapLength = 0;
                gapStart = -1;
                prev = false;
            }
        }
        stallArr[maxGapStart+maxGap/2] = 1;
        return stallArr;
    }
    public static void main(String[] args) {
        try {
            File file = new File("socdist1.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Socdist1 socdist1 = new Socdist1();
        socdist1.read();
    }
}
