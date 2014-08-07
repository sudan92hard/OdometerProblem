import java.io.*;
import java.util.*;

public class ProceduralOdometer {
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

	public static String getNextReading(String distance)
	{
		if(!isValidDistance(distance))
			return "Invalid Distance";
		
		
		if(distance.equals(getMaximumDistance(distance.length())))
			return "";
			
		int numOfDigits = distance.length();
		char[] charArrayDistance = distance.toCharArray();
		
		if(charArrayDistance[numOfDigits - 1] - '0' < 9)
		{
			charArrayDistance[numOfDigits - 1] += 1;
			//System.out.println(new String(charArrayDistance));
			return new String(charArrayDistance);
		}
		
		for(int i = numOfDigits - 1 ; i > 0 ; i--)
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
             while(!startReading.equals(endReading)) 
             {
                 readings.add(startReading);
                 startReading = getNextReading(startReading);
             }
             readings.add(endReading);
            return readings;
        }
	
	public static void main(String args[]){
		int digits = 4;
		String minimumDistance = getMinimumDistance(digits);
		String maximumDistance = getMaximumDistance(digits);
		String nextDistance = getNextReading(minimumDistance);
		List< String > readingList = getListOfReadings(minimumDistance,maximumDistance);
		System.out.println(readingList);
	}	
}
