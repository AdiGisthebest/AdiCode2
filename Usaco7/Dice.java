import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dice {
    ArrayList<Boolean> ans = new ArrayList<>();
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < length; i++) {
            String[] arr = scanner.nextLine().split(" ");
            int[] a = new int[4];
            int[] b = new int[4];
            for(int j = 0; j < 4; j++) {
                a[j] = Integer.parseInt(arr[j]);
            }
            for(int j = 0; j < 4; j++) {
                b[j] = Integer.parseInt(arr[j+4]);
            }
            this.genPossible(a, b);
        }
        for(int i = 0; i < ans.size(); i++) {
            if(ans.get(i)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
    public void genPossible(int[] a, int[] b) {
        for(int i = 1; i < 11; i++) {
            for(int j = 1; j < 11; j++) {
                for(int k = 1; k < 11; k++) {
                    for(int s = 1; s < 11; s++) {
                        int[] arr = {i,j,k,s};
                        int betterA = better(arr,a);
                        int betterB = better(arr,b);
                        int aBetter = better(a, b);
                        if(aBetter == 1) {
                            if (betterB == 0 && betterA == 1) {
                                //System.out.println(Arrays.toString(a));
                                //System.out.println(Arrays.toString(b));
                                //System.out.println(Arrays.toString(arr));
                                ans.add(true);
                                return;
                            }
                        } else if (aBetter == 0) {
                            if(betterA == 0 && betterB == 1) {
                                //System.out.println(Arrays.toString(a));
                                //System.out.println(Arrays.toString(b));
                                //System.out.println(Arrays.toString(arr));
                                ans.add(true);
                                return;
                            }
                        } else {
                            ans.add(false);
                        }
                    }
                }
            }
        }
        ans.add(false);
    }
    public int better(int[] a, int[] b) {
        int aScore = 0;
        int bScore = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(a[i] > b[j]) {
                    aScore++;
                } else if (b[j] > a[i]) {
                    bScore++;
                }
            }
        }
        if(aScore > bScore) {
            return 1;
        }
        if(bScore > aScore) {
            return 0;
        }
        return 2;
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        dice.read();
    }
}
