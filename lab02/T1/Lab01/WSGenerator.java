package Lab01;

import java.io.*;
import java.util.*;

public class WSGenerator {

    private static ArrayList<String> solutionsMap = new ArrayList<>();
    //direction vectors
    private static int[] x = { -1, -1, -1,  0, 0,  1, 1, 1 };
    private static int[] y = { -1,  0,  1, -1, 1, -1, 0, 1 };

    public static void readFile(String fileName) throws FileNotFoundException {
        try {

            File f = new File(fileName);
            Scanner textReader = new Scanner(f);

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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //Finds a place for the word in the matrix, and then places it
    // input: WS matriz, word to place
    public static  void findPlace(char[][] matrix, String word){
        int startingX, startingY, direction;
        boolean placed = false;

        while (true){
            //randomly generates x and y coordinates + direction
            startingX = new Random().nextInt(matrix.length);
            startingY = new Random().nextInt(matrix.length);
            direction = new Random().nextInt(8);

            //checks if the matrix has space for the word
           if (checkIfFits(word, matrix, startingX, startingY, direction)){
               placeWord(word, matrix, startingX, startingY, direction);
               break;
           }
        }
    }

    //places a word in the matrix
    //input word, the matrix, the x coordinate, the y coordinate and the direction
    private static void placeWord(String word, char[][] matrix, int startingX, int startingY, int direction) {
        for (int k = 0; k <word.length(); k++) {
            matrix[startingX][startingY] = word.charAt(k);
            startingX += x[direction];
            startingY += y[direction];
        }
    }

    //checks if a words fits in any space in the matrix
    //input word, the matrix, the x coordinate, the y coordinate and the direction
    private static boolean checkIfFits(String word, char[][] matrix, int startingX, int startingY, int direction) {
        for (int k = 0; k <word.length(); k++) {
            //check if the space is occupied with a different letter
            if (matrix[startingX][startingY] != '\0' && matrix[startingX][startingY] != word.charAt(k)) {
                return false;
            }

            //move in a direction and check it the x and y are still inside the matrix
            startingX += x[direction];
            startingY += y[direction];
            if (startingX < 0 || startingX >= matrix.length  || startingY < 0 || startingY >= matrix.length ){
                return false;
            }


        }
        return true;
    }

    private static void printInFile(char[][] matrix, String fileName){
        try {
            FileWriter writer = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(writer);

            //prints matrix on a file
            for (int i = 0; i < matrix.length; i++) {
                for (int j =0; j < matrix.length ; j++) {
                    printWriter.print(matrix[i][j]);
                }
                printWriter.println();
            }

            //print list of words on a file
            for (String word : solutionsMap) {
                printWriter.printf("%s; ", word.toLowerCase());
            }

            printWriter.close();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) throws FileNotFoundException {

        boolean inputFlag = false;
        boolean sizeFlag = false;
        boolean outputFlag = false;
        String inputFilename = null;
        String outputFilename = null;
        int size = 0;

        //arguments validation routine
        for (int argIndex = 0; argIndex < args.length; argIndex++){
            switch (args[argIndex]) {
                case "-i":
                    inputFlag = true;
                    inputFilename = args[argIndex +1];
                    break;
                case "-s":
                    sizeFlag = true;
                    size = Integer.parseInt(args[argIndex + 1]);
                    if (size < 4){
                        System.err.println("ERROR: Size too small");
                        System.exit(1);
                    }
                    break;
                case "-o":
                    outputFlag = true;
                    outputFilename = args[argIndex +1];
                    break;
            }
        }

        if (!inputFlag || !sizeFlag){
            System.err.println("ERROR: missing arguments");
            System.exit(1);
        }

        long startTime = System.currentTimeMillis();
        readFile(inputFilename);
        solutionsMap.sort(Comparator.comparing(String::length).reversed());

        if (solutionsMap.get(0).length() > size*size) {
            System.err.println("ERROR: There are words too big for this puzzle size");
            System.exit(1);
        }

        char matrix[][] = new char[size][size];

        for (int wordNr = 0; wordNr < solutionsMap.size(); wordNr++){
            findPlace(matrix, solutionsMap.get(wordNr));
        }

        //fills the rest of the matrix with random chars
        for (int i = 0; i< size; i++) {
            for (int j =0; j < size ; j++) {
                if (matrix[i][j] == '\0') {
                    matrix[i][j] = (char)(new Random().nextInt(26) + 'A');
                }
            }
        }

        if (outputFlag) {
            printInFile(matrix, outputFilename);
        } else {

            //print matrix on terminal
            for (int i = 0; i< size; i++) {
                for (int j =0; j < size ; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }

            //print word list on terminal
            for (String word : solutionsMap) {
                System.out.printf("%s; ", word.toLowerCase());
            }

        }

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("\nElapsed time: " + (double) timeElapsed / 1000);
    }
}
