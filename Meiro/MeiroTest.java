
public class MeiroTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Meiro meiro=new Meiro();
		if(meiro.walk(meiro.Iriguti())){
			System.out.println("goal");
		}
		else {
			System.out.println("goalできなかった");
		}
	}

}
