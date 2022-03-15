package lab01;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WSGenerator {

    public static void main(String[] args) throws IOException {

        String[] words =  new String[] {"programming", "java", "words", "lines", "civic", "test", "stack"};

        int dimension = 50;
        ArrayList<String> matrix = createMatrix(dimension);
        matrix = fillMatrix(matrix, words);

        BufferedWriter writer = new BufferedWriter(new FileWriter("sdl_01.txt"));
        for (String line: matrix) {

            writer.write(line);
            writer.write("\n");

        }
        writer.close();
    }

    public static ArrayList<String> createMatrix (int dimension){

        ArrayList<String> matrix = new ArrayList<>();

        StringBuilder line = new StringBuilder();
        //Random r = new Random();
        //char c = (char)(r.nextInt(26) + 'a');
        for (int i = 0; i < dimension; i++) {
            //line.append(c);
            line.append("-");
        }

        for (int i = 0; i < dimension; i++) {
            matrix.add(line.toString());
        }

        return matrix;
    }



    public static ArrayList<String> fillMatrix (ArrayList<String> matrix, String[] words){

        for (String w: words) {
            matrix = checkPositions(matrix, w);
        }
        printMatrix(matrix);
        return matrix;
    }



    public static ArrayList<ArrayList> get_positions(int maxSize, int wordSize, Random r){

        ArrayList<ArrayList> positions = new ArrayList<>();
        int x, y, d_x, d_y;
        boolean flag = false;

        //while positions are not accepted keeps searching for new ones
        while(!flag){

            //get random coordenates
            x = r.nextInt(maxSize - 0) + 0;
            y = r.nextInt(maxSize - 0) + 0;

            do {
                d_x = r.nextInt(2 + 1) - 1;
                d_y = r.nextInt(2 + 1) - 1;
            } while (d_x == 0 && d_y == 0);

            if (x + wordSize * d_x >= 0 && x + wordSize * d_x < maxSize  &&  y + wordSize * d_y >= 0 && y + wordSize * d_y < maxSize) {

                for (int i = 0; i < wordSize; i++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(x + i * d_x);
                    temp.add(y + i * d_y);
                    positions.add(temp);
                }
                flag = true;
            }

        }
        return positions;
    }

    public static ArrayList<String> checkPositions(ArrayList<String> matrix, String word){

        boolean flag = false;
        ArrayList<ArrayList> positions = new ArrayList<>();
        Random r = new Random();
        int letter;

        while(!flag){
            positions = get_positions(matrix.get(0).length(), word.length(), r);

            String line;
            int iteration = 0, x, y;
            boolean flag2 = true;
            StringBuilder sb = new StringBuilder();

            for(ArrayList <Integer> p : positions) {

                x = p.get(0);
                y = p.get(1);

                line = matrix.get(x);

                if (!(line.charAt(y) == '-' || line.charAt(y) == word.charAt(iteration))) {
                    flag2 = false;
                }
                iteration++;
            }

            if (flag2) {

                letter = 0;

                for (ArrayList <Integer> coordenate : positions) {
                    x = coordenate.get(0);
                    y = coordenate.get(1);

                    for (int i = 0 ; i < matrix.get(x).length(); i++) {
                        if (i == y) {
                            sb.append(word.toUpperCase().charAt(letter));
                            letter++;
                        } else {
                            sb.append(matrix.get(x).toUpperCase().charAt(i));
                        }
                    }

                    matrix.set(x , sb.toString());
                    sb.setLength(0);
                }

                flag = true;
            }
        }
        return matrix;
    }

    public static void printMatrix (ArrayList<String> matrix){
        Random r = new Random();
        for (String line: matrix) {
            System.out.println(line);
        }
    }
}
