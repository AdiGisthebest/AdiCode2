//package Usaco5;

import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class Photo {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("photo.in"));
            int numLen = Integer.parseInt(scanner.nextLine());
            HashSet<Integer> contains = new HashSet<>();
            HashSet<Integer> range = new HashSet<>();
            String[] strArr = scanner.nextLine().split(" ");
            int[] numbers = new int[numLen-1];
            int startNum = 1;
            for(int i = 0; i < numLen-1; i++) {
                numbers[i] = Integer.parseInt(strArr[i]);
            }
            for(int i = 0; i < numLen; i++) {
                range.add(i+1);
            }
            for(int i = 0; i < numLen; i++) {
                int[] nums = new int[numLen];
                nums[0] = startNum;
                contains.add(startNum);
                boolean broken = false;
                int currNum = startNum;
                for(int j = 0; j < numLen-1; j++) {
                    currNum = numbers[j] - currNum;
                    nums[j+1] = currNum;
                    if(!contains.contains(currNum) && range.contains(currNum)) {
                        contains.add(currNum);
                    } else {
                        broken = true;
                        break;
                    }
                }
                if(!broken) {
                    for(int j = 0; j < numLen-1; j++) {
                        System.out.print(nums[j] + " ");
                    }
                    System.out.print(nums[numLen-1]);
                    return;
                } else {
                    startNum++;
                    contains = new HashSet<>();
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("photo.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
        }
        Photo photo = new Photo();
        photo.read();
    }
}
