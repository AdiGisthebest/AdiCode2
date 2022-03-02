import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Photo {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] strArr = scanner.nextLine().split(" ");
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        HashMap<Integer,Integer> diffMap = new HashMap<>();
        for(int i = 0; i < length; i++) {
            arr1[i] = Integer.parseInt(strArr[i]);
        }
        strArr = scanner.nextLine().split(" ");
        for(int i = 0; i < length; i++) {
            arr2[i] = Integer.parseInt(strArr[i]);
        }
        int ans = 0;
        int[] diff = calcDiffs(arr1, arr2);
        for(int i = 0; i < diff.length; i++) {
            diffMap.put(arr1[i],diff[i]);
        }
        for(int i = 0; i < diff.length; i ++) {
            if(diff[i] > 0) {
                ans++;
            }
        }
        int origAns = ans;
        for(int i = 0; i < diff.length; i++) {
            if(diff[i] > -ans) {
                ans++;
            }
        }
        System.out.println(ans-origAns);
    }
    public int[] calcDiffs(int[] arr1, int[] arr2) {
        int[] diffs = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            boolean contains = false;
            for(int j = 0; j < arr1.length; j++) {
                if(arr1[i] == arr2[j]) {
                    diffs[i] = i - j;
                }
            }
        }
        return diffs;
    }
    public int[] makeBestMove(int[] arr1, int[] arr2, HashMap<Integer,Integer> diffMap) {
        for(int i = 0; i < arr1.length; i++) {
            if(diffMap.get(arr2[i]) > 0) {
               for(int j = 0; j < arr1.length; j++) {
                   if(arr1[j] == arr2[i]) {
                       //System.out.println(arr1[j]);
                       for(int k = 0; k < diffMap.get(arr2[i]); k++) {
                           int temp = arr1[j-k];
                           arr1[j-k] = arr1[j-k-1];
                           arr1[j-k-1] = temp;
                           //System.out.println(Arrays.toString(arr1));
                       }
                       break;
                   }
               }
               break;
            }
        }
        return arr1;
    }
    public static void main(String[] args) {
        Photo photo = new Photo();
        photo.read();
    }
}
