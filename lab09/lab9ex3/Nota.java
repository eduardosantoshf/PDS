package lab9;

abstract class Nota {

	    protected Nota successor = null;

	    public void withdraw(int money){
	        if(successor != null)
	            this.successor.withdraw(money);
	        else    
	            System.out.println("Not possible to withdraw " + money + " euros!");
	    }

	    protected boolean canHandleWithdraw(int money){
	        return false;
	    }

	    public Nota setSuccessor(Nota succ){
	    this.successor = succ;
	        return this;
	    }
}
