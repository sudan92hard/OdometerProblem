import java.io.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class ListOfReadingsTest{

	static ArrayList<String> startReading = new ArrayList<String>();
	static ArrayList<String> endReading = new ArrayList<String>();
	static ArrayList<ArrayList<String>> expectedReadings = new ArrayList<ArrayList<String>>();
	ProceduralOdometer odo = new ProceduralOdometer();
	@Before
	public  void readRangeInput() throws FileNotFoundException
	{
		Scanner sc = new Scanner(new FileReader("inputRange"));
		String line;
		ArrayList<String> readingList;
		while(sc.hasNext())
		{
			readingList = new ArrayList<String>();
			line = sc.nextLine();
			String lineToken[] = line.split(" ");
			startReading.add(lineToken[0]);
			endReading.add(lineToken[1]);
			String reading[] = lineToken[2].split(","); 
			Collections.addAll(readingList, reading);
			expectedReadings.add(readingList);


		}
	}
	@Test
	public  void getListOfReadingsTest()
	{
		List<String> listOfReading = new ArrayList<String>();
		for(int i = 0; i < startReading.size(); i++)
		{
			listOfReading = odo.getListOfReadings(startReading.get(i),endReading.get(i));
			for(int j = 0; j < expectedReadings.get(i).size(); j++)
			{
				assertEquals(listOfReading.get(j), expectedReadings.get(i).get(j));
			}
		}
	}

	@Test
	public void testIsValid() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("valid"));
		String token = "";

		while((token = br.readLine()) != null){
			assertTrue(ProceduralOdometer.isValidDistance(token));
		}

		//make for false also

	}

	@Test
	public void testGetMinimumDistance() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader("minimum"));
		String token = "";

		while((token = br.readLine()) != null){
			String tokens[] = token.split(" ");
			assertEquals(tokens[1], ProceduralOdometer.getMinimumDistance(Integer.parseInt(tokens[0])));
		}
	}

	@Test
	public void testGetMaximumDistance() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader("maximum"));
		String token = "";

		while((token = br.readLine()) != null){
			String tokens[] = token.split(" ");
			assertEquals(tokens[1], ProceduralOdometer.getMaximumDistance(Integer.parseInt(tokens[0])));
		}
	}

	@Test
	public void testgetNextDistance() throws IOException {
		ProceduralOdometer odometerObj = new ProceduralOdometer();

		ArrayList <String> getNextDistanceInput = new ArrayList<String>();
		ArrayList <String> getNextDistanceExpectedOutput = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("getNextDistanceInput"));
		String line;
		while((line = br.readLine()) != null)
		{
			getNextDistanceInput.add(line);
		}

		br = new BufferedReader(new FileReader("getNextDistanceExpectedOutput"));
		while((line = br.readLine()) != null)
		{
			getNextDistanceExpectedOutput.add(line);
		}

		for(int i = 0 ; i < getNextDistanceInput.size() ; i++)
		{
			assertTrue(getNextDistanceExpectedOutput.get(i).equals(odo.getNextReading(getNextDistanceInput.get(i))));
		}
	}
}
