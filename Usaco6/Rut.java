import java.awt.desktop.PrintFilesEvent;
import java.util.*;

public class Rut {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> eastCows = new ArrayList<>();
        ArrayList<int[]> northCows = new ArrayList<>();
        HashMap<String, Integer> cowIds = new HashMap<>();
        int length = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < length; i++) {
            String[] arr = scanner.nextLine().split(" ");
            int[] intArr = {Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
            cowIds.put(arr[1] + " " + arr[2], i);
            if(arr[0].equals("E")) {
                eastCows.add(intArr);
            } else {
                northCows.add(intArr);
            }
        }
        Collections.sort(eastCows, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[1] < t2[1]) {
                    return -1;
                } else if (t1[1] > t2[1]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Collections.sort(northCows, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[0] < t2[0]) {
                    return -1;
                } else if (t1[0] > t2[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        String[] ans = new String[length];
        ArrayList<int[]> nClone = clone(northCows);
        ArrayList<int[]> eClone = clone(eastCows);
        //printMatrix(nClone);
        //printMatrix(eClone);
        for(int i = 0; i < nClone.size(); i++) {
            boolean lost = false;
            for(int j = 0; j < eClone.size(); j++) {
                if(nClone.get(i)[0] > eClone.get(j)[0] && eClone.get(j)[1] > nClone.get(i)[1]) {
                    //System.out.println(Arrays.toString(eClone.get(j)));
                    int nDist = eClone.get(j)[1] - nClone.get(i)[1];
                    int eDist = nClone.get(i)[0] - eClone.get(j)[0];
                    if(nDist < eDist) {
                        //System.out.println(Arrays.toString(nClone.get(i)) + " " + Arrays.toString(eClone.get(j)));
                        eClone.remove(j);
                        j--;
                    } else if (nDist > eDist) {
                        //System.out.println(Arrays.toString(nClone.get(i)) + " " + Arrays.toString(eClone.get(j)) + " lost");
                        ans[cowIds.get(nClone.get(i)[0] + " " + nClone.get(i)[1])] = String.valueOf(nDist);
                        lost = true;
                        break;
                    }
                }
            }
            //printMatrix(eClone);
            if(!lost) {
                ans[cowIds.get(nClone.get(i)[0] + " " + nClone.get(i)[1])] = "Infinity";
            }
        }
        nClone = clone(northCows);
        eClone = clone(eastCows);
        for(int i = 0; i < eClone.size(); i++) {
            boolean lost = false;
            for(int j = 0; j < nClone.size(); j++) {
                if(nClone.get(j)[0] > eClone.get(i)[0] && eClone.get(i)[1] > nClone.get(j)[1]) {
                    int nDist = eClone.get(i)[1] - nClone.get(j)[1];
                    int eDist = nClone.get(j)[0] - eClone.get(i)[0];
                    if(eDist < nDist) {
                        nClone.remove(j);
                        j--;
                    } else if (eDist > nDist) {
                        ans[cowIds.get(eClone.get(i)[0] + " " + eClone.get(i)[1])] = String.valueOf(eDist);
                        lost = true;
                        break;
                    }
                }
            }
            if(!lost) {
                ans[cowIds.get(eClone.get(i)[0] + " " + eClone.get(i)[1])] = "Infinity";
            }
        }
        for(int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    public ArrayList<int[]> clone(ArrayList<int[]> target) {
        ArrayList<int[]> clone = new ArrayList<>();
        for(int i = 0; i < target.size(); i++) {
            clone.add(target.get(i).clone());
        }
        return clone;
    }
    public void printMatrix(ArrayList<int[]> arr) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.println(Arrays.toString(arr.get(i)));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Rut rut = new Rut();
        rut.read();
    }
}
