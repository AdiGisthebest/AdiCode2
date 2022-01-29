import java.io.File;
import java.io.PrintStream;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gym {
    public void read() {
        try {
            Scanner scan = new Scanner(new File("gymnastics.in"));
            String[] strArr = scan.nextLine().split(" ");
            int length = Integer.parseInt(strArr[0]);
            int cowNum = Integer.parseInt(strArr[1]);
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            String[] arr = scan.nextLine().split(" ");
            for(int i = 0; i < cowNum; i++) {
                ArrayList<Integer> add = new ArrayList<>();
                for(int j = i+1; j < cowNum; j++) {
                    add.add(Integer.parseInt(arr[j]));
                }
                map.put(Integer.parseInt(arr[i]),add);
            }
            for(int i = 1; i < length; i++) {
                arr = scan.nextLine().split(" ");
                for(int k = 0; k < cowNum; k++) {
                    int num = Integer.parseInt(arr[k]);
                    ArrayList<Integer> add = new ArrayList<>();
                    for(int j = k+1; j < cowNum; j++) {
                        if(map.get(num).contains(Integer.parseInt(arr[j]))) {
                            add.add(Integer.parseInt(arr[j]));
                        }
                    }
                    //System.out.println(add + " add");
                    map.put(num,add);
                }
            }
            int ans = 0;
            for(int i = 1; i <= cowNum; i++) {
                ans = ans+map.get(i).size();
                //System.out.println(map.get(i) + " " + i);
            }
            System.out.println(ans);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("gymnastics.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gym gym = new Gym();
        gym.read();
    }
}
