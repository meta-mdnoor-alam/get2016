package Session1;

/**
 * To implement Operator class of Calculator.
 * @author Noor
 *
 */
public class Operator {
	
	int operatorId;
	double result;
	
	/**
	 * Parameterized constructor
	 * @param operatorId
	 */
	public Operator(int operatorId) {
		super();
		this.operatorId = operatorId;
	}
	
	/**
	 * Performs operations according to operator id
	 */
	public void performOperation(){
		
	}
	
	/**
	 * Getting the operator id
	 * @return Operator Id
	 */
	public int getOperatorId() {
		return operatorId;
	}

	/**
	 * Setting the operator id
	 * @param operatorId
	 */
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * send the final result 
	 * @return
	 */
	public double getResult() {
		return result;
	}
	
}
