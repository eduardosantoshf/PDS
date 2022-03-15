import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TextReader tr = new TextReader("src/test.txt");
        System.out.println(tr.hasNext());
        System.out.println(tr.next());

        ReaderInterface ri = new TermFilter(tr);
        System.out.println(ri.next());

        ReaderInterface ri2 = new ReverseFilter(tr);
        System.out.println(ri2.next());

        ReaderInterface ri3 = new CoderFilter(tr);
        System.out.println(ri3.next());

    }
}
