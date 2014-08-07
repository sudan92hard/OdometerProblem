import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class OdometerProblemTest {
	ArrayList<Object> list1;
	ArrayList<Object> list2;
	ArrayList<Object> list3;

	public void testFileIsAscending() throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("AscendingTestFile"));
		String line;
		list1 = new ArrayList<Object> ();
		while((line = br.readLine()) != null)
		{
			String s[] = line.split(";");
			String inp[] = s[0].split(" ");
			String output = s[1].replaceAll(" ", "");
			ArrayList<Integer> digits = new ArrayList<Integer>();
			for(int i = 0; i < inp.length; i++){
				inp[i] = inp[i].replace(" ", "");
				digits.add(Integer.parseInt(inp[i]));
			}
			list1.add(digits);
			list1.add(output);
		}
		br.close();
	}
	public void testFileMaxValue() throws Exception{
	
		BufferedReader br = new BufferedReader(new FileReader("GetMaxValueTest"));
		String line;
		list2 = new ArrayList<Object> ();
		while((line = br.readLine()) != null)
		{
			String s[] = line.split(";");
			String inp = s[0].replaceAll(" ", "");
			int input = Integer.parseInt(inp);
			String output[] = s[1].split(" ");
			ArrayList<Integer> digits = new ArrayList<Integer>();
			for(int i = 1; i < output.length; i++){
				output[i] = output[i].replace(" ", "");
				digits.add(Integer.parseInt(output[i]));
			}
			list2.add(input);
			list2.add(digits);
		}
		br.close();
	}
	public void testFileMinValue() throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader("GetMinValueTest"));
		String line;
		list3 = new ArrayList<Object> ();
		while((line = br.readLine()) != null)
		{
			String s[] = line.split(";");
			String inp = s[0].replaceAll(" ", "");
			int input = Integer.parseInt(inp);
			String output[] = s[1].split(" ");
			ArrayList<Integer> digits = new ArrayList<Integer>();
			for(int i = 1; i < output.length; i++){
				output[i] = output[i].replace(" ", "");
				digits.add(Integer.parseInt(output[i]));
			}
			list3.add(input);
			list3.add(digits);
		}
		br.close();
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testIsAscending() {
		
		Odometer odometer = new Odometer(0);
		
		for(int i = 0; i < list1.size() -1; i += 2){
			ArrayList<Integer> numbers = (ArrayList<Integer>) list1.get(i);
			ArrayList<Digit> digits = new ArrayList<Digit>();
			for(int k =0; k < numbers.size(); k++){
				digits.add(new Digit(numbers.get(i)));
			}
			String output = (String) list1.get(i+ 1);
			assertEquals(output, odometer.isAscendingCondition(digits));
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testGetMaxValue() {
		
		Odometer odometer = new Odometer(0);
		for(int i = 0; i < list2.size() -1; i += 2){
			int input = (int) list2.get(i);
			ArrayList<Integer> numbers = (ArrayList<Integer>) list2.get(i);
			ArrayList<Digit> digits = new ArrayList<Digit>();
			for(int k =0; k < numbers.size(); k++){
				digits.add(new Digit(numbers.get(i)));
			}
			assertEquals(digits, odometer.getMaxValue(input));
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testGetMinValue() {
		
		Odometer odometer = new Odometer(0);
		for(int i = 0; i < list3.size() -1; i += 2){
			int input = (int) list3.get(i);
			ArrayList<Integer> numbers = (ArrayList<Integer>) list3.get(i);
			ArrayList<Digit> digits = new ArrayList<Digit>();
			for(int k =0; k < numbers.size(); k++){
				digits.add(new Digit(numbers.get(i)));
			}
			assertEquals(digits, odometer.getMaxValue(input));
		}
	}
	

}