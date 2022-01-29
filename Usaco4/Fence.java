

import java.io.File;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toHexString;

public class Fence {
    public void read() {
        try {
            Scanner scan = new Scanner(System.in);
            int length = Integer.parseInt(scan.nextLine());
            for(int i = 0; i < length; i++) {
                int angle = 0;
                char [] arr = scan.nextLine().toCharArray();
                for(int k = 1; k < arr.length; k++) {
                    if(arr[k -1] == 'E') {
                         if(arr[k] == 'N') {
                             angle = angle - 90;//Correct
                         } else if(arr[k] == 'S') {
                             angle = angle + 90;//Correct
                         }
                    } else if (arr[k-1] == 'W') {
                        if(arr[k] == 'N') {
                            angle = angle + 90;//Correct
                        } else if(arr[k] == 'S') {
                            angle = angle - 90;//Correct
                        }
                    } else if (arr[k-1] == 'N') {
                        if(arr[k] == 'W') {
                            angle = angle - 90;//Correct
                        } else if(arr[k] == 'E') {
                            angle = angle + 90;//Correct
                        }
                    } else if (arr[k-1] == 'S') {
                        if(arr[k] == 'W') {
                            angle = angle + 90;//Correct
                        } else if(arr[k] == 'E') {
                            angle = angle - 90;//Correct
                        }
                    }
                }
                //System.out.println(angle);
                if(angle > 0) {
                    System.out.println("CW");
                } else {
                    System.out.println("CCW");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Fence fence = new Fence();
        fence.read();
    }
}
