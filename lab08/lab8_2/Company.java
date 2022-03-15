package lab8_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {
	public static User user;
	private List<Employee> emps = new ArrayList<>();
	private SocialSecurity socialSecurity = new SocialSecurity();
	private Insurance insurance = new Insurance();
	private Parking parking = new Parking();

	
	public void admitEmployee(Person person, double salary) {
		Employee e = new Employee(person, salary);
		emps.add(e);
		
		e.createCard(new EmployeeCard(person.getName()));
		System.out.println(person.getName() + " tem id card " + e.getEmployeeCard().getEmployee_id());
		if(socialSecurity.regist(person))
			System.out.println(person.getName() + " foi registado na segurança social");
		if(insurance.regist(person))
			System.out.println(person.getName() + " foi registado na seguradora");
		if(parking.allow(person))
			System.out.println(person.getName() + " foi permitida no parque de estacionamento");

		
		}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getPerson().getBankAccount();
			ba.deposit(e.getSalary());
			}
		}
	

	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	public SocialSecurity getSocialSecurity() {
		return socialSecurity;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public Parking getParking() {
		return parking;
	}



	
	
}
