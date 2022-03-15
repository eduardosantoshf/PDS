public class Gestor implements Observer{
    private String name = "";

    public Gestor(String name) { this.name = name; }

    @Override
    public void update(String message) {
        System.out.printf("%s: %s\n",this.name,message);
    }

    @Override
    public String getType() {
        return "Gestor";
    }

    public void startLeilao(Product p) {
        p.startAuction(1);
    }
}
