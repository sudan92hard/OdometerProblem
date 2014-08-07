class Odometer{
	Digit[] digits;
	int numOfDigits;
	
	Odometer(int numOfDigits ){
		this.numOfDigits = numOfDigits;
	}
	boolean CompareDigits(Digit d1, Digit d2){
		
	}
	int getNextValue( int distance){
		
		
	}
	int convertToNumber(Digit[] d){
		
	}
	void convertToDigitsAndUpdate(int num){
		
	}
	int getMinimumValue(){
		
	}
	int getMaxValue(){
		
	}
	String getAllValues(){
		
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
	void setValue(){}
	
}

public class OdometerProblem {

	
	public static void main(String[] args) {
		
		int numOfDigits = Integer.parseInt(args[1]);
		Odometer odometer = new Odometer(numOfDigits);
		System.out.println(odometer.getAllValues());
	}

}
