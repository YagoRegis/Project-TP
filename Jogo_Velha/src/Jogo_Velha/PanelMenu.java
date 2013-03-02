package Jogo_Velha;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelMenu extends JPanel implements ActionListener {
	
	private JButton newGame = new JButton("New Game");
	private JButton exit = new JButton("Exit");
	
	public PanelMenu () {
		this.setLayout(new GridLayout(2,1));
		
		this.add(newGame);
		this.add(exit);
		
		newGame.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		Object origem = event.getSource();
		JFrame game = new PanelGame();
		
		if(origem.equals(newGame)) {
			game.setSize(300,300);
			game.setVisible(true);
		}
		else{
			if(origem.equals(exit)){
					System.exit(ABORT);
			}
			else{
					//default
			}
		}
	}

}
