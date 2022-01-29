import java.awt.desktop.PrintFilesEvent;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Swap {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("swap.in"));
            String[] strArr = scanner.nextLine().split(" ");
            int length = Integer.parseInt(strArr[0]);
            int times = Integer.parseInt(strArr[1]);
            int[] arr = new int[length];
            strArr = scanner.nextLine().split(" ");
            int[] swapArr1 = new int[2];
            swapArr1[0] = Integer.parseInt(strArr[0]);
            swapArr1[1] = Integer.parseInt(strArr[1]);
            strArr = scanner.nextLine().split(" ");
            int[] swapArr2 = new int[2];
            swapArr2[0] = Integer.parseInt(strArr[0]);
            swapArr2[1] = Integer.parseInt(strArr[1]);
            for(int i = 0; i < length; i++) {
                arr[i] = i + 1;
            }
            boolean equalBool = false;
            int repeatNum = 0;
            int[] origArr = new int[length];
            for(int i = 0; i < length; i++) {
                origArr[i] = arr[i];
            }
            while(!equalBool) {
                this.swap(arr, swapArr1[0],swapArr1[1]);
                this.swap(arr, swapArr2[0],swapArr2[1]);
                repeatNum++;
                boolean inside = false;
                for(int i = 0; i < length; i++) {
                    if(arr[i] != origArr[i]) {
                        equalBool = false;
                        inside = true;
                    }
                }
                if(!inside) {
                    equalBool = true;
                }
            }
            //System.out.println(repeatNum);
            times = times%repeatNum;
            for(int i = 0; i < times; i++) {
                this.swap(arr, swapArr1[0],swapArr1[1]);
                this.swap(arr, swapArr2[0],swapArr2[1]);
            }
            for(int i = 0; i < length; i++) {
                System.out.println(arr[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    public int[] swap(int[] arr, int num1, int num2) {
        for(int i = 0; i < (Math.abs(num2-num1))/2 + 1; i++) {
            int temp = arr[num1+i-1];
            arr[num1+i-1] = arr[num2-i-1];
            arr[num2-i-1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        try {
            File file = new File("swap.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Swap swap = new Swap();
        swap.read();
        /*int[] arr = {1,2,3,4,5,6,7};
        swap.swap(arr, 2, 5);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
    }
}
