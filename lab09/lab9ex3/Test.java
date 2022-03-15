package lab9;

import java.util.Scanner;

public class Test {
	
    public static void main(String[] args) {

	//Neste exercicio é simulado o funcionamento de uma caixa de multibanco que tenta devolver o minimo numero de notas. 


        Nota billChain = new Nota500().setSuccessor(
        		new Nota200().setSuccessor(
        				new Nota100().setSuccessor(
        						new Nota50().setSuccessor(
        								new Nota20().setSuccessor(
        										new Nota10())))));
       
        
			int amount = 0;
			System.out.println("Enter amount to withdraw");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if(amount%10 == 0)
				billChain.withdraw(amount);
			else {
				System.out.print("Error: it as to be divisible by 10 because 10 is the smaller bill!");
			}

		
        
    }
}
        
        
