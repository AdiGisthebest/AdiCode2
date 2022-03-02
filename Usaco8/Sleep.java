
import java.util.ArrayList;
import java.util.Scanner;

public class Sleep {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] answers = new int[length];
        for(int i = 0; i < length; i++) {
            int subLength = Integer.parseInt(scanner.nextLine());
            String[] strArr = scanner.nextLine().split(" ");
            ArrayList<Integer> sleep = new ArrayList<>();
            for(int j = 0; j < subLength; j++) {
                sleep.add(Integer.parseInt(strArr[j]));
            }
            answers[i] = this.solve(sleep);
        }
        for(int i = 0; i < length; i++) {
            System.out.println(answers[i]);
        }
    }
    public int solve(ArrayList<Integer> sleep) {
        int minMoves = Integer.MAX_VALUE;
        int allSum = 0;
        for(int i = 0; i < sleep.size(); i++) {
            allSum = allSum + sleep.get(i);
        }
        ArrayList<Integer> originalSleep = (ArrayList<Integer>)sleep.clone();
        //System.out.println(sleep);
        ArrayList<Integer> maxSet = new ArrayList<>();
        for(int i = 1; i < sleep.size(); i++) {
            if(allSum%i == 0) {
                maxSet.add(allSum/i);
            }
        }
        //System.out.println(maxSet);
        for(int k = 0; k < maxSet.size(); k++) {
            int moves = 0;
            int max = maxSet.get(k);
            //System.out.println(max);
            for(int i = 0; i < sleep.size(); i++) {
                if(sleep.get(i) < max && i != sleep.size()-1) {
                    int num = sleep.get(i) + sleep.get(i+1);
                    sleep.remove(i);
                    sleep.remove(i);
                    sleep.add(i,num);
                    //System.out.println(sleep + " " + max);
                    if(num < max) {
                        i--;
                    } else if (num > max) {
                        moves  = Integer.MAX_VALUE;
                        break;
                    }
                    moves++;
                } else if (sleep.get(i) < max && i == sleep.size()-1 && i != 0) {
                    int num = sleep.get(i) + sleep.get(i-1);
                    sleep.remove(i-1);
                    sleep.remove(i-1);
                    sleep.add(i-1,num);
                    //System.out.println(sleep + " " + max);
                    if (num > max) {
                        moves = Integer.MAX_VALUE;
                        break;
                    }
                    moves++;
                }
            }
            if(moves < minMoves) {
                minMoves = moves;
            }
            sleep = (ArrayList<Integer>) originalSleep.clone();
        }
        return minMoves;
    }

    public static void main(String[] args) {
        Sleep sleep = new Sleep();
        sleep.read();
    }
}
