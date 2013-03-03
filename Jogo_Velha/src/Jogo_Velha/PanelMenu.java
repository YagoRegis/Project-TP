/**
 * This program contains the main menu of the game, with options "New game" and "Exit"
 * 
 */
package Jogo_Velha;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

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
	
	//This function sees where the player clicked and do the right action, New Game or Exit the game
	public void actionPerformed(ActionEvent event) {
		Object origem = event.getSource();
		JFrame game = new PanelGame();
		int ScreenSize = 300;
		
		if(origem.equals(newGame)) {
			game.setSize(ScreenSize,ScreenSize);
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
