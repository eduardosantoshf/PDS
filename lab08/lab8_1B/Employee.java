package lab8_1B;

class Employee {

	private double salary;
	private Person person;

	public Employee(Person p, double s) {
		person = p;
		salary = s;
	}

	public double getSalary() {
		return salary;
		}
	
	public Person getPerson() {
		return person;
	}
	
}
