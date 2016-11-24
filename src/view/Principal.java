package view;

import java.util.Scanner;

import modelo.EnumJogada;
import modelo.TicTacToe;

public class Principal {

	public static void main(String[] args) {
		
		TicTacToe velha = new TicTacToe();
		
		//Solicitar para o usuário uma linha e uma coluna.
		Scanner s = new Scanner(System.in);
		
		int linha = 0;
		int coluna = 0;
		Boolean fimDeJogo = false;
		
		while(!fimDeJogo)
		{
			System.out.println("***************");
			System.out.println("Jogador: " + velha.getProximoJogador());
			System.out.println("***************");
			
			System.out.print("Entre com a linha desejada: ");
			linha = s.nextInt() - 1;
			
			System.out.print("Entre com a coluna desejada: ");
			coluna = s.nextInt() - 1;
			
			if(!velha.registrarJogada(linha,coluna))
			{
				System.out.println("Jogada inválida. Tente novamente.");
			}
			
			if(velha.verificarGanhador() && !velha.getEmpate())
			{
				System.out.println(" ********* Você Venceu !! ***********");
				fimDeJogo = true;
			}else if(velha.verificarGanhador() && velha.getEmpate())
			{
				System.out.println(" ********* Deu velha ***********");
				fimDeJogo = true;
			}
			
			imprimirTabuleiro(velha.getTabuleiro());
		}

	}
	
	public static void imprimirTabuleiro(EnumJogada[][] tabuleiro)
	{
		System.out.println();
		
		for(int l = 0; l < 3; l++)
		{
			for(int c = 0; c< 3; c++)
			{
				if(tabuleiro[l][c] != EnumJogada.Empty)
					System.out.print(tabuleiro[l][c] + " | ");
				else
					System.out.print(" " + " | ");
			}
			
			System.out.println();
		}
	}

}
