package seminar1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
    public static void division() {
        try {
            System.out.print("Введите 1 число: ");
            Integer num1 = Methods.requestNumber();
            System.out.print("Введите 2 число: ");
            Integer num2 = Methods.requestNumber();
            System.out.println("Результат деления: " + num1/num2);
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0 недопустимо");
        }
    }

    private static Integer requestNumber() {
        try {
            Scanner sc = new Scanner(System.in);
            Integer temp = sc.nextInt();
            return temp;
        } catch (java.util.InputMismatchException e) {
            System.out.print("Некорректный ввод\nПовторный ввод числа: ");
            return requestNumber();
        }
    }

    public static void requestAge() {
        try {
            System.out.print("Введите ваш возраст: ");
            Long age = reqLong();
            System.out.println("Ваш возраст: " + age);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Long reqLong() throws NumberFormatException {
        try {
            Scanner sc = new Scanner(System.in);
            Long temp = sc.nextLong();
            sc.close();
            return temp;
        } catch (java.util.InputMismatchException e) {
            throw new NumberFormatException("Некорректный ввод");
        }
    }

    public static void countSumNumbers(String path) {
        Double sum = 0.0;
        List<String> MyList = new ArrayList<>();
        readingFile(path, MyList);
        System.out.println(MyList);
        try {
            for (int i = 0; i < MyList.size(); i++) {
                sum += Double.parseDouble(MyList.get(i));
            }
            System.out.println("Сумма всех чисел равна: " + sum);
        } catch (NumberFormatException e) {
            System.out.println("Некорректное значение числа в файле");
        }
    }

    private static void readingFile(String path, List<String> newList) {
        try (FileReader fileReader = new FileReader(path)) {
            Scanner scanRead = new Scanner(fileReader);
            int i = 1;
            while (scanRead.hasNextLine()) {
                String current = scanRead.nextLine();
                newList.add(current);
                i++;
            }
            scanRead.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Файл не найден");
        }
    }
}
