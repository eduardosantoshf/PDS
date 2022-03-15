package lab6_1;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends Database {
	
	private Registos registo;
	
	public Adapter(Registos registo) {
		super();
		this.registo = registo;
	}
		
	
	public void addEmployee(Empregado empregado) {
		registo.insere(empregado);
	}
	
	public void removeEmployee(int codigo) {
		registo.remove(codigo);
	}
	
	public void isEmployee(int codigo) {
		registo.isEmpregado(codigo);
	}
	
	public void printEmployees(int codigo) {	
		List <Empregado> e = new ArrayList <>();
    	e = registo.listaDeEmpregados();
    	
    	System.out.println("Lista de todos os empregados:");
        for (int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i).toString());
		}
	}

	
}
