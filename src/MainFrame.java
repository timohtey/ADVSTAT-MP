import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private BarGraphPanel graphPanel;
	private JTextField polynomial_textField;
	private JTextField intervalA_textField;
	private JTextField intervalB_textField;
	private JTextField iterations_textField;
	private JTextField threshold_textField;
	private JComboBox<String> method_comboBox;
	private JButton solve_button;
	private JTextArea textArea;
	
	public MainFrame() {		
		initializeComponents();
		initializeFrame();
	}
	
	public void initializeFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.getContentPane().setPreferredSize(new Dimension(660, 560));
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		
		JLabel lblPolynomial = new JLabel("Polynomial:");
		lblPolynomial.setBounds(10, 429, 72, 14);
		getContentPane().add(lblPolynomial);
		
		polynomial_textField = new JTextField();
		polynomial_textField.setBounds(81, 429, 137, 20);
		getContentPane().add(polynomial_textField);
		polynomial_textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("x0:");
		lblNewLabel.setBounds(10, 454, 72, 14);
		getContentPane().add(lblNewLabel);
		
		intervalA_textField = new JTextField();
		intervalA_textField.setBounds(81, 454, 137, 20);
		getContentPane().add(intervalA_textField);
		intervalA_textField.setColumns(10);
		
		JLabel lblIntervalB = new JLabel("x1:");
		lblIntervalB.setBounds(10, 479, 60, 14);
		getContentPane().add(lblIntervalB);
		
		intervalB_textField = new JTextField();
		intervalB_textField.setBounds(81, 479, 137, 20);
		getContentPane().add(intervalB_textField);
		intervalB_textField.setColumns(10);
		
		JLabel lblIterations = new JLabel("Iterations:");
		lblIterations.setBounds(10, 504, 60, 14);
		getContentPane().add(lblIterations);
		
		iterations_textField = new JTextField();
		iterations_textField.setBounds(81, 504, 137, 20);
		getContentPane().add(iterations_textField);
		iterations_textField.setColumns(10);
		
		JLabel lblThreshold = new JLabel("Threshold:");
		lblThreshold.setBounds(10, 529, 60, 14);
		getContentPane().add(lblThreshold);
		
		threshold_textField = new JTextField();
		threshold_textField.setBounds(81, 529, 137, 20);
		getContentPane().add(threshold_textField);
		threshold_textField.setColumns(10);
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setBounds(228, 429, 46, 14);
		getContentPane().add(lblMethod);
		
		method_comboBox = new JComboBox<String>();
		method_comboBox.addItem("Bisection Method");
		method_comboBox.addItem("Regula Falsi Method");
		method_comboBox.addItem("Newton's Method");
		method_comboBox.addItem("Secant Method");
		method_comboBox.setBounds(274, 426, 137, 20);
		getContentPane().add(method_comboBox);
		
		solve_button = new JButton("Solve Root");
		solve_button.setBounds(274, 453, 137, 23);
		getContentPane().add(solve_button);
		
		JLabel lblRootValues = new JLabel("Root Values:");
		lblRootValues.setBounds(421, 429, 82, 14);
		getContentPane().add(lblRootValues);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(421, 454, 229, 95);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		this.pack();
	}
	
	public void initializeComponents() {
		graphPanel = new BarGraphPanel(new ArrayList<Double>(), new ArrayList<Double>(),new ArrayList<Integer>(), new ArrayList<Integer>());
		graphPanel.setBounds(0, 0, 660, 400);
		getContentPane().add(graphPanel);
	}

	public BarGraphPanel getBarGraphPanel(){
		return graphPanel;
	}
	public String getPolynomial(ArrayList<Integer> coefficient, ArrayList<Integer> powers){
		String polynomial = polynomial_textField.getText();
		boolean negative = false;
		String number = new String();
		if(polynomial.equals("") == false){
			int j = 0;
			for(int i = 0; i<polynomial.length(); i++){
				System.out.println(j);
				if(polynomial.charAt(i) != ' ' && polynomial.charAt(i) != '-'){
					number = number + Character.toString(polynomial.charAt(i));
				} else if(polynomial.charAt(i) == '-'){
					negative = true;
				} else if(polynomial.charAt(i) == ' '){
					if(j%2 == 0){
						if(negative == true){
							coefficient.add(Integer.parseInt(number)*-1);
							negative = false;
							j++;
						} else {
							coefficient.add(Integer.parseInt(number));
							j++;
						}
					} else{
						powers.add(Integer.parseInt(number));
						j++;
					}
					number = new String();
				}
			}
			if(coefficient.size()!=powers.size() && j%2 != 0){
				powers.add(Integer.parseInt(number));
			}
			
		}
		
		/*for(int l=0; l<coefficient.size(); l++){
			System.out.println("Coefficient " + l + ": " + coefficient.get(l));
			System.out.println("Power " + l + ": " + powers.get(l));
		}*/
		return polynomial;
	}
	
	public JTextField polynomial_textField(){
		return polynomial_textField;
	}
	
	public JTextField intervalA_textField(){
		return intervalA_textField;
	}
	
	public JTextField intervalB_textField(){
		return intervalB_textField;
	}
	public JTextField iterations_textField(){
		return iterations_textField;
	}
	
	public JTextField threshold_textField(){
		return threshold_textField;
	}
	
	public float intervalA(){
		float intervalA = 0;
		if(intervalA_textField.getText().equals("") == false){
			intervalA = Float.parseFloat(intervalA_textField.getText());
		}
		return intervalA;
	}
	
	public float intervalB(){
		float intervalB = 0;
		if(intervalB_textField.getText().equals("") == false){
			intervalB = Float.parseFloat(intervalB_textField.getText());
		}
		return intervalB;
	}
	
	public int getIterations(){
		int iteration = 0;
		if(iterations_textField.getText().equals("") == false){
			iteration = Integer.parseInt(iterations_textField.getText());
		}
		return iteration;
	}
	
	public double getThreshold(){
		double threshold = 0;
		if(threshold_textField.getText().equals("") == false){
			threshold = Double.parseDouble(threshold_textField.getText());
		}
		return threshold;
	}

	public int getMethod_comboBox() {
		String method = method_comboBox.getSelectedItem().toString();
		int choice = 0;
		switch(method){
			case "Bisection Method": choice = 1; break;
			case "Regula Falsi Method": choice = 2; break;
			case "Newton's Method": choice = 3; break;
			case "Secant Method": choice = 4; break;
		}
		return choice;
	}
	
	public JTextArea getTextArea(){
		return textArea;
	}

	public void setMethod_comboBox(JComboBox<String> method_comboBox) {
		this.method_comboBox = method_comboBox;
	}
	
	public void addSolveListener(ActionListener listener){
		solve_button.addActionListener(listener);
	}
	
	public void refresh(ArrayList<Double> roots, ArrayList<Double> polyRoots, ArrayList<Integer> coefficients, ArrayList<Integer> powers){
		graphPanel = new BarGraphPanel(roots, polyRoots, coefficients, powers);
		getContentPane().add(graphPanel);
		graphPanel.revalidate();
		graphPanel.repaint();
	}
}
