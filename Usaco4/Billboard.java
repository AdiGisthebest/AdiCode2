import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Billboard {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("billboard.in"));
            String[] rect = scanner.nextLine().split(" ");
            int[] lawnBoard = new int[4];
            lawnBoard[0] = Integer.parseInt(rect[0]);
            lawnBoard[1] = Integer.parseInt(rect[1]);
            lawnBoard[2] = Integer.parseInt(rect[2]);
            lawnBoard[3] = Integer.parseInt(rect[3]);
            rect = scanner.nextLine().split(" ");
            int[] foodBoard = new int[4];
            foodBoard[0] = Integer.parseInt(rect[0]);
            foodBoard[1] = Integer.parseInt(rect[1]);
            foodBoard[2] = Integer.parseInt(rect[2]);
            foodBoard[3] = Integer.parseInt(rect[3]);
            int totalArea = (lawnBoard[3] - lawnBoard[1]) * (lawnBoard[2] - lawnBoard[0]);
            if (foodBoard[3] >= lawnBoard[3] && foodBoard[1] <= lawnBoard[1]) {
                if(foodBoard[2] < lawnBoard[2] && foodBoard[0] > lawnBoard[0]) {
                    System.out.println(totalArea);
                    return;
                } else if (foodBoard[2] < lawnBoard[2]) {
                    int areaSub = (foodBoard[2] - lawnBoard[0]) * (lawnBoard[3] - lawnBoard[1]);
                    int tarpArea = totalArea - areaSub;
                    if(tarpArea < 0) {
                        System.out.println(0);
                        return;
                    } else if (tarpArea > totalArea) {
                        System.out.println(totalArea);
                        return;
                    } else {
                        System.out.println(tarpArea);
                        return;
                    }
                } else {
                    int areaSub = (lawnBoard[2] - foodBoard[0]) * (lawnBoard[3] - lawnBoard[1]);
                    int tarpArea = totalArea - areaSub;
                    if(tarpArea < 0) {
                        System.out.println(0);
                        return;
                    } else if (tarpArea > totalArea) {
                        System.out.println(totalArea);
                        return;
                    } else {
                        System.out.println(tarpArea);
                        return;
                    }
                }
            } else if (foodBoard[2] >= lawnBoard[2] && foodBoard[0] <= lawnBoard[0]) {
                if(foodBoard[3] < lawnBoard[3] && foodBoard[1] > lawnBoard[1]) {
                    System.out.println(totalArea);
                    return;
                } else if (foodBoard[3] < lawnBoard[3]) {
                    int areaSub = (foodBoard[3] - lawnBoard[1]) * (lawnBoard[2] - lawnBoard[0]);
                    int tarpArea = totalArea - areaSub;
                    if(tarpArea < 0) {
                        System.out.println(0);
                        return;
                    } else if (tarpArea > totalArea) {
                        System.out.println(totalArea);
                        return;
                    } else {
                        System.out.println(tarpArea);
                        return;
                    }
                } else {
                    int areaSub = (lawnBoard[3] - foodBoard[1]) * (lawnBoard[2] - lawnBoard[0]);
                    int tarpArea = totalArea - areaSub;
                    if(tarpArea < 0) {
                        System.out.println(0);
                        return;
                    } else if (tarpArea > totalArea) {
                        System.out.println(totalArea);
                        return;
                    } else {
                        System.out.println(tarpArea);
                        return;
                    }
                }
            }
            System.out.println(totalArea);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("billboard.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Billboard billboard = new Billboard();
        billboard.read();
    }
}
