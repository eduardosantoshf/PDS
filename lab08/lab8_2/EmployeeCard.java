package lab8_2;


public class EmployeeCard {
	
	private String employee_name;
	private int employee_id;
	private static int id;
	
	EmployeeCard(String name){
        this.employee_name = name;
        this.employee_id = id;
        id++;
    }

	public String getEmployee_name() {
		return employee_name;
	}


	public int getEmployee_id() {
		return employee_id;
	}

	



}
