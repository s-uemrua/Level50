package 三目並べソースコード完成版;

import java.util.Random;

public class ComputerPlayer extends Player {
	
	//x座標とy座標を入れるための箱をつくる。
	Random random;
	//プレイヤーが座標を入力するメソッド
	int[] coordinate;

	
	public ComputerPlayer(String order, String mark) {
		super(order,mark);
		random = new Random();
		coordinate = new int[2];
	}
	
	
	public int[] inputCoordinate() {
		//列(ｙ座標）を入れる箱に0を代入。
		coordinate[0] = 0;
		//行(x座標）を入れる箱に0を代入。
		coordinate[1] = 0;
		
		int randomValueX = random.nextInt(3)+1;
		coordinate[0] = randomValueX;
		int randomValueY = random.nextInt(3)+1;
		coordinate[1] = randomValueY;
		return coordinate;
	}
}
