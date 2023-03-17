package estrutura;

import interfaces.ILetra;

public class Letra implements ILetra{
	private Character letra;
	private int valorPonto;
	
	public Letra(char letra, int valor){
		this.letra = letra;
		this.valorPonto = valor;
	}
		
	public Character getCaracter(){
		return this.letra;
	}
		
	public int getValorPonto(){
		return this.valorPonto;
	}
}
