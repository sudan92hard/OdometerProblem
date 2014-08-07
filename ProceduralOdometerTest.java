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

}
