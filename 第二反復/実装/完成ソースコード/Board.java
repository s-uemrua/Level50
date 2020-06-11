package 三目並べソースコード完成版;

public class Board {
	private Line lines[] = new Line[8];
	private Cell cells[][] = new Cell[3][3];

	public Board() {
		for(int i =0;i<3;i++) {
			for(int j =0;j<3;j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		
		lines [0] = new Line(cells[0][0],cells[0][1],cells[0][2]);
		lines [1] = new Line(cells[1][0],cells[1][1],cells[1][2]);
		lines [2] = new Line(cells[2][0],cells[2][1],cells[2][2]);
		lines [3] = new Line(cells[0][0],cells[1][0],cells[2][0]);
		lines [4] = new Line(cells[0][1],cells[1][1],cells[2][1]);
		lines [5] = new Line(cells[0][2],cells[1][2],cells[2][2]);
		lines [6] = new Line(cells[2][0],cells[1][1],cells[0][2]);
		lines [7] = new Line(cells[0][0],cells[1][1],cells[2][2]);
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
	
	public void showBoard() {
		for(int i = 0;i<3;i++) {
			System.out.println("ーーーーー");
			for(int j = 0;j<3;j++) {
				if(j==2) {
					System.out.println(cells[i][j].getMark() + "|");
				}else {
					System.out.print(cells[i][j].getMark() + "|");
				}
			}
		}
		System.out.println("ーーーーー");
	}
	
}