package lab5_01;

public class BeverageFactory {
    public static Commodity createBeverage(Temperature temp) {
        if (temp == Temperature.WARM) {
            return new Milk();
        } else {
            return new FruitJuice();
        }
    }
}
