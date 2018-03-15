import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Node {
	private String textData;
	private Node yesNode;
	private Node noNode;

	Node(String zz){
		textData =zz;
		yesNode = null;
		noNode = null;
	}

	public void putText(String zz){
		textData=zz;
	}
	public String getText(){
		return textData;
	}
	public Node getYes(){
		return yesNode;
	}
	public void putYes(Node a){
		yesNode=a;
	}
	public Node getNo(){
		return noNode;
	}
	public void putNo(Node a){
		noNode=a;
	}
	public boolean askText()throws IOException {
		System.out.println(textData+"ですか?");
		String name =(new BufferedReader(new InputStreamReader(System.in))).readLine();
		if(name.equals("yes")){
			return true;
		}
		else if(name.equals("no")){
			return false;
		}
		return false;
	}
	public boolean checkItem(){
		if(yesNode==null && noNode==null){
			return false;
		}
		else{
			return true;
		}

	}
	public void expandTree()throws IOException{
		Node a=new Node(textData);
		noNode=a;
		System.out.println("何を思い浮かべたか教えて下さい");
		String name2 =(new BufferedReader(new InputStreamReader(System.in))).readLine();
		Node b=new Node(name2);
		yesNode=b;
		System.out.println(this.noNode.textData+"ならnoで,"+this.yesNode.textData+"ならyesとなる質問を入力してください");
		String name3 =(new BufferedReader(new InputStreamReader(System.in))).readLine();
		this.textData=name3;

	}
}
