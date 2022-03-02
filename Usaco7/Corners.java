
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Corners {
    int[] sideLengths = new int[3];
    int[] sideLengths2 = new int[3];
    public void read() {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split(" ");
        int length = Integer.parseInt(strArr[0]);
        int maxSize = Integer.parseInt(strArr[1]);
        ArrayList<Integer> sizes = new ArrayList<>();
        HashMap<Integer,Integer> occurences = new HashMap<>();
        strArr = scanner.nextLine().split(" ");
        for(int i = 0; i < length; i++) {
            if(occurences.get(Integer.parseInt(strArr[i])) != null) {
                if(occurences.get(Integer.parseInt(strArr[i])) <= 3) {
                    sizes.add(Integer.parseInt(strArr[i]));
                    occurences.put(Integer.parseInt(strArr[i]), occurences.get(Integer.parseInt(strArr[i])) + 1);
                }
            } else {
                sizes.add(Integer.parseInt(strArr[i]));
                occurences.put(Integer.parseInt(strArr[i]), 1);
            }
        }
        System.out.println(occurences);
        System.out.println(sizes);
        double biggestL = biggestTriWithL(sizes, maxSize);
        double biggest = biggestTri(sizes);
        if(biggestL > biggest) {
            if(biggestL == 0) {
                System.out.println("-1 -1 -1");
            } else {
                Arrays.sort(sideLengths);
                System.out.println(sideLengths[0] + " " + sideLengths[1] + " " + sideLengths[2]);
            }
        } else {
            if(biggest == 0) {
                System.out.println("-1 -1 -1");
            } else {
                Arrays.sort(sideLengths2);
                System.out.println(sideLengths2[0] + " " + sideLengths2[1] + " " + sideLengths2[2]);
            }
        }

    }
    public double biggestTriWithL(ArrayList<Integer> sizes, int maxSize) {
        double maxArea = 0;
        for(int i = 0; i < sizes.size(); i++) {
           for(int j = i+1; j < sizes.size(); j++) {
               for(int k = 0; k <= maxSize; k++) {
                   if(sizes.get(i) + sizes.get(j) > k) {
                       double semi = sizes.get(i) + sizes.get(j) + k;
                       semi = semi/2;
                       double area = semi * (semi-sizes.get(i)) * (semi - sizes.get(j)) * (semi - k);
                       if(area >= maxArea) {
                           maxArea = area;
                           sideLengths = new int[]{sizes.get(i), sizes.get(j), k};
                       }
                   } else {
                       break;
                   }
               }
           }
        }
        return maxArea;
    }
    public double biggestTri(ArrayList<Integer> sizes) {
        double maxArea = 0;
        for(int i = 0; i < sizes.size(); i++) {
            for(int j = i+1; j < sizes.size(); j++) {
                for(int k = j+1; k < sizes.size(); k++) {
                    if(sizes.get(i) + sizes.get(j) > sizes.get(k)) {
                        double semi = sizes.get(i) + sizes.get(j) + sizes.get(k);
                        semi = semi/2;
                        double area = semi * (semi-sizes.get(i)) * (semi - sizes.get(j)) * (semi - sizes.get(k));
                        if(area >= maxArea) {
                            maxArea = area;
                            sideLengths2 = new int[]{sizes.get(i), sizes.get(j), sizes.get(k)};
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Corners corners = new Corners();
        corners.read();
    }
}
