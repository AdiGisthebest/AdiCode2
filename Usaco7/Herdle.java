import java.util.HashMap;
import java.util.Scanner;

public class Herdle {
    int correct;
    int partCorrect;
    public void read() {
        char[][] grid1 = new char[3][3];
        char[][] grid2 = new char[3][3];
        HashMap<String,Integer> counts = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            grid1[i] = scan.nextLine().toCharArray();
        }
        for(int i = 0; i < 3; i++) {
            grid2[i] = scan.nextLine().toCharArray();
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid1[i][j] == grid2[i][j]) {
                    correct++;
                    grid2[i][j] = ' ';
                } else {
                    if(!counts.containsKey(String.valueOf(grid1[i][j]))) {
                        counts.put(String.valueOf(grid1[i][j]), 1);
                    } else {
                        counts.put(String.valueOf(grid1[i][j]), counts.get(String.valueOf(grid1[i][j])) + 1);
                    }
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(counts.get(String.valueOf(grid2[i][j])) != null && counts.get(String.valueOf(grid2[i][j])) > 0) {
                    partCorrect++;
                    counts.put(String.valueOf(grid2[i][j]), counts.get(String.valueOf(grid2[i][j])) - 1);
                }
            }
        }
        System.out.println(correct);
        System.out.println(partCorrect);
    }

    public static void main(String[] args) {
        Herdle herdle = new Herdle();
        herdle.read();
    }
}