package lab9_2;

import java.util.ArrayList;

public class Client {
	
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		AddCommand comandoAdd = new AddCommand(lista);
		RemoveCommand comandoRemove = new RemoveCommand(lista);
		
		//add
		comandoAdd.execute(1);
		comandoAdd.execute(2);
		comandoAdd.execute(3);

		comandoAdd.undo();
		
		
		
		//remove
		comandoRemove.execute(1);
		comandoRemove.execute(2);
		
		comandoRemove.undo();
		

	}

}
