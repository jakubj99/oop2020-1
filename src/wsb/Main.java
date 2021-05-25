package wsb;

import wsb.genericTypes.SuperNumber;

public class Main {
    public static void main(String[] args) {
        SuperNumber<Double> number = new SuperNumber<>(.5);
        SuperNumber<Double> number1 = new SuperNumber<>(1.0);
        SuperNumber<Double> number2 = new SuperNumber<>(1.5);

        System.out.println(number.getDoub());
        System.out.println(number.getInt());
        System.out.println(number.isDoubEqInt());
        System.out.println(number1.isDoubEqInt());
        System.out.println(number.intEq(number1));
        System.out.println(number.intEq(number2));
        System.out.println(number.doubEq(number1));
        System.out.println(number.doubEq(number2));
    }
}


