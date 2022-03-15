package lab9;

public class Nota100 extends Nota {

    @Override
    public void withdraw(int money){
    	if(canHandleWithdraw(money)) {
    	int numNotas100 = money / 100;
    	int moneyLeft = money % 100;
    	System.out.println("Withdraw " + numNotas100 + " bills of 100 euros");
        if(moneyLeft != 0)
            super.withdraw(moneyLeft);   
    	}
    	else {
    		super.withdraw(money);
    	}
    }

    @Override
    protected boolean canHandleWithdraw(int money){
        if(money < 100){
            return false;
        }
        return true;
    }
}

