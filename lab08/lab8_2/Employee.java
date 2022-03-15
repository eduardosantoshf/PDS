package lab8_2;

class Employee {

	private double salary;
	private Person person;
	private EmployeeCard card;

	public Employee(Person p, double s) {
		person = p;
		salary = s;
		this.card= null;
	}

	public double getSalary() {
		return salary;
		}
	
	public Person getPerson() {
		return person;
	}
	
	public EmployeeCard getEmployeeCard() {
		return card;
	}
	
    public void createCard(EmployeeCard c) {
        this.card = c;
    }
    
   
	
	
}
