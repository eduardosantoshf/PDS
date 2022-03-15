package lab08_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    public static User user;
    private Insurance insurance =  new Insurance();
    private Parking parking = new Parking();
    private SocialSecurity socialSecurity = new SocialSecurity();

    private List<Employee> emps = new ArrayList<>();

    public void admitEmployee(Person p, double salary) {
        Employee e = new Employee(p, salary);
        emps.add(e);
        insurance.regist(e);
        socialSecurity.regist(e);
        parking.allow(e, this);
    }

    public void paySalaries(int month) {
        for (Employee e : emps)
            e.paySalary();
    }

    public List<Employee> employees() { return Collections.unmodifiableList(emps); }

}
