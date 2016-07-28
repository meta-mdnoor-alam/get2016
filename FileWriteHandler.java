package Session4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to write a new node on the file
 * @author Noor
 *
 */
public class FileWriteHandler {
	
	String fileName;
	BufferedWriter fileObject;
	
	public FileWriteHandler(String fileName) {
		this.fileName=fileName;
		fileObject=null;
	}
	
	private boolean canWrite() {
		try {
			fileObject=new BufferedWriter(new FileWriter(fileName, true));
			return true;
		} catch (Exception e) {
			System.out.println("Somthing went wrong. "+e.getMessage());
			return false;
		}
	}
	
	public boolean writeUserNode(UserNode userNode) throws IOException {
		if (canWrite()==true) {
			String singleNode;
			singleNode=userNode.getNodeId()+","+userNode.getProfile().getName()+","+userNode.getUserProfile().getGender()+","+
					   userNode.getProfile().getCity()+","+userNode.getType()+","+userNode.getUserProfile().getAge();
			fileObject.newLine();
			fileObject.write(singleNode);
			return true;
		}
		return false;
	}
	
	public boolean writeOrgNode(OrganisationNode orgNode) throws IOException {
		if (canWrite()==true) {
			String singleNode;
			singleNode=orgNode.getNodeId()+","+orgNode.getProfile().getName()+","+orgNode.getOrganisationProfile().getSector()+","+
					   orgNode.getProfile().getCity()+","+orgNode.getType();
			fileObject.newLine();
			fileObject.write(singleNode);
			return true;
		}
		return false;
	}
	
	public boolean writeConnection(UserNode firstNode, UserNode secondNode) throws IOException {
		if (canWrite()==true) {
			String connection=firstNode.getNodeId()+"-"+secondNode.getNodeId();
			fileObject.newLine();
			fileObject.write(connection);
			return true;
		}
		return false;
	}
}
