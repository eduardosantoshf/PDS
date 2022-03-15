public class Available implements State {
    @Override
    public void register(Book b) { throw new UnsupportedOperationException("Operation not available."); }

    @Override
    public void reserve(Book b) { b.setState(new Reserved()); }

    @Override
    public void cancelReserve(Book b) { throw new UnsupportedOperationException("Operation not available."); }

    @Override
    public void giveBack(Book b) { throw new UnsupportedOperationException("Operation not available."); }

    @Override
    public void take(Book b) { b.setState(new Borrowed()); }
}
