package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WSSolver {

    static char[][] matrix = null;;
    static ArrayList<String> words = new ArrayList<>();
    static ArrayList<String> wordsDirections = new ArrayList<>();
    static ArrayList<Integer> wordPos = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        /*----------------------------- working with the file -----------------------------*/
        Scanner reader = null;
        int linesNumber = 0;
        try {
            reader = new Scanner(new File("src/lab01/lettersSoup.txt"), "utf-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //adding letters soup to matrix
        String line = reader.nextLine();
        int matrixSize = line.length();
        matrix = new char[matrixSize][matrixSize];
        int count = 0;

        for (int i = 0; i < matrixSize; i++) {
            matrix[count][i] = line.charAt(i);
        }
        count++;

        while (reader.hasNextLine() && count < matrixSize) {
            line = reader.nextLine();
            for (int j = 0; j < matrixSize; j++) {
                matrix[count][j] = line.charAt(j);
            }
            count++;
        }

        String word = "";

        reader.useDelimiter("[^a-zA-Z0-9]+");

        while (reader.hasNext()) {
            //word = reader.next().replaceAll("[^\\w]", " ");
            word = reader.next();
            words.add(word);
        }

        //System.out.println(words);

        //print matrix
        /*
        for (int i = 0; i < matrixSize; i++) {
            System.out.println(matrix[i]);
        }
         */

        //pesquisa
        int wordChar = 0;
        int wordLine = 0;
        int wordCol = 0;
        String wordDirection = null;
        boolean flag = false;
        int times = 0;
        for (String w: words) {
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (Character.toLowerCase(matrix[i][j]) == Character.toLowerCase(w.charAt(wordChar))) {

                        //up
                        if (i - w.length() + 1 >= 0) {
                            wordChar = 1;
                            for (int y = 1; y < w.length(); y++) {
                                if (Character.toLowerCase(matrix[i - y][j]) == Character.toLowerCase(w.charAt(wordChar))) {
                                    wordChar++;
                                } else {
                                    break;
                                }
                            }

                            if (wordChar == w.length()) {
                                wordLine = i + 1;
                                wordCol = j + 1;
                                wordDirection = "up";
                                if (flag == false) {
                                    times++;
                                    flag = true;
                                }

                            }
                        }

                        //down
                        if (i + w.length() <= count) {
                            wordChar = 1;
                            for (int y = 1; y < w.length(); y++) {
                                if (Character.toLowerCase(matrix[i + y][j]) == Character.toLowerCase(w.charAt(wordChar))) {
                                    wordChar++;
                                } else {
                                    break;
                                }
                            }
                            if (wordChar == w.length()) {
                                wordLine = i + 1;
                                wordCol = j + 1;
                                wordDirection = "down";
                                if (flag == false)
                                    flag = true;

                            }
                        }
                        //right
                        if (j + w.length() <= count) {
                            wordChar = 1;
                            for (int y = 1; y < w.length(); y++) {
                                if (Character.toLowerCase(matrix[i][j + y]) == Character.toLowerCase(w.charAt(wordChar)))
                                    wordChar++;
                                else {
                                    break;
                                }
                            }
                            if (wordChar == w.length()) {
                                wordLine = i + 1;
                                wordCol = j + 1;
                                wordDirection = "right";
                                if (flag == false)
                                    flag = true;

                            }
                        }
                        //left
                        if (j - w.length() + 1 >= 0) {
                            wordChar = 1;
                            for (int y = 1; y < w.length(); y++) {
                                if (Character.toLowerCase(matrix[i][j - y]) == Character.toLowerCase(w.charAt(wordChar)))
                                    wordChar++;
                                else {
                                    break;
                                }
                            }
                            if (wordChar == w.length()) {
                                wordLine = i + 1;
                                wordCol = j + 1;
                                wordDirection = "left";
                                if (flag == false)
                                    flag = true;

                            }
                        }
                        //upleft
                        if (j - w.length() + 1 >= 0 && i - w.length() + 1 >= 0) {
                            wordChar = 1;
                            for (int y = 1; y < w.length(); y++) {
                                if (Character.toLowerCase(matrix[i - y][j - y]) == Character.toLowerCase(w.charAt(wordChar)))
                                    wordChar++;
                                else {
                                    break;
                                }
                            }
                            if (wordChar == w.length()) {
                                wordLine = i + 1;
                                wordCol = j + 1;
                                wordDirection = "upleft";
                                if (flag == false)
                                    flag = true;

                            }
                        }
                        //upright
                        if (i - w.length() + 1 >= 0 && j + w.length() <= count) {
                            wordChar = 1;
                            for (int y = 1; y < w.length(); y++) {
                                if (Character.toLowerCase(matrix[i - y][j + y]) == Character.toLowerCase(w.charAt(wordChar)))
                                    wordChar++;
                                else {
                                    break;
                                }
                            }
                            if (wordChar == w.length()) {
                                wordLine = i + 1;
                                wordCol = j + 1;
                                wordDirection = "upright";
                                if (flag == false)
                                    flag = true;

                            }
                        }
                        //downright
                        if (i + w.length() <= count && j + w.length() <= count) {
                            wordChar = 1;
                            for (int y = 1; y < w.length(); y++) {
                                if (Character.toLowerCase(matrix[i + y][j + y]) == Character.toLowerCase(w.charAt(wordChar)))
                                    wordChar++;
                                else {
                                    break;
                                }
                            }
                            if (wordChar == w.length()) {
                                wordLine = i + 1;
                                wordCol = j + 1;
                                wordDirection = "downright";
                                if (flag == false)
                                    flag = true;

                            }
                        }
                        //downleft
                        if (i + w.length() <= count && j - w.length() + 1 >= 0) {
                            wordChar = 1;
                            for (int y = 1; y < w.length(); y++) {
                                if (Character.toLowerCase(matrix[i + y][j - y]) == Character.toLowerCase(w.charAt(wordChar)))
                                    wordChar++;
                                else {
                                    break;
                                }
                            }
                            if (wordChar == w.length()) {
                                wordLine = i + 1;
                                wordCol = j + 1;
                                wordDirection = "downleft";
                                if (flag == false)
                                    flag = true;

                            }
                        }

                    }
                    wordChar = 0;
                }
            }
            if (flag == true) {
                wordPos.add(wordLine);
                wordPos.add(wordCol);
                wordsDirections.add(wordDirection);
                flag = false;
            }
        }

        //verifications
        int count2 = 0;
        for (char[] c: matrix) {
            count2++;
        }
        isMatrix(count2, matrixSize);
        if (MatrixIsUppercase(matrix)) {
            System.out.println("Every char in the matrix is uppercase");
        }
        System.out.println(checkWordsCases(words));
        System.out.println(checkWordsSize(words));
        System.out.println(checkRepeatedWords(words));


        int count3 = 1;
        for (int i = 0; i < words.size(); i++) {
            System.out.printf("\n %-15s %-5s %5s,%-5s %-10s", words.get(i).toUpperCase(), words.get(i).length(), wordPos.get(count3 - 1), wordPos.get(count3), wordsDirections.get(i));
            count3 += 2;
        }



    }


    /*------------------------------------ methods ------------------------------------*/

    public static void isMatrix(int count, int matrixSize) {
        boolean flag = true;
        if (count == matrixSize) {
            System.out.println("I's a matrix");
        }
        return;
    }

    public static boolean MatrixIsUppercase(char[][] matrix) {
        for (char[] c: matrix) {
            for (char c2: c) {
                if (!Character.isUpperCase(c2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWordsCases(ArrayList<String> w) {
        boolean flag = true;
        for (String word: words) {
            char[] charArray = word.toCharArray();
            int count = 0;
            for (int i = 0; i < charArray.length; i++) {
                if (Character.isUpperCase(charArray[i])) {
                    count++;
                }
            }
            if (count == word.length()) {
                flag = false;
                System.err.println("ERROR: Words can't have all letter uppercase");
            }
        }
        return flag;
    }

    public static boolean checkWordsSize(ArrayList<String> w) {
        boolean flag = true;
        for (String word: w) {
            if (word.length() < 4) {
                flag = false;
                System.err.println("Words' length has to be >= 4");
            }
        }
        return flag;
    }

    public static boolean checkRepeatedWords(ArrayList<String> w) {
        boolean flag = true;
        for (int i = 0; i < w.size(); i++) {
            for (int j = i + 1; j < w.size(); j++) {
                if ((i != j) && w.get(i).equals(w.get(j))) {
                    flag = false;
                }
            }
        }
        return flag;
    }

}
