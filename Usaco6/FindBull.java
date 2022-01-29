import java.awt.desktop.PrintFilesEvent;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FindBull {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("bcs.in"));
            String[] arr = scanner.nextLine().split(" ");
            int size = Integer.parseInt(arr[0]);
            int length = Integer.parseInt(arr[1]);
            int[][] figure = new int[size][size];
            int[][][] pieces = new int[length][size][size];
            ArrayList<Integer> fittingPieces = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                char[] charArr = scanner.nextLine().toCharArray();
                for(int j = 0; j < size; j++) {
                    if(charArr[j] == '#') {
                        figure[i][j] = 1;
                    }
                }
            }
            for(int i = 0; i < length; i++) {
                for(int j = 0; j < size; j++) {
                    char[] charArr = scanner.nextLine().toCharArray();
                    for(int k = 0; k < size; k++) {
                        if(charArr[k] == '#') {
                            pieces[i][j][k] = 1;
                        }
                    }
                }
            }
            for(int i = 0; i < length; i++) {
                //System.out.println(ifFits(pieces[i], figure));
                if(ifFits(pieces[i],figure)) {
                    fittingPieces.add(i);
                }
            }
            Collections.sort(fittingPieces);
            //System.out.println(fittingPieces);
            if(fittingPieces.size() == 2) {
                System.out.println((fittingPieces.get(0) + 1) + " " + (fittingPieces.get(1) + 1));
            } else {
                for(int i = 0; i < fittingPieces.size(); i++) {
                    for(int j = 0 ; j < fittingPieces.size(); j++) {
                        int[][] figureCopy = copy(figure);
                        subtract(pieces[fittingPieces.get(i)],figureCopy);
                        subtract(pieces[fittingPieces.get(j)],figureCopy);
                        for(int k = 0; k < figureCopy.length; k++) {
                            //System.out.println(Arrays.toString(figureCopy[k]));
                        }
                        //System.out.println(fittingPieces.get(i) + " " + fittingPieces.get(j));
                        if(allZeros(figureCopy)) {
                            if(fittingPieces.get(i) < fittingPieces.get(j)) {
                                System.out.println((fittingPieces.get(i)+1) + " " + (fittingPieces.get(j)+1));
                            } else {
                                System.out.println((fittingPieces.get(j)+1) + " " + (fittingPieces.get(i)+1));
                            }

                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean ifFits(int[][] piece, int[][] figure) {
        int maxX = 0;
        int maxY = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int i = 0; i < piece.length; i++) {
            for(int j = 0; j < piece[i].length; j++) {
                if(piece[i][j] == 1) {
                    if(i > maxY) {
                        maxY = i;
                    }
                    if(i < minY) {
                        minY = i;
                    }
                    if(j > maxX) {
                        maxX = j;
                    }
                    if(j < minX) {
                        minX = j;
                    }
                }
            }
        }
        int width = maxX-minX+1;
        int height = maxY-minY+1;
        //System.out.println(width + " " + height);
        for(int i = 0; i < piece.length-height + 1; i++) {
            for(int j = 0; j < piece[i].length - width + 1; j++) {
                int[][] piecePart = new int[height][width];
                int[][] figurePart = new int[height][width];
                for(int k = 0; k < height; k++) {

                    for(int l = 0; l < width; l++) {
                        piecePart[k][l] = piece[minX+k][minY+l];
                        figurePart[k][l] = figure[k+i][l+j];
                    }
                }
                if(isEqual(piecePart,figurePart)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isEqual(int[][] piecePart, int[][] figurePart) {
        for(int i = 0; i < piecePart.length; i++) {
            //System.out.println(Arrays.toString(piecePart[i]) + "   " + Arrays.toString(figurePart[i]));
            for(int j = 0; j < piecePart[i].length; j++) {
                if(piecePart[i][j] == 1 && figurePart[i][j] == 0) {
                    //System.out.println();
                    return false;
                }
            }
        }
        //System.out.println();
        return true;
    }
    public int[][] copy(int [][] original) {
        int [][] copy = new int[original.length][original[0].length];
        for(int i = 0; i < copy.length; i++) {
            for(int j = 0; j < copy[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }
    public void subtract(int[][] piece, int[][] figure) {
        int maxX = 0;
        int maxY = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int i = 0; i < piece.length; i++) {
            for(int j = 0; j < piece[i].length; j++) {
                if(piece[i][j] == 1) {
                    if(i > maxY) {
                        maxY = i;
                    }
                    if(i < minY) {
                        minY = i;
                    }
                    if(j > maxX) {
                        maxX = j;
                    }
                    if(j < minX) {
                        minX = j;
                    }
                }
            }
        }
        int width = maxX-minX+1;
        int height = maxY-minY+1;
        for(int i = 0; i < piece.length-height + 1; i++) {
            for(int j = 0; j < piece[i].length - width + 1; j++) {
                int[][] piecePart = new int[height][width];
                int[][] figurePart = new int[height][width];
                for(int k = 0; k < height; k++) {
                    for(int l = 0; l < width; l++) {
                        piecePart[k][l] = piece[minX+k][minY+l];
                        figurePart[k][l] = figure[k+i][l+j];
                    }
                }
                if(isEqual(piecePart,figurePart)) {
                    for(int k = 0; k < height; k++) {
                        for(int l = 0; l < width; l++) {
                            if(piecePart[minX + k][minY+l] == 1) {
                                figure[k+i][l+j] = piecePart[minX+k][minY+l]-1;
                            }
                        }
                    }
                }
            }
        }
    }
    public boolean allZeros(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
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
