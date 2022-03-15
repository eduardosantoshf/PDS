package lab08_02;

import java.util.List;

public class SharkCompany {
    public static void main(String[] args) {
        Person[] persons = { new Person("Maria Silva"),
                new Person("Manuel Pereira"),
                new Person("Aurora Machado"),
                new Person("Augusto Lima")
        };

        Company shark = new Company();
        Company.user = User.COMPANY;
        shark.admitEmployee(persons[0], 1000);
        shark.admitEmployee(persons[1], 900);
        shark.admitEmployee(persons[2], 1200);
        shark.admitEmployee(persons[3], 1100);
        List<Employee> sharkEmps = shark.employees();

        System.out.println("Initial balances:");
        for (Person p : persons)
            System.out.println("[P] " + p.getName() + " balance: " + p.getBankAccount().balance());

        System.out.println("------------------------------");
        System.out.println("Employee's salaries:");
        for (Employee e : sharkEmps)
            System.out.println("[E] " + e.getPersonName() + " salary: " + e.getSalary());

        shark.paySalaries(1);
        System.out.println("------------------------------");
        System.out.println("Balances after payments:");
        for (Person p : persons)
            System.out.println("[P] " + p.getName() + " balance: " + p.getBankAccount().balance());

    }
}
