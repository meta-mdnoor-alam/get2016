package Session2;

import java.util.Scanner;

import Session1.MySinglyLinkedList;

/**
 * @author Noor
 *
 */
public class MyStack {
	private MySinglyLinkedList<Character> stack; // this is stack which we have to maintain
	private int top = -1; // this is condition that stack is empty

	//constructor
	public MyStack() {
		stack = new MySinglyLinkedList<Character>();
	}

	// It push the element into the stack
	public void push(char data) {
		top++;
		stack.add(data);
	}
	
	// It pop the element into the stack
	public char pop() {
		char data = stack.remove(top);
		top--;
		return data;
	}

	// It peek the element in stack top
	public char peek() {
		char data = stack.get(top);
		return data;
	}

	// this function convert the infix expression to postfix expression
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

	public boolean isOperator(char data) {
		if (data == '*' || data == '/' || data == '+' || data == '-'
				|| data == '^' || data == '(' || data ==')') {
			return true;
		}
		return false;
	}

	public static void main(String[] ar) {
		MyStack stack = new MyStack();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The Expression");
		String expression = scan.next();
		String out = stack.convertInfixToPostfix(expression);
		System.out.println(out);
		scan.close();
	}
}
