package lab9;

public class Nota10 extends Nota {

    @Override
    public void withdraw(int money){
    	if(canHandleWithdraw(money)) {
    	int numNotas10 = money / 10;
    	int moneyLeft = money % 10;
    	System.out.println("Withdraw " + numNotas10 + " bills of 10 euros");
        if(moneyLeft != 0)
            super.withdraw(moneyLeft);   
    	}
    	else {
    		super.withdraw(money);
    	}
    }

    @Override
    protected boolean canHandleWithdraw(int money){
        if(money < 10){
            return false;
        }
        return true;
    }
}
