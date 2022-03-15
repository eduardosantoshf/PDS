package lab08_02;

public class Person {
    private String name;
    private BankAccount bankAccount;

    public Person(String name) {
        this.name = name;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }

    public String getName() { return name; }

    public BankAccount getBankAccount() { return bankAccount; }
}
