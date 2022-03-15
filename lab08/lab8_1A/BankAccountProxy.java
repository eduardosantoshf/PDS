package lab8_1A;

public class BankAccountProxy implements BankAccount{
	private BankAccountImpl bankAccount; 

	BankAccountProxy(String bank, double initialDeposit) {
		this.bankAccount =  new BankAccountImpl(bank, initialDeposit);
		}
	
	public String getBank() {
		return this.bankAccount.getBank();
		}
	
	
	public void deposit(double amount) {
		 this.bankAccount.deposit(amount);
		}

	
	public boolean withdraw(double amount) {
		if (Company.user == User.OWNER)
			return this.bankAccount.withdraw(amount);
		else {
			return false;}	
		}

 
	public double balance() {
		if (Company.user == User.OWNER)
			return this.bankAccount.balance();
		else {
			return Double.NaN;}
		}

}

