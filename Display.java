package Session5;

import java.util.List;
import java.util.Scanner;

/**
 * Class to display the menu content of the menu list.
 * @author Noor
 */
public class Display {
	
	/**
	 * Method to display menu based on the level of the label.
	 * @param menu
	 * @param level
	 */
	public void display(Menu menu,int level) {
		try {
			List<MenuItem> menuItemList=menu.getMenuItems();
			int totalMenuItems=menuItemList.size();
			for(int index=0 ; index < totalMenuItems ; index++) {
				System.out.println((index+1+" ")+menuItemList.get(index).getLabel());
			}
			
			int userInput = 0;
			String input="";
			boolean toContinue=false;
			
			while(!toContinue) {    //take user input to perform action(move-forward, move-backward or exit)
				System.out.println("Please choose an option");
				input=new Scanner(System.in).next();
				toContinue=Display.isInputValid(input, Constants.TYPE_IS_NUMBER_INPUT, totalMenuItems);
			}
			
			userInput=Integer.parseInt(input);
			
			if(menuItemList.get(userInput-1).getType()==Constants.TYPE_IS_MENU) {
				Stack.pointer+=1;
				Stack.menu[Stack.pointer]=menu;
				display(menuItemList.get(userInput-1).menu,level+1);
			} else if(menuItemList.get(userInput-1).getType()!=Constants.TYPE_IS_MENU && menuItemList.get(userInput-1).getType()!=Constants.TYPE_IS_BACK) {
				System.out.println("There is nothing to display in the chosen option");	
				display(menu, level);
			} else if(menuItemList.get(userInput-1).getType()==Constants.TYPE_IS_BACK && level==1) {
				System.exit(-1);
			} else if(menuItemList.get(userInput-1).getType()==Constants.TYPE_IS_BACK && level!=1) {
				Stack.pointer-=1;
				display(Stack.menu[Stack.pointer+1], level-1);
			}
		} catch(Exception exception) {
			System.out.println("Sorry something went wrong \n"+exception.getMessage());
		}
	}
	
	/**
	 * Method to check whether the input is valid or not.
	 * @param input
	 * @param type
	 * @param length
	 * @return valid input or not.
	 */
	public static boolean isInputValid(String input,int type,int length) {
		boolean status=true;
		boolean validityByNumberInput =(type==Constants.TYPE_IS_NUMBER_INPUT ) && (input.length()>1 || input.codePointAt(0)<"0".codePointAt(0) || 
																			   input.codePointAt(0)>"9".codePointAt(0) ||
																			   Integer.parseInt(input)>length);
		boolean validityByStringInput =(type==Constants.TYPE_IS_STRING_INPUT) && (input.length()==0);
		if(validityByNumberInput || validityByStringInput) {
				status=false;
		}
		return status;
	}
}