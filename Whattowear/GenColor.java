import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;

public class GenColor {
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
    public static void main(String[] args) {
        int dataSetSize = 10000;
        GenColor color = new GenColor();
        File outFile1 = new File("result1.txt");
        File outFile2 = new File("result2.txt");
        File outFile3 = new File("result3.txt");
        File inFile = new File("featureData.txt");
        try {
            FileWriter writer =  new FileWriter(inFile);
            FileWriter outWriter1 = new FileWriter(outFile1);
            FileWriter outWriter2 = new FileWriter(outFile2);
            FileWriter outWriter3 = new FileWriter(outFile3);
            for(int i = 0; i < dataSetSize; i++) {
                int R =(int)(Math.random()*255);
                int G = (int)(Math.random()*255);
                int B = (int)(Math.random()*255);
                int num = color.findColor(R, G, B);
                switch (num) {
                    case 1:
                        outWriter1.write("1\n");
                        outWriter2.write("0\n");
                        outWriter3.write("0\n");
                    break;
                    case 2:
                        outWriter1.write("0\n");
                        outWriter2.write("1\n");
                        outWriter3.write("0\n");
                    break;
                    case 3:
                        outWriter1.write("0\n");
                        outWriter2.write("0\n");
                        outWriter3.write("1\n");
                }
                writer.write(1+ " " + R + " " + G + " " + B + "\n");
            }
            writer.close();
            outWriter1.close();
            outWriter2.close();
            outWriter3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
