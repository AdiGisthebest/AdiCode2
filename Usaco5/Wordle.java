import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.awt.desktop.PrintFilesEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Wordle {
    ArrayList<String> words = new ArrayList<>();
    int[][] frequencyPerChar = new int[5][26];
    char[][] bestChars = new char[5][26];
    HashMap<Long,ArrayList<String>> wordRank = new HashMap<>();
    HashMap<Character,Integer> frequencies = new HashMap<>();
    ArrayList<String> rankedWords = new ArrayList<>();
    ArrayList<Character> guessedLetters = new ArrayList<>();
    public void load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("words.txt")));
            String line = "";
            while((line = reader.readLine()) != null) {
                if(line.length() == 5) {
                    words.add(line);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void loadFrequencies(ArrayList<String> words) {
        for(int i = 0; i < words.size(); i++) {
            char[] characters = words.get(i).toCharArray();
            for(int j = 0; j < 5; j++) {
                if(frequencies.containsKey(characters[j])) {
                    frequencies.put(characters[j],frequencies.get(characters[j]) + 1);
                } else {
                    frequencies.put(characters[j],1);
                }
                int position = (int)characters[j] - 97;
                frequencyPerChar[j][position]++;
            }
        }
    }
    public void loadBestChars(int[][] frequencyPerChar) {
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 5; j++) {
                int maxPos = -1;
                int max = -1;
                for(int k = 0; k < 26; k++) {
                    if(frequencyPerChar[j][k] > max) {
                        max = frequencyPerChar[j][k];
                        maxPos = k;
                    }
                }
                bestChars[j][i] = (char)(97+maxPos);
                frequencyPerChar[j][maxPos] = -1;
            }
        }
    }
    public long rateWord(String word) {
        char[] chars = word.toCharArray();
        long rateNum = 1;
        HashSet<Character> diffChars = new HashSet<>();
        for(int i = 0; i < 5; i++) {
            int pos = 0;
            for(int j = 0; j < 26; j++) {
                if(bestChars[i][j] == chars[i]) {
                    pos = j+1;
                }
            }
            diffChars.add(chars[i]);
            rateNum = rateNum*pos*pos;
        }
        rateNum = rateNum/(diffChars.size());
        return rateNum;
    }
    public void rateWords() {
        ArrayList<Long> ranks = new ArrayList<>();
        for(int i = 0; i < words.size(); i++) {
            long rank = this.rateWord(words.get(i));
            if(!wordRank.containsKey(rank)) {
                ArrayList<String> sameRankWords = new ArrayList<>();
                sameRankWords.add(words.get(i));
                wordRank.put(rank, sameRankWords);
                ranks.add(rank);
            } else {
                wordRank.get(rank).add(words.get(i));
            }
        }
        Collections.sort(ranks);
        for(int i = 0; i < ranks.size(); i++) {
            ArrayList<String> sameRankedWords = wordRank.get(ranks.get(i));
            for(int j = 0; j < sameRankedWords.size(); j++) {
                rankedWords.add(sameRankedWords.get(j));
            }
        }
    }
    public boolean wordWorks(String guess, String pattern, String currWord) {
        for(int i = 0; i < 5; i++) {
            if(pattern.charAt(i) == 'c') {
                if(guess.charAt(i) != currWord.charAt(i)) {
                    return false;
                } else {
                    if(i < 4) {
                        guess = guess.substring(0,i)+"*"+guess.substring(i+1);
                        currWord = currWord.substring(0,i)+"*"+currWord.substring(i+1);
                    } else {
                        guess = guess.substring(0,i)+"*";
                        currWord = currWord.substring(0,i)+"*";
                    }
                }
            }
        }

        for(int i = 0; i < 5; i++) {
            if(pattern.charAt(i) == 'p') {
                if(!currWord.contains(String.valueOf(guess.charAt(i))) || currWord.charAt(i) == guess.charAt(i)) {
                    return false;
                }
            }
        }
        for(int i = 0; i < 5; i++) {
            if(pattern.charAt(i) == 'w') {
                if(currWord.contains(String.valueOf(guess.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
    public void stemWords(String guess, String pattern) {
        ArrayList<String> newWords = new ArrayList<>();
        for(int i = 0; i < words.size(); i++) {
            if(wordWorks(guess,pattern, words.get(i))) {
                newWords.add(words.get(i));
            }
        }
        words = newWords;
        frequencyPerChar = new int[5][26];
        bestChars = new char[5][26];
        wordRank = new HashMap<>();
        frequencies = new HashMap<>();
        rankedWords = new ArrayList<>();
    }
    public static void main(String[] args) {
        Wordle wordle = new Wordle();
        wordle.load();
        Scanner scanner = new Scanner(System.in);
        System.out.println(wordle.wordWorks("geode", "wwcwc", "choke"));
        while(true) {
            wordle.loadFrequencies(wordle.words);
            wordle.loadBestChars(wordle.frequencyPerChar);
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < 5; j++) {
                    System.out.print(wordle.bestChars[j][i] + " ");
                }
                System.out.println();
            }
            wordle.rateWords();
            ArrayList<String> topTen = new ArrayList<>();
            if(wordle.rankedWords.size() > 10) {
                for(int i = 0; i < 10; i++) {
                    topTen.add(wordle.rankedWords.get(i));
                }
            } else {
                topTen = wordle.rankedWords;
            }

            System.out.println("Top ten best guesses");
            System.out.println(topTen);
            System.out.println("Please enter the word you guessed");
            String guess = scanner.nextLine();
            System.out.println("Please enter the pattern for the word");
            String pattern = scanner.nextLine();
            if(pattern.equals("ccccc")) {
                System.out.println("You won");
                break;
            }
            wordle.stemWords(guess, pattern);
        }
    }
}
