import java.util.Scanner;

public class Bulky {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split(" ");
        int gridSize = Integer.parseInt(strArr[0]);
        int length = Integer.parseInt(strArr[1]);
        int[][] grid = new int[gridSize][gridSize];
        for(int i = 0; i < gridSize; i++) {
            strArr = scanner.nextLine().split(" ");
            for(int j = 0; j < gridSize; j++) {
                grid[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        for(int i = 0; i < length; i++) {

        }
    }
    public int solve(int[][] grid, int startX, int startY, int endX, int endY) {
        if(startX < endX) {
            if(startY < endY) {
                int maxElev = 0;

            }
        } else {

        }
    }
}
