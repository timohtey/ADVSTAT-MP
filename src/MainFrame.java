import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class MainFrame extends JFrame {
	private BarGraphPanel graphPanel;
	private JTextField polynomial_textField;
	private JTextField intervalA_textField;
	private JTextField intervalB_textField;
	private JTextField iterations_textField;
	private JTextField threshold_textField;
	private JComboBox method_comboBox;
	
	public MainFrame() {
		initializeComponents();
		initializeFrame();
	}
	
	public void initializeFrame() {
		getContentPane().setLayout(null);
		this.getContentPane().setPreferredSize(new Dimension(660, 560));
		this.setVisible(true);
		this.setResizable(false);
		
		JLabel lblPolynomial = new JLabel("Polynomial:");
		lblPolynomial.setBounds(85, 420, 72, 14);
		getContentPane().add(lblPolynomial);
		
		polynomial_textField = new JTextField();
		polynomial_textField.setBounds(156, 420, 137, 20);
		getContentPane().add(polynomial_textField);
		polynomial_textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("x0:");
		lblNewLabel.setBounds(85, 445, 72, 14);
		getContentPane().add(lblNewLabel);
		
		intervalA_textField = new JTextField();
		intervalA_textField.setBounds(156, 445, 137, 20);
		getContentPane().add(intervalA_textField);
		intervalA_textField.setColumns(10);
		
		JLabel lblIntervalB = new JLabel("x1:");
		lblIntervalB.setBounds(85, 470, 60, 14);
		getContentPane().add(lblIntervalB);
		
		intervalB_textField = new JTextField();
		intervalB_textField.setBounds(156, 470, 137, 20);
		getContentPane().add(intervalB_textField);
		intervalB_textField.setColumns(10);
		
		JLabel lblIterations = new JLabel("Iterations:");
		lblIterations.setBounds(85, 495, 60, 14);
		getContentPane().add(lblIterations);
		
		iterations_textField = new JTextField();
		iterations_textField.setBounds(156, 495, 137, 20);
		getContentPane().add(iterations_textField);
		iterations_textField.setColumns(10);
		
		JLabel lblThreshold = new JLabel("Threshold:");
		lblThreshold.setBounds(85, 520, 60, 14);
		getContentPane().add(lblThreshold);
		
		threshold_textField = new JTextField();
		threshold_textField.setBounds(156, 520, 137, 20);
		getContentPane().add(threshold_textField);
		threshold_textField.setColumns(10);
		
		JLabel lblMethod = new JLabel("Method:");
		lblMethod.setBounds(389, 420, 46, 14);
		getContentPane().add(lblMethod);
		
		JComboBox method_comboBox = new JComboBox();
		method_comboBox.addItem("Bisection Method");
		method_comboBox.addItem("Regula Falsi Method");
		method_comboBox.addItem("Newton's Method");
		method_comboBox.addItem("Secant Method");
		method_comboBox.setBounds(445, 417, 137, 20);
		getContentPane().add(method_comboBox);
		
		JButton solve_button = new JButton("Solve Root");
		solve_button.setBounds(462, 516, 120, 23);
		getContentPane().add(solve_button);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
		this.pack();
	}
	
	public void initializeComponents() {
		graphPanel = new BarGraphPanel(new ArrayList<Double>(), 0, 0);
		graphPanel.setBounds(10, 11, 640, 395);
		getContentPane().add(graphPanel);
	}

	public String intervalA(){
		return polynomial_textField.getText();
	}
	
	public int intervalB(){
		return Integer.parseInt(intervalA_textField.getText());
	}
	
	public int getIterations(){
		return Integer.parseInt(iterations_textField.getText());
	}
	
	public int getThreshold(){
		return Integer.parseInt(threshold_textField.getText());
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

	public void setMethod_comboBox(JComboBox method_comboBox) {
		this.method_comboBox = method_comboBox;
	}
	
}
