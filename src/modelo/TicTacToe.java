package modelo;

public class TicTacToe {
	
	private int contadorDeJogadas = 0;
	private Boolean empate = false;
	
	private EnumJogada proximoJogador;
	
	private EnumJogada[][] tabuleiro;
	
	public TicTacToe()
	{
		resetTabuleiro();
	}

	public EnumJogada getProximoJogador()
	{
		return proximoJogador;
	}
	
	public EnumJogada[][] getTabuleiro()
	{
		return tabuleiro;
	}
	
	public Boolean getEmpate()
	{
		return empate;
	}
	private void resetTabuleiro()
	{
		//Toda vez que reiniciar meu jogo, inicio como o X
		proximoJogador = EnumJogada.X;
		contadorDeJogadas = 0;
		
		tabuleiro = new EnumJogada[3][3];
		
		for(int i = 0; i < 3; i++)
		{
			for(int c = 0; c < 3; c++)
			{
				tabuleiro[i][c] = EnumJogada.Empty;
			}
		}
	}
	public Boolean registrarJogada(int linha, int coluna)
	{
		if(!verficarJogada(linha, coluna))
		{
			return false;
		}
		
		if(proximoJogador == EnumJogada.X)
			jogadaX(linha,coluna);
		else
			jogadaO(linha,coluna);
		
		definirProximoJogador();
		
		contadorDeJogadas++;
		
		
		return true;
	}
	
	private void definirProximoJogador()
	{
		if(proximoJogador == EnumJogada.X)
			proximoJogador = EnumJogada.O;
		else
			proximoJogador = EnumJogada.X;
	}
	
	private Boolean verficarJogada(int linha, int coluna)
	{
		if(tabuleiro[linha][coluna] == EnumJogada.Empty)
			return true;
		
		return false;
	}
	private void jogadaX(int linha, int coluna)
	{
		tabuleiro[linha][coluna] = EnumJogada.X;
	}
	private void jogadaO(int linha, int coluna)
	{
		tabuleiro[linha][coluna] = EnumJogada.O;
	}
	
	public Boolean verificarGanhador()
	{
		//Verificar se houve ganhador na mesma LINHA.
		if(verificarGanhadorNaLinha())
			return true;
		
		if(verificarGanhadorNaColuna())
			return true;
		
		if(verificarGanhadorNaDiagonal())
			return true;
		
		if(this.contadorDeJogadas >= 9)
		{
			this.empate = true;
			return true;
		}
		
		return false;
	}
	private Boolean verificarGanhadorNaDiagonal()
	{
		if(tabuleiro[0][0] != EnumJogada.Empty ||
		   tabuleiro[1][1] != EnumJogada.Empty ||
		   tabuleiro[2][2] != EnumJogada.Empty
		  )
		{
			return (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]);
		}
		if(tabuleiro[0][2] != EnumJogada.Empty ||
				   tabuleiro[1][1] != EnumJogada.Empty ||
				   tabuleiro[2][0] != EnumJogada.Empty
				  )
				{
					return 		(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]);
				}


		return false;
		
	}
	private Boolean verificarGanhadorNaColuna()
	{
		Boolean retorno = false;
		for(int c = 0; c < 3; c++)
		{
			if( (tabuleiro[0][c] != EnumJogada.Empty ||
				 tabuleiro[1][c] != EnumJogada.Empty ||
			     tabuleiro[2][c] != EnumJogada.Empty) && 
			   tabuleiro[0][c] == tabuleiro[1][c] && tabuleiro[1][c] == tabuleiro[2][c])
			{
				retorno = true;
				break;
			}
		}
		return retorno;
	}	
	private Boolean verificarGanhadorNaLinha()
	{
		Boolean retorno = false;
		for(int l = 0; l < 3; l++)
		{
			if( (tabuleiro[l][0] != EnumJogada.Empty ||
				 tabuleiro[l][1] != EnumJogada.Empty ||
				 tabuleiro[l][2] != EnumJogada.Empty) && 
				tabuleiro[l][0] == tabuleiro[l][1] && tabuleiro[l][1] == tabuleiro[l][2])
			{
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	
}
