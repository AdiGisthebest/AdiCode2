

import java.util.ArrayList;
import java.util.Scanner;

public class Cowculator {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().replaceAll(" ", "");
        ArrayList<String> expression = new ArrayList<>();
        String subStr = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '+' || str.charAt(i) == '*' || str.charAt(i) == '-') {
                expression.add(subStr);
                expression.add(String.valueOf(str.charAt(i)));
                subStr = "";
            } else {
                subStr = subStr + str.charAt(i);
            }
        }
        expression.add(subStr);
        for(int i = 0; i < expression.size(); i++) {
            if(expression.get(i).equals("+")) {
                int num1  = Integer.parseInt(expression.get(i-1));
                int num2  = Integer.parseInt(expression.get(i+1));
                int sum = num1+num2;
                expression.remove(i-1);
                expression.remove(i-1);
                expression.remove(i-1);
                expression.add(i-1,String.valueOf(sum));
                i = i - 1;
            }
        }
        //System.out.println(expression);
        for(int i = 0; i < expression.size(); i++) {
            if(expression.get(i).equals("*")) {
                int num1  = Integer.parseInt(expression.get(i-1));
                int num2  = Integer.parseInt(expression.get(i+1));
                int product = num1*num2;
                expression.remove(i-1);
                expression.remove(i-1);
                expression.remove(i-1);
                expression.add(i-1,String.valueOf(product));
                i = i - 1;
            }
        }
        //System.out.println(expression);
        for(int i = 0; i < expression.size(); i++) {
            if(expression.get(i).equals("-")) {
                int num1  = Integer.parseInt(expression.get(i-1));
                int num2  = Integer.parseInt(expression.get(i+1));
                int diff = num1-num2;
                expression.remove(i-1);
                expression.remove(i-1);
                expression.remove(i-1);
                expression.add(i-1,String.valueOf(diff));
                i = i - 1;
            }
        }
        System.out.println(expression.get(0));
    }

    public static void main(String[] args) {
        Cowculator cowculator = new Cowculator();
        cowculator.read();
    }
}
