package Lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WSSolver {

    private static int size = 100;
    private static char matrix[][] = new char[50][50];
    private static ArrayList<String> solutionsMap = new ArrayList<>();

    //direction: vector + name
    private static int[] x = { -1, -1, -1,  0, 0,  1, 1, 1 };
    private static int[] y = { -1,  0,  1, -1, 1, -1, 0, 1 };
    private static String[] dir = {"upleft", "up", "uprigth", "left", "rigth", "downleft", "down", "downright"};

    public static boolean isRedundant(String givenWord){
        for ( String word : solutionsMap) {
            if (word.contains(givenWord) || givenWord.contains(word)){
                return true;
            }
        }
        return false;
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner textReader = new Scanner(f);
        String line;
        int i = 0;
        int j = 0;

        while (textReader.hasNextLine() && i < size) {
            line = textReader.nextLine();
            //first time doing the loop
            if (size == 100) {
                size = line.length();
                //check the size
                if (size > 50){
                    System.err.println("ERROR: Puzzle cannot be bigger than 50x50");
                    System.exit(1);
                }
            }

            char lineMatrix[] = line.toCharArray();
            if (lineMatrix.length != size){
                System.err.println("ERROR: Puzzle isn't a square");
                System.exit(1);
            }
            j = 0;
            for (char c : lineMatrix) {
                matrix[i][j] = c;
                j++;

            }
            i++;
        }
        if (i!= size) {
            System.err.println("ERROR: Puzzle isn't a square");
            System.exit(1);
        }

        while (textReader.hasNext()) {
            String[] solution = textReader.next().toUpperCase().split("[;,\\s]");
            for (int word = 0; word < solution.length; word++) {
                if (solution[word].length() > 3) {

                    //check for repetitions
                    if (solutionsMap.contains(solution[word])) {
                        System.err.println("ERROR: List contains duplicated words (" + solution[word] + ").");
                        System.exit(1);
                        //check for redundancy
                    } else if (WSSolver.isRedundant(solution[word])) {
                        System.err.println("ERROR: List contains words with redundancy (" + solution[word] + ").");
                        System.exit(1);
                    } else {
                        solutionsMap.add(solution[word]);
                    }
                    //check for word's minimum length of 4
                } else {
                    System.err.println("ERROR: Words have to be at least 4 chars long (" + solution[word] + ").");
                    System.exit(1);
                }
            }
        }

        textReader.close();
    }

    private static void searchWord(String Word){
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++) {

                //searches fo the word in the puzzle (at every letter that's the same as the word's first letter)
                // and prints the info
                if (Word.charAt(0) == matrix[i][j]) {
                    int direction = checkEveryDirections(Word, i, j);
                    if (direction >= 0 && direction<8) {
                        System.out.printf("%-15s %-8d %-8s %-10s\n", Word, Word.length(), (i+1) +"," + (j+1), dir[direction]);

                    }

                }
            }
        }
    }

    //looks at every 8 directions looking for the word
    //input: the words and the x and y coordinates of the first letter
    //output: the direction of the word if it's found, -1 if fails
    private static int checkEveryDirections(String word, int row, int col){
        int len = word.length();

        for (int direction = 0; direction < 8; direction++){
            StringBuilder s = new StringBuilder();

            //appends the first letter and start moving in one direction
            int newRow = row + x[direction];
            int newColumn = col + y[direction];
            s.append(word.charAt(0));

            for (int k = 1; k < len; k++)
            {
                // If out of bound break
                if (newRow >= size || newRow < 0 || newColumn >= size || newColumn < 0)
                    break;

                // If not matched, break
                if (matrix[newRow][newColumn] != word.charAt(k))
                    break;

                s.append(matrix[newRow][newColumn]);


                // Moving in particular direction
                newRow += x[direction];
                newColumn += y[direction];

            }

            if (word.compareTo(s.toString()) == 0) {
                return direction;
            }

        }
        return -1;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String fileName = null;
        long startTime = 0, endTime = 0;
        boolean timingFlag = false;

        //arguments validation routine
        if (args.length == 2 && args[0].equals("-timing")) {
            startTime = System.currentTimeMillis();
            fileName = args[1];
        } else if (args.length == 1) {
            fileName = args[0];
        } else {
            System.err.printf("ERROR: Invalid arguments");
            System.exit(1);
        }

        readFile(fileName);
        for (String Word : solutionsMap) {
            searchWord(Word);
        }

        if (args.length == 2 && args[0].equals("-timing")) {
            endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            System.out.printf("Elapsed time: %.3f", (double) timeElapsed / 1000);
        }
    }

}