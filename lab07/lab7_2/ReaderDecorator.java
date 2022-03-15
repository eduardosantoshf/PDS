import java.io.FileNotFoundException;

public class ReaderDecorator implements ReaderInterface {
    private ReaderInterface reader;

    public ReaderDecorator(ReaderInterface r) {
        this.reader = r;
    }

    @Override
    public boolean hasNext() throws FileNotFoundException {
        return this.reader.hasNext();
    }

    @Override
    public String next() throws FileNotFoundException {
        return this.reader.next();
    }
}
