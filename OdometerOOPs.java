import java.util.ArrayList;

class Odometer{
	ArrayList<Digit> digits;
	int numOfDigits;
	
	Odometer(int numOfDigits ){
		this.numOfDigits = numOfDigits;
		digits = getMinimumValue(numOfDigits);
	}
	
	boolean isAscendingCondition(){
		
	}
	
	ArrayList<Digit> getMinValue(int numOfDigits){
		
	}
		
	ArrayList<Digit > getMaxValue(int numOfDigits){
		
	}
	
	ArrayList<Digit> getNextValue(){
		
	}
	
}

class Digit{
	int value;
	Digit(int value){
		this.value = value;
	}
	
	int getValue(){
		return value;
	}
	void setValue(int value){
		this.value = value;
	}
	
}

public class OdometerProblem {

	
	public static void main(String[] args) {
		
		int numOfDigits = Integer.parseInt(args[1]);
		Odometer odometer = new Odometer(numOfDigits);
		System.out.println(getAllValues(Odometer));
	}

}