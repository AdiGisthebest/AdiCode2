import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class ReadColor {
    public int findColor(int R, int G, int B) {
        if(R > G+B) {
            return 1;
        } else if (G > R+B) {
            return 2;
        } else if (B > G+R) {
            return 3;
        } else {
            if(R >= G && R >= B) {
                return 1;
            } else if (B >= G && B >= R) {
                return 3;
            } else {
                return 2;
            }
        }
    }
    public boolean compareColor(int trueColor, int predictedColor) {
        if(trueColor == predictedColor) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        try {
            //File file = new File("realResult.txt");
            //PrintStream stream = new PrintStream(file);
            //System.setOut(stream);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        ReadColor color = new ReadColor();
        //File inFile = new File("featureData.txt");
        File outFile = new File("compResults.txt");
        try {
            //FileWriter writer =  new FileWriter(inFile);
            FileWriter writer2 =  new FileWriter(outFile);
            Scanner scanner = new Scanner(new File("featureData.txt"));
            Scanner scan2 = new Scanner(new File("predResult.txt"));
            for(int i = 0; i < 1000; i++) {
                String[] arr = scanner.nextLine().split(" ");
                int R = Integer.parseInt(arr[1]);
                int G = Integer.parseInt(arr[2]);
                int B = Integer.parseInt(arr[3]);
                int predNum = Integer.parseInt(scan2.nextLine());
                /*int R =(int)(Math.random()*255);
                int G = (int)(Math.random()*255);
                int B = (int)(Math.random()*255);*/
                int num = color.findColor(R, G, B);
                //System.out.println(num);
                /*writer.write(1 + " " + R + " " + G + " " + B + " \n");*/
                if(color.compareColor(num, predNum)) {
                    writer2.write(num + "\n");
                } else {
                    writer2.write(num + " " + predNum + "\n");
                }
            }
            writer2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
