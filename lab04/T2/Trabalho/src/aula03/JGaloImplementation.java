package aula03;

public class JGaloImplementation implements JGaloInterface {
	private char actualPlayer;
	private char[][] Matriz;
	private char winner;

	public JGaloImplementation() {
		this('X');
	}
	public JGaloImplementation(char c) {
		actualPlayer=c;
		Matriz=new char[3][3];
		winner=' ';
	}
	public char getActualPlayer() {
		return actualPlayer;
	}
	public boolean setJogada(int lin, int col) {
		Matriz[lin-1][col-1]=actualPlayer;
		return true;
	}
	public boolean isFinished() {
		int n=0;
		//ver se estão todos preenchidos
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(Matriz[i][j]!='X' && Matriz[i][j]!='O') {
					n++;
				}
			}
		}
		String s="";
		for(int i=0;i<3;i++) {
			if(getHorizontal(i).equals("XXX")||getHorizontal(i).equals("OOO")) {
				winner=actualPlayer;
				return true;
			}
			if(getVertical(i).equals("XXX")||getVertical(i).equals("OOO")) {
				winner=actualPlayer;
				return true;
			}
		}
		if(getDiagonalED().equals("XXX")||getDiagonalED().equals("OOO")) {
			winner=actualPlayer;
			return true;
		}
		if(getDiagonalDE().equals("XXX")||getDiagonalDE().equals("OOO")) {
			winner=actualPlayer;
			return true;
		}
		if(n==0) {
			winner=' ';
			return true;
		}
		actualPlayer=nextPlayer();
		return false;
		
	}
	public char checkResult() {
		return winner;
	}
	public String getHorizontal(int i){
		StringBuilder sb= new StringBuilder();
		for(int j=0;j<3;j++) {
			sb.append(Matriz[i][j]);
		}
		return sb.toString();
	}
	public String getVertical(int j){
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<3;i++) {
			sb.append(Matriz[i][j]);
		}
		return sb.toString();
	}
	public String getDiagonalED(){
		StringBuilder sb= new StringBuilder();
		int j=0;
		for(int i=0;i<3;i++,j++) {
			sb.append(Matriz[i][j]);
		}
		return sb.toString();
	}
	public String getDiagonalDE(){
		StringBuilder sb= new StringBuilder();
		int i=2;
		for(int j=0;j<3;j++,i--) {
			sb.append(Matriz[i][j]);
		}
		return sb.toString();
	}
	public char nextPlayer() {
		if (actualPlayer=='X')
			return 'O';
		if (actualPlayer=='O')
			return 'X';		
		return ' ';
	}
}
