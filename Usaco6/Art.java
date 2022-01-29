import com.sun.jdi.request.ExceptionRequest;

import javax.xml.stream.events.StartDocument;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Art {
    ArrayList<HashSet<Integer>> breakers = new ArrayList<>();
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("art.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[][] canvas = new int[length][length];
            HashSet<Integer> colorSize = new HashSet<>();
            for(int i = 0; i < length; i++) {
                String[] arr = scanner.nextLine().split("");
                for(int j = 0; j < length; j++) {
                    canvas[i][j] = Integer.parseInt(arr[j]);
                    colorSize.add(canvas[i][j]);
                }
            }
            for(int i = 0; i < 9; i++) {
                breakers.add(new HashSet<Integer>());
            }
            colorSize.remove(0);
            //System.out.println(this.rectBreak(colorSize.size(), 0, canvas, new ArrayList<Integer>(),0));
            System.out.println(rectBreak2(canvas));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*public int rectBreak(int colors, int rectsFound, int[][] matrix, ArrayList<Integer> breakList, int currRects) {
        if(rectsFound >= colors) {
            return currRects;
        }
        ArrayList<Integer> newBreaks = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            HashSet<Integer> breaks = new HashSet<>();
            int[] points = findRect(matrix, i);
            if(points != null) {
                //System.out.println(Arrays.toString(points) + " " + i +  colors);
                for(int j = points[0]; j <= points[1]; j++) {
                    //System.out.println(Arrays.toString(matrix[j]));
                    for(int k = points[2]; k <= points[3]; k++) {
                        //System.out.print(matrix[j][k] + " ");
                        breaks.add(matrix[j][k]);
                    }
                    //System.out.println();
                }
                Integer[] breakArr = new Integer[breaks.size()];
                breaks.toArray(breakArr);
                //System.out.println(Arrays.toString(breakArr) + " " + i + " " + breakList);
                boolean broken = false;
                for(int j = 0; j < breakArr.length; j++) {
                    if((!breakList.contains(breakArr[j]) && Integer.parseInt(breakArr[j].toString()) != i) || breakList.contains(i)) {
                        //System.out.println("inside" + (Integer.parseInt(breakArr[j].toString()) != i));
                        broken = true;
                    }
                }
                if(!broken) {
                    //System.out.println(i);
                    newBreaks.add(i);
                    rectsFound++;
                }
            }
        }
        for(int i = 0; i < newBreaks.size(); i++) {
            breakList.add(newBreaks.get(i));
        }
        return this.rectBreak(colors,rectsFound, matrix, breakList, newBreaks.size());
    }*/
    public int rectBreak2(int[][] matrix) {
        for(int i = 1; i < 9; i++) {
            int[] points = findRect(matrix,i);
            HashSet<Integer> breaks = new HashSet<>();
            if(points != null) {
                for(int j = points[0]; j <= points[1]; j++) {
                    for(int k = points[2]; k <= points[3]; k++) {
                        breaks.add(matrix[j][k]);
                    }
                }
                Integer[] breakArr = new Integer[breaks.size()];
                breaks.toArray(breakArr);
                for(int j = 0; j < breakArr.length; j++) {
                    breakers.get(breakArr[j]).add(i);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 9; i++) {
            if(breakers.get(i).size() == 1) {
                //System.out.println(i);
                ans++;
            }
        }
        return ans;
    }
    public int[] findRect(int[][] matrix, int num) {
        int[] retArr = new int[4];
        retArr[0] = Integer.MAX_VALUE;
        retArr[2] = Integer.MAX_VALUE;
        boolean numFound = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == num) {
                    numFound = true;
                    if(i < retArr[0]) {
                        retArr[0] = i;
                    }
                    if(i > retArr[1]) {
                        retArr[1] = i;
                    }
                    if(j < retArr[2]) {
                        retArr[2] = j;
                    }
                    if(j > retArr[3]) {
                        retArr[3] = j;
                    }
                }
            }
        }
        if(numFound) {
            return retArr;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("art.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        Art art = new Art();
        art.read();
    }
}
