package lab7_1;

public class TeamLeader extends EmployeeDecorator{

	public TeamLeader(EmployeeInterface t) {
		super(t);
	}
	
	@Override
	public void start(String date) {
		System.out.println("TeamLeader (" + super.toString() + ") started in date " +date);
		
	}

	@Override
	public void terminate(String date) {
		System.out.println("TeamLeader (" + super.toString() + ") terminated in date: "+date);
		
	}

	@Override
	public void work() {
		System.out.println("TeamLeader (" + super.toString() + ") is working ");
		
	}
	public void plan() {
		System.out.println("TeamLeader (" + super.toString() + ") is planning ");
		
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

}
