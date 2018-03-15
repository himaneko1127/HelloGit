import java.awt.Container;

import javax.swing.JFrame;

public class Test extends JFrame{
	public Test() {
		//タイトル設定
		setTitle("Hello Worldを表示する");

		//メインパネルを作成してフレームに追加
		MainPanel panel = new MainPanel();
		Container contentP = getContentPane();
		contentP.add(panel);

		//パネルサイズに合わせてフレームサイズを自動設定
		pack();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test frame = new Test();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}


