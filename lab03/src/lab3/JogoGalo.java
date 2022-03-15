package lab3;

public class JogoGalo implements JGaloInterface {
		private int jogadas;
		private char[][] tabuleiro = new char[3][3];
		private char jogador1;
		private char jogador2;
	    
	    public JogoGalo(){
	    	jogadas = 0;
	    	jogador1 = 'X';
	    	jogador2= 'O';
	        for(int i=0; i<3; i++){
	        	for(int n=0; n<3; n++) {
	        		tabuleiro[i][n]= '-';
	        	}
	        }
	    }
	    
	    public JogoGalo(char jogador1){
	    	this.jogadas = 0;
	    	if(jogador1== 'O') {
	    		this.jogador2 = 'X';
	    		this.jogador1 = 'O';
	    	}
	    	else {
	    		this.jogador2 = 'O';
	    		this.jogador1 = 'X';
	    	}
	        for(int i=0; i<3; i++){
	        	for(int n=0; n<3; n++) {
	        		tabuleiro[i][n]= '-';
	        	}
	        }
	    }
	    
	    

		@Override
		public char getActualPlayer() {
			// impares == jogador2 par == jogador1
			if(jogadas%2==0) {
				return jogador1;
			}
			else {
				return jogador2;
			}
		}

		@Override
		public boolean setJogada(int lin, int col) {
			if(tabuleiro[col-1][lin-1] == '-') {
				tabuleiro[col-1][lin-1] = getActualPlayer();
				jogadas++;
				return true;
			}
			else {
			return false;
			}
		}

		@Override
		public boolean isFinished() {
						//linhas
			        for(int linha=0 ; linha < 3 ; linha++){
			            if( tabuleiro[linha][0]=='X' && tabuleiro[linha][1]=='X' && tabuleiro[linha][2] == 'X')
			                return true;
			            if( tabuleiro[linha][0]=='O' && tabuleiro[linha][1]=='O' && tabuleiro[linha][2] == 'O')
			                return true;
			        }

			        	//colunas
			        for(int coluna=0 ; coluna<3 ; coluna++){
			            if( tabuleiro[0][coluna]=='X' && tabuleiro[1][coluna]== 'X' && tabuleiro[2][coluna] == 'X')
			                return true;
			            if( tabuleiro[0][coluna]=='O' && tabuleiro[1][coluna]== 'O' && tabuleiro[2][coluna] == 'O')
			                return true;
			        }
			        
			        	//diagonais
			        if( tabuleiro[0][0]== 'X' && tabuleiro[1][1]=='X' && tabuleiro[2][2] == 'X')
			            return true;
			        if( tabuleiro[0][0]== 'O' && tabuleiro[1][1]=='O' && tabuleiro[2][2] == 'O')
			            return true;
				    if( tabuleiro[0][2]== 'X' && tabuleiro[1][1]=='X' && tabuleiro[2][0] == 'X')
			            return true;
				    if( tabuleiro[0][2]== 'O' && tabuleiro[1][1]=='O' && tabuleiro[2][0] == 'O')
			            return true;
				    
				    	//termina o numero de jogadas
			        if(jogadas == 9) {
			        	return true;
			        }
			return false;
		}

		@Override
		public char checkResult() {
			// 'O' se O ganhou, 'X', se X ganhou, '-' se ninguém ganhou
			
			if(isFinished() && jogadas==9) {
				return ' ';
			} 
			else if(isFinished() && jogadas < 9 && getActualPlayer() == jogador2 ) {
				return jogador1;
			}
			else {
				return jogador2;
			}
		}
	

}
