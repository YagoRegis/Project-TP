package Jogo_Velha;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Game1 extends JFrame{
	
	final static String GAME = "Game";
	
	public Game1() {
		super("Jogo da Velha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tabGame = new PnlGame();
        
        tabbedPane.addTab(GAME, tabGame);

        this.add(tabbedPane, BorderLayout.CENTER);
        */
        
        JPanel tabGame = new PanelMenu();

        this.add(tabGame, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		Game1 telaPrincipal = new Game1();
		telaPrincipal.setSize(300,200);
		telaPrincipal.setVisible(true);

	}

}
