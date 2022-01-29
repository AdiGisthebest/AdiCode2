import java.util.Scanner;

public class PRB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] lines = new String[length * 3];
        for(int i = 0; i < lines.length; i++) {
            lines[i] = scanner.nextLine();
        }
        for(int i = 0; i < length; i++) {
            int num = i*3;
            char[] str = lines[num].toCharArray();

            if(findCount(str) == 5) {
                str = lines[num+1].toCharArray();
                if(findCount(str) == 7) {
                    str = lines[num+2].toCharArray();
                    if(findCount(str) == 5) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
    public static int findCount(char[] str) {
        int count = 0;
        for(int j = 0; j < str.length; j++) {
            if(str[j] == 'e' || str[j] == 'i' || str[j] == 'o' || str[j] == 'u' || str[j] == 'a') {
                count++;
            }
        }
        return count;
    }
}
