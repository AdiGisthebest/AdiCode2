import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Out {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("outofplace.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[] cowHeights = new int[length];
            int[] correctOrder = new int[length];
            for(int i = 0; i < length; i++) {
                cowHeights[i] = Integer.parseInt(scanner.nextLine());
                correctOrder[i] = cowHeights[i];
            }
            Arrays.sort(correctOrder);
            boolean[] diffs = new boolean[2];
            int[] pos = new int[2];
            boolean first = false;
            for(int i = 0; i < length; i++) {
                if(correctOrder[i] != cowHeights[i] && first == false) {
                    first = true;
                    pos[0] = i;
                    if(i > 0) {
                        if(cowHeights[i-1] < cowHeights[i]) {
                            diffs[0] = true;
                        } else {
                            diffs[0] = false;
                        }
                    } else {
                        diffs[0] = true;
                    }
                }
                if(correctOrder[i] != cowHeights[i] && first == true) {
                    pos[1] = i;
                    if(i > 0) {
                        if(cowHeights[i-1] < cowHeights[i]) {
                            diffs[1] = true;
                        } else {
                            diffs[1] = false;
                        }
                    } else {
                        diffs[1] = true;
                    }
                }
            }
            if(!first){
                System.out.println(0);
                return;
            }
            boolean bessiePos = diffs[0] && diffs[1];
            int count = 0;
            if(!bessiePos) {
                for(int i = pos[0]; i < pos[1]; i++) {
                    //System.out.println(cowHeights[i]);
                    if(i != 0) {
                        if(cowHeights[i] != cowHeights[i-1]) {
                            count++;
                        }
                    } else {
                        count++;
                    }
                }
            } else {
                for(int i = pos[0]+1; i <= pos[1]; i++) {
                    //System.out.println(cowHeights[i]);
                    if(i != 0) {
                        if(cowHeights[i] != cowHeights[i-1]) {
                            count++;
                        }
                    } else {
                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("outofplace.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Out out = new Out();
        out.read();
    }
}
