
import java.util.Scanner;
public class Magic {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] square = new int[size][size];
        int[] columnSum = new int[size];
        int[] rowSum = new int[size];
        for (int i = 0; i < size; i++) {
            String[] strArr = scanner.nextLine().split(" ");
            for(int j = 0; j < size; j++) {
                square[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                columnSum[i] = columnSum[i] + square[i][j];
            }
        }
    }
}
