import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Hoofball {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("hoofball.in"));
            int length = Integer.parseInt(scan.nextLine());
            String[] strArr = scan.nextLine().split(" ");
            int count = 1;
            int[] arr = new int[length];
            int [] diff = new int[length -1];
            for(int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            Arrays.sort(arr);
            for(int i = 0; i < length-1; i++) {
                diff[i] = -1 * (arr[i] - arr[i+1]);
            }
            int increase = -1;
            int num = 0;
            for(int i = 0; i < length-1; i++) {
                if(!(increase == -1)) {
                    if(increase == 1) {
                        if(diff[i-1] > diff[i]) {
                            increase = -1;
                            count++;
                            num = 0;
                        }
                    } else if(increase == 0) {
                        //System.out.println(diff[i-1] + " " + diff[i]);
                        if(diff[i-1] <= diff[i]) {
                            increase = -1;
                            count++;
                            num = 0;
                        }
                    }
                    //System.out.println(increase);
                } else {
                    if(num == 0) {
                        num = diff[i];
                    } else {
                        if(diff[i] > num) {
                            increase = 1;
                            //System.out.println(diff[i] + " " + num);
                        } else {
                            increase = 0;
                            //System.out.println(diff[i] + " " + num);
                        }
                    }
                }
            }
            System.out.println(count);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("hoofball.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Hoofball2 hoofball = new Hoofball2();
        hoofball.read();
    }
}
