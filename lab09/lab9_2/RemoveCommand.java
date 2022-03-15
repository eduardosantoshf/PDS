package lab9_2;

import java.util.Collection;
import java.util.Stack;

class RemoveCommand<E> implements Command {

	protected Collection<E> colecao;
	protected Stack stack = new Stack<>();
	
    RemoveCommand(Collection<E> colecao){
    	this.colecao= colecao;
    }
	@Override
	public <E> void execute(E elemento) {
		// TODO Auto-generated method stub
		if(colecao.remove(elemento)) {
			stack.add(elemento);
		} ;

		
	}

	@Override
	public <E> void undo() {
		// TODO Auto-generated method stub
		if(colecao.add((E) stack.peek())){
			stack.pop();
		}
	}

}
