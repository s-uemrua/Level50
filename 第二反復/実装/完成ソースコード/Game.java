package 三目並べソースコード完成版;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private List<Turn> log  = new ArrayList<Turn>();
	private Player player1;
	private Player player2;
	private Player currentplayer;
	private Board board;
	
	
	public Game() {
		 player1 = new HumanPlayer("先攻","〇");
		 currentplayer = player1;
		 board = new Board();
	}

	
	public void start() {
		gameMode();
		board.showBoard();
		gameProgress();
	}

	
	public void addlog(Turn turn) {
		log.add(turn);
	}


	public  void changePlayer() {
		if(currentplayer == player1) {
			currentplayer = player2;
		}else {
			currentplayer = player1;
		}
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
	
	
	private void gameMode() {
		int mode;
		while(true) {
			try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("ゲームモードを選択してください");
			System.out.println("1:一人モード　　2:対戦モード");
			mode = Integer.parseInt(scan.next());
			if(mode<3) {
				break;
			} else {
				System.out.println("1,2の数字を入力してください。");
			}
		}catch(NumberFormatException e) {
			System.out.println("入力値が正しくありません。");
		}
		}if(mode == 1) {
			 player2 = new ComputerPlayer("後攻", "×");
		}else if(mode == 2) {
			 player2 = new HumanPlayer("後攻","×");
		
		}
	}
	
	
	private void gameProgress() {
		Turn turn;
		boolean value = false;
		for(int i = 0;i<9;i++) {
			if(currentplayer == player1) {
				turn = new Turn(currentplayer, board);
			}else {
				turn = new Turn(currentplayer, board);
			}
			 turn.start(); 
			value =  board.judgeWinner();
			addlog(turn);
			board.showBoard();
			if(value ==true) {
				showWinner();
				showlog();
				break;
			}
		
				changePlayer();
		}
		if(log.size()== 9 && value ==false) {
			showDrow();
			showlog();
		}
	}

	
}

