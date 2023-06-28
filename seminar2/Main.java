package seminar2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Положительное или отрицательное число");
        try {
            Methods.posOrNeg();
        } catch (InvalidNumberException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nДеление");
        try {
            Methods.division();
        } catch (DivisionByZeroException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nПроверка 3 чисел (1 число <= 100, 2 >= 0, их сумма > 10, 3 не равно 0)");
        try {
            Methods.check3Num();
        } catch (NumberOutOfRangeException | NumberSumException | DivisionByZeroException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
