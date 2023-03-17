package estrutura;

import java.util.ArrayList;
import estrutura.Fabrica.TipoEstrategia;
import interfaces.ILetra;

public class Escolher{
	private Fabrica fabrica;
	private ArrayList<ILetra> letras;
	private TipoEstrategia dificuldade;
	
	public Escolher(TipoEstrategia dificuldade){
		this.dificuldade = dificuldade;
		this.letras = new ArrayList<ILetra>();
		this.fabrica = new Fabrica();
		selecionarDificuldade();
	}

	private void selecionarDificuldade(){
		if(this.dificuldade == TipoEstrategia.FACIL){
			this.letras = this.fabrica.criaEstrategia(TipoEstrategia.FACIL).sorteio();
		}else if(this.dificuldade == TipoEstrategia.DIFICIL){
			this.letras = this.fabrica.criaEstrategia(TipoEstrategia.DIFICIL).sorteio();
		}else{
			this.letras = null;
		}
	}
	
	public ArrayList<ILetra> getLetras(){
		return this.letras;
	}
}