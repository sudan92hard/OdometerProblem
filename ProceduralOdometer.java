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
		int minimunDistance = getMinimunDistance(digits);
		int maximumDistance = getMaximumDistance(digits);
		int nextDistance = getNextDistance(minimumDistance);
		ArrayList< Integer > = getListOfDistance(minimumDistance,maximumDistance);
	}
	
	public static boolean isValidDistance(String number){
		for(int i = 0; i < number.length() - 1; i++){
			if(number.charAt(i) >= number.charAt(i + 1))
				return false;
		}
		return true;
	}
}
