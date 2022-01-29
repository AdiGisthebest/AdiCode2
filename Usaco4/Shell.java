import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Shell {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("shell.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int underShell = 1;
            int guess1 = 0;
            int guess2 = 0;
            int guess3 = 0;
            int[][] swaps = new int[length][2];
            int[] guesses = new int[length];
            for(int i = 0; i < length; i++) {
                String[] arr = scanner.nextLine().split(" ");
                swaps[i][0] = Integer.parseInt(arr[0]);
                swaps[i][1] = Integer.parseInt(arr[1]);
                guesses[i] = Integer.parseInt(arr[2]);
            }
            for(int i = 0; i < length; i++) {
                if(swaps[i][0] == underShell) {
                    underShell = swaps[i][1];
                } else if (swaps[i][1] == underShell) {
                    underShell = swaps[i][0];
                }
                if(guesses[i] == underShell) {
                    guess1++;
                }
            }
            underShell = 2;
            for(int i = 0; i < length; i++) {
                if(swaps[i][0] == underShell) {
                    underShell = swaps[i][1];
                } else if (swaps[i][1] == underShell) {
                    underShell = swaps[i][0];
                }
                if(guesses[i] == underShell) {
                    guess2++;
                }
            }
            underShell = 3;
            for(int i = 0; i < length; i++) {
                if(swaps[i][0] == underShell) {
                    underShell = swaps[i][1];
                } else if (swaps[i][1] == underShell) {
                    underShell = swaps[i][0];
                }
                if(guesses[i] == underShell) {
                    guess3++;
                }
            }
            if(guess3 >= guess2 && guess3 >= guess1) {
                System.out.println(guess3);
            } else if (guess2 >= guess3 && guess2 >= guess1) {
                System.out.println(guess2);
            } else {
                System.out.println(guess1);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("shell.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Shell shell = new Shell();
        shell.read();
    }
}
