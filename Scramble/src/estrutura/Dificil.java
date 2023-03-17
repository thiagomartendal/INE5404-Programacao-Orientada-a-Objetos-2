package estrutura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import interfaces.IEstrategia;
import interfaces.ILetra;

public class Dificil implements IEstrategia{
	private ArrayList<ILetra> letras;
	private Random gerador;
	private AddLetra add;
	private long tempo;
	
	public Dificil(){
		this.letras = new ArrayList<ILetra>();
		this.gerador = new Random();
		this.add = new AddLetra();
		this.tempo = System.nanoTime();
	}
	
	@Override
	public ArrayList<ILetra> sorteio(){
		for(int i = 0;i < 10;i++){
			this.letras.add(add.getLetraMinusculas().get(gerador.nextInt(add.getLetraMinusculas().size())));
		}
		for(int i = 0;i < 10;i++){
			this.letras.add(add.getLetraMaiusculas().get(gerador.nextInt(add.getLetraMaiusculas().size())));
		}
		Collections.shuffle(this.letras, new Random(this.tempo));
		return this.letras;
	}
}
