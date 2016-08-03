package Session4;

import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Noor
 *
 */
public class GuestRoomAllotment {

	private Scanner scannner;
	
	public GuestRoomAllotment(){
		
	}
	
	/**
	 * Method to compute the alloted room no. to the guest.
	 * @param roomsList
	 * @param guestAge
	 * @return alloted room
	 */
	public int allotRoomNumberToGuest(List<Character> roomsList , int guestAge , int roomsOccupied){
		if(roomsOccupied == roomsList.size()) {    	//if all the rooms are occupied then return -1
			return -1;
		}

		int allotedRoom = guestAge % roomsList.size();

		while(roomsList.get(allotedRoom) != 'E') {
			allotedRoom++;    //linear probing
			allotedRoom = allotedRoom % roomsList.size();    //// if greater than size of rooms then reduce it
		}

		roomsList.set(allotedRoom, 'O');

		return allotedRoom;
	}

	/**
	 * Method to return user input of string type.
	 * @param task
	 * @return user input for string variables
	 */
	public String getUserStringInput(String task){			
		String userInput = null;
		try {
			scannner=new Scanner(System.in);
			System.out.print("\n"+task+"  :\t");
			userInput = scannner.next();
		} catch(Exception ex) {
			System.out.println("Something went wrong : "+ex.getMessage());
			getUserStringInput(task);
		}
		return userInput;
	}

	/**
	 * Method to return user input of integer type.
	 * @param task
	 * @return user input (integer)
	 */
	public int getUserIntegerInput(String task){
		int userInput = 0;
		try {
			System.out.println("\n"+task+"  :\t");
			userInput = Integer.parseInt(scannner.next());
		} catch(Exception ex) {
			System.out.println("Something went wrong: "+ex.getMessage());
			getUserIntegerInput(task);
		}
		return userInput;
	}

	/**
	 * Program main function.
	 * @param args
	 */
	public static void main(String[] args){
		GuestRoomAllotment roomAllotment = new GuestRoomAllotment();
		try {
			GuestHouse guestHouse = new GuestHouse("V Guest House", 7);
			List<Character> roomsList = guestHouse.getRoomAllotmentList();
			char userChoice = 'y';
			int roomsOccupied = 0;

			do {
				System.out.println("Welcome to "+ guestHouse.getGuestHouseName());
				String guestName = roomAllotment.getUserStringInput("Please enter your name");
				int guestAge = roomAllotment.getUserIntegerInput("Please enter your age");
				Guest guest = new Guest(guestName , guestAge);

				int roomAlloted = roomAllotment.allotRoomNumberToGuest(roomsList , guestAge , roomsOccupied);
				roomsOccupied++;

				if(roomAlloted == -1) {
					System.out.println("Sorry " +guest.getGuestName()+" Cannot assign room. All the rooms are occupied.");
				} else {
					System.out.println("Thank you "+ guest.getGuestName() +" for using our services.\nThe room alloted to you is  :\t"+roomAlloted);
				}

				userChoice = ((String) roomAllotment.getUserStringInput("Press Y or y to continue")).charAt(0);

			}while(userChoice == 'y' || userChoice == 'Y');
		} catch(Exception ex) {
			System.out.println("Something went wrong: "+ex.getMessage());
		} 	
	}
}
