import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class MilkFactory {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("factory.in"));
            int length = Integer.parseInt(scanner.nextLine());
            int[][] graph = new int[length][length];
            for(int i = 0; i < length -1; i ++) {
                String[] arr = scanner.nextLine().split(" ");
                int num1 = Integer.parseInt(arr[0])-1;
                int num2 = Integer.parseInt(arr[1])-1;
                graph[num2][num1] = 1;
            }
            for(int i = 0; i < length; i++) {
                boolean broken = false;
                for(int j = 0; j < length; j++) {
                    if(!this.graphSearch(graph, new HashSet<>(), j, i, length)) {
                        broken = true;
                        break;
                    }
                }
                if(!broken) {
                    System.out.println(i+1);
                    return;
                }
            }
            System.out.println(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean graphSearch(int[][] graph, HashSet<Integer> check, int target, int currNode, int length) {
        if(currNode == target) {
            return true;
        }
        for(int i = 0; i < length; i++) {
            if(graph[currNode][i] == 1) {
                if(!check.contains(i)) {
                    check.add(i);
                    if(this.graphSearch(graph,check,target,i,length)) {
                        return true;
                    }
                    check.remove(i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            File file = new File("factory.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
        }
        MilkFactory milkFactory = new MilkFactory();
        milkFactory.read();
    }
}
