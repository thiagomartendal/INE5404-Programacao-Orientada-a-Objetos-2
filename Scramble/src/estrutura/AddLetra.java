package estrutura;

import java.util.ArrayList;
import interfaces.ILetra;

public class AddLetra{
	private ILetra letra;
	private ArrayList<ILetra> letrasMinusculas;
	private ArrayList<ILetra> letrasMaiusculas;
	
	public AddLetra(){
		this.letrasMinusculas = new ArrayList<ILetra>();
		this.letrasMaiusculas = new ArrayList<ILetra>();
		//--
		this.letra = new Letra('a', 5);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('b', 4);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('c', 9);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('d', 10);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('e', 5);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('f', 4);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('g', 15);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('h', 3);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('i', 5);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('j', 4);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('k', 10);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('l', 20);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('m', 18);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('n', 1);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('o', 5);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('p', 4);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('q', 11);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('r', 2);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('s', 7);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('t', 20);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('u', 5);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('v', 4);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('w', 10);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('x', 35);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('y', 6);
		this.letrasMinusculas.add(this.letra);
		this.letra = new Letra('z', 45);
		this.letrasMinusculas.add(this.letra);
		//--
		this.letra = new Letra('A', 10);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('B', 9);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('C', 3);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('D', 11);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('E', 10);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('F', 9);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('G', 25);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('H', 13);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('I', 10);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('J', 9);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('K', 11);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('L', 2);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('M', 8);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('N', 5);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('O', 10);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('P', 9);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('Q', 11);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('R', 20);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('S', 17);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('T', 25);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('U', 10);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('V', 9);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('W', 20);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('X', 45);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('Y', 15);
		this.letrasMaiusculas.add(this.letra);
		this.letra = new Letra('Z', 55);
		this.letrasMaiusculas.add(this.letra);
	}
	
	public boolean verificaLetraMinuscula(char[] letra){
		boolean verificar = false;
		for(int i = 0;i < this.letrasMinusculas.size();i++){
			for(int j = 0;j < letra.length;j++){
				if(letra[j] == this.letrasMinusculas.get(i).getCaracter()){
					verificar = true;
				}
			}
		}
		return verificar;
	}

	public boolean verificaLetraMaiuscula(char[] letra){
		boolean verificar = false;
		for(int i = 0;i < this.letrasMaiusculas.size();i++){
			for(int d = 0;d < letra.length;d++){
				if(letra[d] == this.letrasMaiusculas.get(i).getCaracter()){
					verificar = true;
				}
			}
		}
		return verificar;
	}
	
	public int procurarPontoMinusucla(Character letra){
		int ponto = 0;
		for(int i = 0;i < this.letrasMinusculas.size();i++){
			if(letra == this.letrasMinusculas.get(i).getCaracter()){
				ponto = this.letrasMinusculas.get(i).getValorPonto();
			}
		}
		return ponto;
	}

	public int procurarPontoMaiuscula(Character letra){
		int ponto = 0;
		for(int i = 0;i < this.letrasMaiusculas.size();i++){
			if(letra == this.letrasMaiusculas.get(i).getCaracter()){
				ponto = this.letrasMaiusculas.get(i).getValorPonto();
			}
		}
		return ponto;
	}
	
	public ArrayList<ILetra> getLetraMinusculas(){
		return this.letrasMinusculas;
	}
	
	public ArrayList<ILetra> getLetraMaiusculas(){
		return this.letrasMaiusculas;
	}
}