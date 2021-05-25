package wsb.genericTypes;

public class SuperNumber<N extends Number> {

    private final N number;

    public SuperNumber(N number) {
        this.number = number;
    }

    public int getInt() { return number.intValue(); }

    public double getDoub() { return number.doubleValue(); }

    public boolean isDoubEqInt() { return number.doubleValue() == number.intValue(); }

    public boolean intEq(SuperNumber<?> other) { return number.intValue() == other.getInt(); }

    public boolean doubEq(SuperNumber<?> other) { return number.doubleValue() == other.getDoub(); }

}
