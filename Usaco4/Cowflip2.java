import com.sun.source.tree.TryTree;

import java.awt.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Cowflip2 {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("breedflip.in"));
            int length = Integer.parseInt(scanner.nextLine());
            char[] origArr = scanner.nextLine().toCharArray();
            char[] cowArr = scanner.nextLine().toCharArray();
            int ans = 0;
            int[] diffs = new int[length];
            for(int i = 0; i < length; i++) {
                if(origArr[i] == cowArr[i]) {
                    diffs[i] = 1;
                } else {
                    diffs[i] = 0;
                }
            }

            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cowflip2 cowflip = new Cowflip2();
        cowflip.read();
    }
}