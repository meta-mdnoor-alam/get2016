package Session1;

/**
 * POJO class to simulate the books table in the database
 * @author Noor
 */
public class Books {

	private int accessionNumber;
	private String titleId;
	private String purchaseDate;
	private float price;
	private String status;
	
	public void setAccessionNumber(int accessionNumber) {
		this.accessionNumber = accessionNumber;
	}
	
	public int getAccessionNumber() {
		return accessionNumber;
	}
	
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}
	
	public String getTitleId() {
		return titleId;
	}
	
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
