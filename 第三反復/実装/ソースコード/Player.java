package project;
abstract  class Player {
	//先攻、後攻をいれる。
	private String order;
	private String mark;
	
	//プレイヤー名（先攻、後攻）のセット
	public Player(String order,String mark) {
		this.order = order;
		this.mark = mark;
	}
	
	public abstract int[] inputCoordinate();
	
	public  String getOrder() {
		return order;
	}
	public String getMark() {
		return mark;
	}
}