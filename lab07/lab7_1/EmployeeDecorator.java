package lab7_1;

public abstract class  EmployeeDecorator implements EmployeeInterface {
     
	private EmployeeInterface t;

	
	public EmployeeInterface getT() {
		return t;
	}

	public void setT(EmployeeInterface t) {
		this.t = t;
	}

	public EmployeeDecorator(EmployeeInterface t) {
		this.t = t;
	}
	
	public void start(String date) {
		t.start(date);	
	}

	public void terminate(String date) {
		t.terminate(date);
	}

	public void work() {
		t.work();
	}

	@Override
	public String toString() {
		return t.toString();
	}
	
	
	
	
	
}
