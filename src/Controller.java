import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controller {
	private NumericalMethod model;
	private MainFrame view;
	public Controller(NumericalMethod model, MainFrame view){
		this.model = model;
		this.view = view;
		
		view.addSolveListener(new SolveListener());
	}
	
	private class SolveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ArrayList<Integer> coefficients = new ArrayList<Integer>();
			ArrayList<Integer> powers = new ArrayList<Integer>();
			view.getPolynomial(coefficients, powers);
			model.setCoefficients(coefficients);
			model.setPowers(powers);
			switch(view.getMethod_comboBox()){
				case 1: model.getBisection(); break;
				case 2: model.getRegulaFalsi(); break;
				case 3: model.getNewton(); break;
				case 4: model.getSecant(); break;
			}
		}
	}
}
