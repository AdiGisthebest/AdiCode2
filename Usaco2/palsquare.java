import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
/*
ID: incredi2
LANG: JAVA
TASK: palsquare
*/

class palsquare {
    public void read() {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("palsquare.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int base = Integer.parseInt(scan.nextLine());
        this.solve(base);
    }
    public void solve(int base) {
        BigInteger bigInt = BigInteger.ONE;
        for(int i = 1; i < 300; i ++) {
            BigInteger square = bigInt.multiply(bigInt);
            if(this.check(square.toString(base))) {
                System.out.println(bigInt.toString(base).toUpperCase() + " " + square.toString(base).toUpperCase());
            }
            bigInt = bigInt.add(BigInteger.ONE);
        }
    }
    public boolean check(String num) {
        for(int i = 0 ; i < num.length()/2; i++) {
            if(num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            File file = new File("palsquare.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        palsquare pal = new palsquare();
        pal.read();
    }
}


