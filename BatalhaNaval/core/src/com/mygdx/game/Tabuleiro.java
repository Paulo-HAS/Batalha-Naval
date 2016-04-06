package com.mygdx.game;

public class Tabuleiro {
	private char[][] tab = new char[10][10];	//matriz do tabuleiro
	Barco[] embarcacao;							// embarcações 
	
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
	
	public void spawn(char[][] tab, int tamanhobarco){		//função que coloca o navio no mapa
		int i;
		int x,y;
		int verificaerro = 0;	//verifica se tem permissão de se colocar um navio no local proposto	
		int orientacao;			// 0 = horizontal/ 1 = vertical
		
		x = (int) (Math.random() % 10);			//gera as posições aleatoriamente
		y = (int) (Math.random() % 10);
		orientacao = (int) (Math.random() % 2);		//0 = horizontal/ 1 = vertical
		
		if(orientacao == 0){	// barco na horizontal
			for(i = 0; i < tamanhobarco && i >= 0;){						
				if(verificaerro == 0){
					if(tab[x][y] == '~' && tab[x-1][y] == '~' &&		//verifica a posiçãs e as outras
							tab[x+1][y] == '~'&& tab[x][y+1] == '~' &&	//posições próximas por
							tab[x][y-1] == '~'){						//obstruções
							
						tab[x][y] = 'B'; //"B" identifica posição ocupada por barco
						y++;			//aumenta y, pois é horizontal
						i++;			//contador corre normalmente
					}
					else{				//se houve obstrução
						tab[x][y] = '~';	//posição volta a ser neutra
						verificaerro = 1;		//a partir de então começa processo de deleção do barco
						i--;			//contador corre no sentido inverso
					}
				}
				else{
					tab[x][y] = '~';	// a partir do primeiro sinal de erro esse trecho deleta o barco
					y--;				//voltando posição na matriz...
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
						x++;			//aumenta y, pois é horizontal
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
			
			if( verificaerro == 1)					//se não foi possivel criar o barco
				this.spawn(tab, tamanhobarco);		//a operação é refeita com ele
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
