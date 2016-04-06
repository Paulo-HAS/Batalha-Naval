package com.mygdx.game;

public class Tabuleiro {
	private char[][] tab = new char[10][10];	//matriz do tabuleiro
	Barco[] embarcacao;							// embarca��es 
	
	Tabuleiro(){
		int i,j;	//contadores
		
		for(i=0;i<9;i++)
			for(j=0;j<9;j++)
				tab[i][j]='~';	//cria um tabuleiro neutro
		
		for(i = 1; i <= 10; i++){
			embarcacao[i] = new Barco(i);					//cria um barco
			this.spawn(tab, embarcacao[i].getTamanho());
		}
	}
	
	public void spawn(char[][] tab, int tamanhobarco){		//fun��o que coloca o navio no mapa
		int i;
		int x,y;
		int verificaerro = 0;	//verifica se tem permiss�o de se colocar um navio no local proposto	
		int orientacao;			// 0 = horizontal/ 1 = vertical
		
		x = (int) (Math.random() % 10);			//gera as posi��es aleatoriamente
		y = (int) (Math.random() % 10);
		orientacao = (int) (Math.random() % 2);		//0 = horizontal/ 1 = vertical
		
		if(orientacao == 0){	// barco na horizontal
			for(i = 0; i < tamanhobarco && i >= 0;){						
				if(verificaerro == 0){
					if(tab[x][y] == '~' && tab[x-1][y] == '~' &&		//verifica a posi��s e as outras
							tab[x+1][y] == '~'&& tab[x][y+1] == '~' &&	//posi��es pr�ximas por
							tab[x][y-1] == '~'){						//obstru��es
							
						tab[x][y] = 'B'; //"B" identifica posi��o ocupada por barco
						y++;			//aumenta y, pois � horizontal
						i++;			//contador corre normalmente
					}
					else{				//se houve obstru��o
						tab[x][y] = '~';	//posi��o volta a ser neutra
						verificaerro = 1;		//a partir de ent�o come�a processo de dele��o do barco
						i--;			//contador corre no sentido inverso
					}
				}
				else{
					tab[x][y] = '~';	// a partir do primeiro sinal de erro esse trecho deleta o barco
					y--;				//voltando posi��o na matriz...
					i--;				//voltando o contador...
				}
			}
		}
			
			
		if(orientacao == 1){	//barco com 
			for(i = 0; i < tamanhobarco && i >= 0;){	//se i<0 significa que o barco foi deletado
				if(verificaerro == 0){
					if(tab[x][y] == '~' && tab[x-1][y] == '~' &&
							tab[x+1][y] == '~'&& tab[x][y+1] == '~' &&
							tab[x][y-1] == '~'){
								
						tab[x][y] = 'B';
						x++;			//aumenta y, pois � horizontal
						i++;			//contador corre normalmente
					}
					else{				
						tab[x][y] = '~';
						verificaerro = 1;
						i--;			//contador corre no sentido inverso
					}
				}
				else{
					tab[x][y] = '~';
					x--;
					i--;
				}
			}
			
			if( verificaerro == 1)					//se n�o foi possivel criar o barco
				this.spawn(tab, tamanhobarco);		//a opera��o � refeita com ele
		}
	}
	
	public void disparo(int x, int y){
		if(tab[x][y] == '~')
			tab[x][y] = 'M';
		if(tab[x][y] == 'B'){
			tab[x][y] = 'H';
			if((tab[x-1][y] =='H' || tab[x-1][y] =='~') 
					&& (tab[x+1][y] =='H' || tab[x+1][y] =='~')
					&& (tab[x][y-1] =='H' || tab[x][y-1] =='~')
					&& (tab[x][y+1] =='H' || tab[x][y+1] =='~')
					
		}
	}

}
