package seminar3;

import java.util.Scanner;

public class PowerCalculator{
    public static void calculatePower(int basis, int degree) throws InvalidInputException{
        if (basis == 0 && degree < 0) throw new InvalidInputException("Невозможно возвести 0 в отрицательную степень");
        double rezult;
        if (basis == 0) rezult = 0;
        else if (degree == 0) rezult = 1;
        else if (degree > 0) {
            rezult = basis;
            for (int i = 2; i <= degree; i++) {
                rezult *= basis;
            }
        } else {
            rezult = basis;
            rezult = 1/rezult;
            for (int i = degree; i < -1; i++) {
                rezult /= Double.valueOf(basis);
            }
        }
        System.out.printf("Результат возведения %s в степень %s: %f\n", basis, degree, rezult);
    }    

    public static int fillNumInt(String str) throws InvalidInputException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите " + str + ": ");
            int value = sc.nextInt();
            return value;
        } catch (java.util.InputMismatchException e) {
            throw new InvalidInputException("Некорректный ввод числа");
        }
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}