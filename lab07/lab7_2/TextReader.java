import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements ReaderInterface {
    private File file;
    private int index = 0;
    Scanner sc;

    TextReader(String filepath) {
        try {
            this.file = new File(filepath);
        } catch (Exception e) {
            System.err.println("ERROR! This file could not be loaded!");
        }
    }

    @Override
    public boolean hasNext() throws FileNotFoundException {
        boolean flag = false;
        if (this.file == null){
            System.out.println("File not initialized");
            return false;
        }
        try {
            sc = new Scanner(this.file);

            if (sc.hasNextLine()) {
                flag = true;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR! This file could not be loaded!");
            flag = false;
        }
        return flag;
    }

    @Override
    public String next() throws FileNotFoundException {
        if (hasNext()) {
            return sc.nextLine();
        } else {
            return null;
        }
    }
}
