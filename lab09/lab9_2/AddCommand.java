package lab9_2;

import java.util.Collection;
import java.util.Stack;

 class AddCommand<E> implements Command {
	 
	protected Collection<E> colecao;
	protected Stack stack = new Stack<>();
	
    AddCommand(Collection<E> colecao){
    	this.colecao= colecao;
    } 
	
	@Override
	public <E> void execute(E elemento) {
		// TODO Auto-generated method stub
		if(this.colecao.add((E) elemento)) {
			stack.add(elemento);
		} ;

		
	}

	@Override
	public <E> void undo() {
		// TODO Auto-generated method stub
		if(this.colecao.remove(stack.peek())){
			stack.pop();
		}
	}

}
