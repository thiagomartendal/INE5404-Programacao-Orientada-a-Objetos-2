package estrutura;

import java.util.List;
//import enums.Direcao;
import interfaces.IJogo;
import interfaces.ILetra;

public class Jogo implements IJogo{
	private List<ILetra> letras;
	private static Jogo jogo;
	private Dicionario dicionario;
	private int pontos;
	private int linhaInicial;
	private int colunaInicial;
	private boolean palavraCerta;
	private boolean termina;
	private Direcao direcao;
	
	private Jogo(){
		this.pontos = 0;
	}
	
	public static Jogo getInstance(){
		if(jogo == null){
			jogo = new Jogo();
		}
		return jogo;
	}

	@Override
	public void adicionaPalavra(List<ILetra> letras, int linhaInicial, int colunaInicial, Direcao direcao){
		this.letras = letras;
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.direcao = direcao;
		this.dicionario = new Dicionario();
		verificarPalavra(formarPalavra());
	}
	
	private void verificarPalavra(String palavra){
		if(this.dicionario.getDicionario().contains(palavra)){
			this.palavraCerta = true;
		}else{
			this.palavraCerta = false;
		}
	}

	private String formarPalavra(){
		String palavra = "";
		for(int i = 0;i < this.letras.size();i++){
			palavra = palavra+this.letras.get(i).getCaracter().toString();
		}
		return palavra;
	}
	
	@Override
	public boolean palavraCerta(){
		return this.palavraCerta;
	}
	
	@Override
	public int linhaInicial(){
		return this.linhaInicial;
	}
	
	@Override
	public int colunaInicial(){
		return this.colunaInicial;
	}
	
	@Override
	public Direcao direcao(){
		return this.direcao;
	}
	
	@Override
	public int pontuacao(){
		for(int i = 0;i < this.letras.size();i++){
			somarPontos(i);
		}
		return this.pontos;
	}

	private void somarPontos(int i){
		switch(direcao){
			case Horizontal:
				this.pontos = (this.letras.get(i).getValorPonto()+(linhaInicial+colunaInicial)+10)+this.pontos;
			break;
			case Vertical:
				this.pontos = (this.letras.get(i).getValorPonto()+(linhaInicial+colunaInicial)+20)+this.pontos;
			break;
			default:
				this.pontos = (this.letras.get(i).getValorPonto()+(linhaInicial+colunaInicial))+this.pontos;
		}
	}
	
	@Override
	public void encerra(){
		
	}

	@Override
	public boolean terminou(){
		return this.termina;
	}
}