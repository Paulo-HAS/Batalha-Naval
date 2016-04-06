package com.mygdx.game;

public class Barco {
	private int tamanho;//tamanho do navio
	private boolean estado;
	
					//"n" é proveniente do contador no laço de repetição do construtor do tabuleiro
					//a partir dele é possivel saber o tamanho que o navio deve ter
					//garantindo sempre o numero proposto de navios e no modo proposto
					
	Barco(int n){
		if(n == 1)					//para gerar 1 barco de 5
			tamanho = 5;
		else if(n == 2 || n == 3)	//para gerar dois barcos de 4
			tamanho = 4;
		else if(n > 3 && n < 7)		//para gerar 3 barcos de 3
			tamanho = 3;
		else if(n >= 7)				//para gerar 4 barcos de 2
			tamanho = 2;
		estado = true;
	}
	
	public void setEstado(boolean e){
		estado = e;
	}
	
	public boolean getEstado(){
		return estado;
	}
	
	public int getTamanho(){		//método para obter o tamanho do navio
		return tamanho;
	}
	
	
}
