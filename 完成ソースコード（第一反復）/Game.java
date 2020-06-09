package Sisaku;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Turn> log  = new ArrayList<Turn>();
	private int[] array= new int[2];
	private Player player1 = new Player("先攻");
	private Player player2 = new Player("後攻");
	private Player currentplayer = player1;
	private Board board = new Board();
	returnValue value;
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}


	public void start() {
		Turn turn;
		// TODO 自動生成されたメソッド・スタブ
		for(int i = 0;i<9;i++) {
			if(currentplayer == player1) {
				turn = new Turn(currentplayer, "〇", board);
			}else {
				turn = new Turn(currentplayer, "×", board);
			}
			 value = turn.start(); 
			 array[0] = value.array[0];
			 array[1] = value.array[1];
			addlog(turn);
			if(value.judgeMark ==true) {
				showBoard();
				showWinner();
				showlog();
				break;
			}
			showBoard();
			changeplayer();
		}
		if(log.size()== 9 && value.judgeMark ==false) {
			showBoard();
			showDrow();
			System.out.println("<ターン履歴>");
			showlog();
		}else {
			showBoard();
			showWinner();
			System.out.println("<ターン履歴>");
			showlog();
		}
	}

	public void addlog(Turn turn) {
		log.add(turn);
	}
	
	public void showBoard() {
		for(int i = 0;i<3;i++) {
			System.out.println("-------");
			System.out.print("|");
			for(int j = 0;j < 3;j++) {
				if(j==2) {
					System.out.println(board.cells[i][j].getcell() + "|");
				}else {
					System.out.print(board.cells[i][j].getcell() + "|");
				}
			}
		}
		System.out.println("-------");
	}
	public  void changeplayer() {
		if(currentplayer == player1) {
			currentplayer = player2;
		}else {
			currentplayer = player1;
		}
	}

	public  void showWinner() {
		System.out.println("勝者は" + currentplayer.getOrder() + "です。");
	}
	public void showlog() {
		Turn turn;
		for(int i = 0;i<log.size();i++) {
			turn = log.get(i);
			turn.getLog();
		}
	}
	public void showDrow() {
		System.out.println("引き分けです。");
	}
}

