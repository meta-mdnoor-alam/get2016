package Session5.ConcordanceOfCharacters;

import java.util.List;
import java.util.Map;

/**
 * Class to display the result of concordance of characters occurrences of string.
 * @author Noor
 */
public class DisplayConcordance {

	private MapImplementor mapObject;
	private StringBuffer inputString;
	private Map<Character, List<Integer>> map;
	private List<Integer> indicesList;
	
	/**
	 * Parameterized constructor
	 * @param inputString
	 */
	public DisplayConcordance(StringBuffer inputString) {
		this.inputString = inputString;
	}
	
	/**
	 * Method to display concordance of characters occurrences of string.
	 */
	public void displayConcordance() {
		mapObject = new MapImplementor();
		mapObject.computeConcordance(inputString);
		map = mapObject.getConcordanceOfCharactersMap();
		
		for (Map.Entry<Character, List<Integer>> mapEntryVariable : map.entrySet()) {
			indicesList = mapEntryVariable.getValue();
			System.out.print(mapEntryVariable.getKey()+" = [");
			for (Integer index : indicesList) {
				System.out.print(index+",");
			}
			System.out.print("],  ");
		}
	}
}
