package Session2;

/**To validate user given inputs.
 * @author Noor
 */
public class ValidateInput {

	/**
	 * @param questionNo
	 * @param response
	 * @return valid response for any question or not
	 */
	public boolean isValidResponse(int questionNo, String response) {
		if (questionNo==1 && response.length()>0) {  //For Question1, which is Text type.
			if (response.chars().allMatch(s->Character.isLetter(s))) {
				return true;
			}
			return false;
		} else if (questionNo==2 && response.length()>0) {      //For Question2, which is Numeric type.
			if (response.chars().allMatch(s->Character.isDigit(s))) {
				return true;
			}
			return false;
		} else if (questionNo==3 && response.length()==1 && response.chars().allMatch(s->Character.isDigit(s))) {  //For Question3, which is Single Select type.
			if (Integer.parseInt(response)>=1 && Integer.parseInt(response)<=5) {
				return true;
			}
			return false;
		} else if (questionNo==4 && response.length()>0) {  //For Question4, which is Multi Select type.
			String[] temp=response.split("[/]");
			int noOfMultiAnswered=0;
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].equalsIgnoreCase("Service Quality") || temp[i].equalsIgnoreCase("Communication") || temp[i].equalsIgnoreCase("Delivery Process")) {
					noOfMultiAnswered++;
				}
			}
			if (noOfMultiAnswered==temp.length) {
				return true;
			}
			return false;
		} else if (questionNo==5 && response.length()>0) {  //For Question5, which is Text type.
			return true;
		} else {
			return false;
		}
	}
}
