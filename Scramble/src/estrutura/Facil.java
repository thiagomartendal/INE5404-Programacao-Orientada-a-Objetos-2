package estrutura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import interfaces.IEstrategia;
import interfaces.ILetra;

public class Facil implements IEstrategia{
	private ArrayList<ILetra> letras;
	private AddLetra add;
	private Random gerador;
	private long tempo;
	
	public Facil(){
		this.letras = new ArrayList<ILetra>();
		this.add = new AddLetra();
		this.gerador = new Random();
		this.tempo = System.nanoTime();
	}
	
	@Override
	public ArrayList<ILetra> sorteio(){
		for(int i = 0;i < 26;i++){
			this.letras.add(add.getLetraMinusculas().get(i));
		}
		for(int i = 0;i < 13;i++){
			ILetra letra = add.getLetraMaiusculas().get(gerador.nextInt(add.getLetraMaiusculas().size()));
			if(!(this.letras.contains(letra))){
				this.letras.add(add.getLetraMaiusculas().get(gerador.nextInt(add.getLetraMaiusculas().size())));
			}
		}
		Collections.shuffle(this.letras, new Random(this.tempo));
		return letras;
	}
}
