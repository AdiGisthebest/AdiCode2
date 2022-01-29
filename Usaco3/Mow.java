
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Mow {
    public void read() {
        int[][] matrix = new int[2005][2005];
        try {
            Scanner scanner = new Scanner(new File("mowing.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int time = 2;
            int xPos = 1001;
            int yPos = 1001;
            matrix[xPos][yPos] = 1;
            int minNum = Integer.MAX_VALUE;
            for(int i = 0; i < length; i ++) {
                String[] arr = scanner.nextLine().split(" ");
                char letter = arr[0].charAt(0);
                int number = Integer.parseInt(arr[1]);
                for(int j = 0; j < number; j++) {
                    switch(letter) {
                        case 'N':
                            yPos++;
                            if(matrix[yPos][xPos] != 0) {
                                if((time - matrix[yPos][xPos]) < minNum) {
                                    minNum = time - matrix[yPos][xPos];
                                    matrix[yPos][xPos] = time;
                                }
                            } else {
                                matrix[yPos][xPos] = time;
                            }
                            time++;
                        break;
                        case 'S':
                            yPos--;
                            if(matrix[yPos][xPos] != 0) {
                                if((time - matrix[yPos][xPos]) < minNum) {
                                    minNum = time - matrix[yPos][xPos];
                                    matrix[yPos][xPos] = time;
                                }
                            } else {
                                matrix[yPos][xPos] = time;
                            }
                            time++;
                        break;
                        case 'E':
                            xPos++;
                            if(matrix[yPos][xPos] != 0) {
                                if((time - matrix[yPos][xPos]) < minNum) {
                                    minNum = time - matrix[yPos][xPos];
                                    matrix[yPos][xPos] = time;
                                }
                            } else {
                                matrix[yPos][xPos] = time;
                            }
                            time++;
                        break;
                        case 'W' :
                            xPos--;
                            if(matrix[yPos][xPos] != 0) {
                                if((time - matrix[yPos][xPos]) < minNum) {
                                    minNum = time - matrix[yPos][xPos];
                                    matrix[yPos][xPos] = time;
                                }
                            } else {
                                matrix[yPos][xPos] = time;
                            }
                            time++;
                    }
                }
            }
            for(int i= 0; i < 2005; i++) {
                for(int j = 0; j < 2005; j++) {
                    if(matrix[i][j] == 0) {
                        //System.out.print(".");
                    } else {
                        //System.out.print(matrix[i][j] + " ");
                    }
                }
                //System.out.println();
            }
            if(minNum == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minNum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("mowing.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Mow mow = new Mow();
        mow.read();
    }
}
