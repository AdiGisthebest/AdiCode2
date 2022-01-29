import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ABC {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("whereami.in"));
            int length = Integer.parseInt(scan.nextLine());
            char[] colors = scan.nextLine().toCharArray();
            ArrayList<String> repeatList = new ArrayList<>();
            for(int i = 1; i < length; i++) {
                boolean breakBool = false;
                for(int j = 0; j < length - i+1; j++) {
                    StringBuilder builder = new StringBuilder();
                    for(int k = 0; k < i; k++) {
                        builder.append(colors[j + k]);
                    }
                    if(!repeatList.contains(builder.toString())) {
                        repeatList.add(builder.toString());
                    } else {
                        repeatList = new ArrayList<>();
                        breakBool = true;
                        break;
                    }
                }
                //System.out.println(repeatList);
                if(!breakBool) {
                    System.out.println(i);
                    return;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("whereami.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ABC abc = new ABC();
        abc.read();
    }
}
