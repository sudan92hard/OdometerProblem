import java.util.ArrayList;

class Odometer{
	ArrayList<Digit> digits;
	int numOfDigits;
	
	Odometer(int numOfDigits ){
		this.numOfDigits = numOfDigits;
		digits = getMinimumValue(numOfDigits);
	}
	
	boolean isAscendingCondition(ArrayList<Digit > digits){
		 
		for(int i = 0; i < digits.size() - 1; i++ )
		{
			if(digits.get(i).getValue() >= digits.get(i + 1).getValue())
			{
				return false;
			}
		}
		
		return true;
		
	}
	
	ArrayList<Digit> getMinValue(int numOfDigits){
		
		ArrayList<Digit> dgt = new ArrayList<Digit>();
		for ( int i = 0; i < numOfDigits ; i++){
			Digit d = new Digit(i);
			dgt.add(d);
		}
		return dgt;
	}
		
	ArrayList<Digit > getMaxValue(int numOfDigits){
		ArrayList<Digit> dgt = new ArrayList<Digit>();
		int j = 9;
		for ( int i = 0; i < numOfDigits ; i++){
			Digit d = new Digit(j--);
			dgt.add(d);
	}
	
	ArrayList<Digit> getNextValue(){
		
		Integer number;
		number = digitToNumber(digits,this.numOfDigits);
		while(!isAscendingCondition(numberToDigit(number)))
		{
			number ++;
			digits = numberToDigit(number);
		}
		 
		return digits;
		
	}
	
	ArrayList<Digit> numberToDigit(Integer number,int numOfDigits){
		
		ArrayList<Digit> digit = new ArrayList<Digit>();
		while(number > 0){
			
			Digit d = new Digit(number % 10);
			digit.add(d);
			number = number / 10;
			
		}
		Collections.reverse(digit);
		
		return digit;
	}
	
	Integer digitToNumber(ArrayList<Digit> digit,int numOfDigits){
		
		Integer number = new Integer(0);
		
		for(Digit dgt: digit)
		{
			number = number * 10 + dgt.getValue();
		}
		
		return number;
		
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
