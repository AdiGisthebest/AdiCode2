import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumGame {
    ArrayList<String> possibilities = new ArrayList<>();
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] arr = scanner.nextLine().split(" ");
        String[] max = new String[6];
        for(int i = 0; i < arr.length; i++) {
            switch(arr[i].length()) {
                case 1:
                    if(max[0] != null) {
                        if(Integer.parseInt(max[0]) < Integer.parseInt(arr[i])) {
                            max[0] = arr[i];
                        }
                    } else {
                        max[0] = arr[i];
                    }
                    break;
                case 2:
                    if(max[1] != null) {
                        if(Integer.parseInt(max[1]) < Integer.parseInt(arr[i])) {
                            max[1] = arr[i];
                        }
                    } else {
                        max[1] = arr[i];
                    }
                    break;
                case 3:
                    if(max[2] != null) {
                        if(Integer.parseInt(max[2]) < Integer.parseInt(arr[i])) {
                            max[2] = arr[i];
                        }
                    } else {
                        max[2] = arr[i];
                    }
                    break;
                case 5:
                    if(max[3] != null) {
                        if(Integer.parseInt(max[3]) < Integer.parseInt(arr[i])) {
                            max[3] = arr[i];
                        }
                    } else {
                        max[3] = arr[i];
                    }
                    break;
                case 7:
                    if(max[4] != null) {
                        if(Integer.parseInt(max[4]) < Integer.parseInt(arr[i])) {
                            max[4] = arr[i];
                        }
                    } else {
                        max[4] = arr[i];
                    }
                    break;
                case 9:
                    if(max[5] != null) {
                        if(Integer.parseInt(max[5]) < Integer.parseInt(arr[i])) {
                            max[5] = arr[i];
                        }
                    } else {
                        max[5] = arr[i];
                    }
                    break;
            }
        }
        allPossible(new ArrayList<String>(Arrays.asList(max)),"");
        System.out.println(possibilities);
        String maxNum = "0";
        for(int i = 0; i < possibilities.size(); i++) {
            if(Integer.parseInt(possibilities.get(i)) > Integer.parseInt(maxNum)) {
                maxNum = possibilities.get(i);
            }
        }
        if(maxNum.equals("0")) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(maxNum);
        }
    }
    public void allPossible(ArrayList<String> max, String currElem) {
        if(currElem.length() == 9) {
            possibilities.add(currElem);
            return;
        } else if (currElem.length() > 9) {
            return;
        }
        for(int i = 0; i < max.size(); i++) {
            if(max.get(i) != null) {
                ArrayList<String> maxClone = (ArrayList<String>)max.clone();
                maxClone.remove(i);
                this.allPossible(maxClone, currElem + max.get(i));
            }
        }
        return;
    }

    public static void main(String[] args) {
        NumGame numGame = new NumGame();
        numGame.read();
    }
}
