package lab9_2;

import java.util.Collection;

public interface Command {
	public <E> void execute(E elemento);
	public <E> void undo();
}
