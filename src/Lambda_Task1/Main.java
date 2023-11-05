package Lambda_Task1;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 3);
        int b = calc.minus.apply(3, 1);

        try {
            int c = calc.divide.apply(a, b);//при оперции деления необходима проверка деляния на ноль или обработать возможное исключение через блок try and catch
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка! Нельзя делить на ноль!");
        }

        int d = calc.abs.apply(-4);
        calc.println.accept(d);
        boolean e = calc.isPositive.test(-7);
        System.out.println(e);

    }
}
