import java.awt.Color;
import java.awt.Graphics;


public class Block {
	public static final int WIDTH =40;
	public static final int HEIGHT = 15;
	public int x,y;
	public boolean isDeleted;
	public static final int NO_COLLISION =0;
	public static final int DOWN=1;
	public static final int LEFT=2;
	public static final int RIGHT=3;
	public static final int UP = 4;
	public static final int DOWN_LEFT=5;
	public static final int DOWN_RIGHT=6;
	public static final int UP_LEFT=7;
	public static final int UP_RIGHT=8;

	Block(int x,int y){
		this.x=x;
		this.y=y;
		isDeleted=false;
	}
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x,y,WIDTH,HEIGHT);
		g.setColor(Color.BLUE);
		g.drawRect(x,y,WIDTH,HEIGHT);
	}
	public int bump(Ball ball){
		if(ball.gety()+ball.getsize()==this.y){
		      if(this.x<ball.getx()+ball.getsize() && this.x+WIDTH>ball.getx()-ball.getsize()){//下の当たり判定
		    	  return UP;
		      }
		 }
		if(ball.gety()-ball.getsize()==this.y+HEIGHT){
		      if(this.x<ball.getx()+ball.getsize() && x+WIDTH>ball.getx()-ball.getsize()){//上の当たり判定
		    	  return DOWN;
		      }
		}
		if(ball.gety()+ball.getsize()>=this.y && ball.gety()-ball.getsize()<this.y+HEIGHT){
		      if(x+WIDTH==ball.getx()-ball.getsize()){//右側の当たり判定
		        return RIGHT;
		      }
		      if(this.x==ball.getx()+ball.getsize()){//左側の当たり判定
		        return LEFT;
		      }
		 }
		if(ball.gety()+ball.getsize()>y&&ball.gety()<y){//左上の判定
			if(ball.getx()+ball.getsize()>x && ball.getx()<x){
				return UP_LEFT;
			}
			if(ball.getx()-ball.getsize()<x+WIDTH && ball.getx()>x+WIDTH){
				return UP_RIGHT;
			}
		}
		if(ball.gety()-ball.getsize()<y+HEIGHT && ball.gety()>y+HEIGHT){
			if(ball.getx()+ball.getsize()>x && ball.getx()<x){
				return DOWN_LEFT;
			}
			if(ball.getx()-ball.getsize()<x+WIDTH && ball.getx()>x+WIDTH){
				return DOWN_RIGHT;
			}
		}
		return NO_COLLISION ;
	}
	public void delete(){
		isDeleted=true;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
}

