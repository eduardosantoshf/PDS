import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void manage() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do {
            if (!flag) {
                System.out.println("*** Library ***");
                for (Book b : books)
                    System.out.println(b);
                System.out.println(
                        ">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela \n");

            }
            System.out.print(">> ");
            flag = false;

            String line = sc.nextLine();
            if (!line.contains(",")) {
                System.err.println("Wrong input!!!\n");
                continue;
            }

            int book = Integer.parseInt(line.split(",")[0]) - 1;
            int op = Integer.parseInt(line.split(",")[1]);
            switch (op) {
                case 1:
                    try {
                        books.get(book).register();
                    } catch (Exception e) {
                        flag = true;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case 2:
                    try {
                        books.get(book).take();
                    } catch (Exception e) {
                        flag = true;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;

                case 3:
                    try {
                        books.get(book).giveBack();
                    } catch (Exception e) {
                        flag = true;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;

                case 4:
                    try {
                        books.get(book).reserve();
                    } catch (Exception e) {
                        flag = true;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;

                case 5:
                    try {
                        books.get(book).cancelReserve();
                    } catch (Exception e) {
                        flag = true;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
            }
        } while (true);
    }
}
