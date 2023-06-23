package seminar1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверка деления на 0");
        Methods.division();
        System.out.println("");
        System.out.println("Обработка некорректного ввода");
        Methods.requestAge();
        System.out.println("");
        System.out.println("Чтение файла и подсчет суммы чисел");
        Methods.countSumNumbers("seminar1/test.txt");
        Methods.countSumNumbers("seminar1/test2.txt");
    }
}