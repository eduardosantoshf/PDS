import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseFilter extends ReaderDecorator {
    Scanner sc;

    public ReverseFilter(ReaderInterface r) {
        super(r);
    }

    @Override
    public boolean hasNext() throws FileNotFoundException {
        return super.hasNext();
    }

    @Override
    public String next() throws FileNotFoundException {
        sc = new Scanner(super.next());
        String reversed = "";
        String line = sc.nextLine();
        for (int i = line.length() - 1; i > -1; i--) {
            reversed = reversed + line.charAt(i);
        }
        return reversed;
    }
}
