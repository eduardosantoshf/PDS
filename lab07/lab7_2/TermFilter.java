import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TermFilter extends ReaderDecorator {
    Scanner sc = new Scanner("");
    Scanner sc2;

    public TermFilter(ReaderInterface r) {
        super(r);
    }

    @Override
    public boolean hasNext() throws FileNotFoundException {
        return super.hasNext();
    }

    @Override
    public String next() throws FileNotFoundException {
        sc = new Scanner(super.next());
        return sc.next();
    }
}
