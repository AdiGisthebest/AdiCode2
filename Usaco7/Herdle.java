import java.util.HashMap;
import java.util.Scanner;

public class Herdle {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        char [][] correctArr = new char[3][3];
        char [][] guessArr = new char[3][3];
        int correct = 0;
        int partialCorrect = 0;
        HashMap<Character,Integer> charCount = new HashMap<>();
        for(int i = 0; i < 3; i++) {
            correctArr[i] = scanner.nextLine().toCharArray();
        }
        for(int i = 0; i < 3; i++) {
            guessArr[i] = scanner.nextLine().toCharArray();
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(correctArr[i][j] == guessArr[i][j]) {
                    correct++;
                    guessArr[i][j] = '-';
                } else {
                    if(charCount.containsKey(correctArr[i][j])) {
                        charCount.put(correctArr[i][j], charCount.get(correctArr[i][j]) + 1);
                    } else {
                        charCount.put(correctArr[i][j],1);
                    }
                }
            }
        }
        //System.out.println(charCount.keySet());

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(charCount.containsKey(guessArr[i][j])) {
                    partialCorrect++;
                    if(charCount.get(guessArr[i][j]) == 1) {
                        charCount.remove(guessArr[i][j]);
                    } else {
                        charCount.put(guessArr[i][j],charCount.get(guessArr[i][j]) - 1);
                    }
                }
            }
        }
        System.out.println(correct);
        System.out.println(partialCorrect);
    }

    public static void main(String[] args) {
        Herdle herdle = new Herdle();
        herdle.read();
    }
}
