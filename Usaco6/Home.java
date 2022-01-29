import java.io.PrintStream;
import java.util.Scanner;

public class Home {
    public void read() {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] results = new int[length];
        for(int i = 0; i < length; i++) {
            String[] arr = scanner.nextLine().split(" ");
            int gridSize = Integer.parseInt(arr[0]);
            int stepCnt = Integer.parseInt(arr[1]);
            int[][] grid = new int[gridSize][gridSize];
            for(int j = 0; j < gridSize; j++) {
                char[] charArr = scanner.nextLine().toCharArray();
                for(int k = 0; k < gridSize; k++) {
                    if(charArr[k] == 'H') {
                        grid[j][k] = 1;
                    }
                }
            }
            int ans = 0;
            switch(stepCnt) {
                //Fix
                case 3:
                    for(int j = 1; j < gridSize-1; j++) {
                        for(int k = 1; k < gridSize-1; k++) {
                            int jPos = 0;
                            int kPos = 0;
                            boolean bale = false;
                            while(jPos < j) {
                                if(grid[jPos][kPos] == 1) {
                                    bale = true;
                                    break;
                                }
                                jPos++;
                            }
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            while(kPos < k && !bale) {
                                if(grid[jPos][kPos] == 1) {
                                    bale = true;
                                    break;
                                }
                                kPos++;
                            }
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            while(jPos < gridSize-1 && !bale) {
                                if(grid[jPos][kPos] == 1) {
                                    bale = true;
                                    break;
                                }
                                jPos++;
                            }
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            while(kPos < gridSize-1 && !bale) {
                                if(grid[jPos][kPos] == 1) {
                                    bale = true;
                                    break;
                                }
                                kPos++;
                            }
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            if(!bale) {
                                ans++;
                            }
                        }
                    }

                    for(int j = 1; j < gridSize-1; j++) {
                        for(int k = 1; k < gridSize-1; k++) {
                            int jPos = 0;
                            int kPos = 0;
                            boolean bale = false;
                            while(kPos < k) {
                                if(grid[jPos][kPos] == 1) {
                                    bale = true;
                                    break;
                                }
                                kPos++;
                            }
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            while(jPos < j && !bale) {
                                if(grid[jPos][kPos] == 1) {
                                    bale = true;
                                    break;
                                }
                                jPos++;
                            }
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            while(kPos < gridSize-1 && !bale) {
                                if(grid[jPos][kPos] == 1) {
                                    bale = true;
                                    break;
                                }
                                kPos++;
                            }
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            while(jPos < gridSize-1 && !bale) {
                                if(grid[jPos][kPos] == 1) {
                                    bale = true;
                                    break;
                                }
                                jPos++;
                            }
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            if(!bale) {
                                ans++;
                            }
                        }
                    }
                case 2:
                    for(int j = 1; j < gridSize-1; j++) {
                        int jPos = 0;
                        int kPos = 0;
                        boolean bale = false;
                        while(jPos < j) {
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            jPos++;
                        }
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        while(kPos < gridSize -1 && !bale) {
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            kPos++;
                        }
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        while(jPos < gridSize-1 && !bale) {
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            jPos++;
                        }
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        if(!bale) {
                            ans++;
                        }
                    }
                    for(int j = 1; j < gridSize-1; j++) {
                        int jPos = 0;
                        int kPos = 0;
                        boolean bale = false;
                        while(kPos < j) {
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            kPos++;
                        }
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        while(jPos < gridSize -1 && !bale) {
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            jPos++;
                        }
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        while(kPos < gridSize-1 && !bale) {
                            if(grid[jPos][kPos] == 1) {
                                bale = true;
                            }
                            kPos++;
                        }
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        if(!bale) {
                            ans++;
                        }
                    }

                case 1:
                    int kPos = 0;
                    int jPos = 0;
                    boolean bale = false;
                    while(kPos < gridSize-1) {
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        kPos++;
                    }
                    if(grid[jPos][kPos] == 1) {
                        bale = true;
                    }
                    while(jPos < gridSize-1) {
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        jPos++;
                    }
                    if(grid[jPos][kPos] == 1) {
                        bale = true;
                    }
                    if(!bale) {
                        ans++;
                    }
                    kPos = 0;
                    jPos = 0;
                    bale = false;
                    while(jPos < gridSize-1) {
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        jPos++;
                    }
                    if(grid[jPos][kPos] == 1) {
                        bale = true;
                    }
                    while(kPos < gridSize-1) {
                        if(grid[jPos][kPos] == 1) {
                            bale = true;
                        }
                        kPos++;
                    }
                    if(grid[jPos][kPos] == 1) {
                        bale = true;
                    }
                    if(!bale) {
                        ans++;
                    }
            }
            results[i] = ans;
        }
        for(int i = 0; i < length; i++) {
            System.out.println(results[i]);
        }
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.read();
    }
}
