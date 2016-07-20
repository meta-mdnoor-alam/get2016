package Session4;

import java.util.ArrayList;
import java.util.List;

/**To implement Tower of Hanoi problem with n no. of disks.
 * Assumption : Smaller to bigger disks are numbered in increasing order.
 * @author Noor
 */
public class TowerOfHanoi {

	List<String> movesList=new ArrayList<String>();
	
	/**
	 * To implement Tower of Hanoi problem with n number of disks. 
	 * @param sourceBar Source bar from which the disk is to be displaced 
	 * @param destinationBar Destination bar to which the disk is to be displaced
	 * @param auxiliaryBar Helping auxiliary bar with the help of which disk is displaced from source to destination bar 
	 * @param noOfDisk No. of disk on which the disk shifting is to be done. 
	 * @return List of moves by calling towerOfHanoi recursively.
	 */
	public List<String> towerOfHanoi(String sourceBar, String destinationBar, String auxiliaryBar, int noOfDisk) {
		//termination condition
		if (noOfDisk==1) {
			movesList.add("Move Disk "+noOfDisk+" from "+sourceBar+" to "+destinationBar);
			return movesList;
		}
		
		movesList=towerOfHanoi(sourceBar, auxiliaryBar, destinationBar, noOfDisk-1);
		movesList.add("Move Disk "+noOfDisk+" from "+sourceBar+" to "+destinationBar);
		movesList=towerOfHanoi(auxiliaryBar, destinationBar, sourceBar, noOfDisk-1);

		return movesList;
	}
	
	

}
