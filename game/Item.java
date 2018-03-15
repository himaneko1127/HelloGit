import java.awt.Color;
import java.awt.Graphics;
public class Item{
	private final int size =10; //ボールの大きさ
	public  int x,y; //ボールの位置
	public  int vx,vy; //ボールの位置方向と速さ]
	public  boolean isDeletes;
	public Item(int x,int y){
		this.x=x;
		this.y=y;
		vx=0;
		vy=2;
		isDeletes=false;
	}
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(x-size/2,y-size/2,size,size);
	}
	public void move(){
		y+=vy;
	}
	public void mive(int xx,int yy){
		this.x=xx;
		this.y=yy;
	}
	public void putx(int x){
		this.x=x;
	}
	public void puty(int y){
		this.y=y;
	}
	public int getsize(){
		return size/2;
	}
	public void bound(){
		vy=-vy;
	}
	public void Delet(){
		isDeletes=false;
	}
	public void getitem(){
		isDeletes=true;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}



}

