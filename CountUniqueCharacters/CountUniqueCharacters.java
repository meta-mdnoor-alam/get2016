package Session6.CountUniqueCharacters;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class to count the unique characters in string and cache the strings if already passed.
 * @author Noor
 */
public class CountUniqueCharacters {

	private Map<String, Integer> cache;
	private Set<Character> uniqueCharacterSet;
	
	public CountUniqueCharacters() {
		cache = new HashMap<String, Integer>();
	}
	
	/**
	 * Method to count the number of unique characters in a string
	 * @param value - The string in which the unique character number is to be found
	 * @return The number of unique characters in the string
	 */
	public int countUniqueCharacters(String inputString) {
		if(cache.containsKey(inputString)) {		//Checking if the string was previously passed
			System.out.println("\nString is already present in cache");
			return cache.get(inputString);
		}
		
		uniqueCharacterSet = new TreeSet<Character>();
		int inputStringLength = inputString.length();
		
		for(int index=0; index < inputStringLength; index++) {
			if (inputString.charAt(index) == ' ') {
				continue;
			}
			uniqueCharacterSet.add(inputString.charAt(index));
		}
		
		cache.put(inputString, uniqueCharacterSet.size());
		
		return uniqueCharacterSet.size();
	}
}
