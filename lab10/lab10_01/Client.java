public class Client implements Observer{
    public String name = "";

    public Client(String name) { this.name = name; }

    public boolean bid (Product prod, double bid_value) {
        return prod.registerProductBid(bid_value, this);
    }

    @Override
    public void update(String message) {
        System.out.printf("%s: %s\n", this.name, message);
    }

    @Override
    public String getType() {
        return "Client";
    }
}
