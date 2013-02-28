

public class Grid1 {
	
	private String selection[][];

	public String[][] getSelection() {
		return selection;
	}
	public void setSelection(String selection, int position[]) {
		this.selection[position[0]][position[1]] = selection;
	}

	public Grid1() {
		super();
		String grid[][] = {{"","",""},
						   {"","",""},
						   {"","",""}};
		this.selection = grid;
		}

	
}