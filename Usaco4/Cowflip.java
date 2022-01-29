import com.sun.source.tree.TryTree;

import java.awt.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Cowflip {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("breedflip.in"));
            int length = Integer.parseInt(scanner.nextLine());
            char[] origArr = scanner.nextLine().toCharArray();
            char[] cowArr = scanner.nextLine().toCharArray();
            boolean prev = false;
            int ans = 0;
            for(int i = 0; i < length; i++) {
                if(origArr[i] != cowArr[i]) {
                    if(!prev) {
                        ans++;
                        prev = true;
                    }
                } else {
                    prev = false;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("breedflip.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cowflip cowflip = new Cowflip();
        cowflip.read();
    }
}
