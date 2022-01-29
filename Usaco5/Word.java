

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Word {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("word.in"));
            String[] arr = scanner.nextLine().split(" ");
            int wordCnt = Integer.parseInt(arr[0]);
            int lineLen = Integer.parseInt(arr[1]);
            String[] word = scanner.nextLine().split(" ");
            int currCnt = word[0].length();
            String ans = word[0];
            for(int i = 1; i < wordCnt; i++) {
                if(currCnt+word[i].length() > lineLen) {
                    ans = ans + "\n" + word[i];
                    currCnt = word[i].length();
                } else {
                    ans = ans + " " + word[i];
                    currCnt = currCnt + word[i].length();
                }
            }
            System.out.println(ans);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("word.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
        }
        Word word = new Word();
        word.read();
    }
}
