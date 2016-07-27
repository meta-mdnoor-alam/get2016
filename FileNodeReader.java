package Session4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * To read a node from file.
 * @author Noor
 */
public class FileNodeReader {

	String fileName;
	List<Node> node;
	BufferedReader fileObject;
	
	public FileNodeReader(String fileName) {
		this.fileName=fileName;
		node=null;
		fileObject=null;
	}
	
	private boolean canRead() {
		try {
			fileObject=new BufferedReader(new FileReader(fileName));
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong. "+e.getMessage());
			return false;
		}
	}
	
	public List<Node> readNode() throws IOException {
		if (canRead()==true) {
			node=new ArrayList<Node>();
			String singleNodeData;
			Node nodeObject;
			while ((singleNodeData=fileObject.readLine())!=null) {
				String[] temp=singleNodeData.split("[,]");
				nodeObject=new Node(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4]);
				node.add(nodeObject);
			}
		}
		return node;
	}
}
