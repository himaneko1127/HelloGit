
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JPanel;


public class MainPanel extends JPanel implements Runnable,MouseListener,MouseMotionListener {
	//ブロックの行数
	private static final int NUM_BLOCK_ROW=10;
	//ブロックの列数
	private static final int NUM_BLOCK_COL = 7;
	//ブロック数
	private static final int NUM_BLOCK = NUM_BLOCK_ROW*NUM_BLOCK_COL;
	private Block[][] block;//ブロックの配列へのポインタ

	public static final int WIDTH = 360;
	public static final int HEIGHT = 480;
	private Ball ball;//ボール
	private Racket racket; //ラケット
	private Item item;
	private Thread ballLoop;//ゲームループ
	private Thread itemLoop;
	private int xx,yy;


	public MainPanel() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		ball = new Ball();
		racket = new Racket();
		item = new Item(0,0);
		ballLoop = new Thread(this);
		block = new Block[NUM_BLOCK_ROW][NUM_BLOCK_COL];
		for(int i=0; i<NUM_BLOCK_ROW; i++){
			for(int j=0; j<NUM_BLOCK_COL; j++){
				int x = j*Block.WIDTH + Block.WIDTH;
				int y = i*Block.HEIGHT + Block.HEIGHT;
				block[i][j] = new Block(x,y);
			}
		}
		ballLoop.start();
		//itemLoop.start();
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	public void run(){
		int z=0;
		while(z==0){
			ball.move();
			item.move();
			if(ball.finish(block)==-1 || ball.finish(block)==1){
				z=1;
			}
			//ラケットに衝突したか判定し、衝突していたら向きを変え返す
			if(racket.bump(ball)){
				ball.bound();
			}
			if(racket.itemget(item)){
				item.Delet();
				racket.putwidth(380);
			}

			blocks:for(int i=0; i<NUM_BLOCK_ROW; i++){
				for(int j=0; j<NUM_BLOCK_COL; j++){
					if(block[i][j].isDeleted==false){
						int Pos =block[i][j].bump(ball);
						if(Pos>0){ //ブロックにあたっていたら
							item.putx(block[i][j].x+block[i][j].WIDTH/2);
							item.puty(block[i][j].y+block[i][j].HEIGHT/2);
							Random rand = new Random(System.currentTimeMillis());
							int o=rand.nextInt(10);
							if(o==3){
							item.getitem();
							}
							block[i][j].delete();
							ball.BKbound(Pos);
							break blocks;
						}
					}
				}
			}

			repaint();
			try {
				Thread.sleep(5);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}


	/*public void runn(){
		int z=0;
		while(z==0){
			item.move();
			if(racket.itemget(item)){
				item.Delet();
				racket.putwidth(380);
			}
			repaint();
			try {
				Thread.sleep(5);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}*/


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK); //背景
		g.fillRect(0,0,WIDTH,HEIGHT);
		racket.draw(g);//ラケット
		ball.draw(g);//ボール
		if(item.isDeletes==true){
			item.draw(g);
		}
		for (int i=0; i<NUM_BLOCK_ROW;i++){
			for(int j=0; j<NUM_BLOCK_COL; j++){
				if(block[i][j].isDeleted==false){
					block[i][j].draw(g);
				}
			}
		}
		if(ball.finish(block)==-1){
			g.setColor(Color.GREEN);
			g.drawString("Game Over You lose", WIDTH/2-30, HEIGHT/2);
		}
		if(ball.finish(block)==1){
			g.setColor(Color.GREEN);
			g.drawString("You WIN", WIDTH/2, HEIGHT/2);
		}
	}


	//マウスをクリックしたとき呼ばれる
	public void mouseClicked(MouseEvent e){}
	//マウスがウィンドウ内に入ったとき呼ばれる
	public void mouseEntered(MouseEvent e){}
	//マウスがウィンドウ外に出たときよばれる
	public void mouseEcited(MouseEvent e){}
	//マウスボタンが押されたとき呼ばれる
	public void mousePressed(MouseEvent e){}
	//マウスボタンが離されたとき呼ばれrう
	public void mouseReleased(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent arg0) {}

	public void mouseMoved(MouseEvent e){
		xx=e.getX();
		yy=e.getY();
		//ball.mive(xx,yy);
		racket.move(xx);
	}
	public void mouseDragged(MouseEvent e){}

}
