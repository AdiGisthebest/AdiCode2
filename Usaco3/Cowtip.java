import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Cowtip {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("cowtip.in"));
            int length = Integer.parseInt(scan.nextLine());
            int[][] cows = new int[length][length];
            int[][] points = new int[length*length][2];
            for(int i = 0; i < length; i++) {
                String[] strArr = scan.nextLine().split("");
                for(int j = 0; j < length; j++) {
                    cows[i][j] = Integer.parseInt(strArr[j]);
                }
            }
            int count = 0;
            for(int i = length - 1; i >= 0; i--) {
                for(int j = length - 1; j >= 0; j--) {
                    if(cows[i][j] == 1) {
                        int[] point1 = new int[2];
                        point1[0] = i;
                        point1[1] = j;
                        /*for(int k = 0; k < length; k++) {
                            for(int z = 0; z < length; z++) {
                                System.out.print(cows[k][z]);
                            }
                            System.out.println();
                        }*/
                        //System.out.println();
                        cows = this.tipCows(point1,cows);
                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public int[][] tipCows(int[] point1, int[][] totalMatrix) {
        for(int i = 0; i <= point1[0]; i++) {
            for(int j = 0; j <= point1[1]; j++) {
                if(totalMatrix[i][j] == 1) {
                    totalMatrix[i][j] = 0;
                } else {
                    totalMatrix[i][j] = 1;
                }
            }
        }
        return totalMatrix;
    }

    public static void main(String[] args) {
        try {
            File file = new File("cowtip.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cowtip cowtip = new Cowtip();
        cowtip.read();
    }
}
