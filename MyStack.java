package Session2;

import java.util.Scanner;

import Session1.MySinglyLinkedList;

/**Program to implement a Stack using a linked list.
 * @author Noor
 */
public class MyStack {
	private MySinglyLinkedList<Character> stack;
	private int top = -1;

	/**
	 * Default constructor.
	 */
	public MyStack() {
		stack = new MySinglyLinkedList<Character>();
	}

	/**
	 * Method to push the element into the stack.
	 * @param data
	 */
	public void push(char data) {
		top++;
		stack.add(data);
	}
	
	/**
	 * Method to pop the element into the stack.
	 * @return data which was on the top of the stack.
	 */
	public char pop() {
		char data = stack.remove(top);
		top--;
		return data;
	}

	/**
	 * Method to peek the element at the stack top.
	 * @return data at the top of the stack.
	 */
	public char peek() {
		char data = stack.get(top);
		return data;
	}

	/**
	 * Method to return the precedence of the operator.
	 * @param data
	 * @return
	 */
	private int precedence(char data) {
		if (data == '^'){
			return 3;
		}
		else if (data == '*' || data == '/') {
			return 2;
		} else if (data == '+' || data == '-') {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Method to check whether the data is operator or not.
	 * @param data
	 * @return success or not.
	 */
	public boolean isOperator(char data) {
		if (data == '*' || data == '/' || data == '+' || data == '-'
				|| data == '^' || data == '(' || data ==')') {
			return true;
		}
		return false;
	}
	
	/**
	 * Method to convert infix expression to postfix expression.
	 * @param expression
	 * @return
	 */
	public String convertInfixToPostfix(String expression) {
		String output="";
		int length = expression.length();
		for (int i = 0; i < length; i++) {
			char data = expression.charAt(i);
			if (isOperator(data)) {
				if (top == -1)
					push(data);
				else {
					char previous = peek();
					if(precedence(previous) <= precedence(data) || data == '(') {
						push(data);
					}else{
						while(precedence(previous) > precedence(data) && !stack.isEmpty()){
							if(!(peek() == '('))
								output += pop();
							else{
								pop();
								break;
							}
						}
						if(!(data == ')'))
							push(data);
					}
				}
			}else{
				output += data;
			}
		}
		while(!stack.isEmpty()){
			output += pop();
		}
		return output;
	}

	/**
	 * Program's main function.
	 * @param ar
	 */
	public static void main(String[] ar) {
		MyStack stack = new MyStack();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the infix notation  :\t");
		String expression = scan.next();
		String output = stack.convertInfixToPostfix(expression);
		System.out.print("\n\nPostfix notation  :\t"+output);
		scan.close();
	}
}
