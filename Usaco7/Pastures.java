import java.util.Arrays;
import java.util.Scanner;

public class Pastures {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        String[] arr =scanner.nextLine().split(" ");
        int[] rect1 = formatRect(new int[] {Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3])});
        arr = scanner.nextLine().split(" ");
        int[] rect2 = formatRect(new int[] {Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3])});
        System.out.println(Arrays.toString(rect1));
        System.out.println(Arrays.toString(rect2));
        if(intersects(rect1,rect2)) {
            System.out.println("MOO");
        } else {
            System.out.println("MOO MOO");
            System.out.println(findDistBetweenRects(rect1, rect2));
        }
    }
    public boolean intersects(int[] rect1, int[] rect2) {
        int[][] grid = new int[1000][1000];
        for(int i = rect1[0]; i < rect1[2]; i++) {
            for(int j = rect1[1]; j < rect1[3]; j++) {
                grid[j][i] = 1;
            }
        }
        for(int i = rect2[0]; i < rect2[2]; i++) {
            for(int j = rect2[1]; j < rect2[3]; j++) {
                if(grid[j][i] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public int[] formatRect(int[] rect) {
        if(rect[0] > rect[2] && rect[1] < rect[3]) {
            return new int[] {rect[2],rect[1],rect[0],rect[3]};
        }
        if(rect[0] < rect[2] && rect[1] > rect[3]) {
            return new int[] {rect[0],rect[3],rect[1],rect[2]};
        }
        return rect;
    }
    public int findDistBetweenRects(int[] rect1, int[] rect2) {
        int[][] corners1 = new int[4][2];
        corners1[0] = new int[]{rect1[0],rect1[1]};
        corners1[1] = new int[]{rect1[0],rect1[3]};
        corners1[2] = new int[]{rect1[2],rect1[1]};
        corners1[3] = new int[]{rect1[2],rect1[3]};
        int minDist = Integer.MAX_VALUE;
        for(int k = 0; k < 4; k++) {
            for(int i = rect2[0]; i < rect2[2]; i++) {
                for(int j = rect2[1]; j < rect2[3]; j++) {
                    int dist = this.findDist(corners1[k][0],corners1[k][1],i,j);
                    System.out.println(dist);
                    if(dist < minDist) {
                        minDist = dist;
                    }
                }
            }
        }
        return minDist;
    }
    public int findDist(int x1, int y1, int x2, int y2) {
        return (x1-x2) + (y1-y2);
    }
    public boolean inside(int x1, int y1, int[] rect) {
        if(x1 > rect[0] && x1 < rect[2]) {
            if(y1 > rect[1] && y1 < rect[3]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Pastures pastures = new Pastures();
        pastures.read();
    }
}
