package Session5.ConcordanceOfCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to implement hash-map for storing the list of occurrence of characters of the input string indices with key values.
 * @author Noor
 */
public class MapImplementor {

	private Map<Character, List<Integer>> concordanceOfCharactersMap;
	
	/**
	 * Default constructor
	 */
	public MapImplementor() {
		concordanceOfCharactersMap=new HashMap<Character, List<Integer>>();
	}

	/** 
	 * @return the concordanceOfCharactersMap
	 */
	public Map<Character, List<Integer>> getConcordanceOfCharactersMap() {
		return concordanceOfCharactersMap;
	}
	
	/**
	 * Method to compute the occurrences of characters.
	 * @param inputString
	 */
	public void computeConcordance(StringBuffer inputString) {
		int inputStringLength=inputString.length();
		
		if (inputStringLength == 0) {
			System.out.println("Empty String");
			return;
		} else {
			for (int index = 0, indexWithoutWhiteSpace = 0; index < inputStringLength; index++) {
				char character = inputString.charAt(index);
				
				if (character == ' ') {
					continue;
				}
				
				List<Integer> indicesOfCharacterOccurenceList = concordanceOfCharactersMap.get(character);
				
				if(indicesOfCharacterOccurenceList==null) {
					indicesOfCharacterOccurenceList = new ArrayList<Integer>();
				}
				
				indicesOfCharacterOccurenceList.add(indexWithoutWhiteSpace++);
				concordanceOfCharactersMap.put(character, indicesOfCharacterOccurenceList);
			}
		}
	}
}
