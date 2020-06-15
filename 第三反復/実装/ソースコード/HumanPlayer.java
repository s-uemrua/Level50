package project;


import java.util.Scanner;

public class HumanPlayer extends Player {
	int[] coordinate;
	public HumanPlayer(String order, String mark) {
		super(order,mark);
		coordinate = new int[2];
	}
	
	//プレイヤーが座標を入力するメソッド
	public int[] inputCoordinate() {
		//列(ｙ座標）を入れる箱に0を代入。
		coordinate[0] = 0;
		//行(x座標）を入れる箱に0を代入。
		coordinate[1] = 0;

		while(true) {
			//javaでキーボード入力するときに必要なScannerクラスのインスタンス作成
			try {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("行と列を、半角スペースで区切って入力して下さい (例：2行目の3列目 → 2 3)");
				//列を入力
				//Integerがあるのは、万が一日本語入力されても数字に変換するため。
				coordinate[0] = Integer.parseInt(sc.next());
				//行を入力
				coordinate[1] = Integer.parseInt(sc.next());
				//正しい座標を入力した場合、ループを抜ける。そうでなければ、もう一度入力させる。
				if(coordinate[0] > 0 && coordinate[0] <=  3
						&& coordinate[1] > 0 && coordinate[1] <= 3) {
					break;
				} else {
					System.out.println("1~3の数字を入力してください。");
				}
			}catch(NumberFormatException e) {
				System.out.println("入力値が正しくありません。");
			}
		}
		return coordinate;
	}
}


