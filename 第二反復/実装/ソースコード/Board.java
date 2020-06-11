package ミニプロジェクト2;

public class Board {
	private Line lines[] = new Line[8];
	private Cell cells[][] = new Cell[3][3];

	public Board() {
		int z = 0;
		for(int i =0;i<3;i++) {
			for(int j =0;j<3;j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		for(int i =0;i<3;i++) {//縦
			lines [z] = new Line(cells[i][0],cells[i][1],cells[i][2]);
			z++;
		}
		for(int j =0;j<3;j++) {//横
			lines [z] = new Line(cells[0][j],cells[1][j],cells[2][j]);
			z++;
		}
		lines [z] = new Line(cells[0][0],cells[1][1],cells[2][2]);
		z++;
		lines [z] = new Line(cells[2][0],cells[1][1],cells[0][2]);
		z++;
	}

	public boolean checkCoordinate(int x, int y){
		return cells[x-1][y-1].judgeCoordinate();
	}

	public boolean judgeWinner() {
		boolean judge = false;
		for(int z=0;z<8;z++) {
			 judge = lines[z].judgeLine();
			 if(judge == true) {
				 break;
			 }
		}
		return judge;
	}
	
	public Cell getCell(int x, int y) {
		return cells[x-1][y-1];
	}
	
	public String showBoard(int x, int y) {
		return cells[x][y].getMark();
	}
}