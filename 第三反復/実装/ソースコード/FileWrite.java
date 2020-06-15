package ミニプロジェクト完成版;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {
	private Game game;
	private Board board ;
	FileWriter fw;
	PrintWriter pw;
	
	public FileWrite(Game game, Board board) {
		this.board = board;
		this.game = game;
	}
	
	public void write(boolean value) {
		try {
			fw = new FileWriter("c:\\hoge\\log.txt",false);
			pw = new PrintWriter(new BufferedWriter(fw));
			if(value == true) {
				pw.println(game.showWinner());
			}else {
				pw.println(game.showDrow());
			}
			
			for(int i = 0;i<3;i++) {
				pw.println();
				pw.println("ーーーーー");
				for(int j = 0;j<3;j++) {
					if(j==2) {
						pw.print(board.showBoard(i,j) + "|");
					}else {
						pw.print(board.showBoard(i,j) + "|");
					}
				}
			}
			pw.println();
			pw.println("ーーーーー");
			
			System.out.println();
			System.out.println("<ターン履歴>");
			pw.println();
			pw.println("<ターン履歴>");
			String Log[];
			Log = game.showlog();
			for(int i = 0;i<Log.length;i++) {
				pw.println(Log[i]);
			}
			
			
			pw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
