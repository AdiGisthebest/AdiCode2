import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class OutputConverter {
    public static void main(String[] args) {
        try {
            try {
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            HashMap<Character,Integer> letterMap = new HashMap<>();
            Scanner scanner = new Scanner(new File("outputData.txt"));
            letterMap.put('a', 1);
            letterMap.put('b', 2);
            letterMap.put('c', 3);
            letterMap.put('d', 4);
            letterMap.put('e', 5);
            letterMap.put('f', 6);
            letterMap.put('g', 7);
            letterMap.put('h', 8);
            letterMap.put('i', 9);
            letterMap.put('j', 10);
            letterMap.put('k', 11);
            letterMap.put('l', 12);
            letterMap.put('m', 13);
            letterMap.put('n', 14);
            letterMap.put('o', 15);
            letterMap.put('p', 16);
            letterMap.put('q', 17);
            letterMap.put('r', 18);
            letterMap.put('s', 19);
            letterMap.put('t', 20);
            letterMap.put('u', 21);
            letterMap.put('v', 22);
            letterMap.put('w', 23);
            letterMap.put('x', 24);
            letterMap.put('y', 25);
            letterMap.put('z', 26);
            letterMap.put('A', 27);
            letterMap.put('B', 28);
            letterMap.put('C', 29);
            letterMap.put('D', 30);
            letterMap.put('E', 31);
            letterMap.put('F', 32);
            letterMap.put('G', 33);
            letterMap.put('H', 34);
            letterMap.put('I', 35);
            letterMap.put('J', 36);
            letterMap.put('K', 37);
            letterMap.put('L', 38);
            letterMap.put('M', 39);
            letterMap.put('N', 40);
            letterMap.put('O', 41);
            letterMap.put('P', 42);
            letterMap.put('Q', 43);
            letterMap.put('R', 44);
            letterMap.put('S', 45);
            letterMap.put('T', 46);
            letterMap.put('U', 47);
            letterMap.put('V', 48);
            letterMap.put('W', 49);
            letterMap.put('X', 50);
            letterMap.put('Y', 51);
            letterMap.put('Z', 52);
            while(scanner.hasNext()) {
                char[] arr = scanner.nextLine().toCharArray();
                if(arr.length == 0) {
                    System.out.println(53);
                } else {
                    System.out.println(letterMap.get(arr[0]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
