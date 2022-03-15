package lab08_01;

import java.util.List;

public class SharkCompany {

    public static void main(String[] args) throws IllegalAccessException {
        Company shark = new Company();
        Company.user = User.OWNER;
        shark.admitPerson("Maria Silva", 1000);
        shark.admitPerson("Manuel Pereira", 900);
        shark.admitPerson("Aurora Machado", 1200);
        shark.admitPerson("Augusto Lima", 1100);
        List<Employee> sharkEmps = shark.employees();
        System.out.println("Company.user = User.USER:");
        for (Employee e: sharkEmps) {
            // "talking to strangers", but this is not a normal case
            try {
                System.out.println(e.getBankAccount().balance());
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }
        }
        shark.paySalaries(1);
        for (Employee e: sharkEmps) {
            try {
                e.getBankAccount().withdraw(500);
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                System.out.println(e.getBankAccount().balance());
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            };
        }
        System.out.println("--------------------------------");
        System.out.println("Company.user = User.COMPANY:");
        Company.user = User.COMPANY;
        for (Employee e: sharkEmps) {
            // "talking to strangers", but this is not a normal case
            try {
                System.out.println(e.getBankAccount().balance());
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }
        }
        shark.paySalaries(1);
        for (Employee e: sharkEmps) {
            try {
                e.getBankAccount().withdraw(500);
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                System.out.println(e.getBankAccount().balance());
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            };
        }

    }
}
