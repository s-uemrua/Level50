package Sisaku;

public class Board {
	Line lines[] = new Line[8];
	Cell cells[][] = new Cell[3][3];
	private int i,j,z;

	public Board() {
		for(i =1;i<4;i++) {
			for(j =1;j<4;j++) {
				cells[i-1][j-1] = new Cell(i, j);
			}
		}
			for(i =0;i<3;i++) {//縦
					lines [z] = new Line(cells[i][0],cells[i][1],cells[i][2]);
					z++;
			}
			for(j =0;j<3;j++) {//横
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
		for(z=0;z<8;z++) {
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
}