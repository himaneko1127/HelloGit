import java.awt.Color;
import java.awt.Graphics;

public class Racket {
	//public static final int WIDTH =80;//80
	public static final int HEIGHT = 25;//25
	public  int WIDTH = 80;//25
	private int centerPos;
	private int zanki=0;
	public Racket() {
		centerPos = MainPanel.WIDTH/2;
	}
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(centerPos - WIDTH/2,MainPanel.HEIGHT-HEIGHT,WIDTH,HEIGHT);
	}
	public void move(int pos){
		centerPos=pos;
		if(centerPos-WIDTH/2<0){
			centerPos=WIDTH/2;
		}
		if(centerPos+WIDTH/2>MainPanel.WIDTH){
			centerPos=MainPanel.WIDTH-WIDTH/2;
		}

	}
	public boolean bump(Ball ball){
		if(ball.gety()+5==MainPanel.HEIGHT-HEIGHT){
		      if(centerPos-WIDTH/2<ball.getx()+ball.getsize()&& centerPos+WIDTH/2>ball.getx()-ball.getsize()){
		    	  zanki=zanki-1;
		    	  if(zanki==0){
		    		  WIDTH=80;
		    	  }
		    	  return true;
		      }
		}
		return false;
	}

	public boolean itemget(Item item){
		if(item.gety()+5==MainPanel.HEIGHT-HEIGHT){
		      if(centerPos-WIDTH/2<item.getx()+item.getsize()&& centerPos+WIDTH/2>item.getx()-item.getsize()){
		    	  zanki=3;
		    	  return true;
		      }
		}
		return false;
	}
	public void putwidth(int x){
		WIDTH=x;
	}
}
