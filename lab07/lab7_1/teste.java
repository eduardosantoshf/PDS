package lab7_1;

import java.util.*;

public class teste {
    public static void main (String[]args) {
	EmployeeInterface e1 = new Employee ("123");
	TeamMember t1 = new TeamMember (new Employee ("124"));
	Manager m1 = new Manager (new TeamLeader (new Employee("125")));
	TeamLeader l1 = new TeamLeader (new Employee("126"));
	Map<EmployeeInterface, String[]> emp = new HashMap<>();
	emp.put(e1, new String[]{ "8-04-2019","9-04-2019" });
	emp.put(t1, new String[]{ "9-04-2019","11-04-2019" });
	emp.put(m1, new String[]{ "17-04-2019","20-04-2019" });
	emp.put(l1, new String[]{ "10-04-2019", "15-04-2019" });
	
	
	for (EmployeeInterface e : emp.keySet()) {
		String[] datas = emp.get(e);
		e.start(datas[0]);
		e.work();
		e.terminate(datas[1]);
	}
	
	
}
}
