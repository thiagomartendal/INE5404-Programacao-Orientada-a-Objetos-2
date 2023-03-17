package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import estrutura.Escolher;
import estrutura.AddLetra;
import estrutura.Fabrica.TipoEstrategia;
import estrutura.Jogo;
import estrutura.Letra;
import interfaces.IJogo.Direcao;
import interfaces.ILetra;

public class JogoFacil implements ActionListener{
	private Jogo jogo;
	private JPanel painel;
	private JButton botao;
	private Escolher escolher;
	private JTextField entrada;
	private JTextField linha;
	private JTextField coluna;
	private JLabel pontuacao;
	private JComboBox<Direcao> direcao;
	
	public JogoFacil(JPanel painel){
		this.jogo = Jogo.getInstance();
		this.painel = painel;
		this.painel.setLayout(new BorderLayout());
		this.escolher = new Escolher(TipoEstrategia.FACIL);
		this.entrada = new JTextField(30);
		this.linha = new JTextField(2);
		this.coluna = new JTextField(2);
		this.pontuacao = new JLabel();
		this.direcao = new JComboBox<Direcao>();
		this.linha.setDocument(new Caractere(2));
		this.coluna.setDocument(new Caractere(2));
	}
	
	private String letras(){
		String letras = "";
		for(int i = 0;i < this.escolher.getLetras().size();i++){
			letras = this.escolher.getLetras().get(i).getCaracter().toString()+" "+letras;
		}
		return letras;
	}
	
	private void menu(){
		JPanel painel = new JPanel();
		JLabel etiqueta = new JLabel("Letras: "+letras());
		JLabel etiqueta2 = new JLabel("Palavra: ");
		JLabel etiqueta3 = new JLabel("Linha: ");
		JLabel etiqueta4 = new JLabel("Coluna: ");
		this.direcao.addItem(Direcao.Horizontal);
		this.direcao.addItem(Direcao.Vertical);
		this.direcao.setBackground(Color.ORANGE);
		this.direcao.setForeground(Color.BLACK);
		etiqueta.setForeground(Color.BLACK);
		etiqueta2.setForeground(Color.BLACK);
		etiqueta3.setForeground(Color.BLACK);
		etiqueta4.setForeground(Color.BLACK);
		this.botao = new JButton("Verificar Palavra");
		this.botao.setBackground(Color.ORANGE);
		painel.add(etiqueta3);
		painel.add(this.linha);
		painel.add(etiqueta4);
		painel.add(this.coluna);
		painel.add(etiqueta2);
		painel.add(this.entrada);
		painel.add(this.direcao);
		painel.add(this.botao);
		painel.add(etiqueta);
		painel.setBackground(Color.CYAN);
		this.painel.add(painel, BorderLayout.PAGE_START);
	}
	
	private void campo(){
		JPanel campo = new JPanel();
		JPanel painel = new JPanel();
		JPanel painel2 = new JPanel();
		JPanel painel3 = new JPanel();
		campo.setLayout(new BorderLayout());
		painel.setLayout(new GridLayout(15, 15));
		painel2.setLayout(new GridLayout(0, 15));
		painel3.setLayout(new GridLayout(15, 0));
		final JTextField[][] quadrados = new JTextField[15][15];
		reguas(painel2, painel3);
		quadros(painel, quadrados);
		painel.setBackground(Color.CYAN);
		painel2.setBackground(Color.CYAN);
		painel3.setBackground(Color.CYAN);
		campo.add(painel2, BorderLayout.PAGE_START);
		campo.add(painel3, BorderLayout.WEST);
		campo.add(painel, BorderLayout.CENTER);
		this.painel.add(campo, BorderLayout.CENTER);
	}

	private void reguas(JPanel painel2, JPanel painel3){
		for(int i = 0;i < 15;i++){
			painel2.add(new JLabel(String.valueOf(i)));
			painel3.add(new JLabel(String.valueOf(i)));
		}
	}

	private void quadros(JPanel painel, final JTextField[][] quadrados){
		for(int i = 0;i < quadrados.length;i++){
			for(int j = 0;j < quadrados[i].length;j++){
				final JTextField txt = new JTextField();
				txt.setHorizontalAlignment(JTextField.CENTER);
				txt.setDocument(new Caractere(1));
				txt.setEditable(false);
				txt.setForeground(Color.WHITE);
				quadrados[i][j] = txt;
				painel.add(quadrados[i][j]);
			}
		}
		evento(quadrados);
	}

	private void evento(final JTextField[][] quadrados){
		ActionListener acao = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					clique(quadrados);
				}catch(NumberFormatException excecao){
					
				}
			}

			private void clique(final JTextField[][] quadrados){
				AddLetra add = new AddLetra();
				List<ILetra> letras = new ArrayList<ILetra>();
				String palavra = JogoFacil.this.entrada.getText().trim();
				char[] letra = palavra.toCharArray();
				adicionarLetra(add, letras, letra);
				Direcao direcao = (Direcao) JogoFacil.this.direcao.getSelectedItem();
				int linha = Integer.parseInt(JogoFacil.this.linha.getText());
				int coluna = Integer.parseInt(JogoFacil.this.coluna.getText());
				JogoFacil.this.jogo.adicionaPalavra(letras, linha, coluna, direcao);
				compararLetrasEscolhidas(quadrados, letras, letra);
			}

			private void compararLetrasEscolhidas(final JTextField[][] quadrados, List<ILetra> letras, char[] letra){
				boolean c = false;
				c = analizar(letras, c);
				if(c){
					comparar(quadrados, letra);
				}else{
					JOptionPane.showMessageDialog(null, "Uma letra não existe nas letras escolhidas.");
				}
			}

			private boolean analizar(List<ILetra> letras, boolean c){
				for(int i = 0;i < letras.size();i++){
					ILetra letraEscolhidaPeloUsuario = letras.get(i);	
					for(int j = 0;j < JogoFacil.this.escolher.getLetras().size();j++){
						ILetra letraDisponivel = JogoFacil.this.escolher.getLetras().get(j);
						if(letraDisponivel.getCaracter().equals(letraEscolhidaPeloUsuario.getCaracter())){
							c = true;
							j = JogoFacil.this.escolher.getLetras().size();
						}
					}
					if(c == false){
						i = letras.size();
					}
				}
				return c;
			}
			
			private void comparar(final JTextField[][] quadrados, char[] letra){
				if(JogoFacil.this.jogo.palavraCerta()){
					campo(quadrados, letra, JogoFacil.this.jogo.direcao(), JogoFacil.this.jogo.linhaInicial(), JogoFacil.this.jogo.colunaInicial());
					JogoFacil.this.pontuacao.setText("Pontos: "+String.valueOf(JogoFacil.this.jogo.pontuacao()));
				}
			}

			private void campo(final JTextField[][] quadrados, char[] letra, Direcao direcao, int linha, int coluna){
				for(int i = 0;i < quadrados.length;i++){
					for(int j = 0;j < quadrados[i].length;j++){
						compararQuadros(quadrados, letra, direcao, linha, coluna, i, j);
					}
				}
			}

			private void compararQuadros(final JTextField[][] quadrados, char[] letra, Direcao direcao, int linha, int coluna, int i, int j){
				if(i == linha && j == coluna){
					if(direcao == Direcao.Horizontal){
						exibirLetrasHorizontal(quadrados, i, j, letra);
					}else if(direcao == Direcao.Vertical){
						exibirLetrasVertical(quadrados, i, j, letra);
					}
				}
			}

			private void adicionarLetra(AddLetra add, List<ILetra> letras, char[] letra){
				criarLetraMaiuscula(add, letras, letra);
				criarLetraMinuscula(add, letras, letra);
			}

			private void criarLetraMinuscula(AddLetra add, List<ILetra> letras, char[] letra){
				for(int d = 0;d < letra.length;d++){
					procurarLetraMinuscula(add, letras, letra, d);
				}
			}

			private void procurarLetraMinuscula(AddLetra add, List<ILetra> letras, char[] letra, int d){
				if(add.verificaLetraMinuscula(letra)){
					if(add.procurarPontoMinusucla(letra[d]) != 0){
						ILetra l = new Letra(letra[d], add.procurarPontoMinusucla(letra[d]));
						letras.add(l);
					}
				}
			}

			private void criarLetraMaiuscula(AddLetra add, List<ILetra> letras, char[] letra){
				for(int d = 0;d < letra.length;d++){
					procurarLetraMaiuscula(add, letras, letra, d);
				}
			}

			private void procurarLetraMaiuscula(AddLetra add, List<ILetra> letras, char[] letra, int d){
				if(add.verificaLetraMaiuscula(letra)){
					if(add.procurarPontoMaiuscula(letra[d]) != 0){
						ILetra l = new Letra(letra[d], add.procurarPontoMaiuscula(letra[d]));
						letras.add(l);
					}
				}
			}

			private void exibirLetrasHorizontal(final JTextField[][] quadrados, final int i, final int j, char[] letras){
				for(int k = 0;k < letras.length;k++){
					verificarEspacoHorizontal(quadrados, i, j, letras, k);
				}
			}

			private void verificarEspacoHorizontal(final JTextField[][] quadrados, final int i, final int j, char[] letras, int k){
				if(j+k > 14){
					JOptionPane.showMessageDialog(null, "O número de colunas atigiu o limite, selecione outra coluna.");
					limparHorizontal(quadrados, i);
				}else{
					quadrados[i][j+k].setText(String.valueOf(letras[k]));
					corHorizontal(quadrados, i, j, k);
					JogoFacil.this.entrada.setText("");
					JogoFacil.this.linha.setText("");
					JogoFacil.this.coluna.setText("");
				}
			}

			private void corHorizontal(final JTextField[][] quadrados, final int i, final int j, int k){
				Color[] cor = {Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.PINK, Color.RED, Color.YELLOW};
				Random gerador = new Random();
				int numero = gerador.nextInt(8);
				quadrados[i][j].setBackground(cor[numero]);
				for(int l = 0;l < j+k;l++){
					if(l >= j){
						quadrados[i][l].setBackground(quadrados[i][j].getBackground());
					}
				}
				quadrados[i][j+k].setBackground(quadrados[i][j].getBackground());
			}

			private void limparHorizontal(final JTextField[][] quadrados, final int i){
				for(int l = 0;l < quadrados.length;l++){
					for(int n = 0;n < quadrados[l].length;n++){
						quadrados[i][n].setText("");
						quadrados[i][n].setBackground(Color.WHITE);
					}
				}
			}
			
			private void exibirLetrasVertical(final JTextField[][] quadrados, final int i, final int j, char[] letras){
				for(int k = 0;k < letras.length;k++){
					verificarEspacoVertical(quadrados, i, j, letras, k);
				}
			}
			
			private void verificarEspacoVertical(final JTextField[][] quadrados, final int i, final int j, char[] letras, int k){
				if(i+k > 14){
					JOptionPane.showMessageDialog(null, "O número de linhas atigiu o limite, selecione outra linha.");
					limparVertical(quadrados, j);
				}else{
					quadrados[i+k][j].setText(String.valueOf(letras[k]));
					corVertical(quadrados, i, j, k);
					JogoFacil.this.entrada.setText("");
					JogoFacil.this.linha.setText("");
					JogoFacil.this.coluna.setText("");
				}
			}
			
			private void corVertical(final JTextField[][] quadrados, final int i, final int j, int k){
				Color[] cor = {Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.PINK, Color.RED, Color.YELLOW};
				Random gerador = new Random();
				int numero = gerador.nextInt(8);
				quadrados[i][j].setBackground(cor[numero]);
				for(int l = 0;l < i+k;l++){
					if(l >= i){
						quadrados[l][j].setBackground(quadrados[i][j].getBackground());
					}
				}
				quadrados[i+k][j].setBackground(quadrados[i][j].getBackground());
			}
			
			private void limparVertical(final JTextField[][] quadrados, final int j){
				for(int l = 0;l < quadrados.length;l++){
					for(int n = 0;n < quadrados[l].length;n++){
						quadrados[n][j].setText("");
						quadrados[n][j].setBackground(Color.WHITE);
					}
				}
			}
		};
		this.botao.addActionListener(acao);
	}
	
	private JPanel pontos(){
		JPanel painel = new JPanel();
		this.pontuacao.setForeground(Color.WHITE);
		painel.add(this.pontuacao, BorderLayout.CENTER);
		painel.setBackground(Color.BLUE);
		return painel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		menu();
		campo();
		this.painel.add(pontos(), BorderLayout.PAGE_END);
		this.painel.revalidate();
	}
}