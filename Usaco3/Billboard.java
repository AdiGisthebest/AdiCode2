//package Usaco3;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Billboard {
   public void read() {
       try {
           Scanner scan = new Scanner(new File("billboard.in"));
           String[] stringArr = scan.nextLine().split(" ");
           int[] rect1 = new int[4];
           for(int i = 0; i < 4; i++) {
               rect1[i] = Integer.parseInt(stringArr[i]);
           }
           stringArr = scan.nextLine().split(" ");
           int[] rect2 = new int[4];
           for(int i = 0; i < 4; i++) {
               rect2[i] = Integer.parseInt(stringArr[i]);
           }
           // check covers right
           int subNum = 0;
           if(rect2[1] >= rect1[1]) {
               if(rect2[3] <= rect1[3]) {
                   subNum =(rect1[0] - rect2[2]) * (rect1[3] - rect1[1]);
               }
           } else if (rect2[0] <= rect1[0]) {
                if(rect2[2] >= rect1[2]) {
                    subNum = (rect2[3] - rect1[1]) * (rect1[2] - rect1[0]);
                }
           }
           System.out.println(subNum);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    public static void main(String[] args) {
        Billboard billboard = new Billboard();
        billboard.read();
    }
}
