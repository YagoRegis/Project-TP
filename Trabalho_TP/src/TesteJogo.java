import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

public class TesteJogo {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		Jogo jogo = new Jogo();
		jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jogo.setSize(300,310);
		jogo.setVisible(true);
		jogo.setLocation(500,200);
	}
}
