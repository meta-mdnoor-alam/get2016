package Session5.ConcordanceOfCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to implement hash-map for storing the list of occurrence of characters of the input string indices with key values.
 * @author Noor
 *
 */
public class MapImplementor {

	private Map<Character, List<Integer>> concordanceOfCharactersMap;
	private List<Integer> indicesOfCharacterOccurenceList;
	
	/**
	 * Default constructor
	 */
	public MapImplementor() {
		concordanceOfCharactersMap=new HashMap<Character, List<Integer>>();
		indicesOfCharacterOccurenceList = new ArrayList<Integer>();
	}

	/** 
	 * @return the concordanceOfCharactersMap
	 */
	public Map<Character, List<Integer>> getConcordanceOfCharactersMap() {
		return concordanceOfCharactersMap;
	}

	/**
	 * @param concordanceOfCharactersMap the concordanceOfCharactersMap to set
	 */
	public void setConcordanceOfCharactersMap(Map<Character, List<Integer>> concordanceOfCharactersMap) {
		this.concordanceOfCharactersMap = concordanceOfCharactersMap;
	}

	/**
	 * @return the indicesOfCharacterOccurenceList
	 */
	public List<Integer> getIndicesOfCharacterOccurenceList() {
		return indicesOfCharacterOccurenceList;
	}

	/**
	 * @param indicesOfCharacterOccurenceList the indicesOfCharacterOccurenceList to set
	 */
	public void setIndicesOfCharacterOccurenceList(List<Integer> indicesOfCharacterOccurenceList) {
		this.indicesOfCharacterOccurenceList = indicesOfCharacterOccurenceList;
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
			for (int index = 0; index < inputStringLength; index++) {
				char character = inputString.charAt(index);
				indicesOfCharacterOccurenceList = concordanceOfCharactersMap.get(character);
				
				if(indicesOfCharacterOccurenceList==null) {
					indicesOfCharacterOccurenceList = new ArrayList<Integer>();
				}
				
				indicesOfCharacterOccurenceList.add(index);
				concordanceOfCharactersMap.put(character, indicesOfCharacterOccurenceList);
			}
		}
	}
}
