public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Anti-Stress", 2018, "Omodionah");
        Book b2 = new Book("A Guerra dos Padrões", 2019, "Jorge Omel");
        Book b3 = new Book("A Procura da Luz", 2017, "Khumatkli");
        Library lib = new Library();
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        lib.manage();
    }
}
