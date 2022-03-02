import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindBull {
    ArrayList<Integer> fittingPieces = new ArrayList<>();
    public void read() {
        try {
            Scanner scan = new Scanner(new File("bcs.in"));
            String[] arr = scan.nextLine().split(" ");
            int gridSize = Integer.parseInt(arr[0]);
            int exampleCnt = Integer.parseInt(arr[1]);
            char[][] piece = new char[gridSize][gridSize];
            //System.out.println(piece);
            char[][][] guesses = new char[exampleCnt][gridSize][gridSize];
            for(int i = 0; i < gridSize; i++) {
                char[] charArr = scan.nextLine().toCharArray();
                piece[i] = charArr;
            }
            for(int i = 0; i < exampleCnt; i++) {
                for(int j = 0; j < gridSize; j++) {
                    guesses[i][j] = scan.nextLine().toCharArray();
                }
            }
            for(int i = 0; i < exampleCnt; i++) {
                if(this.checkFit(piece, guesses[i])) {
                    fittingPieces.add(i);
                }
            }
            //System.out.println(fittingPieces + " fittingPieces");
            for(int i = 0; i < fittingPieces.size(); i++) {
                for(int j = i+1; j < fittingPieces.size(); j++) {
                    if(this.checkIfWorks(piece, guesses[fittingPieces.get(i)], guesses[fittingPieces.get(j)])) {
                        System.out.println((fittingPieces.get(i)+1) + " " + (fittingPieces.get(j)+1));
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<char[][]> removeAllWays(char[][] piece, char[][] guess) {
        int[] corners = this.findCorners(guess);
        int minX = corners[0];
        int maxX = corners[1];
        int minY = corners[2];
        int maxY = corners[3];
        int iter = 0;
        int jter = 0;
        ArrayList<char[][]> ans = new ArrayList<>();
        char[][] newGuess = new char[maxY-minY+1][maxX-minX+1];
        for(int i = minY; i <= maxY; i++,iter++) {
            jter = 0;
            for(int j = minX; j <= maxX; j++,jter++) {
                newGuess[iter][jter] = guess[i][j];
            }
        }
        //System.out.println(newGuess.length + " " + newGuess[0].length);
        //System.out.println(piece.length - newGuess.length+1);
        //System.out.println(piece.length-newGuess[0].length+1);
        for(int i = 0; i < piece.length - newGuess.length+1; i++) {
            for(int j = 0; j < piece.length-newGuess[0].length+1; j++) {
                boolean breakBool = false;
                for(int k = 0; k < newGuess.length; k++) {
                    for(int l = 0; l < newGuess[0].length; l++) {
                        if(newGuess[k][l] != piece[i+k][j+l] && piece[i+k][j+l] == '.') {
                            breakBool = true;
                            break;
                        }
                    }
                }
                if(!breakBool) {
                    char[][] pieceClone = this.copy(piece);
                    //System.out.println(pieceClone + " " + piece);
                    for(int k = 0; k < newGuess.length; k++) {
                        for(int l = 0; l < newGuess[0].length; l++) {
                            if(newGuess[k][l] == piece[i+k][j+l] && piece[i+k][j+l] == '#') {
                                pieceClone[i+k][j+l] = '-';
                            }
                        }
                    }
                    //printMatrix(pieceClone);
                    ans.add(pieceClone);
                }
            }
        }
        return ans;
    }
    public char[][] copy(char[][] arr) {
        char[][] copy = new char[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
    public boolean checkIfWorks(char[][] piece, char[][] guess1, char[][] guess2) {
        ArrayList<char[][]> removed = this.removeAllWays(piece, guess1);
        for(int i = 0; i < removed.size(); i++) {
            //printMatrix(removed.get(i));
            //printMatrix(guess2);
            //System.out.println(this.checkFit(removed.get(i),guess2));
            if(this.checkFit(removed.get(i), guess2)) {

                ArrayList<char[][]> removedGuess2 = this.removeAllWays(removed.get(i),guess2);
                for(int k = 0; k < removedGuess2.size(); k++) {
                    //printMatrix(removedGuess2.get(k));
                    if(this.matrixMatch(piece,removedGuess2.get(k))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean matrixMatch(char[][] removedMatrix, char[][] piece){
        for(int i = 0; i < removedMatrix.length; i++) {
            for(int j = 0; j < removedMatrix.length; j++) {
                if(removedMatrix[i][j] == '-' && piece[i][j] != '#') {
                    return false;
                }
                if(piece[i][j] == '#' && piece[i][j] != '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkFit(char[][] piece, char[][] guess) {
        int[] corners = this.findCorners(guess);
        int minX = corners[0];
        int maxX = corners[1];
        int minY = corners[2];
        int maxY = corners[3];
        int iter = 0;
        int jter = 0;
        char[][] newGuess = new char[maxY-minY+1][maxX-minX+1];
        //System.out.println(Arrays.toString(corners));
        //System.out.println(newGuess.length + " " + newGuess[0].length);
        for(int i = minY; i <= maxY; i++,iter++) {
            jter = 0;
            for(int j = minX; j <= maxX; j++,jter++) {
                newGuess[iter][jter] = guess[i][j];
            }
        }
        //System.out.println(piece.length - newGuess.length+1);
        //System.out.println(piece.length-newGuess[0].length+1);
        for(int i = 0; i < piece.length - newGuess.length+1; i++) {
            for(int j = 0; j < piece.length-newGuess[0].length+1; j++) {
                boolean breakBool = false;
                for(int k = 0; k < newGuess.length; k++) {
                    for(int l = 0; l < newGuess[0].length; l++) {
                        if(newGuess[k][l] != piece[i+k][j+l] && piece[i+k][j+l] == '.') {
                            breakBool = true;
                            break;
                        }
                    }
                }
                if(!breakBool) {
                    return true;
                }
            }
        }
        return false;
    }
    public int[] findCorners(char[][] guess) {
        int minX = Integer.MAX_VALUE;
        int maxX = 0;
        int minY = Integer.MAX_VALUE;
        int maxY = 0;
        for(int i = 0; i < guess.length; i++) {
            for(int j = 0; j < guess.length; j++) {
                if(guess[i][j] == '#') {
                    if(i < minY) {
                        minY = i;
                    }
                    if(i > maxY) {
                        maxY = i;
                    }
                    if(j < minX) {
                        minX = j;
                    }
                    if(j > maxX) {
                        maxX = j;
                    }
                }
            }
        }
        int[] arr = {minX,maxX,minY,maxY};
        return arr;
    }
    public void printMatrix(char[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("bcs.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        FindBull findBull = new FindBull();
        findBull.read();
    }
}
