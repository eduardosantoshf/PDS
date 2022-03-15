package lab6_1;

import java.util.ArrayList;
import java.util.List;

public class Registos {
	
	private ArrayList<Empregado> empregados; // Stores the employees
	public Registos() {
	empregados = new ArrayList<>();
	}
	public void insere(Empregado emp) {
		if (!empregados.contains(emp)){
			empregados.add(emp);
		 }
		 else {
			System.out.println("Já existe este empregado!");
		 }
	}
	public void remove(int codigo) {
		// Code to remove employee
		for (int i = 0 ; i < empregados.size() ; i++) {
	    	  if (empregados.get(i).codigo()==codigo) {
	    		  empregados.remove(empregados.get(i));
	    		  break;
	    	  }
	      }
	}
	public boolean isEmpregado(int codigo) {
	// Code to find employee
		for (int i = 0 ; i < empregados.size() ; i++) {
	    	  if (empregados.get(i).codigo()==codigo) {
	    		  return true;
	    	  }
	      }
		return false;
	}
	public List<Empregado> listaDeEmpregados() {
	// Code to retrieve collection
		List<Empregado> emp = new ArrayList<>();
		 for (int i = 0; i < empregados.size(); i++) {
		     emp.add(empregados.get(i));
	  }
      return emp;
		
	}

}
