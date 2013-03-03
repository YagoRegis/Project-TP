/**
 * This program aims to create the logical part of the game and also its graphics part
 * 
 */

package Jogo_Velha;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelGame extends JFrame implements ActionListener {
	
	private boolean player = true;
	private int position[] = {0,0};
	
	//Variables of the grid that appears on the screen, each with its position in the matrix  
	private JButton cell11;
	private JButton cell12;
	private JButton cell13;
	private JButton cell21;
	private JButton cell22;
	private JButton cell23;
	private JButton cell31;
	private JButton cell32;
	private JButton cell33;
	
	private Grid1 grid = new Grid1();
	private boolean end = false;
	private String message = "";
		
	public PanelGame() {
		this.setLayout(new GridLayout(3,3));
		
		cell11 = new JButton(grid.getSelection()[0][0]);
		cell12 = new JButton(grid.getSelection()[0][1]);
		cell13 = new JButton(grid.getSelection()[0][2]);
		cell21 = new JButton(grid.getSelection()[1][0]);
		cell22 = new JButton(grid.getSelection()[1][1]);
		cell23 = new JButton(grid.getSelection()[1][2]);
		cell31 = new JButton(grid.getSelection()[2][0]);
		cell32 = new JButton(grid.getSelection()[2][1]);
		cell33 = new JButton(grid.getSelection()[2][2]);
		
		//Adding cells to the GridLayout
		this.add(cell11);
		this.add(cell12);
		this.add(cell13);
		this.add(cell21);
		this.add(cell22);
		this.add(cell23);
		this.add(cell31);
		this.add(cell32);
		this.add(cell33);
		
		cell11.addActionListener(this);
		cell12.addActionListener(this);
		cell13.addActionListener(this);
		cell21.addActionListener(this);
		cell22.addActionListener(this);
		cell23.addActionListener(this);
		cell31.addActionListener(this);
		cell32.addActionListener(this);
		cell33.addActionListener(this);
	}
	
	//Here is the logical part and the action buttons of the Grid(Enabled or not)
	public void actionPerformed(ActionEvent event) {
		Object origem = event.getSource();
		
		if(origem.equals(cell11)) {
			cell11.setEnabled(false);
			position[0] = 0; position[1] = 0;
		}
		else{
			//Default
		}
		if(origem.equals(cell12)) {
			cell12.setEnabled(false);
			position[0] = 0; position[1] = 1;
		}
		else{
			//Default
		}
		if(origem.equals(cell13)) {
			cell13.setEnabled(false);
			position[0] = 0; position[1] = 2;
		}
		else{
			//Default
		}
		if(origem.equals(cell21)) {
			cell21.setEnabled(false);
			position[0] = 1; position[1] = 0;
		}
		else{
			//Default
		}
		if(origem.equals(cell22)) {
			cell22.setEnabled(false);
			position[0] = 1; position[1] = 1;
		}
		else{
			//Default
		}
		if(origem.equals(cell23)) {
			cell23.setEnabled(false);
			position[0] = 1; position[1] = 2;
		}
		else{
			//Default
		}
		if(origem.equals(cell31)) {
			cell31.setEnabled(false);
			position[0] = 2; position[1] = 0;
		}
		else{
			//Default
		}
		if(origem.equals(cell32)) {
			cell32.setEnabled(false);
			position[0] = 2; position[1] = 1;
		}
		else{
			//Default
		}
		if(origem.equals(cell33)) {
			cell33.setEnabled(false);
			position[0] = 2; position[1] = 2;
		}
		else{
			//Default
		}
			
		if(player){
			grid.setSelection("X", position);
		}
		else{
			grid.setSelection("O", position);
		}
			
		cell11.setText(grid.getSelection()[0][0]);
		cell12.setText(grid.getSelection()[0][1]);
		cell13.setText(grid.getSelection()[0][2]);
		cell21.setText(grid.getSelection()[1][0]);
		cell22.setText(grid.getSelection()[1][1]);
		cell23.setText(grid.getSelection()[1][2]);
		cell31.setText(grid.getSelection()[2][0]);
		cell32.setText(grid.getSelection()[2][1]);
		cell33.setText(grid.getSelection()[2][2]);

		//Detects if there is a draw
		int line,column;
		end = true;
		for(line=0;line<3;line++){
			for(column=0;column<3;column++){
				if(grid.getSelection()[line][column]=="") {
					end = false;
				}
				else{
					//Default
				}
			}
		}
		message = "Draw.";
		
		for(line=0;line<3;line++){
			//Detects if the game has a winner
			if((grid.getSelection()[line][0]==grid.getSelection()[line][1]&&grid.getSelection()[line][0]==grid.getSelection()[line][2]&&grid.getSelection()[line][0]!="") ||
				(grid.getSelection()[0][line]==grid.getSelection()[1][line]&&grid.getSelection()[0][line]==grid.getSelection()[2][line]&&grid.getSelection()[0][line]!="") ||
				(grid.getSelection()[0][0]==grid.getSelection()[1][1]&&grid.getSelection()[0][0]==grid.getSelection()[2][2]&&grid.getSelection()[0][0]!="") ||
				(grid.getSelection()[0][2]==grid.getSelection()[1][1]&&grid.getSelection()[1][1]==grid.getSelection()[2][0]&&grid.getSelection()[2][0]!="")) {
				end = true;
				
				if(player){
					message = "Payer 1 won.";
				}
				else{
					message = "Player 2 won.";
				}
				
			}
			else{
				//Default
			}
		}
			
		if(end){
			JOptionPane.showMessageDialog(null, "End of game: " + message);
			this.setVisible(false);
		}
		else{
			//default
		}
		//Swap turns
		player = !player;
	}
}
