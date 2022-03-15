package lab5_01;

public class MeatFactory {
    public static Commodity createMeat (Temperature temp) {
        if (temp == Temperature.WARM) {
            return new Pork();
        } else {
            return new Tuna();
        }
    }
}
