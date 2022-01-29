import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Milkorder {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("milkorder.in"));
            String[] arr = scanner.nextLine().split(" ");
            int length = Integer.parseInt(arr[0]);
            int orderLength = Integer.parseInt(arr[1]);
            int posLength = Integer.parseInt(arr[2]);
            arr = scanner.nextLine().split(" ");
            int[] numbers = new int[orderLength];
            int[] cowOrder = new int[length];
            int startNum = -1;
            int startPos = -1;
            boolean oneInside = false;
            for(int i = 0; i < orderLength; i++) {
                numbers[i] = Integer.parseInt(arr[i]);
                if(numbers[i] == 1) {
                    oneInside = true;
                }
            }
            for(int i  = 0; i < posLength; i++) {
                arr = scanner.nextLine().split(" ");
                int number = Integer.parseInt(arr[0]);
                int pos = Integer.parseInt(arr[1]) - 1;
                cowOrder[pos] = number;
                if(cowOrder[pos] == 1) {
                    System.out.println(pos+1);
                    return;
                }
            }
            for(int i = 0 ; i < length; i++) {
                int num = cowOrder[i];
                if(num != 0) {
                    boolean inside = false;
                    int pos = 0;
                    for(int j = 0; j < orderLength; j++) {
                        if(numbers[j] == num) {
                           inside = true;
                           pos = j;
                           break;
                        }
                    }
                    if(oneInside) {
                        if(inside) {
                            if(startNum == -1) {
                                startNum = num;
                                startPos = pos;
                                int numFill = pos;
                                //System.out.println(numFill + " numFill " + pos);
                                for(int k = 0; k < i && numFill > 0; k++) {
                                    if(cowOrder[k] == 0) {
                                        cowOrder[k] = numbers[numFill-1];
                                        numFill--;
                                    }
                                }
                            } else {
                                int numFill = pos - startPos - 1;
                                //System.out.println(numFill + " numFill " + pos);
                                for(int k = 0; k < i && numFill > 0; k++) {
                                    if(cowOrder[k] == 0) {
                                        cowOrder[k] = numbers[startPos-numFill-1];
                                        numFill--;
                                    }
                                }
                                startPos = pos;
                                startNum = num;
                            }
                        }
                    } else {
                        if(inside) {
                            if(startNum == -1) {
                                startNum = num;
                                startPos = pos;
                                int numFill = pos;
                                //System.out.println(numFill + " numFill " + pos);
                                for(int k = i; k >= 0 && numFill > 0; k--) {
                                    if(cowOrder[k] == 0) {
                                        cowOrder[k] = -1;
                                        numFill--;
                                    }
                                }
                            } else {
                                int numFill = pos - startPos - 1;
                                //System.out.println(numFill + " numFill " + pos);
                                startPos = pos;
                                startNum = num;
                                for(int k = i; k >= 0 && numFill > 0; k--) {
                                    if(cowOrder[k] == 0) {
                                        cowOrder[k] = -1;
                                        numFill--;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(oneInside) {
                int amtPast = 1;
                boolean pastLastNum = false;
                for(int i = 0; i < length; i++) {
                    if(cowOrder[i] == startNum) {
                        pastLastNum = true;
                    }
                    if(pastLastNum && cowOrder[i] == 0) {
                        cowOrder[i] = numbers[startPos+amtPast];
                        amtPast++;
                        if(startPos+amtPast == orderLength) {
                            break;
                        }
                    }
                }
            }
            if(!oneInside) {
                for(int i = 0; i < length; i++) {
                    if(cowOrder[i] == 0) {
                        System.out.println(i+1);
                        return;
                    }
                }
            } else {
                for(int i = 0; i < length; i ++) {
                    if(cowOrder[i] == 1) {
                        System.out.println(i+1);
                        return;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("milkorder.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        Milkorder milkorder = new Milkorder();
        milkorder.read();
    }
}
