import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

public class Reduction {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("reduce.in"));
            int length = Integer.parseInt(scanner.nextLine());
            ArrayList<int[]>cows = new ArrayList<>();
            int[] leftMostCow = new int[2];
            int[] rightMostCow = new int[2];
            int[] topMostCow = new int[2];
            int[] bottomMostCow = new int[2];
            for(int i = 0; i < length; i++) {
                String[] stringArr = scanner.nextLine().split(" ");
                int[] arr = new int[2];
                int cowX = Integer.parseInt(stringArr[0]);
                int cowY = Integer.parseInt(stringArr[1]);
                arr[0] = cowX;
                arr[1] = cowY;
                cows.add(arr);
            }
            int minY = Integer.MAX_VALUE;
            int minX = Integer.MAX_VALUE;
            int maxX = 0;
            int maxY = 0;
            for(int i = 0; i < length; i++) {
                int[] arr = cows.get(i);
                if(arr[0] < minX) {
                    minX = arr[0];
                    rightMostCow = arr;
                }
                if(arr[0] > maxX) {
                    maxX = arr[0];
                    leftMostCow = arr;
                }
                if(arr[1] < minY) {
                    minY = arr[1];
                    topMostCow = arr;
                }
                if(arr[1] > maxY) {
                    maxY = arr[1];
                    bottomMostCow = arr;
                }
            }
            int area = (maxX-minX) * (maxY-minY);
            for(int i = 0; i < 4; i++) {
                switch(i) {
                    case 0:
                        cows.remove(topMostCow);
                        break;
                    case 1:
                        cows.remove(bottomMostCow);
                        break;
                    case 2:
                        cows.remove(leftMostCow);
                        break;
                    case 3:
                        cows.remove(rightMostCow);
                        break;
                }
                int tempMinY = Integer.MAX_VALUE;
                int tempMinX = Integer.MAX_VALUE;
                int tempMaxX = 0;
                int tempMaxY = 0;
                for(int j = 0; j < length-1; j++) {
                    int[] arr = cows.get(j);
                    if(arr[0] < tempMinX) {
                        tempMinX = arr[0];
                    }
                    if(arr[0] > tempMaxX) {
                        tempMaxX = arr[0];
                    }
                    if(arr[1] < tempMinY) {
                        tempMinY = arr[1];
                    }
                    if(arr[1] > tempMaxY) {
                        tempMaxY = arr[1];
                    }
                }
                int tempArea = (tempMaxX-tempMinX) * (tempMaxY-tempMinY);
                if(tempArea < area) {
                    area = tempArea;
                }
                switch(i) {
                    case 0:
                        cows.add(topMostCow);
                        break;
                    case 1:
                        cows.add(bottomMostCow);
                        break;
                    case 2:
                        cows.add(leftMostCow);
                        break;
                    case 3:
                        cows.add(rightMostCow);
                        break;
                }
            }
            System.out.println(area);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("reduce.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        Reduction reduction = new Reduction();
        reduction.read();
    }
}
