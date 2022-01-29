import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Grass {
    int[][] graph;
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("revegetate.in"));
            String[] strArr = scanner.nextLine().split(" ");
            int pastureNum = Integer.parseInt(strArr[0]);
            int cowNum = Integer.parseInt(strArr[1]);
            graph = new int[pastureNum][pastureNum];
            for(int i = 0; i < cowNum; i++) {
                strArr = scanner.nextLine().split(" ");
                int cow1 = Integer.parseInt(strArr[0]) - 1;
                int cow2 = Integer.parseInt(strArr[1]) - 1;
                graph[cow1][cow2] = 1;
                graph[cow2][cow1] = 1;
            }
            int[] grassType = new int[pastureNum];
            for(int i = 0; i < pastureNum; i++) {
                grassType[i] = 1;
            }
            for(int i = 0; i < pastureNum; i++) {
                for(int j = 0; j < pastureNum; j++) {
                    if(graph[i][j] == 1) {
                        if(grassType[i] == grassType[j]) {
                            if(i < j) {
                                grassType[j]++;
                            } else if (i > j) {
                                grassType[i]++;
                            }
                        }
                    }
                }
            }
            String ans = "";
            for(int i = 0; i < pastureNum; i++) {
                ans = ans + grassType[i];
            }
            System.out.println(ans);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("revegetate.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Grass grass = new Grass();
        grass.read();
    }
}
