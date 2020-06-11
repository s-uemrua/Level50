package ミニプロジェクト2;

public class Cell {
	
	private int x;
	private int y;
	private String mark =" ";


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

	public String getMark() {
		return mark;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public int getX() {
		return x+1;
	}
	
	public int getY() {
		return y+1;
	}
}
