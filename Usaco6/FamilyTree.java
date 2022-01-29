import java.awt.desktop.PrintFilesEvent;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

public class FamilyTree {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("family.in"));
            String[] arr = scanner.nextLine().split(" ");
            int length = Integer.parseInt(arr[0]);
            String cow1 = arr[1];
            String cow2 = arr[2];
            HashMap<String,TNode> map = new HashMap<>();
            map.put(cow1, new TNode(cow1));
            map.put(cow2, new TNode(cow2));
            for(int i = 0; i < length; i++) {
                arr = scanner.nextLine().split(" ");
                if(map.containsKey(arr[0])) {
                    TNode node = map.get(arr[0]);
                    if(map.containsKey(arr[1])) {
                        node.arrayList.add(map.get(arr[1]));
                        map.get(arr[1]).mother = node;
                    } else {
                        TNode child = new TNode(arr[1]);
                        node.arrayList.add(child);
                        child.mother = node;
                        map.put(arr[1],child);
                    }
                } else if (map.containsKey(arr[1])) {
                    TNode node = new TNode(arr[0]);
                    node.arrayList.add(map.get(arr[1]));
                    map.get(arr[1]).mother = node;
                    map.put(arr[0],node);
                } else {
                    TNode node = new TNode(arr[0]);
                    TNode node2 = new TNode(arr[1]);
                    node.arrayList.add(node2);
                    node2.mother = node;
                    map.put(arr[0],node);
                    map.put(arr[1],node2);
                }
            }
            String[] relationshipMap = findRelationRecursive(map, cow1, cow2, -1);
            String[] relationshipMap2 = findRelationRecursive(map, cow2, cow1, -1);
            if(relationshipMap[1].equals("Success")) {
                if(relationshipMap[0].equals("Siblings")) {
                    System.out.println("SIBLINGS");
                } else {
                    System.out.println(cow2 + " is the " + relationshipMap[0] + " of " + cow1);
                }
            } else if (relationshipMap2[1].equals("Success")) {
                if(relationshipMap2[0].equals("Siblings")) {
                    System.out.println("SIBLINGS");
                } else {
                    System.out.println(cow1 + " is the " + relationshipMap2[0] + " of " + cow2);
                }
            } else {
                if(relationshipMap2[1].equals(relationshipMap[1])) {
                    System.out.println("COUSINS");
                } else {
                    System.out.println("NOT RELATED");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String[] findRelationRecursive(HashMap<String,TNode> map, String currCow, String targetCow, int greatCount) {
        if(map.get(currCow).mother == null) {
            String[] arr = new String[2];
            arr[0] = "None";
            arr[1] = currCow;
            return arr;
        } else {
            TNode node = map.get(currCow);
            int length = node.mother.arrayList.size();
            ArrayList<TNode> sisters = node.mother.arrayList;
            if(node.mother.name.equals(targetCow)) {
                String great = new String();
                for(int i = 0; i < greatCount - 1; i++) {
                    great = great + "great-";
                }
                if(greatCount == 1) {
                    great = great + "grand-";
                }
                String[] arr = new String[2];
                arr[0] = great + "mother";
                arr[1] = "Success";
                return arr;
            }
            for(int i = 0; i < length; i++) {
                //System.out.println(sisters.get(i).name + " " + targetCow + " " + greatCount);
                if(sisters.get(i).name.equals(targetCow)) {
                    String great = new String();
                    for(int j = 0; j < greatCount; j++) {
                        great = great + "great-";
                    }
                    if(greatCount >= 0) {
                        String[] arr = new String[2];
                        arr[0] = great + "aunt";
                        arr[1] = "Success";
                        return arr;
                    } else {
                        String[] arr = new String[2];
                        arr[0] = "Siblings";
                        arr[1] = "Success";
                        return arr;
                    }

                }
            }
            return findRelationRecursive(map, node.mother.name, targetCow, greatCount+1);
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("family.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }
        FamilyTree familyTree = new FamilyTree();
        familyTree.read();
    }
}
class TNode {
    String name;
    TNode mother;
    ArrayList<TNode> arrayList;
    public TNode(String title) {
        name = title;
        arrayList = new ArrayList<>();
    }
}
