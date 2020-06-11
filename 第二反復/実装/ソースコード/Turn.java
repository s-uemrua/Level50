package ミニプロジェクト2;

public class Turn {

	private Player player;
	private Board board ;
	private Cell cell ;
	String mark;
	
	public Turn(Player player,Board board) {
		this.player = player;
		this.board = board;
	}

	public  boolean start() {
		boolean judge = false;
		 int[] array  = new int[2];
		while(true) {
			array =player.inputCoordinate();
			judge =board.checkCoordinate(array[0],array[1]);
			cell = board.getCell(array[0], array[1]);
			if(judge == true){
				System.out.println("");
				System.out.print(array[0] +","+ array[1] + "を入力");
				System.out.println("");
				break;
			}
			System.out.println("すでに置かれています");
		}
		mark=player.getMark();
		cell.setMark(mark);
		return board.judgeWinner();
	}
	
	public void getLog() {
		System.out.println(player.getOrder()+ ":(" + cell.getX() + "," + cell.getY() + ") " + mark);
	}
}


