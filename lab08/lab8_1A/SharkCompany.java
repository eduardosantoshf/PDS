package lab8_1A;

import java.util.List;

public class SharkCompany {
	
	public static void main(String[] args) {
		
		Company shark = new Company();
		shark.admitPerson("Maria Silva", 1000);
		shark.admitPerson("Manuel Pereira", 900);
		shark.admitPerson("Aurora Machado", 1200);
		shark.admitPerson("Augusto Lima", 1100);
		List<Employee> sharkEmps = shark.employees();
		shark.paySalaries(1);
		
		// simulaçao de funcionários:
		Company.user = User.COMPANY;

		for (Employee e : sharkEmps) {
			System.out.println("Access balance account:");
			if(Double.isNaN(e.getBankAccount().balance()))
				System.out.println("Access denied");
			else{
				System.out.println(e.getName()  + " -> " + e.getBankAccount().balance());
			}
			System.out.println("withdraw:");
			if(e.getBankAccount().withdraw(500))
				System.out.println(e.getName()  + " -> " + e.getBankAccount().balance());
			else {
				System.out.println("Access denied");
			}
		}
		
		// simulação de utilizadores
		
		Company.user = User.OWNER;

		for (Employee e : sharkEmps) {
			System.out.println("Access balance account:");
			if(Double.isNaN(e.getBankAccount().balance()))
				System.out.println("Access denied");
			else{
				System.out.println(e.getName()  + " -> " + e.getBankAccount().balance());
			}
			System.out.println("withdraw:");
			if(e.getBankAccount().withdraw(500))
				System.out.println(e.getName()  + " -> " + e.getBankAccount().balance());
			else {
				System.out.println("Access denied");
			}
		}
		
	}

}
