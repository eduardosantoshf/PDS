public class Auction {
    public static void main(String[] args) {
        Product prod1 = new Product("Vintage Computer", 755);
        Product prod2 = new Product("Bicicleta", 230);
        Product prod3 = new Product("Playstation 1", 500);
        Product prod4 = new Product("Tekken Machine", 1175);
        Product prod5 = new Product("Vintage Leather Ball", 195);

        Client cl1 = new Client("Client 1");
        Client cl2 = new Client("Client 2");
        Client cl3 = new Client("Client 3");

        Gestor g = new Gestor("Gestor");

        prod1.registerObserver(g);
        prod2.registerObserver(g);
        prod3.registerObserver(g);
        prod4.registerObserver(g);
        prod5.registerObserver(g);
    }
}
