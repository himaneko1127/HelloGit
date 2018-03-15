

class Zahyo {
	private int x,y; //迷路図の座標値
	Zahyo(int x1,int y1) {
		this.x=x1;
		this.y=y1;
	}
	public void write() {
		System.out.println("("+x+","+y+")");
	}
	public boolean euqal(Zahyo zz) { //オブジェクトに座標値を設定
		if (zz.getX()==x && zz.getY()==y){
			return true;
		}
		else {
			return false;
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public Zahyo up() {
		Zahyo up = new Zahyo(x,y-1);
		return up;
	}
	public Zahyo down() {
		Zahyo down = new Zahyo(x,y+1);
		return down;

	}
	public Zahyo right() {
		Zahyo right = new Zahyo(x+1,y);
		return right;
	}
	public Zahyo left() {
		Zahyo left = new Zahyo(x-1,y);
		return left;
	}


}

