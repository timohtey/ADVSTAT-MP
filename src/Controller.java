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
			ArrayList<Double> polyRoots = new ArrayList<Double>();
			
			int count = 0;
			if(view.getPolynomial(coefficients, powers).equals("")){
				view.polynomial_textField().setBackground(Color.RED);
				count++;
			} if(view.intervalA() == 0){
				view.intervalA_textField().setBackground(Color.RED);
				count++;
			} if(view.intervalB() == 0 && view.getMethod_comboBox() != 3){
				view.intervalB_textField().setBackground(Color.RED);
				count++;
			} if(view.getIterations() == 0 && view.getThreshold() == 0){
				view.iterations_textField().setBackground(Color.RED);
				view.threshold_textField().setBackground(Color.RED);
				count++;
			}
			
			if(count != 0){
				JOptionPane.showMessageDialog (null, "Complete the fields!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
			model.setCoefficients(coefficients);
			model.setPowers(powers);
			model.setX0(view.intervalA());
			model.setX1(view.intervalB());
			
			int type = 0;
			double value = 0;
			boolean correct = false;
			
			if(count == 0){
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
			}
			
			if(correct){
				view.polynomial_textField().setBackground(Color.WHITE);
				view.intervalA_textField().setBackground(Color.WHITE);
				view.intervalB_textField().setBackground(Color.WHITE);
				view.iterations_textField().setBackground(Color.WHITE);
				view.threshold_textField().setBackground(Color.WHITE);
				
				switch(view.getMethod_comboBox()){
					case 1: roots = model.getBisection(type, value); break;
					case 2: roots = model.getRegulaFalsi(type, value); break;
					case 3: roots = model.getNewton(type, value); break;
					case 4: roots = model.getSecant(type, value); break;
				}
				polyRoots = model.getPolyRoots(value);
			}
			
			String textAreaTxt = "";
			view.getTextArea().setText(null);
			for(int i = 0; i<roots.size(); i++){
				textAreaTxt+="x"+i+": " + roots.get(i)+"\n\r";
			}

			view.getTextArea().setText(textAreaTxt);
			view.refresh(roots, polyRoots);
		}
	}
}
