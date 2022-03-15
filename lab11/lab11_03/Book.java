public class Book {
    private State state;
    private String title;
    private int ISBN;
    private static int currentISBN;
    private int year;
    private String firstAuthor;

    public Book(String title, int year, String firstAuthor) {
        state = new Inventory();
        this.title = title;
        this.year = year;
        this.firstAuthor = firstAuthor;
        ISBN = ++currentISBN;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void register() {
        this.state.register(this);
    }

    public void reserve() {
        this.state.reserve(this);
    }

    public void cancelReserve() {
        this.state.cancelReserve(this);
    }

    public void giveBack() {
        this.state.giveBack(this);
    }

    public void take() {
        this.state.take(this);
    }

    public String toString() {
        return String.format("Book: %-5d %-20s %-20s %-15s", ISBN, title, firstAuthor,
                "[" + state.getClass().getSimpleName() + "]");
    }

}
