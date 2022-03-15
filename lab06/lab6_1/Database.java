package lab6_1;

import java.util.Vector;

public class Database {
	
	private Vector<Employee> employees; // Stores the employees
	public Database() {
	employees = new Vector<>();
	}
	public boolean addEmployee(Employee employee) {
		// Code to add employee
		 if (employees.contains(employee)){
			 return false;
		 }
		 else {
			 employees.add(employee);
			 return true;
		 }
	}
	public void deleteEmployee(long emp_num) {
		// Code to delete employee
	      for (int i = 0 ; i < employees.size() ; i++) {
	    	  if (employees.get(i).getEmpNum()==emp_num) {
	    		  employees.remove(employees.get(i));
	    		  break;
	    	  }
	      }
	}
	public Employee[] getAllEmployees() {
		// Code to retrieve collection
		Employee [] emp = new Employee[employees.size()];
	      
	      for (int i = 0; i < emp.length; i++) {
			     emp[i] = employees.get(i);
		  }
	      return emp;
	}

}
