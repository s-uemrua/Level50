package Sisaku;

public class Line {
	
	Cell cells,cells2,cells3 ;
	private String [] mark = new String[3];
	
	public Line(Cell cells, Cell cells2, Cell cells3) {
		this.cells=cells;
		this.cells2 = cells2;
		this.cells3 = cells3;
	}

	public boolean judgeLine() {
		mark[0] = cells.getcell();
		mark[1] = cells2.getcell();
		mark[2] = cells3.getcell();
		if(!(cells.getcell().equals(" ")) && !(cells2.getcell().equals(" ")) && !(cells3.getcell().equals(" "))&& (mark[0].equals(mark[1])) &&(mark[1].equals(mark[2]))) {
			return true;
		}else {
			return false;
		}
	}
}
