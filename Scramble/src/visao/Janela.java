package visao;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel campo;
	
	public Janela(){
		componentes();
		pack();
	}
	
	private void componentes(){
		BorderLayout layout = new BorderLayout(); 
		this.setLayout(layout);
		this.campo = new JPanel();
		this.add(menu(), BorderLayout.PAGE_START);
		JScrollPane scroll = new JScrollPane(campo());
		scroll.setHorizontalScrollBar(null);
		this.add(scroll, BorderLayout.CENTER);
	}
	
	private JPanel menu(){
		JPanel painel = new JPanel();
		botoes(painel);
		estiloPaineis(painel);
		return painel;
	}

	private void estiloPaineis(JPanel painel){
		painel.setBackground(Color.BLUE);
		this.campo.setBackground(Color.CYAN);
	}

	private void botoes(JPanel painel){
		JButton botao1 = new JButton("Jogo Fácil");
		JButton botao2 = new JButton("Jogo Difícil");
		estiloBotoes(botao1, botao2);
		eventos(botao1, botao2);
		painel.add(botao1);
		painel.add(botao2);
	}

	private void estiloBotoes(JButton botao1, JButton botao2){
		botao1.setBackground(Color.ORANGE);
		botao2.setBackground(Color.ORANGE);
	}
	
	private void eventos(JButton botao1, JButton botao2){
		botao1.addActionListener(new JogoFacil(campo()));
	}
	
	private JPanel campo(){
		return this.campo;
	}
}