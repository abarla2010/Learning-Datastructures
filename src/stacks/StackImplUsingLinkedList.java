package stacks;

import java.util.LinkedList;

/**
 *
 * Stack Implementation using a Linked List
 */
public class StackImplUsingLinkedList {

	LinkedList linkedList;

	/**
	 * Constructor
	 */
	public StackImplUsingLinkedList(){
		linkedList = new LinkedList();
	}

	/**
	 * Method to push an element into the Stack
	 * @param input
	 */
	public void push(int input){
		linkedList.add(input);
	}

	/**
	 * Method to pop an element out of the Stack
	 * @return
	 */
	public int pop(){
		return (int) linkedList.removeLast();
	}

	/**
	 * Method that returns the size of the Stack
	 * @return
	 */
	public int size(){
		return linkedList.size();
	}

	/**
	 * Method that checks if the stack is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		return linkedList.size() == 0;
	}

	/**
	 * Method to convert the stack into a string
	 * @return
	 */
	@Override
	public String toString(){
		String finalString = "";

		while(linkedList.size()!=0){
			finalString = finalString + linkedList.removeLast() + " ";
		}

		return finalString;
	}
}
