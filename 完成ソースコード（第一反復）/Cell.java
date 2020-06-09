package Sisaku;

public class Cell {
	
	private int x;
	private int y;
	protected String mark =" ";


	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean judgeCoordinate() {
		if(this.mark == " ") {
			return true;
		}else {
			return false;
		}
	}

	public String getcell() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public int getX() {
		return x;
	}
	
	public int gety() {
		return y;
	}
}
