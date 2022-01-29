import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class CowGenomics {
    public void read() {
        try {
          Scanner scanner = new Scanner(new File("cownomics.in"));
          String[] arr = scanner.nextLine().split(" ");
          int length = Integer.parseInt(arr[0]);
          int strLen = Integer.parseInt(arr[1]);
          char[][] spotty = new char[length][strLen];
          char[][] plain = new char[length][strLen];
          char[] codes = {'A','G','C','T'};
          for(int i = 0; i < length; i++) {
              spotty[i] = scanner.nextLine().toCharArray();
          }
          for(int i = 0; i < length; i++) {
              plain[i] = scanner.nextLine().toCharArray();
          }
          int ans = 0;
          for(int i = 0; i < strLen; i++) {
              boolean broken = false;
              for(int j = 0; j < 4; j++) {
                  if(contains(spotty, codes[j],i) && contains(plain,codes[j],i)) {
                      broken = true;
                      break;
                  }// else {
                      //for(int k = 0; k < length; k++) {
                          //System.out.println(spotty[k][i] + " " + plain[k][i]);
                      //}
                  //}
              }
              if(!broken) {
                  ans++;
              }
          }
          System.out.println(ans);
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
    public boolean contains(char[][] matrix, char character, int position) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][position] == character) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            File file = new File("cownomics.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        CowGenomics cowGenomics = new CowGenomics();
        cowGenomics.read();
    }
}
