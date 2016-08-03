package Session4;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to store and implement Guest house information.
 * @author Noor
 */
public class GuestHouse {

	private String guestHouseName;
	private int guestHouseTotalRooms;
	private List<Character> roomAllotmentList;
	
	/**
	 * Parameterized constructor
	 */
	public GuestHouse(String guestHouseName, int guestHouseTotalRooms) {
		this.setGuestHouseName(guestHouseName);
		this.setGuestHouseTotalRooms(guestHouseTotalRooms);
		this.setRoomAllotmentStatus();
	}

	/**
	 * @return the guestHouseName
	 */
	public String getGuestHouseName() {
		return guestHouseName;
	}

	/**
	 * @param guestHouseName the guestHouseName to set
	 */
	public void setGuestHouseName(String guestHouseName) {
		this.guestHouseName = guestHouseName;
	}

	/**
	 * @return the guestHouseTotalRooms
	 */
	public int getGuestHouseTotalRooms() {
		return guestHouseTotalRooms;
	}

	/**
	 * @param guestHouseTotalRooms the guestHouseTotalRooms to set
	 */
	public void setGuestHouseTotalRooms(int guestHouseTotalRooms) {
		this.guestHouseTotalRooms = guestHouseTotalRooms;
	}

	/**
	 * @return the roomAllotmentList
	 */
	public List<Character> getRoomAllotmentList() {
		return roomAllotmentList;
	}

	/**
	 * @param roomAllotmentList the roomAllotmentList to set
	 */
	public void setRoomAllotmentStatus() {
		roomAllotmentList=new ArrayList<Character>();
		for (int index = 0; index < guestHouseTotalRooms; index++) {
			roomAllotmentList.add('E');
		}
	}

}
