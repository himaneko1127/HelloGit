import java.io.IOException;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Tree tree=new Tree();
		//Tree tree2=new Tree("動物");
		tree.makeTree();
		Node p=tree.getRoot();
		tree.display(p,"ROOT",0);
		tree.writeTree();

	}
}