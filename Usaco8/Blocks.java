import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Blocks {
    ArrayList<ArrayList<Integer>> perms = new ArrayList<>();
    public void read() {
        char [][] blocks = new char[4][6];
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] answers = new String[length];
        for(int i = 0; i < 4; i++) {
            blocks[i] = scanner.nextLine().toCharArray();
        }
        for(int i = 0; i < length; i++) {
            char[] word = scanner.nextLine().toCharArray();
            if(this.solve(blocks, word)) {
                answers[i] = "YES";
            } else {
                answers[i] = "NO";
            }
        }
        for(int i = 0; i < length; i++) {
            System.out.println(answers[i]);
        }
    }
    public boolean solve(char[][] blocks, char[] word) {
        perms = new ArrayList<>();
        this.makeAllPerm(word.length, new ArrayList<>(), new HashSet<>());
        for(int i = 0; i < perms.size(); i++) {
            boolean broken = false;
            for(int j = 0; j < word.length; j++) {
                char[] block = blocks[perms.get(i).get(j)];
                if(!contains(word[j],block)) {
                    broken = true;
                    break;
                }
            }
            if(!broken) {
                return true;
            }
        }
        return false;
    }
    public boolean contains(char c, char[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == c) {
                return true;
            }
        }
        return false;
    }
    public void makeAllPerm(int length, ArrayList<Integer> current, HashSet<Integer> used) {
        if(current.size() == length) {
            perms.add(current);
        } else {
            for(int i = 0; i < 4; i++) {
                if(!used.contains(i)) {
                    ArrayList<Integer> currClone = (ArrayList<Integer>)current.clone();
                    HashSet<Integer> useClone = (HashSet<Integer>)used.clone();
                    useClone.add(i);
                    currClone.add(i);
                    this.makeAllPerm(length,currClone,useClone);
                }
            }
        }
    }

    public static void main(String[] args) {
        Blocks blocks = new Blocks();
        blocks.read();
    }
}
