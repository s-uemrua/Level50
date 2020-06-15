package ミニプロジェクト完成版;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Game {
	private List<Turn> log  = new ArrayList<Turn>();
	private Player player1 = new HumanPlayer("先攻","〇");
	private Player player2 ;
	private FileRead fr;
	private Player currentplayer = player1;
	private Board board = new Board();
	
	public static void main(String[] args) {
		Game game = new Game();
		File f = new File("c:\\hoge");
		if (!f.exists()) {
			f.mkdirs();
		}
		game.start();
		FileWrite fw = new FileWrite(game, game.getBoard());
		boolean value = game.getBoard().judgeWinner();
		Player getplayer = game.getPlayer2() ;
		if(getplayer !=null) {
		fw.write(value);
		}
		System.out.println("ゲームを終了します。");
	}

	public void start() {
		boolean note = gameMode();
			if(player2 != null) {
				showBoard();
				gameProgress();
			}
	}
	private Board getBoard() {
		return board;
	}
	
	private Player getPlayer2() {
		return player2;
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
	
	private void addlog(Turn turn) {
		log.add(turn);
	}

	private  void changePlayer() {
		if(currentplayer == player1) 
			currentplayer = player2;
		else 
			currentplayer = player1;
	}

	public String showWinner() {
		System.out.println("勝者：" + currentplayer.getOrder());
		return"勝者：" + currentplayer.getOrder();
	}

	public String[] showlog() {
		Turn turn;
		String[] Log = new String[log.size()];
		for(int i = 0;i<log.size();i++) {
			turn = log.get(i);
			Log[i] =turn.getLog();
		}
		return Log;
	}

	public String showDrow() {
		System.out.println("引き分け");
		return "引き分け";
	}

	private boolean gameMode() {
		int mode =0;
		boolean note = false;
		fr = new FileRead();
		for(int i =0;i<2;i++) {
			while(true) {
				try {
					@SuppressWarnings("resource")
					Scanner scan = new Scanner(System.in);
					System.out.println("ゲームモードを選択してください");
					if(note ==false) {
						System.out.println("1:一人モード　　2:対戦モード  3:前回の履歴の表示");
					}else {
						System.out.println("1:一人モード　　2:対戦モード  3:終了");
					}
					mode = Integer.parseInt(scan.next());
					if(mode<4) {
						break;
					} else {
						System.out.println("1,2の数字を入力してください。");
					}
				}catch(NumberFormatException e) {
					System.out.println("入力値が正しくありません。");
				}
			}
			if(mode == 1) {
				player2 = new ComputerPlayer("後攻", "×");
				break;
			}else if(mode == 2) {
				player2 = new HumanPlayer("後攻","×");
				break;
			}else if(mode == 3 && note == false) {
				fr.read();
				note = true;
			}
		}
		return note;
	}
	private void gameProgress() {
		boolean value = false;
		for(int i = 0;i<9;i++) {
			Turn turn = new Turn(currentplayer, board);
			turn.start(); 
			value =  board.judgeWinner();
			addlog(turn);
			showBoard();
			if(value ==true) {
				break;
			}

			changePlayer();
		}
	}
}

