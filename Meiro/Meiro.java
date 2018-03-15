
public class Meiro {
	private Zahyo enter; //入り口座標
	private Zahyo goal; //ゴール座標
	private int map[][];
	public Meiro() { //コンストラクタ
			map = new int[][]{
					{2,2,2,2,2,2,2,2,2,2,2,2},
					{2,0,0,0,0,2,2,2,2,2,2,2},
					{2,0,2,2,2,2,2,2,2,2,2,2},
					{2,0,0,0,2,2,2,2,2,2,2,2},
					{2,0,2,2,2,2,0,0,2,2,2,2},
					{2,0,0,0,0,0,0,0,0,0,2,2},
					{2,0,2,2,2,2,2,2,2,0,0,2},
					{2,0,0,0,0,2,2,2,2,2,0,2},
					{2,2,0,2,2,2,2,0,0,0,0,2},
					{2,2,0,2,2,2,2,2,0,2,2,2},
					{2,0,0,2,2,2,2,2,0,0,0,2},
					{2,2,2,2,2,2,2,2,2,2,2,2}};
			this.display(); //迷路を表示するメソッドを呼び出す
			enter = new Zahyo(1,1);
			goal = new Zahyo(1,2);
	}
	public void display(){
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
	}

	public int getValue(Zahyo zz) {
		return map[zz.getX()][zz.getY()];
	}
	public  void putValue(Zahyo zz) {
		map[zz.getX()][zz.getY()]=1;
	}
	public boolean walk(Zahyo here){ //現在いる位置を引数でもらう
		if (here.euqal(goal)){
			return true;
		}
		else {
			putValue(here);
			System.out.print("I have passed");
			here.write();
		}
		if(getValue(here.up())==0){
			if(walk(here.up())){
				System.out.println("a");
				return true;
			}
			else {
				System.out.print("I have returned");
				here.write();
			}
		}
		if(getValue(here.right())==0){
			if(walk(here.right())){
				System.out.println("a");
				return true;
			}
			else {
				System.out.print("I have returned");
				here.write();
			}
		}
		if(getValue(here.down())==0){
			if(walk(here.down())){
				System.out.println("a");
				return true;
			}
			else {
				System.out.print("I have returned");
				here.write();
			}
		}
		if(getValue(here.left())==0){
			if(walk(here.left())){
				System.out.println("a");
				return true;
			}
			else {
				System.out.print("I have returned");
				here.write();
			}
		}
		return false;

	}
	public Zahyo Iriguti(){
		return enter;
	}

}





