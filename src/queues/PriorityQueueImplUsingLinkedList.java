package queues;

import common.PriorityQueueNode;

/**
 *
 * Priority Queue implementation using Linked List
 * This Priority Queue maintains the minimum element in the end of the Linked List
 */
public class PriorityQueueImplUsingLinkedList {

	public PriorityQueueNode head;
	public PriorityQueueNode previous;
	public int count;

	/**
	 * Constructor
	 */
	public PriorityQueueImplUsingLinkedList(){
		this.head = null;
		this.previous  = null;
		this.count = 0;
	}

	/**
	 * Method to push or insert an element into the priority queue
	 * @param inputData
	 */
	public void offer(Object inputData){

		PriorityQueueNode inputNode = new PriorityQueueNode(inputData);
		PriorityQueueNode tempNode = null;
		int tempResult;

		//Adding the first element
		if(head == null){
			head = inputNode;
		}
		else{
			//TODO
			tempNode = head;
			tempResult = tempNode.compareTo(inputData);

			while(tempNode.next!=null && tempResult==1){

				//keep moving right to be able to place inputData at its location
				previous = tempNode;
				tempNode = tempNode.next;
			}

			//If the element needs to be placed after the last element
			if(tempNode.next==null){
				tempNode.next = inputNode;
				inputNode.previous = tempNode;
			}
			else{
				//Placing the element in its right place
				inputNode.next = tempNode.next;
				tempNode.next = inputNode;
			}
		}

		count++;
	}


	/**
	 * Method to remove/return the minimum element from the priority queue
	 * @return
	 */
	public int remove(){

		PriorityQueueNode tempNode = head;

		for(int i=0; i<count; i++){

			tempNode = tempNode.next;
		}

		count--;

		return (int)tempNode.data;
	}

	/**
	 * Method to check if the priority queue is empty
	 * @return
	 */
	public boolean isEmpty(){
		return count==0;
	}

	/**
	 * Method to return the size of the priority queue
	 * @return
	 */
	public int size(){
		return count;
	}

	/**
	 * Method that converts the prints the priority queue as a string
	 * To print, this method removes an element from the Priority Queue
	 * @return
	 */
	@Override
	public String toString(){

		String finalString = "";

		while(count!=0){
			finalString = finalString + remove() + " ";
		}
		return finalString;
	}

	/**
	 * Method to print the whole priority queue
	 */
	public void display(){

		PriorityQueueNode tempNode = head;

		while(tempNode.next!=null){
			tempNode.printNode();
			tempNode = tempNode.next;
		}
	}
}
