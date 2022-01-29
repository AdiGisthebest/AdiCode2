import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class MilkMix {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("mixmilk.in"));
            int[] bucket1 = new int[2];
            int[] bucket2 = new int[2];
            int[] bucket3 = new int[2];
            String[] bucketArr = scanner.nextLine().split(" ");
            bucket1[0] = Integer.parseInt(bucketArr[0]);
            bucket1[1] = Integer.parseInt(bucketArr[1]);
            bucketArr = scanner.nextLine().split(" ");
            bucket2[0] = Integer.parseInt(bucketArr[0]);
            bucket2[1] = Integer.parseInt(bucketArr[1]);
            bucketArr = scanner.nextLine().split(" ");
            bucket3[0] = Integer.parseInt(bucketArr[0]);
            bucket3[1] = Integer.parseInt(bucketArr[1]);
            int counter = 1;
            for(int i = 1; i <= 100; i++) {
                if(counter == 3) {
                    int milkCapacity = bucket1[0] - bucket1[1];
                    if(bucket3[1] >= milkCapacity) {
                        bucket3[1] = bucket3[1] - milkCapacity;
                        bucket1[1] = bucket1[0];
                    } else {
                        bucket1[1] = bucket1[1] + bucket3[1];
                        bucket3[1] = 0;
                    }
                    counter = 1;
                } else if (counter == 2) {
                    int milkCapacity = bucket3[0] - bucket3[1];
                    if(bucket2[1] >= milkCapacity) {
                        bucket2[1] = bucket2[1] - milkCapacity;
                        bucket3[1] = bucket3[0];
                    } else {
                        bucket3[1] = bucket2[1] + bucket3[1];
                        bucket2[1] = 0;
                    }
                    counter++;
                } else {
                    int milkCapacity = bucket2[0] - bucket2[1];
                    if(bucket1[1] >= milkCapacity) {
                        bucket1[1] = bucket1[1] - milkCapacity;
                        bucket2[1] = bucket2[0];
                    } else {
                        bucket2[1] = bucket1[1] + bucket2[1];
                        bucket1[1] = 0;
                    }
                    counter++;
                }
                /*System.out.print(bucket1[1] + " ");
                System.out.print(bucket2[1] + " ");
                System.out.print(bucket3[1] + " ");
                System.out.println();*/

            }
            System.out.println(bucket1[1]);
            System.out.println(bucket2[1]);
            System.out.println(bucket3[1]);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("mixmilk.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MilkMix milkmix = new MilkMix();
        milkmix.read();
    }
}
