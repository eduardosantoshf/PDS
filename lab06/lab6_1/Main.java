package lab6_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main (String[] args) {
		
    	//*******************TESTE EMPLOYEE E DATABASE ***************
		
    	Employee employee1 = new Employee("Marta Ferreira",88830,2000); 
    	Employee employee2 = new Employee("Eduardo Santos",92635,1000);
    	Employee employee3 = new Employee("Carmen Dias",12345,500);
    	
    	
    	Database database = new Database();
    	
    	database.addEmployee(employee1);
    	database.addEmployee(employee2);
    	database.addEmployee(new Employee("Quim Barreiros",00000,5000)); 	
    	database.deleteEmployee(00000);
    	
    	
        Employee [] emp = database.getAllEmployees();
        System.out.println("List of all employees: ");
        for (int i = 0; i < emp.length; i++) {
			System.out.println(emp[i].toString());
		}
        
        
		//*********************TESTE EMPREGADO E REGISTOS***************
    	Empregado empregado1 = new Empregado("Lucas","Machado",22222,1000);
    	Empregado empregado2 = new Empregado("Rita","Alcantara",33333,750);
    	Empregado empregado3 = new Empregado("João","Silva",44444,1000);
    	
    	
    	
    	Registos reg = new Registos();
    	
    	reg.insere(empregado1);
    	reg.insere(empregado2);
    	reg.insere(new Empregado("Julio","Borges",55555,1500));

    	
    	reg.remove(22222);
    	reg.isEmpregado(33333);
    	reg.isEmpregado(33334);
    	
    	
    	List <Empregado> e = new ArrayList <>();
    	e = reg.listaDeEmpregados();
    	
    	System.out.println("Lista de todos os empregados:");
        for (int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i).toString());
		}

    	
    	 	
    	
    }

}
