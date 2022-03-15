import java.io.FileNotFoundException;
import java.util.Base64;

public class CoderFilter extends ReaderDecorator {
    public CoderFilter(ReaderInterface r) {
        super(r);
    }

    @Override
    public boolean hasNext() throws FileNotFoundException {
        return super.hasNext();
    }

    @Override
    public String next() throws FileNotFoundException {
        String nextword = super.next();
        String encoded = Base64.getEncoder().encodeToString(nextword.getBytes());
        return encoded;
    }
}
