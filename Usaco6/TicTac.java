import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class TicTac {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("tttt.in"));
            char[][] board = new char[3][3];
            HashSet<Character> oneWins = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                board[i] = scanner.nextLine().toCharArray();
            }
            HashSet<String> twoWinners = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                HashSet<Character> checkSet = new HashSet<>();
                int distinct = 0;
                for(int j = 0; j < 3; j++) {
                    if(!checkSet.contains(board[j][i])) {
                        distinct++;
                        checkSet.add(board[j][i]);
                    }
                }
                if(distinct == 1) {
                    Character[] arr = new Character[1];
                    checkSet.toArray(arr);
                    oneWins.add(arr[0]);
                } else if (distinct == 2) {
                    Character[] arr = new Character[2];
                    checkSet.toArray(arr);
                    String str1 = arr[0].charValue()+""+arr[1].charValue();
                    String str2 = arr[1].charValue()+""+arr[0].charValue();
                    twoWinners.add(str1);
                    twoWinners.add(str2);
                }
            }
            for(int i = 0; i < 3; i++) {
                HashSet<Character> checkSet = new HashSet<>();
                int distinct = 0;
                for(int j = 0; j < 3; j++) {
                    if(!checkSet.contains(board[i][j])) {
                        distinct++;
                        checkSet.add(board[i][j]);
                    }
                }
                if(distinct == 1) {
                    Character[] arr = new Character[1];
                    checkSet.toArray(arr);
                    oneWins.add(arr[0]);
                } else if (distinct == 2) {
                    Character[] arr = new Character[2];
                    checkSet.toArray(arr);
                    String str1 = arr[0].charValue()+""+arr[1].charValue();
                    String str2 = arr[1].charValue()+""+arr[0].charValue();
                    twoWinners.add(str1);
                    twoWinners.add(str2);
                }
            }

            HashSet<Character> checkSet = new HashSet<>();
            int distinct = 0;
            for(int i = 0; i < 3; i++) {
                if(!checkSet.contains(board[i][i])) {
                    distinct++;
                    checkSet.add(board[i][i]);
                }
            }
            if(distinct == 1) {
                Character[] arr = new Character[1];
                checkSet.toArray(arr);
                oneWins.add(arr[0]);
            } else if (distinct == 2) {
                Character[] arr = new Character[2];
                checkSet.toArray(arr);
                String str1 = arr[0].charValue()+""+arr[1].charValue();
                String str2 = arr[1].charValue()+""+arr[0].charValue();
                twoWinners.add(str1);
                twoWinners.add(str2);
            }
            distinct = 0;
            checkSet = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                if(!checkSet.contains(board[i][2-i])) {
                    distinct++;
                    checkSet.add(board[i][2-i]);
                }
            }
            if(distinct == 1) {
                Character[] arr = new Character[1];
                checkSet.toArray(arr);
                oneWins.add(arr[0]);
            } else if (distinct == 2) {
                Character[] arr = new Character[2];
                checkSet.toArray(arr);
                String str1 = arr[0].charValue()+""+arr[1].charValue();
                String str2 = arr[1].charValue()+""+arr[0].charValue();
                twoWinners.add(str1);
                twoWinners.add(str2);
            }
            System.out.println(oneWins.size());
            System.out.println(twoWinners.size()/2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("tttt.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        TicTac tictac = new TicTac();
        tictac.read();
    }
}
