package queues;

import java.util.LinkedList;

/**
 *
 * Queue Impl using Linked Lists
 */
public class QueueImplUsingLinkedList {

	public LinkedList linkedList;

	/**
	 * Constructor
	 */
	public QueueImplUsingLinkedList(){
		linkedList = new LinkedList();
	}

	/**
	 * Method to enqueue or push an element into the queue
	 * @param input
	 */
	public void enqueue(int input){
		linkedList.add(input);
	}

	/**
	 * Method to dequeue or pop an element out of the queue
	 * @return
	 */
	public int dequeue(){
		return (int)linkedList.removeFirst();
	}

	/**
	 * Method to find out the size of the queue
	 * @return
	 */
	public int size(){
		return linkedList.size();
	}

	/**
	 * Method to check if the queue is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		return linkedList.size()==0;
	}

	/**
	 * Method to print the queue in a string
	 * @return
	 */
	@Override
	public String toString(){
		String finalString = "";

		while(!linkedList.isEmpty()){
			if(linkedList.size()==1){
				finalString = finalString + linkedList.removeFirst();
			}
			else{
				finalString = finalString + linkedList.removeFirst() + " ";
			}
		}

		return finalString;
	}
}
