

import java.io.File;
import java.lang.instrument.ClassDefinition;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Scanner;

public class Cowyear {
    public void read() {
        try {

            Scanner scan = new Scanner(System.in);
            int length = Integer.parseInt(scan.nextLine());
            HashMap<String,Integer> map = new HashMap<>();
            HashMap<String,Integer> zodiacMap = new HashMap<>();
            map.put("Bessie", 0);
            zodiacMap.put("Bessie", 0);
            String[] zodiac = {"Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig","Rat"};
            for(int i = 0; i < length; i++) {
                String[] arr = scan.nextLine().split(" ");
                String name = arr[0];
                String animalComp = arr[7];
                //System.out.println(animalComp);
                int zodiacIndex = zodiacMap.get(animalComp);
                String animal = arr[4];
                int count = 0;
                if(arr[3].equals("previous")) {
                    int iter = zodiacIndex;
                    //System.out.println(animal);
                    while(true) {
                        count--;
                        iter--;
                        if(iter == 12) {
                            iter = 0;
                        } else if (iter == -1) {
                            iter = 11;
                        }
                        //System.out.println(animal + " " + zodiac[iter]);
                        if(zodiac[iter].equals(animal)) {
                            zodiacMap.put(name, iter);
                            //System.out.println("break");
                            break;
                        }

                    }
                } else {
                    int iter = zodiacIndex;
                    while(true) {
                        count++;
                        iter++;
                        if(iter == 12) {
                            iter = 0;
                        }else if (iter == -1) {
                            iter = 11;
                        }
                        //System.out.println(animal + " " + zodiac[iter]);
                        if(zodiac[iter].equals(animal)) {
                            zodiacMap.put(name, iter);
                            break;
                        }

                    }
                }
                map.put(name, map.get(animalComp) + count);

            }
            System.out.println(Math.abs(map.get("Elsie")));
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Cowyear cowyear = new Cowyear();
        cowyear.read();
    }
}
