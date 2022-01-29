import java.io.File;
import java.util.Scanner;

public class Herd {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        char[] cowphabet = scanner.nextLine().toCharArray();
        char[] word = scanner.nextLine().toCharArray();
        int cnt = 1;
        int iter = 0;
        for(int i = 0; i < 26; i++) {
            //System.out.println(cowphabet[i] + " " + word[iter]);
            if(cowphabet[i] == word[iter]) {
                iter++;
            }
            if(iter == word.length) {
                break;
            }
            if(i == 25) {
                i = -1;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Herd herd = new Herd();
        herd.read();
    }
}
