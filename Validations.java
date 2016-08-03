package Session4;

/**
 * To perform various types of validations over the fields.
 * @author Noor
 */
public class Validations {

	public boolean validateType(String input) {
		if (input.equalsIgnoreCase("user") || input.equalsIgnoreCase("organisation")) {
			return true;
		}
		return false;
	}
	
	public boolean validateAge(int input) {
		if (input>0 && input<100) {
			return true;
		}
		return false;
	}
	
	public boolean validateGender(String input) {
		if (input.equalsIgnoreCase("Male") || input.equalsIgnoreCase("Female")) {
			return true;
		}
		return false;
	}
	
	public boolean validateNameCity(String input) {
		if (input.chars().allMatch(x->Character.isLetter(x))) {
			return true;
		}
		return false;
	}
	
	public boolean validateSector(String input) {
		if (input.equalsIgnoreCase("private") || input.equalsIgnoreCase("public")) {
			return true;
		}
		return false;
	}
	
}
