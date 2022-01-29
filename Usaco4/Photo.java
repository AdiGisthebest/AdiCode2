import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Photo {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("photo.in"));
            int length = Integer.parseInt(scan.nextLine());
            HashMap<Integer, Boolean> contains = new HashMap<>();
            int[] numbers = new int[length - 1];
            int[] newNums = new int[length];
            String[] strNums = scan.nextLine().split(" ");
            for(int i = 0; i < length - 1; i++) {
                numbers[i] = Integer.parseInt(strNums[i]);
            }
            contains = this.reset(contains, length);
            int num1 = numbers[0];
            for(int i = 0; i < num1; i++) {
                boolean broken = false;
                if(contains.get(i) != null && !contains.get(i)) {
                    newNums[0] = i;
                    contains.put(i, true);
                    for (int j = 1; j < length; j++) {
                        int num = numbers[j - 1] - newNums[j - 1];
                        if (contains.get(num) != null && !contains.get(num)) {
                            //System.out.println(num);
                            newNums[j] = num;
                            contains.put(num, true);
                        } else {
                            newNums = new int[length];
                            contains = this.reset(contains, length);
                            broken = true;
                            break;
                        }
                    }
                    //System.out.println(broken);
                    if (!broken) {
                        for (int j = 0; j < length-1; j++) {
                            System.out.print(newNums[j] + " ");
                        }
                        System.out.print(newNums[length - 1]);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<Integer,Boolean> reset(HashMap<Integer,Boolean> contains, int length) {
        for(int i = 1; i <= length; i++) {
            contains.put(i, false);
        }
        return contains;
    }

    public static void main(String[] args) {
        try {
            File file = new File("photo.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Photo photo = new Photo();
        photo.read();
    }
}
