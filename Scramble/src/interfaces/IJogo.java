package interfaces;

import java.util.List;

public interface IJogo{
	public enum Direcao {Horizontal, Vertical}
	public void adicionaPalavra(List<ILetra> letras, int linhaInicial, int colunaInicial, Direcao direcao);
	public boolean palavraCerta();
	public int linhaInicial();
	public int colunaInicial();
	public Direcao direcao();
	public int pontuacao();
	public void encerra();
	public boolean terminou();
}