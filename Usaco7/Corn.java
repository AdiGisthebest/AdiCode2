import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Corn {
    ArrayList<Long> ans = new ArrayList<>();
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < length; i++) {
            int testLength = Integer.parseInt(scanner.nextLine());
            String[] arr = scanner.nextLine().split(" ");
            int[] testArr = new int[arr.length];
            for(int j = 0; j < arr.length; j++) {
                 testArr[j] = Integer.parseInt(arr[j]);
            }
            if(testLength == 1) {
                 ans.add((long)0);
            }else {
                findPath(testLength, testArr, 0, new ArrayList<Integer>(), Integer.MAX_VALUE);
            }
        }
        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    public void findPath(int length, int[] arr, int pos, ArrayList<Integer> path, int min) {
        int[] currArr2 = new int[2];
        int[] currArr3 = new int[3];
        for(int i = 0; i < 3; i++) {
            if(pos+i >= arr.length) {
               break;
            } else if(i == 2) {
                currArr3[i] = arr[pos+i];
            } else {
                currArr3[i] = arr[pos+i];
                currArr2[i] = arr[pos+i];
            }
        }
        //System.out.println(Arrays.toString(currArr3));
        //System.out.println(Arrays.toString(currArr2));
        //.out.println(length +  " " + pos);
        if(length-pos == 1) {
            if(arr[length -1] == min) {
                this.solve(length, arr, min, path);
            } else {
                ans.add((long)-1);
            }
            return;
        }  else if (length-pos == 2) {
            //System.out.println("in2");
            if(canSolveLen2(currArr2)) {
                if(findMin2(currArr2) < min) {
                    min = findMin2(currArr2);
                }
                path.add(2);
                this.solve(length, arr, min, path);
            } else {
                ans.add((long)-1);
            }
            return;
        } else if (length-pos == 3) {
            //System.out.println("in3");
            if(canSolveLen3(currArr3)) {
                if(findMin3(currArr3) < min) {
                    min = findMin3(currArr3);
                }
                path.add(3);
                this.solve(length, arr, min, path);
            } else {
                ans.add((long)-1);
            }
            return;
        }
        if(canSolveLen3(currArr3)) {
            int tempMin = min;
            if(findMin3(currArr3) < min) {
                tempMin = findMin3(currArr3);
            }
            ArrayList<Integer> pathCopy = (ArrayList<Integer>) path.clone();
            pathCopy.add(3);
            this.findPath(length,arr,pos+3,pathCopy, tempMin);
        }
        if(canSolveLen2(currArr2)) {
            int tempMin = min;
            if(findMin2(currArr2) < min) {
                tempMin = findMin2(currArr2);
            }
            ArrayList<Integer> pathCopy = (ArrayList<Integer>) path.clone();
            pathCopy.add(2);
            this.findPath(length,arr,pos+2,pathCopy, tempMin);
        }
    }
    public void solve(int length, int[] arr, int min, ArrayList<Integer> path) {
        long ans = 0;
        int pos = 0;
        for(int i = 0; i < path.size(); i++) {
            if(path.get(i) == 3) {
                int[] tempArr = new int[3];
                for(int j = 0; j < 3; j++) {
                    tempArr[j] = arr[pos+j];
                }
                ans = ans+solveLen3(min,tempArr);
                pos+=3;
            } else {
                int[] tempArr = new int[2];
                for(int j = 0; j < 2; j++) {
                    tempArr[j] = arr[pos+j];
                }
                ans = ans+solveLen2(min,tempArr);
                pos+=2;
            }
        }
        this.ans.add(ans);
    }
    public boolean canSolveLen2(int[] arr) {
        if(arr[0] == arr[1]) {
            return true;
        }
        return false;
    }
    public boolean canSolveLen3(int[] arr) {
        if(arr[0] < arr[1] && arr[1] > arr[2] && arr[1] - ((arr[1] - arr[0]) + (arr[1] - arr[2])) > 0) {
            return true;
        }
        return false;
    }
    public int solveLen2(int min, int[] arr) {
        return 2*(arr[0] - min);
    }
    public int solveLen3(int min, int[] arr) {
        return (((arr[1] - arr[0]) + (arr[1] - arr[2])) * 2) + (2 * ((arr[1] - ((arr[1] - arr[0]) + (arr[1] - arr[2]))) - min));
    }
    public int findMin2(int[] arr) {
        return arr[0];
    }
    public int findMin3(int[] arr) {
        return (arr[1] - ((arr[1] - arr[0]) + (arr[1] - arr[2])));
    }
    public static void main(String[] args) {
        Corn corn = new Corn();
        corn.read();
    }
}
