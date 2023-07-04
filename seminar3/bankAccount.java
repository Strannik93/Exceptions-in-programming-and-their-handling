package seminar3;

public class bankAccount {
    private static Integer nextId = 0;
    private Integer id = 0;
    private String name;
    private Integer balance;

    public bankAccount(String name, Integer balance) {
        this.id = nextId;
        this.name = name;
        this.balance = balance;
        nextId += 1;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setBalance(Integer value) {
        this.balance = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, balance: %s", id, name, balance);
    }
}
