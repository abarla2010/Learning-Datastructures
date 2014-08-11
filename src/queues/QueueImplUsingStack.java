package queues;

import java.util.Stack;

/**
 *
 * Implementation of a Queue using one stack
 */
public class QueueImplUsingStack {

	Stack stack;

	/**
	 * Constructor
	 */
	public QueueImplUsingStack(){
		stack = new Stack();
	}

	/**
	 * Method to push an element in the queue using one stack
	 * Method recursively calls itself to place the new element at the bottom of the stack
	 * This helps in maintaining the queue structure
	 * @param element
	 */
	public void enqueue(int element){

		int topElement = 0;

		if(stack.isEmpty()){
			stack.push(element);
		}
		else{
			topElement = (int) stack.pop();
			enqueue(element);
			stack.push(topElement);
		}
	}

	/**
	 * Method pops out an element from the stack/queue
	 * @return
	 */
	public int dequeue(){
		return (int) stack.pop();
	}

	/**
	 * Method to print the queue in a string
	 * @return
	 */
	@Override
	public String toString(){
		String finalString = "";

		while(!stack.isEmpty()){
			if(stack.size()==1){
				finalString = finalString + stack.pop();
			}
			else{
				finalString = finalString + stack.pop() + " ";
			}
		}

		return finalString;
	}
}

