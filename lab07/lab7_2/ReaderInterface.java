import java.io.FileNotFoundException;

public interface ReaderInterface {
    public boolean hasNext() throws FileNotFoundException;
    public String next() throws FileNotFoundException;
}
