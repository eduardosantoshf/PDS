package lab08_02;

import java.util.HashMap;
import java.util.Map;

public class Parking {
    static private int currID = 0;

    private Map<Integer, Employee> register =  new HashMap<>();

    public void regist(Employee e) { register.put(++currID, e); }

    public Map <Integer, Employee> getParkingRegisters() { return register; }

    public void allow(Employee e, Company c) {
        int sumSalaries = 0;

        for(Employee emp : c.employees())
            sumSalaries += emp.getSalary();

        int salaryAvg = sumSalaries/c.employees().size();

        if( e.getSalary() >= salaryAvg)
            regist(e);
    }
}
