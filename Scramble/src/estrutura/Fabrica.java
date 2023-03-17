package estrutura;

import java.util.HashMap;
import java.util.Map;
import interfaces.IEstrategia;

public class Fabrica{
	public enum TipoEstrategia{FACIL, DIFICIL}
	public Map<TipoEstrategia, IEstrategia> estrategias;
	
	public Fabrica(){
		this.estrategias = new HashMap<TipoEstrategia, IEstrategia>();
		this.estrategias.put(TipoEstrategia.FACIL, new Facil());
		this.estrategias.put(TipoEstrategia.DIFICIL, new Dificil());
	}
	
	public IEstrategia criaEstrategia(TipoEstrategia tipo){
		return this.estrategias.get(tipo);
	}
}

