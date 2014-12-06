import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;


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
			ArrayList<Double> roots = new ArrayList<Double>();
			
			view.getPolynomial(coefficients, powers);
			model.setCoefficients(coefficients);
			model.setPowers(powers);
			model.setX0(view.intervalA());
			model.setX1(view.intervalB());
			
			int type = 0;
			double value = 0;
			boolean correct = true;
			
			if(view.getIterations() != 0 && view.getThreshold() !=0){
				view.iterations_textField().setBackground(Color.RED);
				view.threshold_textField().setBackground(Color.RED);
				JOptionPane.showMessageDialog (null, "Choose only one!", "Error", JOptionPane.WARNING_MESSAGE);
				correct = false;
			} else if(view.getIterations() != 0){
				type = 1;
				value = view.getIterations();
				correct = true;
			} else if(view.getThreshold() != 0){
				type = 2;
				value = view.getThreshold();
				correct = true;
			}
			
			if(correct){
				view.iterations_textField().setBackground(Color.WHITE);
				view.threshold_textField().setBackground(Color.WHITE);
				
				switch(view.getMethod_comboBox()){
					case 1: model.getBisection(type, value); break;
					case 2: model.getRegulaFalsi(type, value); break;
					case 3: model.getNewton(type, value); break;
					case 4: roots = model.getSecant(type, value); break;
				}
			}
			
			String textAreaTxt = "";
			view.getTextArea().setText(null);
			for(int i = 0; i<roots.size(); i++){
				textAreaTxt+="x"+i+": " + roots.get(i)+"\n\r";
			}

			view.getTextArea().setText(textAreaTxt);
		}
	}
}
