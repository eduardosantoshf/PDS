package lab08_02;

import java.util.HashMap;
import java.util.Map;

public class Insurance {
    static private int currID = 0;
    private Map<Integer, Employee> register =  new HashMap<>();

    public void regist(Employee e) { register.put(++currID, e); }

    public Map<Integer, Employee> getInsuranceCompanyRegisters() { return register; }
}
