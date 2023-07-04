package seminar3;

import java.util.ArrayList;
import java.util.List;

public class BankTransactionSystem {
    private static List <bankAccount> listBankAccount = new ArrayList<>();
    
    public static void add(String name, Integer value) {
        listBankAccount.add(new bankAccount(name, value));
    }

    public static void print() {
        for (int i = 0; i < listBankAccount.size(); i++) {
            System.out.println(listBankAccount.get(i));
        }
    }

    public static void transfer(Integer idSend, Integer idHost, Integer sum) throws InvalidAmountException, InsufficientFundsException {
        if (sum <= 0) throw new InvalidAmountException("Некорректная сумма перевода");
        Integer currentSend = null;
        Integer iSend = null;
        Integer currentHost = null;
        Integer iHost = null;
        int i = 0;
        while (i < listBankAccount.size() && (currentSend == null || currentHost == null)) {
            if (listBankAccount.get(i).getId() == idSend) {
                currentSend = listBankAccount.get(i).getBalance();
                iSend = i;
                if (currentSend < sum) throw new InsufficientFundsException("Недостаточно средств на счете");
            } else if (listBankAccount.get(i).getId() == idHost) {
                currentHost = listBankAccount.get(i).getBalance();
                iHost = i;
            }
            i++;
        }
        if (iSend != null && iHost != null) {
            listBankAccount.get(iSend).setBalance(currentSend - sum);
            listBankAccount.get(iHost).setBalance(currentHost + sum);
            System.out.println("Транзакция успешно проведена");
        }
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}