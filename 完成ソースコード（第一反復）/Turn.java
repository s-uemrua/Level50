package Sisaku;

public class Turn {

	private Player player;
	private Board board ;
	private boolean judge=true;
	private int[] array  = new int[2];
	private Cell cell ;
	private String mark;

	public Turn(Player player, String mark ,Board board) {
		this.player = player;
		this.mark = mark;
		this.board = board;
	}

	public  returnValue start() {
		returnValue value = new  returnValue();
		while(true) {
			array =player.inputCoordinate();
			judge =board.checkCoordinate(array[0],array[1]);
			cell = board.getCell(array[0], array[1]);
			if(judge == true){
				break;
			}
			System.out.println("すでに置かれています");
		}
		value.array = array;
		cell.setMark(mark);
		value.Mark= cell.getcell();
		value.judgeMark= board.judgeWinner();
		return value;
	}
	
	public void getLog() {
		System.out.println(player.getOrder()+ ":(" + cell.getX() + "," + cell.gety() + ") " + mark);
	}
}

class returnValue{
	public String Mark;
	public int[] array;//座標
	public boolean judgeMark;//勝敗判定
}


