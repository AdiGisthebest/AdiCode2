import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Backforth {
    ArrayList<Integer> results;
    public void read() {
        try {

            results = new ArrayList<>();
            Scanner scanner = new Scanner(new File("backforth.in"));
            ArrayList<Integer> buckets1 = new ArrayList<>();
            ArrayList<Integer> buckets2 = new ArrayList<>();
            for(int i = 0; i < 2; i++) {
                String[] arr = scanner.nextLine().split(" ");
                for(int j = 0; j < arr.length; j++) {
                    if (i == 0) {
                        buckets1.add(Integer.parseInt(arr[j]));
                    }
                    if(i == 1) {
                        buckets2.add(Integer.parseInt(arr[j]));
                    }
                }
            }
            this.recurse(0, buckets1, buckets2, 1000, 1000);
            System.out.println(results.size());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void recurse(int iterations, ArrayList<Integer> buckets1, ArrayList<Integer> buckets2, int milk1, int milk2) {
        if(iterations >= 4) {
            if(!results.contains(milk1)) {
                results.add(milk1);
            }
            return;
        } else {
            for(int i = 0; i < 10; i++) {
                if(iterations%2 == 0) {
                    int bucketNum = buckets1.get(i);
                    buckets1.remove(new Integer(bucketNum));
                    buckets2.add(bucketNum);
                    this.recurse(iterations+1, buckets1, buckets2, milk1-bucketNum, milk2+bucketNum);
                    buckets2.remove(new Integer(bucketNum));
                    buckets1.add(i,bucketNum);
                } else {
                    int bucketNum = buckets2.get(i);
                    buckets2.remove(new Integer(bucketNum));
                    buckets1.add(bucketNum);
                    this.recurse(iterations+1, buckets1, buckets2, milk1+bucketNum, milk2-bucketNum);
                    buckets1.remove(new Integer(bucketNum));
                    buckets2.add(i,bucketNum);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("backforth.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Backforth backforth = new Backforth();
        backforth.read();
    }
}
