import java.util.ArrayList;
import java.util.Collections;

class Odometer{
	public ArrayList<Digit> digits;
	int numOfDigits;

	Odometer(int numOfDigits ){
		this.numOfDigits = numOfDigits;
		digits = getMinValue(numOfDigits);
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

		Collections.reverse(dgt);
		return dgt; 
	}

	ArrayList<Digit> getNextValue(){

		Integer number;
		number = odometerToNumber(digits,this.numOfDigits);
		number++;

		Integer maxValue = odometerToNumber(this.getMaxValue(this.numOfDigits), this.numOfDigits);

		while(!isAscendingCondition(numberToDigits(number)) && number != maxValue)
		{
			number++;
		}
		digits = new ArrayList<Digit >(numberToDigits(number));

		return digits;

	}

	ArrayList<Digit> numberToDigits(Integer number){

		ArrayList<Digit> digit = new ArrayList<Digit>();
		while(number > 0){

			Digit d = new Digit(number % 10);
			digit.add(d);
			number = number / 10;

		}

		if((digit.size() - 1) != this.numOfDigits)
		{
			digit.add(new Digit(0));
		}

		Collections.reverse(digit);
		return digit;
	}

	Integer odometerToNumber(ArrayList<Digit> digit,int numOfDigits){

		Integer number = new Integer(0);

		for(Digit dgt: digit)
		{
			number = number * 10 + dgt.getValue();
		}

		//System.out.println(number);

		return number;

	}

	/*public void printList(){
		
		Integer number1 = new Integer(digitToNumber(this.getMinValue(numOfDigits),this.numOfDigits));
		Integer maxValue = new Integer(digitToNumber(this.getMaxValue(numOfDigits), this.numOfDigits));
		
		while(number1 != maxValue && )
		{
			number1 = this.digitToNumber(nextValue, this.numOfDigits);
			
			for(Digit d: nextValue)
			{
				System.out.print(d.getValue());
			}
			System.out.println();
		}
	}*/

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

		int numOfDigits = 5;
		Odometer odometer = new Odometer(numOfDigits);
		for(Digit d: odometer.digits)
		{
			System.out.print(d.getValue());
		}
		System.out.println();
		//odometer.printList();
		for(Digit d: odometer.getNextValue())
		{
			System.out.print(d.getValue());
		}
		System.out.println();

	}

}
