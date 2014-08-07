import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
		int index = 0;
		while((line = br.readLine()) != null)
		{
			//System.out.println(index++);
			String s[] = line.split(";");
			String inp[] = s[0].split(" ");
			//String output = s[1].replaceAll(" ", "");
			String output = s[1];
			ArrayList<Integer> digits = new ArrayList<Integer>();
			for(int i = 0; i < inp.length; i++){
				inp[i] = inp[i].replace(" ", "");
				digits.add(Integer.parseInt(inp[i]));
			}
			//System.out.println(digits);
			list1.add(digits);
			list1.add(output);
		}
		//System.out.println(list1.get(2));
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testFileIsAscending();
		testFileMaxValue();
		testFileMinValue();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsAscendingCondition() {
		Odometer odometer = new Odometer(0);		
		for(int i = 0; i < list1.size() -1; i += 2){
			ArrayList<Integer> numbers = (ArrayList<Integer>) list1.get(i);
			ArrayList<Digit> digits = new ArrayList<Digit>();
			for(int k = 0; k < numbers.size(); k++){
				digits.add(new Digit(numbers.get(k)));
			}
			String output = (String) list1.get(i+ 1);
			assertEquals(Boolean.parseBoolean(output), odometer.isAscendingCondition(digits));
		}
	}

	@Test
	public void testGetMinValue() {
		Odometer odometer = new Odometer(0);
		for(int i = 0; i < list3.size() -1; i += 2){
			int input = (int) list3.get(i);
			ArrayList<Integer> numbers = (ArrayList<Integer>) list3.get(i + 1);
			ArrayList<Digit> digits = new ArrayList<Digit>();
			for(int k =0; k < numbers.size(); k++){
				digits.add(new Digit(numbers.get(k)));
			}
			ArrayList<Digit> out = odometer.getMaxValue(input);
			for(int j = 0; j < digits.size(); j++){
				assertEquals(digits.get(j).getValue(), out.get(j).getValue());
			}
			//assertEquals(digits, odometer.getMaxValue(input));
		}
	}

	@Test
	public void testGetMaxValue() {
		Odometer odometer = new Odometer(0);
		for(int i = 0; i < list2.size() -1; i += 2){
			int input = (int) list2.get(i);
			ArrayList<Integer> numbers = (ArrayList<Integer>) list2.get(i + 1);
			ArrayList<Digit> digits = new ArrayList<Digit>();
			for(int k =0; k < numbers.size(); k++){
				digits.add(new Digit(numbers.get(k)));
			}
			ArrayList<Digit> out = odometer.getMaxValue(input);
			for(int j = 0; j < digits.size(); j++){
				assertEquals(digits.get(j).getValue(), out.get(j).getValue());
			}
			//assertEquals(digits, odometer.getMaxValue(input));
		}
	}

	@Test
	public void testGetNextValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumberToDigit() {
		fail("Not yet implemented");
	}

	@Test
	public void testDigitToNumber() {
		fail("Not yet implemented");
	}

}
