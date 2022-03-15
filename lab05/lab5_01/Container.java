package lab5_01;

public abstract class Container {
    protected Commodity commodity;

    public boolean placeCommodity (Commodity c) {
        this.commodity = c;
        return true;
    }
}

class PlasticBottle extends Container {
    //toString
    public String toString() {
        return "PlasticBottle " + super.commodity.toString();
    }
}

class TermicBottle extends Container {
    //toString
    public String toString() {
        return "TermicBottle " + super.commodity.toString();
    }
}

class Tupperware extends Container {
    //toString
    public String toString() {
        return "Tupperware " + super.commodity.toString();
    }
}

class PlasticBag extends Container {
    //toString
    public String toString() {
        return "PlasticBag " + super.commodity.toString();
    }
}
