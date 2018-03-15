import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class Tree {
	private Node root;
	private String myitem;
	PrintWriter out;
	BufferedReader br;
	FileReader fr;

	public Tree(String item)throws IOException{
		myitem=item;
		System.out.println("何か一つ"+item+"を入力してください");
		String name =(new BufferedReader(new InputStreamReader(System.in))).readLine();
		this.root=new Node(name);
	}
	public Tree()throws IOException{
		fr = new FileReader("a.data");
		br = new BufferedReader(fr);
		String a=br.readLine();
		a=br.readLine();
		this.root=new Node(a);
		makeTreeFromFile(root);
	}
	public void makeTreeFromFile(Node zz)throws IOException{
		String b=br.readLine();
		if(b.equals("Yes")){
			b=br.readLine();
			Node tree_y=new Node(b);
			zz.putYes(tree_y);
			makeTreeFromFile(tree_y);

			b=br.readLine();
			b=br.readLine();
			Node tree_n=new Node(b);
			zz.putNo(tree_n);
			makeTreeFromFile(tree_n);
		}
		else {
		}

	}


	public Node getRoot(){
		return root;
	}
	public void makeTree()throws IOException{
		while(true){
			Node pointer=root;
			while(true){
				if(pointer.checkItem()){
					if(pointer.askText()){
						pointer=pointer.getYes();
					}else{
						pointer=pointer.getNo();
					}
				} else {
					if(pointer.askText()){
						System.out.println("当たった");
						break;
					} else{
						pointer.expandTree();
						break;
					}
				}
			}
			System.out.println("続ける場合はyes,やめる場合はno");
			String zz =(new BufferedReader(new InputStreamReader(System.in))).readLine();
			if(zz.equals("no")){
				break;
			}
			else{
			}
		}
	}
	public void display(Node aa,String zz,int n){
		for(int i=0; i<n; i++){
			System.out.print("  ");
		}
		System.out.print(zz);
		System.out.println(aa.getText());
		if(aa.getYes()!=null){
			display(aa.getYes(),"Yes ",n+1);
		}
		if(aa.getNo()!=null){
			display(aa.getNo(),"No ",n+1);
		}
		else {
			return;
		}
	}
	public void writeTree(){
		try {
			FileWriter fw = new FileWriter("a.data");
			BufferedWriter bw =new BufferedWriter(fw);
			out = new PrintWriter(bw);
			writeNode("ROOT",root);
			out.close();
		} catch (IOException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeNode(String a, Node b){
		out.println(a);
		out.println(b.getText());
		if(b.getYes() !=null){
			writeNode("Yes",b.getYes());
		}
		if(b.getNo() !=null){
			writeNode("No",b.getNo());
		}
		else {
			out.println("NULL");
		}
	}


}

