import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


public class ProceduralOdometerTest {

	@Test
	public void testIsValid() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("valid.txt"));
        String token = ""; 
        
        while((token = br.readLine()) != null){
 			assertTrue(ProceduralOdometer.isValidDistance(token));
 		}
        
        //make for false also
        
	}
	
	@Test
	public void testGetMinimumDistance() throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("minimum.txt"));
        String token = "";   
        
        while((token = br.readLine()) != null){
        	String tokens[] = token.split(" ");
 			assertEquals(tokens[1], ProceduralOdometer.getMinimumDistance(Integer.parseInt(tokens[0])));
 		}
	}
	
	@Test
	public void testGetMaximumDistance() throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("maximum.txt"));
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
		BufferedReader br = new BufferedReader(new FileReader("getNextDistanceInput.txt"));
		String line;
	    	while((line = br.readLine()) != null)
	    	{
	    		getNextDistanceInput.add(line);
	    	}
	    	
	    	br = new BufferedReader(new FileReader("getNextDistanceExpectedOutput.txt"));
			while((line = br.readLine()) != null)
	    	{
				getNextDistanceExpectedOutput.add(line);
	    	}
		
		for(int i = 0 ; i < getNextDistanceInput.size() ; i++)
		{
			//System.out.println(getNextDistanceExpectedOutput.get(i) + "  " + odometerObj.getNextDistance(getNextDistanceInput.get(i)));
			assertTrue(getNextDistanceExpectedOutput.get(i).equals(odometerObj.getNextDistance(getNextDistanceInput.get(i))));
		}
	}

}
