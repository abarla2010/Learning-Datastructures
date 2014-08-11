package queues;

import java.util.Stack;

/**
 *
 * Implementing the Queue with two Stacks
 */
public class QueueImplUsingStacks {

	int dequeueCount=0;
	Stack stack1;
	Stack stack2;

	/**
	 * Constructor
	 */
	public QueueImplUsingStacks(){
		stack1 = new Stack();
		stack2 = new Stack();
	}

	/**
	 * Method that puts an element in the Queue
	 * Internally, this method pushed the element into the stack1
	 * @param input
	 */
	public void enqueue(int input){

		if(stack1.isEmpty()){
			stack1.push(input);
		}
		else{
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}

			stack1.push(input);

			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
		}
	}

	/**
	 * Method to remove an element from the queue
	 */
	public int dequeue(){
		return (int) stack1.pop();
	}

	@Override
	public String toString(){
		String finalString = "";

		while(!stack1.isEmpty()){

			if(stack1.size()==1){
				finalString = finalString + stack1.pop();
			}
			else {
				finalString = finalString + stack1.pop() + " ";
			}
		}

		return finalString;
	}

}
