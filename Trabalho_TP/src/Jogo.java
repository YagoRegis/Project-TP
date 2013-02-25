import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
public class Jogo extends JFrame implements ActionListener{

	private int b[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private String player1, player2;
	private int vez = 1;
	private int vit1, vit2;
	private Icon circulo;
	private Icon x;
	private Icon circulo2;
	private Icon x2;
	private JMenuItem menuItemCreditos;
	private JMenuItem menuItemNovo;
	private JMenuItem menuItemRecomecar;
	private JMenuItem menuItemContinuar;
	private JMenuItem menuItemSalvar;
	private JMenuItem menuItemSair;
	private JButton button11;
	private JButton button12;
	private JButton button13;
	private JButton button21;
	private JButton button22;
	private JButton button23;
	private JButton button31;
	private JButton button32;
	private JButton button33;
	private JLabel labelPlacar;
	private JLabel labelVez;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private DadosArquivo dados;
	private boolean win;

	public Jogo() throws FileNotFoundException, IOException{
		
		super("Jogo da Velha");
		setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuJogo = new JMenu("Jogo");
		JSeparator separator = new JSeparator();
		menuItemNovo = new JMenuItem("Novo Jogo");
		menuItemRecomecar = new JMenuItem("Recomeçar Partida");
		menuItemSalvar = new JMenuItem("Salvar Jogo");
		menuItemContinuar = new JMenuItem("Continuar Jogo");
		menuItemSair = new JMenuItem("Sair");
		menuJogo.add(menuItemNovo);
		menuJogo.add(menuItemContinuar);
		menuJogo.add(menuItemRecomecar);
		menuJogo.add(separator);
		menuJogo.add(menuItemSalvar);
		menuJogo.add(menuItemSair);
		menuBar.add(menuJogo);
		
		JMenu menuExtras = new JMenu("Extras");
		menuItemCreditos = new JMenuItem("Créditos");
		menuExtras.add(menuItemCreditos);
		menuBar.add(menuExtras);
		
		circulo = new ImageIcon(getClass().getResource("img/circulo.png"));
		circulo2 = new ImageIcon(getClass().getResource("img/circulo2.png"));
		x = new ImageIcon(getClass().getResource("img/x.png"));
		x2 = new ImageIcon(getClass().getResource("img/x2.png"));
		
		player1 = "Player1";
		player2 = "Player2";
		
		button11 = new JButton(); button11.setBackground(Color.WHITE);
		button12 = new JButton(); button12.setBackground(Color.WHITE);
		button13 = new JButton(); button13.setBackground(Color.WHITE);
		button21 = new JButton(); button21.setBackground(Color.WHITE);
		button22 = new JButton(); button22.setBackground(Color.WHITE);
		button23 = new JButton(); button23.setBackground(Color.WHITE);
		button31 = new JButton(); button31.setBackground(Color.WHITE);
		button32 = new JButton(); button32.setBackground(Color.WHITE);
		button33 = new JButton(); button33.setBackground(Color.WHITE);
		
		vit1=vit2=0;
		labelPlacar = new JLabel("Player1(O): "+vit1+" pts      Player2(X): "+vit2+" pts      ");
		labelVez = new JLabel("Player1");
		
		JPanel panelSouth = new JPanel(new FlowLayout());
		panelSouth.add(labelPlacar);
		panelSouth.add(labelVez);
		
		menuItemCreditos.addActionListener(this);
		menuItemNovo.addActionListener(this);
		menuItemSalvar.addActionListener(this);
		menuItemContinuar.addActionListener(this);
		menuItemRecomecar.addActionListener(this);
		menuItemSair.addActionListener(this);
		button11.addActionListener(this);
		button12.addActionListener(this);
		button13.addActionListener(this);
		button21.addActionListener(this);
		button22.addActionListener(this);
		button23.addActionListener(this);
		button31.addActionListener(this);
		button32.addActionListener(this);
		button33.addActionListener(this);
		
		JPanel panelJogo = new JPanel(new GridLayout(3, 3));
		
		panelJogo.add(button11);
		panelJogo.add(button12);
		panelJogo.add(button13);
		panelJogo.add(button21);
		panelJogo.add(button22);
		panelJogo.add(button23);
		panelJogo.add(button31);
		panelJogo.add(button32);
		panelJogo.add(button33);
		
		add(panelJogo, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		win = false;
		
		if(e.getSource()==button11&&b[0]==0){
			if(vez==1){
				button11.setIcon(circulo); b[0]=1; win = gameOver(b, 0); vez=2;}
			else{
				button11.setIcon(x); b[0]=2; win = gameOver(b, 0); vez=1;}
		}
		
		else if(e.getSource()==button12&&b[1]==0){
			if(vez==1){
				button12.setIcon(circulo); b[1]=1; win = gameOver(b, 1); vez=2;}
			else{
				button12.setIcon(x); b[1]=2; win = gameOver(b, 1); vez=1;}
		}
		
		else if(e.getSource()==button13&&b[2]==0){
			if(vez==1){
				button13.setIcon(circulo); b[2]=1; win = gameOver(b, 2); vez=2;}
			else{
				button13.setIcon(x); b[2]=2; win = gameOver(b, 2); vez=1;}
		}
		
		else if(e.getSource()==button21&&b[3]==0){
			if(vez==1){
				button21.setIcon(circulo); b[3]=1; win = gameOver(b, 3); vez=2;}
			else{
				button21.setIcon(x); b[3]=2; win = gameOver(b, 3); vez=1;}
		}
		
		else if(e.getSource()==button22&&b[4]==0){
			if(vez==1){
				button22.setIcon(circulo); b[4]=1; win = gameOver(b, 4); vez=2;}
			else{
				button22.setIcon(x); b[4]=2; win = gameOver(b, 4); vez=1;}
		}
		
		else if(e.getSource()==button23&&b[5]==0){
			if(vez==1){
				button23.setIcon(circulo); b[5]=1; win = gameOver(b, 5); vez=2;}
			else{
				button23.setIcon(x); b[5]=2; win = gameOver(b, 5); vez=1;}
		}
		
		else if(e.getSource()==button31&&b[6]==0){
			if(vez==1){
				button31.setIcon(circulo); b[6]=1; win = gameOver(b, 6); vez=2;}
			else{
				button31.setIcon(x); b[6]=2; win = gameOver(b, 6); vez=1;}
		}
		
		else if(e.getSource()==button32&&b[7]==0){
			if(vez==1){
				button32.setIcon(circulo); b[7]=1; win = gameOver(b, 7); vez=2;}
			else{
				button32.setIcon(x); b[7]=2; win = gameOver(b, 7); vez=1;}
		}
		
		else if(e.getSource()==button33&b[8]==0){
			if(vez==1){
				button33.setIcon(circulo); b[8]=1; win = gameOver(b, 8); vez=2;}
			else{
				button33.setIcon(x); b[8]=2; win = gameOver(b, 8); vez=1;}
		}
		
		else if(e.getSource()==menuItemCreditos){
			JOptionPane.showMessageDialog(null, "Créditos.", "Créditos", 1);
		}
		
		else if(e.getSource()==menuItemNovo){
			if(JOptionPane.showConfirmDialog(null, "Deseja começar um novo Jogo?", "Novo Jogo", 2)==0){
				button11.setIcon(null);
				button12.setIcon(null);
				button13.setIcon(null);
				button21.setIcon(null);
				button22.setIcon(null);
				button23.setIcon(null);
				button31.setIcon(null);
				button32.setIcon(null);
				button33.setIcon(null);
				player1 = new String(JOptionPane.showInputDialog(null, "Nome do Jogador 1:", "Player1"));
				player2 = new String(JOptionPane.showInputDialog(null, "Nome do Jogador 2:", "Player2"));
				b[0]=b[1]=b[2]=b[3]=b[4]=b[5]=b[6]=b[7]=b[8]=0;
				win=false;
				vit1=vit2=0;
				vez=1;
				labelPlacar.setText(player1+"(O): "+vit1+" pts      "+player2+"(X): "+vit2+" pts      ");
				}
		}
		
		else if(e.getSource()==menuItemSalvar){
			try{
				dados = new DadosArquivo();
				dados.setPlayer1(player1);
				dados.setPlayer2(player2);
				dados.setVit1(vit1);
				dados.setVit2(vit2);
				dados.setB(b);
				output = new ObjectOutputStream(new FileOutputStream("teste.txt"));}
				catch(IOException io){
					JOptionPane.showMessageDialog(null, "Erro ao salvar jogo!", "Erro!", 0);
				}
				try {
					output.writeObject(dados);
				}catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Erro!");
				}
				JOptionPane.showMessageDialog(null, "Jogo salvo com sucesso!", "Sucesso!", 1);
		}
		
		else if(e.getSource()==menuItemContinuar){
			if(JOptionPane.showConfirmDialog(null, "Deseja continuar o jogo salvo?", "Continuar Jogo", 2)==0){
			try{
			input = new ObjectInputStream(new FileInputStream("teste.txt"));}
			catch(IOException io){
				JOptionPane.showMessageDialog(null, "Nenhum jogo salvo!", "Erro", 0);
			}
			DadosArquivo d = new DadosArquivo();
			try {
				d = (DadosArquivo) input.readObject();
			} catch (ClassNotFoundException erro) {
				JOptionPane.showMessageDialog(null, "Erro ao abrir jogo!", "Erro!", 0);
			} catch (IOException erro) {
				JOptionPane.showMessageDialog(null, "Erro ao abrir jogo!", "Erro!", 0);
			}
			vit1 = d.getVit1();
			vit2 = d.getVit2();
			player1 = d.getPlayer1();
			player2 = d.getPlayer2();
			labelPlacar.setText(player1+"(O): "+vit1+" pts      "+player2+"(X): "+vit2+" pts      ");
		}
	}
		
		else if(e.getSource()==menuItemRecomecar){
			if(JOptionPane.showConfirmDialog(null, "Deseja recomeçar a partida?", "Recomeçar Partida", 0)==0){
				button11.setIcon(null);
				button12.setIcon(null);
				button13.setIcon(null);
				button21.setIcon(null);
				button22.setIcon(null);
				button23.setIcon(null);
				button31.setIcon(null);
				button32.setIcon(null);
				button33.setIcon(null);
				b[0]=b[1]=b[2]=b[3]=b[4]=b[5]=b[6]=b[7]=b[8]=0;
				win=false;
				labelPlacar.setText(player1+"(O): "+vit1+" pts      "+player2+"(X): "+vit2+" pts      ");
				vez = (vez==1? 2 : 1);
			}
		}
		
		else if(e.getSource()==menuItemSair){
			if(JOptionPane.showConfirmDialog(null, "Deseja salvar a partida?", "Sair do Jogo", 0)==0){
				try{
					dados = new DadosArquivo();
					dados.setPlayer1(player1);
					dados.setPlayer2(player2);
					dados.setVit1(vit1);
					dados.setVit2(vit2);
					output = new ObjectOutputStream(new FileOutputStream("teste.txt"));}
					catch(IOException io){
						JOptionPane.showMessageDialog(null, "Erro ao salvar jogo!", "Erro!", 0);
					}
					try {
						output.writeObject(dados);
					}catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Erro!");
					}}
				System.exit(0);
		}
			
		if(win){
			String message;
			if(vez==2){
				message = player1+" Venceu!"; vit1++; 
				labelPlacar.setText(player1+"(O): "+vit1+" pts      "+player2+"(X): "+vit2+" pts      "); 
				vez=1;}
			else{
				message = player2+" Venceu!"; vit2++;
				labelPlacar.setText(player1+"(O): "+vit1+" pts      "+player2+"(X): "+vit2+" pts      ");
				vez=2;}
			
			JOptionPane.showMessageDialog(null, message, "Fim de Partida!", 1);
			button11.setIcon(null);
			button12.setIcon(null);
			button13.setIcon(null);
			button21.setIcon(null);
			button22.setIcon(null);
			button23.setIcon(null);
			button31.setIcon(null);
			button32.setIcon(null);
			button33.setIcon(null);
			b[0]=b[1]=b[2]=b[3]=b[4]=b[5]=b[6]=b[7]=b[8]=0;
			
			win=false;
			}
		
		if(b[0]!=0&&b[1]!=0&&b[2]!=0&&b[3]!=0&&b[4]!=0&&b[5]!=0&&b[6]!=0&&b[7]!=0&&b[8]!=0){
			JOptionPane.showMessageDialog(null, "Jogo Empatado!", "Empate", 1);
				button11.setIcon(null);
				button12.setIcon(null);
				button13.setIcon(null);
				button21.setIcon(null);
				button22.setIcon(null);
				button23.setIcon(null);
				button31.setIcon(null);
				button32.setIcon(null);
				button33.setIcon(null);
				b[0]=b[1]=b[2]=b[3]=b[4]=b[5]=b[6]=b[7]=b[8]=0;
				
				win=false;}
		
		labelVez.setText(vez==1 ? player1 : player2);
		
	}

	boolean gameOver(int b[], int i){
		
		if(i==0){
			if(b[1]==b[0]&&b[2]==b[0]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button12.setIcon(vez==1 ? circulo2 : x2);
				button13.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[3]==b[0]&&b[6]==b[0]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button21.setIcon(vez==1 ? circulo2 : x2);
				button31.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[4]==b[0]&&b[8]==b[0]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		
		if(i==1){
			if(b[0]==b[1]&&b[2]==b[1]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button12.setIcon(vez==1 ? circulo2 : x2);
				button13.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[4]==b[1]&&b[7]==b[1]){
				button12.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button32.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		
		if(i==2){
			if(b[0]==b[2]&&b[1]==b[2]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button12.setIcon(vez==1 ? circulo2 : x2);
				button13.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[5]==b[2]&&b[8]==b[2]){
				button13.setIcon(vez==1 ? circulo2 : x2);
				button23.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[4]==b[2]&&b[6]==b[2]){
				button13.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button31.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		
		if(i==3){
			if(b[0]==b[3]&&b[6]==b[3]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button21.setIcon(vez==1 ? circulo2 : x2);
				button31.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[4]==b[3]&&b[5]==b[3]){
				button21.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button23.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		
		if(i==4){
			if(b[3]==b[4]&&b[5]==b[4]){
				button22.setIcon(vez==1 ? circulo2 : x2);
				button21.setIcon(vez==1 ? circulo2 : x2);
				button23.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[1]==b[4]&&b[7]==b[4]){
				button12.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button32.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[0]==b[4]&&b[8]==b[4]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[2]==b[4]&&b[6]==b[4]){
				button31.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button13.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		
		if(i==5){
			if(b[2]==b[5]&&b[8]==b[5]){
				button13.setIcon(vez==1 ? circulo2 : x2);
				button23.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[3]==b[5]&&b[4]==b[5]){
				button21.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button23.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		
		if(i==6){
			if(b[0]==b[6]&&b[3]==b[6]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button21.setIcon(vez==1 ? circulo2 : x2);
				button31.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[7]==b[6]&&b[8]==b[6]){
				button31.setIcon(vez==1 ? circulo2 : x2);
				button32.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[2]==b[6]&&b[4]==b[6]){
				button13.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button31.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		
		if(i==7){
			if(b[6]==b[7]&&b[8]==b[7]){
				button31.setIcon(vez==1 ? circulo2 : x2);
				button32.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[1]==b[7]&&b[4]==b[7]){
				button12.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button32.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		
		if(i==8){
			if(b[6]==b[8]&&b[7]==b[8]){
				button31.setIcon(vez==1 ? circulo2 : x2);
				button32.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[2]==b[8]&&b[5]==b[8]){
				button13.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				button23.setIcon(vez==1 ? circulo2 : x2);
				return true;}
			else if(b[0]==b[8]&&b[4]==b[8]){
				button11.setIcon(vez==1 ? circulo2 : x2);
				button22.setIcon(vez==1 ? circulo2 : x2);
				button33.setIcon(vez==1 ? circulo2 : x2);
				return true;}
		}
		return false;
	}
	
}
