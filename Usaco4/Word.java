import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Word {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("word.in"));
            String[] arr = scanner.nextLine().split(" ");
            int wordCnt = Integer.parseInt(arr[0]);
            int charPerLine = Integer.parseInt(arr[1]);
            String[] words = scanner.nextLine().split(" ");
            int lineCnt = 0;
            String printString = "";
            for(int i = 0; i < wordCnt; i++) {
                if(lineCnt + words[i].length() <= charPerLine) {
                    if(i != 0) {
                        printString = printString+" "+words[i];
                    } else {
                        printString = printString+words[i];
                    }
                    lineCnt = lineCnt + words[i].length();
                } else {
                    printString = printString+"\n"+words[i];
                    lineCnt = words[i].length();
                }
            }
            System.out.println(printString);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("word.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Word word = new Word();
        word.read();
    }
}
