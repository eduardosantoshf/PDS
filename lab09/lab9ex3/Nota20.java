package lab9;

public class Nota20 extends Nota {

    @Override
    public void withdraw(int money){
    	if(canHandleWithdraw(money)) {
    	int numNotas20 = money / 20;
    	int moneyLeft = money % 20;
    	System.out.println("Withdraw " + numNotas20 + " bills of 20 euros");
        if(moneyLeft != 0)
            super.withdraw(moneyLeft);   
    	}
    	else {
    		super.withdraw(money);
    	}
    }

    @Override
    protected boolean canHandleWithdraw(int money){
        if(money < 20){
            return false;
        }
        return true;
    }
}
