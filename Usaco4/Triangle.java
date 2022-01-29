import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Triangle {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("triangles.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[][] points = new int[length][2];
            int maxAns = 0;
            for(int i = 0; i < length; i++) {
                String[] strArr = scanner.nextLine().split(" ");
                int[] arr = new int[2];
                arr[0] = Integer.parseInt(strArr[0]);
                arr[1] = Integer.parseInt(strArr[1]);
                points[i] = arr;
            }
            for(int i = 0; i < length; i++) {
                int maxX = 0;
                int maxY = 0;
                for(int j = 0; j < length; j++) {
                    if(points[i][0] == points[j][0]) {
                        int num = Math.abs(points[i][1] - points[j][1]);
                        //System.out.println(num);
                        if(num >= maxY) {
                            maxY = num;
                        }
                    }
                    if(points[i][1] == points[j][1]) {
                        int num = Math.abs(points[j][0] - points[i][0]);
                        //System.out.println(num);
                        if(num >= maxX) {
                            maxX = num;
                        }
                    }
                }
                int ans = maxX * maxY;

                if(ans >= maxAns) {
                    maxAns = ans;
                }
            }
            System.out.println(maxAns);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("triangles.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Triangle triangle = new Triangle();
        triangle.read();
    }
}
