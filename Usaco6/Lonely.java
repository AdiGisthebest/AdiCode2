import java.util.Scanner;

public class Lonely {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        char[] breeds = scanner.nextLine().toCharArray();
        int good = 0;
        int total = 0;
        for(int i = 0; i < length-2; i++) {
            int gCount = 0;
            int hCount = 0;
            for(int j = i; j < i+3; j++) {
                if(breeds[j] == 'G') {
                    gCount++;
                } else {
                    hCount++;
                }
            }
            if(gCount != 1 && hCount != 1) {
                /*for(int k = i; k <i+3; k++) {
                    System.out.println(breeds[k]);
                }*/
                good++;
            }
            total++;
            for(int j = i + 3; j < length; j++) {
                if(breeds[j] == 'G') {
                    gCount++;
                } else {
                    hCount++;
                }
                if(gCount != 1 && hCount != 1) {
                    //System.out.println(hCount + " " + gCount);
                    /*for(int k = i; k <= j; k++) {
                        System.out.print(breeds[k]);
                    }*/
                    //System.out.println();
                    good++;
                }
                total++;
            }
        }
        System.out.println(total-good);
    }

    public static void main(String[] args) {
        Lonely lonely = new Lonely();
        lonely.read();
    }
}
