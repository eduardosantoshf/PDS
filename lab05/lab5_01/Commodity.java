package lab5_01;

public interface Commodity {
    public Temperature getTemperature();

    public State getState();
}

//classes for each commodity
class Milk implements Commodity {
    private Temperature temp = Temperature.WARM;
    private State st = State.SOLID;

    //getters
    public Temperature getTemperature() {
        return this.temp;
    }
    public State getState() {
        return this.st;
    }

    //toString
    public String toString() {
        return "[commodity=Milk [Temperature()=" + this.temp + ", State()=" + this.st + "]]";
    }
}

class FruitJuice implements Commodity {
    private Temperature temp = Temperature.COLD;
    private State st = State.LIQUID;

    //getters
    public Temperature getTemperature() {
        return this.temp;
    }
    public State getState() {
        return this.st;
    }

    //toString
    public String toString() {
        return "[commodity=FruitJuice [fruit=Orange Temperature()=" + this.temp + ", State()=" + this.st + "]]";
    }
}

class Tuna implements Commodity {
    private Temperature temp = Temperature.COLD;
    private State st = State.SOLID;

    //getters
    public Temperature getTemperature() {
        return this.temp;
    }
    public State getState() {
        return this.st;
    }

    //toString
    public String toString() {
        return "[commodity=Tuna [Temperature()=" + this.temp + ", State()=" + this.st + "]]";
    }
}

class Pork implements Commodity {
    private Temperature temp = Temperature.WARM;
    private State st = State.SOLID;

    //getters
    public Temperature getTemperature() {
        return this.temp;
    }
    public State getState() {
        return this.st;
    }

    //toString
    public String toString() {
        return "[commodity=Pork [Temperature()=" + this.temp + ", State()=" + this.st + "]]";
    }
}