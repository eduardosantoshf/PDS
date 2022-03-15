package lab7_1;

public class Manager extends EmployeeDecorator{

	public Manager(EmployeeInterface t) {
		super(t);
	}
	@Override
	public void start(String date) {
		System.out.println("Manager  (" + super.toString() +") started in date: " + date);
		
	}

	@Override
	public void terminate(String date) {
		System.out.println("Manager (" + super.toString() + ") terminates in date: "+date);
		
	}

	@Override
	public void work() {
		System.out.println("Manager (" + super.toString() + ") is working");
		
	}
	public void manage() {
		System.out.println("Manager (" + super.toString() +") is managing");
		
	}
	@Override
	public String toString() {
		return super.toString();
	}

	
	
}
