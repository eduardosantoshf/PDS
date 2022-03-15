package lab9;

public class Nota50 extends Nota {

    @Override
    public void withdraw(int money){
    	if(canHandleWithdraw(money)) {
    	int numNotas50 = money / 50;
    	int moneyLeft = money % 50;
    	System.out.println("Withdraw " + numNotas50 + " bills of 50 euros");
        if(moneyLeft != 0)
            super.withdraw(moneyLeft);   
    	}
    	else {
    		super.withdraw(money);
    	}
    }

    @Override
    protected boolean canHandleWithdraw(int money){
        if(money < 50){
            return false;
        }
        return true;
    }
}
