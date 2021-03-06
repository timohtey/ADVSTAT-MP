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
		double c=0;
		roots = new ArrayList<Double>();
		roots.add(x0);
		double x, y;
		x = x0;
		y = x1;
		
		if(type == 1){
			for(int i = 0; i<value; i++){
				if((function(x)*function(y))!=0){
					
					c = (x+y)/2;
					if((function(x))*(function(c))>0){
						x = c;
						roots.add(x);
					}else {	
						y = c;
						roots.add(y);
					}
				}	
			}
		} else if(type == 2){
			if(function(x)*function(y)!=0){
				do{
					c = (x+y)/2;
					
					if(function(x)*function(c)>0){
						x = c;
						roots.add(x);
					}
					else{
						y = c;
						roots.add(y);
					}
					
				}while(c>value);
			}
			
		}
	
		return roots;
	}
	
	public ArrayList<Double> getRegulaFalsi(int type, double value){
		double a = function(x0);
		double c = 0;
		double next = 0;
		
		roots = new ArrayList<Double>();
		roots.add(x0);
		
		if (type == 1) {
			for (int i = 0; i < value; i++) {
				c = x1 - ((function(x1)*(x1-x0))/(function(x1)-function(x0)));
				roots.add(c);
				
				next = a * function(c);
				if (next <= 0){ 
					x1 = c;
				} else {
					x0 = c;
				}
			}
		}
		
		else if (type == 2) {
			do {
				c = x1 - ((function(x1)*(x1-x0))/(function(x1)-function(x0)));
				roots.add(c);
				
				next = a * function(c);
				if (next <= 0){ 
					x1 = c;
				} else {
					x0 = c;
				}
			} while (c <= value);
		}
		
		return roots;
	}
	
	public ArrayList<Double> getNewton(int type, double value){
		double newton = x0;
		roots = new ArrayList<Double>();
		roots.add(newton);
		
		if(type == 1){
			for(int i=0; i<value; i++){
				newton = newton-(function(newton)/derivative(newton));
				roots.add(newton);
			}
		}
		else if(type == 2){
			do{
				newton = newton-(function(newton)/derivative(newton));
				roots.add(newton);
			}while(newton >= value);
		}
		
		return roots;
	}
	

	public ArrayList<Double> getSecant(int type, double value){
		double secant = 0;
		roots = new ArrayList<Double>();
		roots.add(x0);
		double x, y;
		x = x0;
		y = x1;
		
		if(type == 1){
			for(int i = 0; i<value; i++){
				secant = y - ((function(y)*(y - x))/(function(y)-function(x)));
				roots.add(secant);
				x = y;
				y = secant;
			}
		} else if(type == 2){
			for(int i = 0; secant<=value; i++){
				secant = y - ((function(y)*(y - x))/(function(y)-function(x)));
				roots.add(secant);
				x = y;
				y = secant;
			}
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
	
	private double derivative(double x){
		double answer = 0;
		int holderCoef=0;
		int holderPwr=0;
		ArrayList<Integer> coef = new ArrayList<Integer>();
		ArrayList<Integer> pwr = new ArrayList<Integer>();
		
		for(int j=0; j<powers.size(); j++){
			if(powers.get(j)!=0){
				holderCoef = powers.get(j)*coefficients.get(j);
				holderPwr = powers.get(j)-1;
				coef.add(holderCoef);
				pwr.add(holderPwr);
			}
		}
		
		for(int i = 0; i<pwr.size(); i++){
			if(pwr.get(i) != 0){
				answer += coef.get(i) * Math.pow(x, pwr.get(i));
			} else {
				answer += coef.get(i);
			}
		}
		return answer;
	}
	
	public ArrayList<Double> getPolyRoots(double value){

		double c=0;
		ArrayList<Double> polyRoots = new ArrayList<Double>();
		System.out.println("X0:"+ x0 + " X1:"+ x1);
		
		for(double i = x0; i<=x1; i++){
			c = function(i);
			polyRoots.add(c);
			
			System.out.println("X:"+ i + " Y:"+ c);
		}
		
		return polyRoots;
	}
}
