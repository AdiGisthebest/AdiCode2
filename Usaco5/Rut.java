import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Rut {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        HashMap<Integer,int[]> eastCows = new HashMap<>();
        HashMap<Integer,int[]> northCows = new HashMap<>();
        int eastCnt = 0;
        int northCnt = 0;
        HashMap<Integer, ArrayList<Integer>> eastInteractions = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> northInteractions = new HashMap<>();
        HashMap<Integer,Integer> eastResults = new HashMap<>();
        HashMap<Integer,Integer> northResults = new HashMap<>();
        int[][] order = new int[length][2];
        for(int i = 0; i < length; i++) {
            String[] arr = scanner.nextLine().split(" ");
            if(arr[0].equals("E")) {
                order[i][0] = 0;
                order[i][1] = eastCnt;
                int[] coords = new int[2];
                coords[0] = Integer.parseInt(arr[1]);
                coords[1] = Integer.parseInt(arr[2]);
                eastCows.put(eastCnt, coords);
                eastCnt++;
            } else {
                order[i][0] = 1;
                order[i][1] = northCnt;
                int[] coords = new int[2];
                coords[0] = Integer.parseInt(arr[1]);
                coords[1] = Integer.parseInt(arr[2]);
                northCows.put(northCnt, coords);
                northCnt++;
            }
        }
        for(int i = 0; i < eastCnt; i++) {
            ArrayList<Integer> addArr = new ArrayList<>();
            for(int j = 0; j < northCnt; j++) {
                int[] eastCoords = eastCows.get(i);
                int[] northCoords = northCows.get(j);
                if(northCoords[0] >= eastCoords[0] && northCoords[1] <= eastCoords[1]) {
                    addArr.add(j);
                }
            }
            eastInteractions.put(i,addArr);
        }
        for(int i = 0; i < northCnt; i++) {
            ArrayList<Integer> addArr = new ArrayList<>();
            for(int j = 0; j < eastCnt; j++) {
                int[] northCoords = northCows.get(i);
                int[] eastCoords = eastCows.get(j);
                if(northCoords[0] >= eastCoords[0] && northCoords[1] <= eastCoords[1]) {
                    addArr.add(j);
                }
            }
            northInteractions.put(i,addArr);
        }

        for(int i = 0; i < eastCnt; i++) {
            ArrayList<Integer> interactions = eastInteractions.get(i);
            boolean lost = false;
            for(int j = 0; j < interactions.size(); j++) {
                int[] northCoords = northCows.get(interactions.get(j));
                int[] eastCoords = eastCows.get(i);
                int eastDist = northCoords[0] - eastCoords[0];
                int northDist = eastCoords[1] - northCoords[1];
                if(eastDist > northDist) {
                    System.out.println(eastCoords[0] + " " + eastCoords[1] + "   " + northCoords[0] + " " + northCoords[1]);
                    lost = true;
                }
            }
            if(!lost) {
                eastResults.put(i,-1);
            }
        }
        for(int i = 0; i < northCnt; i++) {
            ArrayList<Integer> interactions = northInteractions.get(i);
            boolean lost = false;
            for(int j = 0; j < interactions.size(); j++) {
                int[] northCoords = northCows.get(i);
                int[] eastCoords = eastCows.get(interactions.get(j));
                int eastDist = northCoords[0] - eastCoords[0];
                int northDist = eastCoords[1] - northCoords[1];
                if(eastDist < northDist) {
                    System.out.println(northCoords[0] + " " + northCoords[1] + "   " + eastCoords[0] + " " + eastCoords[1]);
                    lost = true;
                }
            }
            if(!lost) {
                northResults.put(i, -1);
            }
        }
        for(int i = 0; i < length; i++) {
            Integer ans;
            //System.out.println(order[i][0] + " order");
            if(order[i][0] == 0) {
                ans = eastResults.get(order[i][1]);
            } else {
                ans = northResults.get(order[i][1]);
            }
            if(ans == -1) {
                System.out.println("Infinity");
            } else {
                System.out.println(ans);
            }
        }
    }

    public static void main(String[] args) {
        Rut rut = new Rut();
        rut.read();
    }
}
