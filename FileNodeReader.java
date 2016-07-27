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
	List<Node> nodeList;
	BufferedReader fileObject;
	
	public FileNodeReader(String fileName) {
		this.fileName=fileName;
		nodeList=null;
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
			nodeList=new ArrayList<Node>();
			String singleNodeData;
			Node node;
			Profile profile;
			while ((singleNodeData=fileObject.readLine())!=null) {
				String[] temp=singleNodeData.split("[,]");
				if (temp[4].equalsIgnoreCase("user")) {
					profile=new UserProfile(temp[1], temp[3], temp[4], Integer.parseInt(temp[5]), temp[2], Integer.parseInt(temp[6]));
					node=new UserNode(Integer.parseInt(temp[0]), temp[4], (UserProfile)profile);
				} else {
					profile=new OrganisationProfile(temp[1], temp[3], temp[4], temp[2]);
					node=new OrganisationNode(Integer.parseInt(temp[0]), temp[4], (OrganisationProfile)profile);
				}
				nodeList.add(node);
			}
		}
		return nodeList;
	}
}
