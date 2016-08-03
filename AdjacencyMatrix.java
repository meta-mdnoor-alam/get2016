package Session4;

import java.io.IOException;
import java.util.List;

/**
 * Class to implement adjacency matrix.
 * @author Noor
 */
public class AdjacencyMatrix {

	static int[][] adjacencyMatrix;
	List<Node> nodeList;
	
	public AdjacencyMatrix(List<Node> nodeList) {
		this.nodeList=nodeList;
		adjacencyMatrix=new int[nodeList.size()][nodeList.size()];
	}
	
	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}
	
	public void setAdjacencyMatrix(String connectionFileName) throws NumberFormatException, IOException {
		FileReadHandler file=new FileReadHandler(connectionFileName);
		file.readConnectionFile();
	}
}
