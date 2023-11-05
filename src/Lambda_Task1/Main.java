package Lambda_Task1;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 3);
        int b = calc.minus.apply(1, 1);
        int c = calc.divide.apply(a, b);
        calc.println.accept(c);

        int d = calc.abs.apply(-4);
        calc.println.accept(d);
        boolean e = calc.isPositive.test(-7);
        System.out.println(e);

    }
}
