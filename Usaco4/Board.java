import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Board {
    public void read() {
        try {
            int[][] space = new int[2001][2001];
            Scanner scan= new Scanner(new File("billboard.in"));
            String[] strArr = scan.nextLine().split(" ");
            int[] billboard1 = new int[4];
            billboard1[0] = Integer.parseInt(strArr[0]);
            billboard1[1] = Integer.parseInt(strArr[1]);
            billboard1[2] = Integer.parseInt(strArr[2]);
            billboard1[3] = Integer.parseInt(strArr[3]);
            strArr = scan.nextLine().split(" ");
            int[] billboard2 = new int[4];
            billboard2[0] = Integer.parseInt(strArr[0]);
            billboard2[1] = Integer.parseInt(strArr[1]);
            billboard2[2] = Integer.parseInt(strArr[2]);
            billboard2[3] = Integer.parseInt(strArr[3]);
            strArr = scan.nextLine().split(" ");
            int[] truck = new int[4];
            truck[0] = Integer.parseInt(strArr[0]);
            truck[1] = Integer.parseInt(strArr[1]);
            truck[2] = Integer.parseInt(strArr[2]);
            truck[3] = Integer.parseInt(strArr[3]);
            for(int i = billboard1[0]+1000; i < billboard1[2]+1000; i++) {
                for(int j = billboard1[1]+1000; j < billboard1[3]+1000; j++) {
                    space[i][j] = 1;
                }
            }
            for(int i = billboard2[0]+1000; i < billboard2[2]+1000; i++) {
                for(int j = billboard2[1]+1000; j < billboard2[3]+1000; j++) {
                    space[i][j] = 1;
                }
            }
            for(int i = truck[0]+1000; i < truck[2]+1000; i++) {
                for(int j = truck[1]+1000; j < truck[3]+1000; j++) {
                    space[i][j] = 0;
                }
            }
            int ans = 0;
            for(int i = 0; i < space.length; i++) {
                for(int j = 0; j < space[i].length; j++) {
                    if(space[i][j] == 1) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("billboard.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Board board = new Board();
        board.read();
    }
}
