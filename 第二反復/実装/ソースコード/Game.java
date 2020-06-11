package ミニプロジェクト2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private List<Turn> log  = new ArrayList<Turn>();
	private Player player1 = new HumanPlayer("先攻","〇");
	private Player player2 = new ComputerPlayer("後攻", "×");
	private Player player3 = new HumanPlayer("後攻","×");
	private Player currentplayer = player1;
	private Board board = new Board();
	
	
	
	/*public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}*/

	public void start() {
		Turn turn;
		int mode;
		boolean value = false;
		while (true) {
			try {
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				System.out.println("ゲームモードを選択してください");
				System.out.println("1:一人モード　　2:対戦モード");
				mode = Integer.parseInt(scan.next());
				if (mode < 3) {
					break;
				} else {
					System.out.println("1,2の数字を入力してください。");
				}
			} catch (NumberFormatException e) {
				System.out.println("入力値が正しくありません。");
			}
		}
		
		
		showBoard();
		for(int i = 0;i<9;i++) {
			if(currentplayer == player1) {
				turn = new Turn(currentplayer, board);
			}else {
				turn = new Turn(currentplayer, board);
			}
			value = turn.start(); 
			addlog(turn);
			showBoard();
			if(value ==true) {
				showWinner();
				System.out.println("");
				System.out.println("<ターン履歴>");
				showlog();
				break;
			}
			if(mode==1) {
				changeCpu();
			}else{
				changeplayer();
			};
		}
		if(log.size()== 9 && value ==false) {
			showDrow();
			System.out.println("");
			System.out.println("<ターン履歴>");
			showlog();
		}
	}

	public void addlog(Turn turn) {
		log.add(turn);
	}

	public void showBoard() {
		for(int i = 0;i<3;i++) {
			System.out.println("ーーーーー");
			for(int j = 0;j<3;j++) {
				if(j==2) {
					System.out.println(board.showBoard(i,j) + "|");
				}else {
					System.out.print(board.showBoard(i,j) + "|");
				}
			}
		}
		System.out.println("ーーーーー");
	}
	
	public  void changeplayer() {
		if(currentplayer == player1) {
			currentplayer = player3;
		}else {
			currentplayer = player1;
		}
	}

	public  void changeCpu() {
		if(currentplayer == player1) {
			currentplayer = player2;
		}else 
			currentplayer = player1;
	}

	public  void showWinner() {
		System.out.println("勝者:" + currentplayer.getOrder());
	}
	
	public void showlog() {
		Turn turn;
		for(int i = 0;i<log.size();i++) {
			turn = log.get(i);
			turn.getLog();
		}
	}
	
	public void showDrow() {
		System.out.println("引き分け");
	}
}

