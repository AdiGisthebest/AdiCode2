import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Lost {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("lostcow.in"));
            String[] arr = scanner.nextLine().split(" ");
            int john = Integer.parseInt(arr[0]);
            int bessie = Integer.parseInt(arr[1]);
            if(john == bessie) {
                System.out.println(0);
                return;
            }
            int ans = 0;
            int johnLoc = john;
            int distance = john - bessie;
            int addNum = 1;
            if(john < bessie) {
                for(int i = 0; johnLoc < bessie; i++) {
                    if(i%2 == 0) {
                        johnLoc = john + (int)Math.pow(2,i);
                    }
                    ans = ans + addNum;
                    addNum = (int)(Math.pow(2,i)+Math.pow(2,i+1));
                    //System.out.println(addNum);
                }
                System.out.println(ans -(johnLoc-bessie));
            } else {

                for(int i = 0; johnLoc > bessie; i++) {
                    if(!(i%2 == 0)) {
                        johnLoc = john - (int)Math.pow(2,i);
                    }
                    ans = ans + addNum;
                    addNum = (int)(Math.pow(2,i)+Math.pow(2,i+1));
                    //System.out.println(addNum);
                }
                System.out.println(ans - (bessie-johnLoc));
            }
        }catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("lostcow.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        Lost lost = new Lost();
        lost.read();
    }
}