package lab08_02;

public class Employee {
    private double salary;
    private Person person;

    public Employee(Person p, double s) {
        person = p;
        salary = s;
    }

    public double getSalary() { return salary; }

    public void paySalary() { person.getBankAccount().deposit(salary); }

    public String getPersonName() { return person.getName(); }

    public String toString() { return "{" + person.getName() + " | " + salary + "}"; }

}
