import java.io.*;

@SuppressWarnings("serial")
public class DadosArquivo implements Serializable{

	private int vit1;
	private int vit2;
	private String player1;
	private String player2;
	private int[] b;
	
	public void setB(int[] b){
		this.b = b;
	}
	
	public int[] getB(){
		return b;
	}
	
	public int getVit1() {
		return vit1;
	}
	
	public void setVit1(int vit1) {
		this.vit1 = vit1;
	}
	
	public int getVit2() {
		return vit2;
	}
	
	public void setVit2(int vit2) {
		this.vit2 = vit2;
	}
	
	public String getPlayer1() {
		return player1;
	}
	
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	
	public String getPlayer2() {
		return player2;
	}
	
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	
}
