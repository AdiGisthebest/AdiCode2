import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Cross {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("crossroad.in"));
            int length = Integer.parseInt(scanner.nextLine());
            HashMap<Integer,Integer> map = new HashMap<>();
            int ans = 0;
            for(int i = 0; i < length; i++) {
                String[] arr = scanner.nextLine().split(" ");
                int cow = Integer.parseInt(arr[0]);
                int side = Integer.parseInt(arr[1]);
                if(!map.containsKey(cow)) {
                    map.put(cow, side);
                } else {
                    int num = Integer.parseInt(map.get(cow).toString());
                    if(side != num) {
                        ans++;
                        map.put(cow, side);
                    }
                }
            }
            System.out.println(ans);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("crossroad.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {

        }
        Cross cross = new Cross();
        cross.read();
    }
}
