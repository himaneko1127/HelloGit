import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class Ball{
	private final int size =10; //ボールの大きさ
	public  int x,y; //ボールの位置
	private int vx,vy; //ボールの位置方向と速さ
	public int zanki;
	public Ball(){
		Random rand = new Random(System.currentTimeMillis());
		x=rand.nextInt(MainPanel.WIDTH-size);
		y=200;
		vx=1;
		vy=1;
		zanki=3;
	}
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(x-size/2,y-size/2,size,size);
	}
	public void move(){
		if(x>360){
			vx=-vx;
		}
		if(x<0){
			vx=-vx;
		}
		if(y>480){
			vy=-vy;
		}
		if(y<0){
			vy=-vy;
		}
		x+=vx;
		y+=vy;
	}
	public void mive(int xx,int yy){
		this.x=xx;
		this.y=yy;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	public int getsize(){
		return size/2;
	}
	public void bound(){
		vy=-vy;
	}
	public void BKbound(int Pos){
		switch (Pos){
	      case Block.UP:{
	        vy=-vy;
	        break;
	      }
	case Block.DOWN:{
	        vy=-vy;
	        break;
	      }
	case Block.LEFT:{
	        vx=-vx;
	        if(vy<0){
	          vy=-vy;
	        }
	break;
	      }
	case Block.RIGHT:{
	        vx=-vx;
	        if(vy<0){
	          vy=-vy;
	        }
	break;
	      }
	case Block.UP_RIGHT:{
	        vx=-vx;
	        vy=-vy;
	        break;
	      }
	case Block.UP_LEFT:{
	        vx=-vx;
	        vy=-vy;
	        break;
	      }
	case Block.DOWN_LEFT:{
	        vx=-vx;
	        vy=-vy;
	        break;
	      }
	}
	}
	public int finish(Block[][] block){
		int z=0;
		int r=block.length;
		int c=block[0].length;
		int k=r*c;
		if(y>479){
			zanki=zanki-1;
			if(zanki<=0){
				return -1;
			}
			Random rand = new Random(System.currentTimeMillis());
			this.x=rand.nextInt(MainPanel.WIDTH-size);
			this.y=200;


		}
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(block[i][j].isDeleted==true){
					z=z+1;
					if(z==k){
						return 1;
					}
				}
			}

		}
		return 0;
	}
}
