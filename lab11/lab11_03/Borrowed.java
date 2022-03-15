public class Borrowed implements State {
    @Override
    public void register(Book b) { throw new UnsupportedOperationException("Operation not available."); }

    @Override
    public void reserve(Book b) { throw new UnsupportedOperationException("Operation not available."); }

    @Override
    public void cancelReserve(Book b) { throw new UnsupportedOperationException("Operation not available."); }

    @Override
    public void giveBack(Book b) { b.setState(new Available()); }

    @Override
    public void take(Book b) { throw new UnsupportedOperationException("Operation not available."); }
}
