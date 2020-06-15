package project;

public class Turn {

	private Player player;
	private Board board ;
	private Cell cell ;
	
	
	public Turn(Player player,Board board) {
		this.player = player;
		this.board = board;
	}

	public  void start() {
		boolean judge = false;
		String mark;
		 int[] array  = new int[2];
		while(true) {
			array =player.inputCoordinate();
			judge =board.checkCoordinate(array[0],array[1]);
			cell = board.getCell(array[0], array[1]);
			if(judge == true){
				System.out.print(array[0] +","+ array[1] + "を入力");
				System.out.println("");
				break;
			}
		}
		mark=player.getMark();
		cell.setMark(mark);
	}
	
	public String getLog() {
		System.out.println(player.getOrder()+ ":(" + cell.getX() + "," + cell.getY() + ") " + cell.getMark());
		return player.getOrder()+ ":(" + cell.getX() + "," + cell.getY() + ") " + cell.getMark();
	}
}


