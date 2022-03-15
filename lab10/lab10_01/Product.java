import java.util.ArrayList;
import java.util.List;

public class Product {
    public int id = 0;
    private static int counter = 0;
    public String description = "";
    public double basePrice = 0;
    public double highestBid = 0;
    private List<Observer> observers;
    private ProductState state;
    private int auctionTime;

    public Product(String description, double price) {
        counter += 1;
        this.id = counter;
        this.description = description;
        this.basePrice = price;
        this.highestBid = price;
        this.observers = new ArrayList<Observer>();
        this.state = ProductState.STOCK;
    }

    public boolean registerProductBid(double v, Observer obs) {
        if (this.state == ProductState.AUCTION) {
            if (v > highestBid) {
                this.highestBid = v;
                this.observers.add(obs);
                this.notify("A bid with the value " + v + " was made");
                return true;
            }
            for (Observer o : this.observers) {
                if (o.getType().equals("Gestor"))
                    o.update("A bid with the value " + v + " was done!");
            }
            return false;
        }
        return false;
    }

    public void registerObserver(Observer o) {
        if (!this.observers.contains(o)) {
            this.observers.add(o);
        }
    }

    public void notify(String message) {
        for (Observer obs : this.observers) {
            obs.update(message);
        }
    }

    public void startAuction(int time) {
        this.state = ProductState.AUCTION;
        this.auctionTime = time;
    }

}
