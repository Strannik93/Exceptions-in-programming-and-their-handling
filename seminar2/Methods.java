package seminar2;

import java.util.Scanner;

public class Methods {
    public static void posOrNeg() throws InvalidNumberException{
        Long num = newNumLong();
        if (num <= 0) throw new InvalidNumberException("Некорректное число");
        System.out.println("Число корректно");
    }

    public static void division() throws DivisionByZeroException{
        Long num1 = newNumLong("первое число");
        Long num2 = newNumLong("второе число");
        if (num2 == 0) throw new DivisionByZeroException("Деление на ноль недопустимо");
        System.out.println("Результат деления первого числа на второе: " + num1/num2);
    }

    public static void check3Num() throws NumberOutOfRangeException, NumberSumException, DivisionByZeroException{
        Long num1 = newNumLong("первое число");
        if (num1 > 100) throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        Long num2 = newNumLong("второе число");
        if (num2 < 0) throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        if (num1+num2 < 10) throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        Long num3 = newNumLong("третье число");
        if (num3 == 0) throw new DivisionByZeroException("Деление на ноль недопустимо");
        System.out.println("Проверка пройдена успешно");
    }

    private static Long newNumLong() {
        while (true) {
            try {
                System.out.print("Введите число: ");
                Scanner sc = new Scanner(System.in);
                Long temp = sc.nextLong();
                return temp;
            } catch (java.util.InputMismatchException e) {
                 System.out.println("Ошибка: Некорректный ввод");
        }
        }
    }
    
    private static Long newNumLong(String text) {
        while (true) {
            try {
                System.out.print("Введите " + text + ": ");
                Scanner sc = new Scanner(System.in);
                Long temp = sc.nextLong();
                return temp;
            } catch (java.util.InputMismatchException e) {
                 System.out.println("Ошибка: Некорректный ввод");
        }
        }
    }
}

class InvalidNumberException extends Exception {
    
    public InvalidNumberException(String message) {
        super(message);
    }
}

class DivisionByZeroException extends Exception {
    
    public DivisionByZeroException(String message) {
        super(message);
    }
}

class NumberOutOfRangeException extends Exception {
    
    public NumberOutOfRangeException(String message) {
        super(message);
    }
}

class NumberSumException extends Exception {
    
    public NumberSumException(String message) {
        super(message);
    }
}