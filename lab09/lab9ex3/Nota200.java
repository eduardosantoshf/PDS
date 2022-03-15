package lab9;

public class Nota200 extends Nota {

    @Override
    public void withdraw(int money){
    	if(canHandleWithdraw(money)) {
    	int numNotas200 = money / 200;
    	int moneyLeft = money % 200;
    	System.out.println("Withdraw " + numNotas200 + " bills of 200 euros");
        if(moneyLeft != 0)
            super.withdraw(moneyLeft);   
    	}
    	else {
    		super.withdraw(money);
    	}
    }

    @Override
    protected boolean canHandleWithdraw(int money){
        if(money < 200){
            return false;
        }
        return true;
    }
}
