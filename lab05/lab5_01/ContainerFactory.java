package lab5_01;

public class ContainerFactory {
    public static Container createContainerFor (Commodity c) {
        if (c.getTemperature() == Temperature.COLD) {
            if (c.getState() == State.LIQUID) {
                return new PlasticBottle();
            } else {
                return new PlasticBag();
            }
        } else {
            if (c.getState() == State.LIQUID) {
                return new TermicBottle();
            } else {
                return new Tupperware();
            }
        }
    }
}
