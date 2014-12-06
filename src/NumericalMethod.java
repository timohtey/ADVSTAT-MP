import java.util.ArrayList;


public class NumericalMethod {
	private ArrayList<Double> roots;
	private ArrayList<Integer> coefficients;
	private ArrayList<Integer> powers;
	private double x0;
	private double x1;
	public NumericalMethod(){
		this.roots = new ArrayList<Double>();
		this.coefficients = new ArrayList<Integer>();
		this.powers = new ArrayList<Integer>();
		this.x0 = 0;
		this.x1 = 0;
	}
	
	public NumericalMethod(ArrayList<Integer> coefficients, ArrayList<Integer> powers, double x0, double x1){
		this.roots = new ArrayList<Double>();
		this.coefficients = coefficients;
		this.powers = powers;
		this.x0 = x0;
		this.x1 = x1;
	}
	
	public void setCoefficients(ArrayList<Integer> coefficients){
		this.coefficients = coefficients;
	}
	
	public void setPowers(ArrayList<Integer> powers){
		this.powers = powers;
	}
	
	public void setX0(double x0){
		this.x0 = x0;
	}
	
	public void setX1(double x1){
		this.x1 = x1;
	}
	
	public ArrayList<Double> getBisection(int type, double value){
		/**
		 * @CHELSEA
		 * ADD BISECTION METHOD CODE HERE
		 * IF TYPE = 1; THE USER CHOSE ITERATION
		 * IF TYPE = 2; THE USER CHOSE THRESHOLD
		 * USE FUNCTION(X) TO SUBSTITUTE THE VALUES TO THE POLYNOMIAL
		 * [x0, x1]
		 */
		return roots;
	}
	
	public ArrayList<Double> getRegulaFalsi(int type, double value){
		/**
		 * @RIO
		 * ADD REGULA FALSI METHOD CODE HERE
		 * IF TYPE = 1; THE USER CHOSE ITERATION
		 * IF TYPE = 2; THE USER CHOSE THRESHOLD
		 * USE FUNCTION(X) TO SUBSTITUTE THE VALUES TO THE POLYNOMIAL
		 * [x0, x1]
		 */
		return roots;
	}
	
	public ArrayList<Double> getNewton(int type, double value){
		/**
		 * @PAULETTE
		 * ADD NEWTON'S METHOD CODE HERE
		 * IF TYPE = 1; THE USER CHOSE ITERATION
		 * IF TYPE = 2; THE USER CHOSE THRESHOLD
		 * USE FUNCTION(X) TO SUBSTITUTE THE VALUES TO THE POLYNOMIAL
		 * Use x0
		 */
		return roots;
	}
	
	public ArrayList<Double> getSecant(int type, double value){
		double secant = 0;
		roots = new ArrayList<Double>();
		roots.add(x0);
		roots.add(x1);
		
		if(type == 1){
			for(int i = 0; i<value; i++){
				secant = x1 - ((function(x1)*(x1 - x0))/(function(x1)-function(x0)));
				roots.add(secant);
				x0 = x1;
				x1 = secant;
			}
		} else if(type == 2){
			for(int i = 0; secant<=value; i++){
				secant = x1 - ((function(x1)*(x1 - x0))/(function(x1)-function(x0)));
				roots.add(secant);
				x0 = x1;
				x1 = secant;
			}
			secant = x1 - ((function(x1)*(x1 - x0))/(function(x1)-function(x0)));
			roots.add(secant);
		}
	
		return roots;
	}

	private double function(double x) {
		double answer = 0;
		for(int i = 0; i<powers.size(); i++){
			if(powers.get(i) != 0){
				answer += coefficients.get(i) * Math.pow(x, powers.get(i));
			} else {
				answer += coefficients.get(i);
			}
		}
		return answer;
	}
}
