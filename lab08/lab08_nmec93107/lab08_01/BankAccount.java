package lab08_01;

public interface BankAccount {
    void deposit (double amount);
    boolean withdraw (double amount) throws IllegalAccessException;
    double balance() throws IllegalAccessException;
}
