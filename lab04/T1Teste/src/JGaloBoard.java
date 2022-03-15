
public class JGaloBoard implements JGaloInterface{
	
	private int turn;
	private boolean[][]board; //has it been tagged?
	private byte[]sums; //easy way to keep track of win status , 3 or -3 equals victory
	public char getActualPlayer() {
			if (turn==0) 
			{return 'X';}
			return 'O';
			}
	
	public boolean setJogada(int lin, int col) {
	if (!board[lin-1][col-1]) { //hasnt been tagged yet
	board[lin-1][col-1]=true; //it has now
	
	int sumchange = (turn==0)?1:-1; // if a sums value gets to 3 or -3 match is over
	turn = (turn+1)%2;
	sums[lin-1]+=sumchange; //0-2
	sums[col+2]+=sumchange; // 3-5
	if (lin==col) {sums[6]+=sumchange;} //diag left
	if (lin==3 && col==1 || lin==2 && col==2 || col==3 && lin==1) {sums[7]+=sumchange;}//diag right
	
	return true;
	}
	return false;
	}
	public boolean isFinished() {
		int sum=0;
	for (int i=0;i<3;i++) { //check 9 spots for if they are tagged
		for (int k=0;k<3;k++) {
		if (board[i][k]) {sum++;}	
		}
	}
	
	if (sum==9) {return true;}//no space left
	
	for(int i=0;i<8;i++){
		if (Math.abs(sums[i])==3) {return true;}//someone has won
	}
	
	return false;//default
	}
	public char checkResult() {
	for(int i=0;i<8;i++){
		if (sums[i]==3) {return 'X';}
		if (sums[i]==-3) {return 'O';}
	}
	return ' ';
	}
	
	
	JGaloBoard(){this.turn = 0;
	board = new boolean[3][3];sums= new byte[8];
	}
	
	JGaloBoard(int turn){this.turn = (turn==1)?1:0;
	board = new boolean[3][3];sums= new byte[8];
	}
	
	JGaloBoard(String turn){this.turn = (turn.equals("O")||turn.equals("1"))?1:0;
	board = new boolean[3][3];sums= new byte[8]; 
	}
}
