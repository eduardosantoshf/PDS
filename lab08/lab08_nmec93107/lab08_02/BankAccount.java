package lab08_02;

public interface BankAccount {
    void deposit(double amount);
    boolean withdraw(double amount);
    double balance();
}
