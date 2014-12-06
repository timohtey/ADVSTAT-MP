
public class Main {
	public static void main(String[] args){
		MainFrame mainFrame = new MainFrame();
		NumericalMethod numericalMethod = new NumericalMethod();
		switch(mainFrame.getMethod_comboBox()){
		case 1: numericalMethod.getBisection(); break;
		case 2: numericalMethod.getRegulaFalsi(); break;
		case 3: numericalMethod.getNewton(); break;
		case 4: numericalMethod.getSecant(); break;
		}
	}
}
