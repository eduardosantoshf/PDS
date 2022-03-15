package lab08_01;

public class Proxy implements BankAccount {

    private BankAccountImpl bankImp = null;

    public Proxy(BankAccountImpl bankImpl) {
        this.bankImp = bankImpl;
    }

    public boolean checkUser() {return (Company.user == User.OWNER) ? true : false;}

    @Override
    public void deposit(double amount) { bankImp.deposit(amount); }

    @Override
    public boolean withdraw(double amount) throws IllegalAccessException {
        if (!checkUser()) {
            throw new IllegalAccessException("Access denied!");
        }
        return bankImp.withdraw(amount);
    }

    @Override
    public double balance() throws IllegalAccessException {
        if (!checkUser()) {
            throw new IllegalAccessException("Access denied!");
        }

        return bankImp.balance();
    }
}
