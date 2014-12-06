import java.util.ArrayList;


public class NumericalMethod {
	private ArrayList<Double> roots;
	private ArrayList<Integer> coefficients;
	private ArrayList<Integer> powers;
	private double x0;
	private double x1;
	public NumericalMethod(){
		
	}
	
	public NumericalMethod(ArrayList<Integer> coefficients, ArrayList<Integer> powers, double x0, double x1){
		this.roots = new ArrayList<Double>();
		this.coefficients = coefficients;
		this.powers = powers;
		this.x0 = x0;
		this.x1 = x1;
	}
	
	public void getBisection(){
		
	}
	
	public void getRegulaFalsi(){
		
	}
	
	public void getNewton(){
		
	}
	
	public void getSecant(){
		double secant = 0;
		for(int i = 0; i</*threshold or iterations*/0; i++){
			secant = x1 - ( (function(x1)*(x1 - x0))/(function(x1)-function(x0)));
			roots.add(secant);
			x0 = x1;
			x1 = secant;
		}
	}

	private double function(double x) {
		double answer = 0;
		for(int i = 0; i<powers.size(); i++){
			answer += coefficients.get(i) * Math.pow(x, powers.get(i));
		}
		return answer;
	}
}
