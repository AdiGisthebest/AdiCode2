import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Lineup {
    //ArrayList<String> cowsFilled = new ArrayList<>();
    public void read() {
        try {
            Scanner scan = new Scanner(new File("lineup.in"));
            int length = Integer.parseInt(scan.nextLine());
            String[][] conditions = new String[length][2];
            for(int i = 0; i < length; i++) {
                String[] arr = scan.nextLine().split(" ");
                conditions[i][0] = arr[0];
                conditions[i][1] = arr[5];
            }
            ArrayList<String> origCows = new ArrayList<>();
            origCows.add("Beatrice");
            origCows.add("Belinda");
            origCows.add("Bella");
            origCows.add("Bessie");
            origCows.add("Betsy");
            origCows.add("Blue");
            origCows.add("Buttercup");
            origCows.add("Sue");
            this.recurse(new ArrayList<>(),origCows, conditions);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public boolean check(String[] condition, ArrayList<String> cows) {
        for(int i = 0; i < cows.size(); i++) {
            if(cows.get(i).equals(condition[1])) {
                if(cows.get(i+1).equals(condition[0])) {
                    return true;
                } else {
                    return false;
                }
            } else if(cows.get(i).equals(condition[0])) {
                if(cows.get(i+1).equals(condition[1])) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public void recurse(ArrayList<String> cowsFilled,ArrayList<String> cowsLeft, String [][] conditions) {
        if(cowsLeft.size() == 0) {
            for(int i = 0; i < conditions.length; i++) {
                //System.out.println(cowsFilled);
                if(!this.check(conditions[i],cowsFilled)) {
                    cowsFilled = new ArrayList<>();
                    return;
                }
            }
            for(int i = 0; i < 8; i++) {
                System.out.println(cowsFilled.get(i));
            }
            System.exit(0);
        } else {
            for(int i = 0; i < cowsLeft.size(); i++) {
                String str = cowsLeft.get(i);
                int index = i;
                cowsFilled.add(str);
                cowsLeft.remove(str);
                this.recurse(cowsFilled,cowsLeft,conditions);
                cowsFilled.remove(str);
                cowsLeft.add(i,str);
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("lineup.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Lineup lineup = new Lineup();
        lineup.read();
    }
}
