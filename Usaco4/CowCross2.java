import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CowCross2 {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("circlecross.in"));
            char[] crossPoints = scanner.nextLine().toCharArray();
            int ans = 0;
            char currChar = ' ';
            HashMap<Character,Integer> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < 52; i++) {
                if(!set.contains(crossPoints[i])) {
                    set.add(crossPoints[i]);
                    currChar = crossPoints[i];
                    for(int j = i+1; j < 52; j++) {
                        if(crossPoints[j] == currChar) {
                            break;
                        } else {
                            if(!map.containsKey(crossPoints[j])) {
                                map.put(crossPoints[j],1);
                            } else {
                                map.put(crossPoints[j],map.get(crossPoints[j]) + 1);
                            }
                        }
                    }
                    for(int j = 0; j < 26; j++) {
                        char checkChar = (char)(65+j);
                        if(map.get(checkChar) != null && Integer.parseInt(map.get(checkChar).toString()) == 1) {
                            ans++;
                        }
                    }
                    map = new HashMap<>();
                }
            }
            System.out.println(ans/2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("circlecross.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CowCross2 cross2 = new CowCross2();
        cross2.read();
    }
}
