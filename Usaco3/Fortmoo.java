import com.sun.source.tree.TryTree;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Fortmoo {
    public void read() {
        try{
            Scanner scanner = new Scanner(new File("fortmoo.in"));
            String[] strArr = scanner.nextLine().split(" ");
            int height =  Integer.parseInt(strArr[0]);
            int width = Integer.parseInt(strArr[1]);
            char[][] matrix = new char[height][width];
            int[][] allPossiblePoints = new int[height*width][2];
            int iterator = 0;
            int maxSize = 0;
            for(int i = 0; i < height; i++) {
                char[] arr = scanner.nextLine().toCharArray();
                matrix[i] = arr;
            }
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    int[] arr = {j,i};
                    //System.out.println(j + " " + i);
                    allPossiblePoints[iterator] = arr;
                    iterator++;
                }
            }
            for(int i = 0; i < allPossiblePoints.length; i++) {
                for(int j = i+1; j < allPossiblePoints.length; j++) {
                    if(this.fits(allPossiblePoints[i],allPossiblePoints[j],matrix)) {
                        //System.out.println(allPossiblePoints[i][0] +" "+ allPossiblePoints[i][1] + "   " + allPossiblePoints[j][0] + " " + allPossiblePoints[j][1]);
                        //System.out.println(Math.abs(allPossiblePoints[i][0] - allPossiblePoints[j][0]) * Math.abs(allPossiblePoints[i][1] - allPossiblePoints[j][1]));
                        if(Math.abs(allPossiblePoints[i][0] - allPossiblePoints[j][0]) * Math.abs(allPossiblePoints[i][1] - allPossiblePoints[j][1]) > maxSize) {
                            maxSize = (Math.abs(allPossiblePoints[i][0] - allPossiblePoints[j][0]) + 1) * (Math.abs(allPossiblePoints[i][1] - allPossiblePoints[j][1])+1);
                        }
                    }
                }
            }
            System.out.println(maxSize);
        } catch (Exception e) {

        }
    }
    public boolean fits(int[] cord1, int[] cord2, char[][] matrix) {
        if(cord1[0] - cord2[0] > 0) {
            for(int i = cord2[0]; i < cord1[0]; i++) {
                if(matrix[cord1[1]][i] == 'X') {
                    return false;
                }
                if(matrix[cord2[1]][i] == 'X') {
                    return false;
                }
            }
        } else {
            for(int i = cord1[0]; i < cord2[0]; i++) {
                if(matrix[cord1[1]][i] == 'X') {
                    return false;
                }
                if(matrix[cord2[1]][i] == 'X') {
                    return false;
                }
            }
        }
        if(cord1[1] - cord2[1] > 0) {
            for(int i = cord2[1]; i < cord1[1]; i++) {
                if(matrix[i][cord1[0]] == 'X') {
                    return false;
                }
                if(matrix[i][cord2[0]] == 'X') {
                    return false;
                }
            }
        } else {
            for(int i = cord1[1]; i < cord2[1]; i++) {
                if(matrix[i][cord1[0]] == 'X') {
                    return false;
                }
                if(matrix[i][cord2[0]] == 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] arr = {{'.','.','.'},{'.','X','.'},{'.','.','.'}};
        int[] cord1 = {0,0};
        int[] cord2 = {1,2};
        try {
            File file = new File("fortmoo.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Fortmoo fortmoo = new Fortmoo();
        fortmoo.read();
    }
}
