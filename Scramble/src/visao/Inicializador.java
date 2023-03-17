package visao;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Inicializador{
	public static void main(String[] args){
		Janela janela = new Janela();
		
		janela.setTitle("Scramble");
		
		janela.setSize(800, 600);
		
		janela.setLocationRelativeTo(null);
		
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setIconImage(new ImageIcon("ico.png").getImage());
		
		janela.setVisible(true);
	}
}