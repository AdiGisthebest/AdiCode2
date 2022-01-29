import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Cowstudy2 {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Integer> cowMap = new HashMap<>();
        HashMap<Character,Integer> alphabetMap = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            alphabetMap.put((char)(97+i), i);
        }
        String[] strArr = scanner.nextLine().split(" ");
        int length = Integer.parseInt(strArr[0]);
        int num = Integer.parseInt(strArr[1]);
        String[] cowArr = new String[num];
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");
        for(int i = 0; i < num; i++) {
            String token = tokenizer.nextToken();
            cowMap.put(token,0);
            cowArr[i] = token;
        }
        for(int i = 0; i < length; i++) {
            String[] arr = scanner.nextLine().split( " ");
            int addVal = 0;
            for(int j = 1; j < num; j++) {
                if(!this.alphabetic(alphabetMap,arr[j-1],arr[j])) {
                    addVal++;
                }
                cowMap.put(arr[j], cowMap.get(arr[j]) + addVal);
            }
        }
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                //System.out.println(cowArr[i] + " "  + cowMap.get(cowArr[i]));
                if(i == j) {
                  System.out.print("B");
                } else {
                    if(cowMap.get(cowArr[i]) > cowMap.get(cowArr[j])) {
                        System.out.print(1);
                    } else if (cowMap.get(cowArr[i]) < cowMap.get(cowArr[j])) {
                        System.out.print(0);
                    } else {
                        System.out.print("?");
                    }
                }
            }
            System.out.println();
        }
    }
    public boolean alphabetic(HashMap<Character,Integer> alphabetMap, String name1, String name2) {
        for(int i = 0; i < name1.length() && i < name2.length(); i++) {
            if(alphabetMap.get(name1.charAt(i)) < alphabetMap.get(name2.charAt(i))) {
                return true;
            } else if (alphabetMap.get(name1.charAt(i)) > alphabetMap.get(name2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Cowstudy2 cowstudy2 = new Cowstudy2();
        cowstudy2.read();
    }
}
