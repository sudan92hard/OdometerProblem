package odometerproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Odometer{
	public ArrayList<Digit> digits;
	int numOfDigits;
        Integer minValue;
        Integer maxValue;

	Odometer(int numOfDigits ){
		this.numOfDigits = numOfDigits;                
		digits = getMinValue(numOfDigits);
                minValue = odometerToNumber(this.getMinValue(this.numOfDigits));
		maxValue = odometerToNumber(this.getMaxValue(this.numOfDigits));
	}
        public String toString(){
            String s = "";
            for(Digit d: digits)
                    {
                        s += "" + d.getValue();
                    }
            return s;
        }
        
	void setDigits(ArrayList<Digit> d){
            digits = d;
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

	ArrayList<Digit> getMaxValue(int numOfDigits){
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
		number = odometerToNumber(digits);
                number++;
                
		while(!isAscendingCondition(numberToOdometer(number)))
		{
                    
                    if(number >= maxValue)
                    {
                        number = minValue;
                    }
                    else{
                        number++;
                    }
		}
                
               
		digits = new ArrayList<Digit >(numberToOdometer(number));

		return digits;
	}
        
	ArrayList<Digit> numberToOdometer(Integer number){

		ArrayList<Digit> digit = new ArrayList<Digit>();
		while(number > 0){

			Digit d = new Digit(number % 10);
			digit.add(d);
			number = number / 10;

		}

		if(digit.size() + 1 == this.numOfDigits)
		{
			digit.add(new Digit(0));
		}

		Collections.reverse(digit);
		return digit;
	}

	Integer odometerToNumber(ArrayList<Digit> digit){

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
                System.out.println("Number of digits : ");
                Scanner sc = new Scanner(System.in);
                int numOfDigits = sc.nextInt();
                if(numOfDigits > 10 || numOfDigits < 1){
                    System.out.println("Invalid number of digits");
                    return;
                }
                System.out.println("Odometer start value : ");
		
                Odometer odometer = new Odometer(numOfDigits);
                int odometerVal = sc.nextInt();
                odometer.setDigits(odometer.numberToOdometer(odometerVal));
                
		System.out.println("Number of odometer values : ");
                Scanner s = new Scanner(System.in);
                int printList = s.nextInt();
                
                while(printList != 0)
                {
                    odometer.getNextValue();
                    System.out.println(odometer);
                    printList--;
                }

	}

}
