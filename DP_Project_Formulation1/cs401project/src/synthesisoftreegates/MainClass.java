package synthesisoftreegates;


public class MainClass {

	public static void main(String[] args) {
		String PinFile=args[0];
		String GateLib=args[1];
		ReadFiles rd=new ReadFiles();
		rd.GateSynthesis(PinFile,GateLib);
//		rd.PostOrder(node);
	}
}
