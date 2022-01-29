import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Evolution {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("evolution.in"));
            int length = Integer.parseInt(scanner.nextLine());
            HashMap<String,Integer> abilityFrequency = new HashMap<>();
            HashMap<Integer,HashSet<String>> cowAbilities = new HashMap<>();
            ArrayList<String> abilitySet = new ArrayList<>();
            for(int i = 0; i < length; i++) {
                String[] arr = scanner.nextLine().split(" ");
                int abilityLength = Integer.parseInt(arr[0]);
                HashSet<String> abilities = new HashSet<>();
                for(int j = 0; j < abilityLength; j++) {
                    abilities.add(arr[j+1]);
                    if(abilityFrequency.containsKey(arr[j+1])) {
                        abilityFrequency.put(arr[j+1],abilityFrequency.get(arr[j+1])+1);
                    } else {
                        abilitySet.add(arr[j+1]);
                        abilityFrequency.put(arr[j+1],1);
                    }
                }
                cowAbilities.put(i,abilities);
            }
            if(this.evolPossible(abilityFrequency, cowAbilities, new HashSet<>(), abilitySet)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public boolean evolPossible(HashMap<String,Integer> abilityFrequency, HashMap<Integer,HashSet<String>> cowAbilities,HashSet<String> abilityCheck, ArrayList<String> abilitySet) {
        if(cowAbilities.size() == 0) {
            return true;
        }
        String maxAbility = "";
        int maxFrequency = 0;
        for(int i = 0; i < abilitySet.size(); i++) {
            if(abilityFrequency.get(abilitySet.get(i)) > maxFrequency) {
                maxFrequency = abilityFrequency.get(abilitySet.get(i));
                maxAbility = abilitySet.get(i);
            }
        }
        if(abilityCheck.contains(maxAbility)) {
            return false;
        }
        abilityCheck.add(maxAbility);
        HashMap<Integer,HashSet<String>> have = new HashMap<>();
        HashMap<Integer,HashSet<String>> haveNot = new HashMap<>();
        ArrayList<String> haveAbilitySet = new ArrayList<>();
        ArrayList<String> haveNotAbilitySet = new ArrayList<>();
        HashMap<String,Integer> haveFrequency = new HashMap<>();
        HashMap<String,Integer> haveNotFrequency = new HashMap<>();
        Integer[] arr = new Integer[cowAbilities.size()];
        cowAbilities.keySet().toArray(arr);
        for(int i = 0; i < cowAbilities.size(); i++) {
            if(cowAbilities.get(arr[i]).contains(maxAbility)) {
                //System.out.println(maxAbility + " " + arr[i] + " have");
                HashSet<String> set = cowAbilities.get(arr[i]);
                set.remove(maxAbility);
                if(set.size() != 0) {
                    String[] abilities = new String[set.size()];
                    set.toArray(abilities);
                    for (int j = 0; j < abilities.length; j++) {
                        if (haveAbilitySet.contains(abilities[j])) {
                            haveFrequency.put(abilities[j], haveFrequency.get(abilities[j]) + 1);
                        } else {
                            haveAbilitySet.add(abilities[j]);
                            haveFrequency.put(abilities[j], 1);
                        }
                    }
                    have.put(arr[i], set);
                }
            } else {
                //System.out.println(maxAbility + " " + arr[i] + " haveNot");
                HashSet set = cowAbilities.get(arr[i]);
                String[] abilities = new String[set.size()];
                set.toArray(abilities);
                if(set.size() != 0) {
                    for(int j = 0; j < abilities.length; j++) {
                        if(haveNotAbilitySet.contains(abilities[j])) {
                            haveNotFrequency.put(abilities[j],haveNotFrequency.get(abilities[j])+1);
                        } else {
                            haveNotAbilitySet.add(abilities[j]);
                            haveNotFrequency.put(abilities[j],1);
                        }
                    }
                    haveNot.put(arr[i],set);
                }
            }
        }
        return this.evolPossible(haveFrequency, have, abilityCheck, haveAbilitySet) && this.evolPossible(haveNotFrequency, haveNot, abilityCheck, haveNotAbilitySet);
    }

    public static void main(String[] args) {
        try {
            File file = new File("evolution.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
        }
        Evolution evolution = new Evolution();
        evolution.read();
    }
}
