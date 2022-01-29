import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Guess {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("guess.in"));
            int length = Integer.parseInt(scanner.nextLine());
            HashMap<String, ArrayList<String>> animalToAttr = new HashMap<>();
            ArrayList<String> animals = new ArrayList<>();
            for(int i = 0; i < length; i++) {
                ArrayList<String> attrs = new ArrayList<>();
                String[] arr = scanner.nextLine().split(" ");
                String animal = arr[0];
                int attrNum = Integer.parseInt(arr[1]);
                for(int j = 0; j < attrNum; j++) {
                    attrs.add(arr[j+2]);
                }
                animalToAttr.put(animal,attrs);
                animals.add(animal);
            }
            int maxCommonNum = 0;
            for(int i = 0; i < animals.size(); i++) {
                for(int j = i+1; j < animals.size(); j++) {
                    ArrayList<String> attr1 = animalToAttr.get(animals.get(i));
                    ArrayList<String> attr2 = animalToAttr.get(animals.get(j));
                    int commonNum = 0;
                    for(int k = 0; k < attr1.size(); k++) {
                        if(attr2.contains(attr1.get(k))) {
                            commonNum++;
                        }
                    }
                    if(commonNum > maxCommonNum) {
                        maxCommonNum = commonNum;
                    }
                }
            }
            System.out.println(maxCommonNum+1);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("guess.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Guess guess = new Guess();
        guess.read();
    }
}
