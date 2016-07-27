package Session4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to write a new node on the file
 * @author Noor
 *
 */
public class FileNodeWriter {
	
	String fileName;
	BufferedWriter fileObject;
	
	public FileNodeWriter(String fileName) {
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
	
	public boolean writeNode(Node node) throws IOException {
		if (canWrite()==true) {
			String singleNode=node.getNodeId()+","+node.getName()+","+node.getGender()+","+node.getCity()+","+node.getType();
			fileObject.newLine();
			fileObject.write(singleNode);
			return true;
		}
		return false;
	}
	
	public boolean writeConnection(Node firstNode, Node secondNode) throws IOException {
		if (canWrite()==true) {
			String connection=firstNode.getNodeId()+"-"+secondNode.getNodeId();
			fileObject.newLine();
			fileObject.write(connection);
			return true;
		}
		return false;
	}
}
