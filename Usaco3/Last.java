import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Last {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("notlast.in"));
            int length = Integer.parseInt(scanner.nextLine());
            HashMap<String,Integer> cowMap = new HashMap<>();
            cowMap.put("Bessie", 0);
            cowMap.put("Elsie", 0);
            cowMap.put("Daisy", 0);
            cowMap.put("Gertie", 0);
            cowMap.put("Annabelle", 0);
            cowMap.put("Maggie", 0);
            cowMap.put("Henrietta", 0);
            for(int i = 0; i < length; i++) {
                String[] arr = scanner.nextLine().split(" ");
                String cow = arr[0];
                int number = Integer.parseInt(arr[1]);
                if(cowMap.containsKey(cow)) {
                    cowMap.put(cow,cowMap.get(cow) + number);
                }
            }

            String[] keySet = new String[cowMap.keySet().size()];
            cowMap.keySet().toArray(keySet);
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < keySet.length; i++) {
                if(cowMap.get(keySet[i]) < min) {
                    min = cowMap.get(keySet[i]);
                }
            }
            int nextMin = Integer.MAX_VALUE;
            for(int i = 0; i < keySet.length; i++) {
                if(cowMap.get(keySet[i]) < nextMin && cowMap.get(keySet[i]) > min) {
                    nextMin = cowMap.get(keySet[i]);
                }
            }
            if(nextMin == Integer.MAX_VALUE) {
                nextMin = min;
            }
            int count = 0;
            String name = "";
            for(int i = 0; i < keySet.length; i++) {
                if(cowMap.get(keySet[i]) == nextMin) {
                    count++;
                    name = keySet[i];
                }
            }
            if(count > 1) {
                System.out.println("Tie");
            } else {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("notlast.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Last last = new Last();
        last.read();
    }
}
