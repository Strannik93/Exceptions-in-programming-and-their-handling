package seminar3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа-калькулятор");
        try {
            int value1 = PowerCalculator.fillNumInt("основание");
            int value2 = PowerCalculator.fillNumInt("показатель степени");
            PowerCalculator.calculatePower(value1, value2);
        } catch (InvalidInputException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("\nБанковский перевод");
        BankTransactionSystem bank = new BankTransactionSystem();
        bank.add("Вася", 500);
        bank.add("Петр", 300);
        bank.add("Иван", 700);
        bank.add("Вася", 1000);
        bank.print();
        try {
            bank.transfer(1, 2, 500);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        bank.print();
    }
}
