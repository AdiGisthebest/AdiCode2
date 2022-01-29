import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class BucketBrigade {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("buckets.in"));
            int[][] grid = new int[10][10];
            int[] rockCoords = new int[2];
            int[] barnCoords = new int[2];
            int[] lakeCoords = new int[2];
            for(int i = 0; i < 10; i++) {
                char[] arr = scanner.nextLine().toCharArray();
                for(int j = 0; j < 10; j ++) {
                    switch(arr[j]) {
                        case 'B':
                            grid[i][j] = 1;
                            barnCoords[0] = i;
                            barnCoords[1] = j;
                        break;
                        case 'R':
                            grid[i][j] = 2;
                            rockCoords[0] = i;
                            rockCoords[1] = j;
                        break;
                        case 'L':
                            grid[i][j] = 3;
                            lakeCoords[0] = i;
                            lakeCoords[1] = j;
                    }
                }
            }
            int length = Math.abs(lakeCoords[0] - barnCoords[0]) + Math.abs(lakeCoords[1] - barnCoords[1]) - 1;
            if (lakeCoords[0] == barnCoords[0]) {
                if(lakeCoords[1] < barnCoords[1]) {
                    for(int i = lakeCoords[1]; i < barnCoords[1]; i++) {
                        if(grid[lakeCoords[0]][i] == 2) {
                            length = length + 2;
                        }
                    }
                } else {
                    for(int i = barnCoords[1]; i < lakeCoords[1]; i++) {
                        if(grid[lakeCoords[0]][i] == 2) {
                            length = length + 2;
                        }
                    }
                }
            } else if(lakeCoords[1] == barnCoords[1]) {
                if(lakeCoords[0] < barnCoords[0]) {
                    for(int i = lakeCoords[0]; i < barnCoords[0]; i++) {
                        if(grid[i][lakeCoords[1]] == 2) {
                            length = length + 2;
                        }
                    }
                } else {
                    for(int i = barnCoords[0]; i < lakeCoords[0]; i++) {
                        if(grid[i][lakeCoords[1]] == 2) {
                            length = length + 2;
                        }
                    }
                }
            }
            System.out.println(length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("buckets.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
        }
        BucketBrigade brigade = new BucketBrigade();
        brigade.read();
    }
}
