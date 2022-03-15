package lab7_1;	

public class Employee implements EmployeeInterface{
    private String dateInicio;
    private String dateFim;
    private String id;
    
	public Employee(String id,String dateInicio,String dateFim) {
		this.id= id;
		this.dateInicio = dateInicio;
		this.dateFim = dateFim;
		
	}
	
	public Employee(String id) {
		this.id= id;
		this.dateInicio = null;
		this.dateFim = null;
		
	}
	
	
	
	public String getDateInicio() {
		return dateInicio;
	}


	public void setDateInicio(String dateInicio) {
		this.dateInicio = dateInicio;
	}



	public String getDateFim() {
		return dateFim;
	}

	public void setDateFim(String dateFim) {
		this.dateFim = dateFim;
	}


	@Override
	public void start(String date) {
		System.out.println("Employee " + id + " started working in date " +date);
		this.dateInicio = date;
	}

	@Override
	public void terminate(String date) {
		System.out.println("Employee " + id + " terminated  working in date " +date);
		this.dateFim = date;
		
	}

	@Override
	public void work() {
		System.out.println("Employee " + id + " is working");
		
	}

	@Override
	public String toString() {
		return "Employee " + id ;
	}
}
