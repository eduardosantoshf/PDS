package lab9;

public class Nota500 extends Nota {

    @Override
    public void withdraw(int money){
    	if(canHandleWithdraw(money)) {
    	int numNotas500 = money / 500;
    	int moneyLeft = money % 500;
    	System.out.println("Withdraw " + numNotas500 + " bills of 500 euros");
        if(moneyLeft != 0)
            super.withdraw(moneyLeft);   
    	}
    	else {
    		super.withdraw(money);
    	}
    }

    @Override
    protected boolean canHandleWithdraw(int money){
        if(money < 500){
            return false;
        }
        return true;
    }
}
