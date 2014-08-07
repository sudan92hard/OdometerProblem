import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ProceduralOdometer {

	public static void main(String args[]){
		int digits = Integer.parseInt(args[1]);
		String minimunDistance = getMinimunDistance(digits);
		String maximumDistance = getMaximumDistance(digits);
		String nextDistance = getNextDistance(minimumDistance);
		ArrayList< String > = getListOfDistance(minimumDistance,maximumDistance);
		List<String> readingsList = getReadingsUptoNKm(String startReading, int numOfReading);
	}
	
	public static boolean isValidDistance(String number){
		for(int i = 0; i < number.length() - 1; i++){
			if(number.charAt(i) >= number.charAt(i + 1))
				return false;
		}
		return true;
	}
	
	public static String getMinimumDistance(int digits){
		if(digits <= 0 || digits > 10)
			return "";
		
		String number = "";
		
		for(int i = 0; i < digits; i++){
			number += i;
		}		
		return number;
	}
	
	public static String getMaximumDistance(int digits){
		if(digits <= 0 || digits > 10)
			return "";
		
		String number = "";
		
		for(int i = digits; i > 0; i--){
			number += (10 - i);
		}		
		return number;
	}
	public static List<String> getReadingsUptoNKm(String startReading, int numOfReading){
		List<String> readings = new ArrayList<String>();
		for(int i = 0; i < numOfReading; i++){
			readings.add(startReading);
			startReading = getNextReading(startReading);
			
		}
		return readings;
	}
	
	public static String getNextDistance(String distance)
	{
		int numOfDigits = distance.length();
		char[] charArrayDistance = distance.toCharArray();
		
		if(charArrayDistance[numOfDigits - 1] - '0' < 9)
		{
			charArrayDistance[numOfDigits - 1] += 1;
			//System.out.println(new String(charArrayDistance));
			return new String(charArrayDistance);
		}
		
		for(int i = numOfDigits - 1 ; i >= 0 ; i--)
		{
			if(charArrayDistance[i] - charArrayDistance[i - 1] > 1)
			{
				charArrayDistance[i - 1] += 1;
				for(int j = i ; j < numOfDigits ; j++)
				{
					charArrayDistance[j] = (char) (charArrayDistance[j-1] + 1);
				}
				break;	
			}
			
		}
	
		return new String(charArrayDistance);
	}
	
	static List<String> getListOfReadings(String startReading, String endReading)
        {
             List<String> readings = new ArrayList<String>();
             if(!isValidDistance(startReading) || !isValidDistance(endReading))
             {
                 return readings;
             }
             while(Integer.parseInt(startReading) <= Integer.parseInt(endReading)) 
             {
                 readings.add(startReading);
                 startReading = getNextReading(startReading);
             }
            return readings;
        }
}
