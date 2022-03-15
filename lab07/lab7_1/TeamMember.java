package lab7_1;

public class TeamMember extends EmployeeDecorator {

	public TeamMember(EmployeeInterface t) {
		super(t);
	}
	
	@Override
	public void start(String date) {
		System.out.println("TeamMember (" + super.toString() + ") started in date:" +date);
		
	}

	@Override
	public void terminate(String date) {
		System.out.println("TeamMember (" + super.toString() + ") terminated in date: "+ date);
		
	}

	@Override
	public void work() {
		System.out.println("TeamMember (" + super.toString() + ") is Working");
		
	}
	
    public void colaborate () {
    	System.out.println("TeamMember (" + super.toString() + ") is Colaborating");
    	
    }

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
