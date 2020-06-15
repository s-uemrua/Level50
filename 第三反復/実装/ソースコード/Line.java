package project;

public class Line {
	
	private Cell cells,cells2,cells3 ;
	
	public Line(Cell cells, Cell cells2, Cell cells3) {
		this.cells=cells;
		this.cells2 = cells2;
		this.cells3 = cells3;
	}

	public boolean judgeLine() {
		String [] mark = new String[3];
		mark[0] = cells.getMark();
		mark[1] = cells2.getMark();
		mark[2] = cells3.getMark();
		if(!(cells.getMark().equals(" ")) && !(cells2.getMark().equals(" ")) && !(cells3.getMark().equals(" "))&& (mark[0].equals(mark[1])) &&(mark[1].equals(mark[2]))) {
			return true;
		}else {
			return false;
		}
	}
}
