package Session4;

import java.util.ArrayList;
import java.util.List;

/**To generate all possible permutations of given letters in string.
 * @author Noor
 */
public class StringPermutation {

	List<String> stringPermute=new ArrayList<String>();
	
	/**
	 * To swap characters of a string.
	 * @param string String on which the swapping is performed
	 * @param indexFirst First index of the string from which to swap
	 * @param indexSecond Second index of the string on which swap to be done
	 * @return swapped characters of the string
	 */
	public StringBuffer swapStringCharacters(StringBuffer string, int indexFirst, int indexSecond) {
		
		char temp=string.charAt(indexFirst);
		string.setCharAt(indexFirst, string.charAt(indexSecond));
		string.setCharAt(indexSecond, temp);

		return string;
	}
	
	/**
	 * Function to generate all permutation of a string recursively.
	 * @param inputString Input string of which all permutations has to be done
	 * @param starting index of the string from which swapping will take place for permutations
	 * @param ending index of the string upto which swapping will be done for permutation
	 * @return list of permuted string.
	 */
	public List<String> generatePermutationOfString(StringBuffer inputString, int startIndex, int endIndex) {
		if (startIndex==endIndex) {
			stringPermute.add(inputString.toString());
		}
		
		for (int i = startIndex; i <= endIndex; i++) {
			inputString=swapStringCharacters(inputString, startIndex, i);
			stringPermute=generatePermutationOfString(inputString, startIndex+1, endIndex);
			inputString=swapStringCharacters(inputString, startIndex, i);
		}
		
		return stringPermute;
	}
}
