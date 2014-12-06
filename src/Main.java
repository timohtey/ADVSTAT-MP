
public class Main {
	public static void main(String[] args){
		MainFrame mainFrame = new MainFrame();
		NumericalMethod numericalMethod = new NumericalMethod();
		new Controller(numericalMethod, mainFrame);
	}
}
