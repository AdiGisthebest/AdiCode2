

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Teleportation {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("teleport.in"));
            String[] strArr = scanner.nextLine().split(" ");
            int start = Integer.parseInt(strArr[0]);
            int end = Integer.parseInt(strArr[1]);
            int telePoint1 = Integer.parseInt(strArr[2]);
            int telePoint2 = Integer.parseInt(strArr[3]);
            int absDist = Math.abs(start - end);
            int teleDist = 0;
            if(Math.abs(telePoint1 - start) < Math.abs(telePoint2 - start)) {
                teleDist = Math.abs(telePoint1 - start) + Math.abs(telePoint2-end);
            } else {
                teleDist = Math.abs(telePoint2- start) + Math.abs(telePoint1-end);
            }
            if(teleDist < absDist) {
                System.out.println(teleDist);
            } else {
                System.out.println(absDist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("teleport.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Teleportation teleportation = new Teleportation();
        teleportation.read();
    }
}
