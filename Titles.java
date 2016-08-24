package Session1;

/**
 * POJO class to simulate the titles table in the database
 * @author Noor
 */
public class Titles {

	private String titleId;
	private String titleName;
	private String subjectId;
	private String publisherId;
	
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}
	
	public String getTitleId() {
		return titleId;
	}
	
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public String getTitleName() {
		return titleName;
	}
	
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getSubjectId() {
		return subjectId;
	}
	
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	public String getPublisherId() {
		return publisherId;
	}
}
